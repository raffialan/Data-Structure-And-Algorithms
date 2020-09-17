import java.util.Arrays;

public class DynamicArray<E> {

	public static int DynamicArray_capacity;
	private E[] dynamicArray;
	private int size = 0;

	@SuppressWarnings("unchecked")
	public DynamicArray() {
		dynamicArray = (E[]) new Object[10];
		DynamicArray_capacity = 10;
	}

	@SuppressWarnings("unchecked")
	public DynamicArray(int dynamicArray_capacity) throws IllegalArgumentException {
		if (DynamicArray_capacity <= 0) {
			throw new IllegalArgumentException(" DynamicArray capacity should be greater than 0");
		}
		DynamicArray_capacity = dynamicArray_capacity;
		dynamicArray = (E[]) new Object[dynamicArray_capacity];
	}

	public void increaseSize() {
		@SuppressWarnings("unchecked")
		E[] temp = (E[]) new Object[2 * DynamicArray_capacity];
		for (int index = 0; index < DynamicArray_capacity; index++) {
			temp[index] = dynamicArray[index];
		}
		dynamicArray = temp;
		DynamicArray_capacity = temp.length;
	}

	public E set(int index, E entry) throws IllegalArgumentException {
		if (index < 0) {
			throw new IllegalArgumentException();
		}
		while (index >= DynamicArray_capacity) {
			increaseSize();
		}
		dynamicArray[index] = entry;
		E entry_return = dynamicArray[index];
		return entry_return;
	}

	public void decreaseSize() {
		@SuppressWarnings("unchecked")
		E[] temp = (E[]) new Object[DynamicArray_capacity / 2];

		if (size() < DynamicArray_capacity / 2) {
			for (int index = 0; index < size(); index++) {
				temp[index] = dynamicArray[index];
			}
			dynamicArray = temp;
			DynamicArray_capacity = temp.length;
		} else {

		}
	}

	public E remove(int index) throws ArrayIndexOutOfBoundsException {
		if (index < size) {
			E entry = dynamicArray[index];
			dynamicArray[index] = null;
			size--;
			int count_index = index;
			while (count_index < size) {
				dynamicArray[count_index] = dynamicArray[count_index + 1];
				count_index++;
				dynamicArray[count_index] = null;
			}
			if (size < DynamicArray_capacity / 2) {
				decreaseSize();
			}
			return entry;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	@Override
	public String toString() {
		return "DynamicArray [array=" + Arrays.toString(dynamicArray) + "]";
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	public E get(int index) throws ArrayIndexOutOfBoundsException {
		if (index < size) {
			return dynamicArray[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public boolean isFull() {
		return (DynamicArray_capacity == size());
	}

	public Integer size() {
		return size;
	}

	public void add(E entry) {
		if (size == DynamicArray_capacity) {
			increaseSize();
		}
		dynamicArray[size++] = entry;
	}
}