public class ADTQueue<K extends Comparable<K>, V> extends AbstractPQ<K, V> {

	public DynamicArray<Entry<K, V>> dynamicArray = new DynamicArray<>();

	public ADTQueue() {
		super();
	}
	
	int var = 2;

	public ADTQueue(KeyComparator<K> comparator) {
		super(comparator);
	}

	public boolean hasRight(int index) {
		return right(index) < dynamicArray.size();
	}

	public void swapEntry(int from, int to) {

		Entry<K, V> entry = dynamicArray.get(from);
		dynamicArray.set(from, dynamicArray.get(to));
		dynamicArray.set(to, entry);

		((PriorityQueueEntry<K, V>) dynamicArray.get(from)).setIndex(from);
		((PriorityQueueEntry<K, V>) dynamicArray.get(to)).setIndex(to);

	}

	public Entry<K, V> top() {
		if (dynamicArray.isEmpty()) {
			return null;
		} else {
			return dynamicArray.get(0);
		}
	}

	public void upheap(int index) {
		while (index > 0) {
			int parent = isparent(index);
			if (compare(dynamicArray.get(index), dynamicArray.get(parent)) <= 0) {
				break;
			}
			swapEntry(index, parent);
			index = parent;
		}
	}

	public int left(int index) {
		return var * index + 1;
	}

	public void downheap(int index) {

		while (hasLeft(index)) {

			int indexChild = left(index);

			if (hasRight(index)) {
				int indexRight = right(index);

				if (compare(dynamicArray.get(indexChild), dynamicArray.get(indexRight)) < 0) {
					indexChild = indexRight;
				}
			}

			if (compare(dynamicArray.get(indexChild), dynamicArray.get(index)) < 0) {
				break;
			}

			swapEntry(index, indexChild);
			index = indexChild;
		}
	}

	public void printArray() {
		System.out.println(dynamicArray);
	}

	public Entry<K, V> removeTop() {
		if (dynamicArray.isEmpty()) {
			return null;
		}
		int index = 0;
		swapEntry(index, dynamicArray.size() - 1);
		Entry<K, V> entryremoved = dynamicArray.get(dynamicArray.size() - 1);
		dynamicArray.remove(dynamicArray.size() - 1);
		downheap(index);
		return entryremoved;
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKeyisValidOrNot(key);
		Entry<K, V> entry = new PriorityQueueEntry<>(key, value, dynamicArray.size());
		dynamicArray.add(entry);
		upheap(dynamicArray.size() - 1);
		return entry;
	}

	public int right(int index) {
		return var * index + var;
	}

	public Entry<K, V> removeByEntry(K key, V value, int index) throws IllegalArgumentException {
		Entry<K, V> entry = new PriorityQueueEntry<>(key, value, index);
		return remove(entry);
	}

	@Override
	public Entry<K, V> remove(Entry<K, V> entry) throws IllegalArgumentException {

		PriorityQueueEntry<K, V> arrayEntry = validateEntry(entry);
		int index = arrayEntry.getIndex();
		if (index == dynamicArray.size() - 1)
			dynamicArray.remove(dynamicArray.size() - 1);
		else {
			swapEntry(index, dynamicArray.size() - 1);
			dynamicArray.remove(dynamicArray.size() - 1);
			downheap(index);
		}

		return arrayEntry;
	}

	public boolean hasLeft(int index) {
		return left(index) < dynamicArray.size();
	}

	public int size() {
		return dynamicArray.size();
	}

	public PriorityQueueEntry<K, V> validateEntry(Entry<K, V> entry) throws IllegalArgumentException {
		if (!(entry instanceof PriorityQueueEntry))
			throw new IllegalArgumentException("Entry is Invalid");
		PriorityQueueEntry<K, V> arrayEntry = (PriorityQueueEntry<K, V>) entry;
		int index = arrayEntry.getIndex();
		if (index >= dynamicArray.size())
			throw new IllegalArgumentException("Entry is Invalid");
		return arrayEntry;
	}

	public K replaceKeyByEntry(K key, V value, int index, K replaceKey) throws IllegalArgumentException {
		Entry<K, V> entry = new PriorityQueueEntry<>(key, value, index);
		return replaceKey(entry, replaceKey);
	}

	public void toggle() {
		keyComparator.toggle();
		heapify();
	}

	@Override
	public K replaceKey(Entry<K, V> entry, K key) throws IllegalArgumentException {
		PriorityQueueEntry<K, V> arrayEntry = validateEntry(entry);
		checkKeyisValidOrNot(key);
		arrayEntry.setKey(key);
		((PriorityQueueEntry<K, V>) dynamicArray.get(arrayEntry.getIndex())).setKey(key);
		downheap(arrayEntry.getIndex());
		return arrayEntry.getKey();
	}

	public void heapify() {
		int index = isparent(size() - 1);
		for (int loop = index; loop >= 0; loop--) {
			downheap(loop);
		}
	}

	public V replaceValueByEntry(K key, V value, int index, V replaceValue) throws IllegalArgumentException {
		Entry<K, V> entry = new PriorityQueueEntry<>(key, value, index);
		return replaceValue(entry, replaceValue);
	}

	@Override
	public V replaceValue(Entry<K, V> entry, V value) throws IllegalArgumentException {
		PriorityQueueEntry<K, V> arrayEntry = validateEntry(entry);
		arrayEntry.setValue(value);
		((PriorityQueueEntry<K, V>) dynamicArray.get(arrayEntry.getIndex())).setValue(value);
		return arrayEntry.getValue();
	}

	public int isparent(int index) {
		return (index - 1) / var;
	}

}