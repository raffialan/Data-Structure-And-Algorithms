public class PriorityQueueEntry<K, V> implements Entry<K, V> {
	private K k;
	private V v;
	private int index;

	public PriorityQueueEntry(K key, V value, int index) {
		this.k = key;
		this.v = value;
		this.index = index;
	}

	public K getKey() {
		return k;
	}

	public V getValue() {
		return v;
	}

	protected void setKey(K key) {
		this.k = key;
	}

	protected void setValue(V value) {
		this.v = value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String toString() {
		return ("Key: " + k + " Value: " + v + " Index: " + this.index);
	}
}