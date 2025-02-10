package lists;

import java.util.Arrays;

public class ArrayList {

	private int[] dataArray;
	private int size;
	private int capacity;
	private final int DEFAULT_CAPACITY = 10;

	public ArrayList() {
		dataArray = new int[DEFAULT_CAPACITY];
		capacity = dataArray.length;
		size = 0;
	}

	public void add(int value) {
		if (size >= capacity) {
			boolean resizeResult = upResize();
			if (!resizeResult) {
				throw new RuntimeException("Cannot add element");
			}
		}
		dataArray[size] = value;
		size += 1;
	}

	public void addByIndex(int value, int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (size >= capacity) {
			boolean resizeResult = upResize();
			if (!resizeResult) {
				throw new RuntimeException("Cannot add element");
			}
		}
		System.arraycopy(dataArray, index, dataArray, index + 1, size - index);
		dataArray[index] = value;
		size += 1;
	}

	public void deleteByIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		System.arraycopy(dataArray, index + 1, dataArray, index, size - index);
		size -= 1;
	}

	public boolean upResize() {
		if (capacity >= Integer.MAX_VALUE - 1) {
			return false;
		}
		long newCapacityL = (capacity * 3L) / 2L + 1L;
		int newCapacity = (newCapacityL < Integer.MAX_VALUE - 1) ? (int) newCapacityL : Integer.MAX_VALUE - 1;
		dataArray = Arrays.copyOf(dataArray, newCapacity);
		capacity = newCapacity;
		return true;
	}

	public void trimToSize() {
		dataArray = Arrays.copyOf(dataArray, size);
		capacity = dataArray.length;
	}

	public void clear() {
		dataArray = new int[0];
		capacity = dataArray.length;
		size = 0;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {

		ArrayList list = new ArrayList();

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		System.out.println("Додані елементи:");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.dataArray[i] + " ");
		}
		System.out.println();

		list.addByIndex(25, 2);
		System.out.println("Вставка 25 на індекс 2:");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.dataArray[i] + " ");
		}
		System.out.println();

		list.deleteByIndex(3);
		System.out.println("Видалення елемента на індексі 3:");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.dataArray[i] + " ");
		}
		System.out.println();

		System.out.println("Розмір списка: " + list.size());

		list.clear();
		System.out.println("Очистка списку:");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.dataArray[i] + " ");
		}
		if(list.size()>0)
			System.out.println();
		else System.out.println("[]");

	}

}
