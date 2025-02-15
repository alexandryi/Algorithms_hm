package stacksAndQueues;

public class Queue {

	private final int DEFAULT_SIZE = 16;
	private Object[] data;
	private int head;
	private int tail;
	private int size;

	public Queue() {
		super();
		data = new Object[DEFAULT_SIZE];
		head = 0;
		tail = 0;
		size = 0;
	}

	public void enqueue(Object value) {
		if ((tail + 1) % data.length == head) {
			increaseSize();
		}
		data[tail] = value;
		tail = (tail + 1) % data.length;
		size += 1;
	}

	private void increaseSize() {
		if (data.length >= Integer.MAX_VALUE - 10) {
			throw new IllegalArgumentException("can't increase the size");
		}
		Object[] newArray = new Object[Math.min(Integer.MAX_VALUE - 10, data.length * 4 / 3 + 1)];
		int addIndex = 0;
		for (;;) {
			if (head % data.length == tail) {
				break;
			}
			newArray[addIndex] = data[head % data.length];
			addIndex += 1;
			head = (head + 1) % data.length;
		}
		data = newArray;
		head = 0;
		tail = addIndex;
		size = tail;
	}

	public Object dequeue() {
		if (head == tail) {
			return null;
		}
		Object returnValue = data[head];
		data[head] = null;
		head = (head + 1) % data.length;
		size -= 1;
		return returnValue;
	}

	public Object peek() {
		if (head == tail) {
			return null;
		}
		return data[head];
	}

	public void trimToSize() {
		Object[] newArray = new Object[size + 1];
		int addIndex = 0;
		for (;;) {
			if (head % data.length == tail) {
				break;
			}
			newArray[addIndex] = data[head % data.length];
			addIndex += 1;
			head = (head + 1) % data.length;
		}
		data = newArray;
		head = 0;
		tail = addIndex;
	}

	public static void main(String[] args) {
		Queue queue = new Queue();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);

		System.out.println("Перший елемент: " + queue.peek());

		System.out.println("Видалено: " + queue.dequeue());
		System.out.println("Видалено: " + queue.dequeue());

		queue.enqueue(40);
		queue.enqueue(50);

		System.out.println("Перший елемент зараз: " + queue.peek());

		System.out.println("Видалено: " + queue.dequeue());
		System.out.println("Видалено: " + queue.dequeue());
		System.out.println("Видалено: " + queue.dequeue());

		System.out.println("Стан черги: " + queue.peek());
	}

}
