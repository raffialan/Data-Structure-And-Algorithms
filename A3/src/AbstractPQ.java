public abstract class AbstractPQ<K extends Comparable<K>, V> {

	public KeyComparator<K> keyComparator;

	public AbstractPQ(KeyComparator<K> comparator) {
		keyComparator = comparator;
	}

	public AbstractPQ() {
		this(new KeyComparator<>());
	}

	public abstract Entry<K, V> removeTop();

	public abstract Entry<K, V> insert(K key, V value) throws IllegalArgumentException;

	public abstract Entry<K, V> top();

	public abstract Entry<K, V> remove(Entry<K, V> entry) throws IllegalArgumentException;

	public abstract K replaceKey(Entry<K, V> entry, K key) throws IllegalArgumentException;

	public abstract V replaceValue(Entry<K, V> entry, V value) throws IllegalArgumentException;

	abstract void toggle();

	public String state() {
		return keyComparator.getState();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int compare(Entry<K, V> first, Entry<K, V> second) {
		return keyComparator.compare(first.getKey(), second.getKey());
	}

	abstract int size();

	public boolean checkKeyisValidOrNot(K key) throws IllegalArgumentException {
		try {
			return (keyComparator.compare(key, key) == 0);
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("Keys are not valid please check your keys.!");
		}
	}

}