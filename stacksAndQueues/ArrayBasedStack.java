package stacksAndQueues;

import java.util.Arrays;

public class ArrayBasedStack {
	private Object[] dataArray;
	private int size;
	private int capacity;
	private final int DEFAULT_CAPACITY = 16;
	private final int MAX_STACK_SIZE = Integer.MAX_VALUE - 1;

	public ArrayBasedStack() {
		dataArray = new Object[DEFAULT_CAPACITY];
		capacity = dataArray.length;
		size = 0;
	}

	public void push(Object value) {
		if (size >= capacity) {
			boolean resizeResult = upResize();
			if (!resizeResult) {
				throw new RuntimeException("Cannot add element");
			}
		}
		dataArray[size] = value;
		size += 1;
	}

	public Object pop() {
		if (size == 0) {
			return null;
		}
		size -= 1;
		Object element = dataArray[size];
		dataArray[size] = null;
		return element;
	}

	public Object peek() {
		if (size == 0) {
			return null;
		}
		return dataArray[size - 1];
	}

	public int size() {
		return size;
	}

	public boolean upResize() {
		if (capacity >= MAX_STACK_SIZE) {
			return false;
		}
		long newCapacityL = (capacity * 3L) / 2L + 1L;
		int newCapacity = (newCapacityL < MAX_STACK_SIZE) ? (int) newCapacityL : MAX_STACK_SIZE;
		dataArray = Arrays.copyOf(dataArray, newCapacity);
		capacity = newCapacity;
		return true;
	}

	public void trimToSize() {
		dataArray = Arrays.copyOf(dataArray, size);
		capacity = dataArray.length;
	}

	public void clear() {
		dataArray = new Object[DEFAULT_CAPACITY];
		capacity = dataArray.length;
		size = 0;
	}

	public static void main(String[] args) {
		ArrayBasedStack stack = new ArrayBasedStack();

		stack.push(10);
		System.out.print(stack.peek() + " ");
		stack.push(20);
		System.out.print(stack.peek() + " ");
		stack.push(30);
		System.out.println(stack.peek());

		System.out.println("Розмір стеку: " + stack.size());

		System.out.println("Верхній елемент: " + stack.peek());

		System.out.println("Видалено: " + stack.pop());
		System.out.println("Видалено: " + stack.pop());

		System.out.println("Розмір після видалення: " + stack.size());

		stack.clear();
		System.out.println("Розмір після очищення: " + stack.size());

	}

}
