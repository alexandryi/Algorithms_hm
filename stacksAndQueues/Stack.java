package stacksAndQueues;

public class Stack {
	private class Node {
		String date;
		Node next;

		public Node(String date, Node next) {
			this.date = date;
			this.next = next;
		}

		public Node() {
		}
	}

	private Node head;

	public Stack() {
		super();
	}

	public void push(String value) {
		Node newNode = new Node(value, head);
		head = newNode;
	}

	public String pop() {
		if (head != null) {
			String result = head.date;
			head = head.next;
			return result;
		}
		return null;
	}

	public String peek() {
		if (head != null) {
			String result = head.date;
			return result;
		}
		return null;
	}

	public long size() {
		long size = 0;
		for (Node currentNode = head; currentNode != null; currentNode = currentNode.next) {
			size += 1L;
		}
		return size;
	}

	public static void main(String[] args) {
		Stack stack = new Stack();

		stack.push("10");
		System.out.print(stack.peek() + " ");
		stack.push("20");
		System.out.print(stack.peek() + " ");
		stack.push("30");
		System.out.println(stack.peek());

		System.out.println("Розмір стеку: " + stack.size());

		System.out.println("Верхній елемент: " + stack.peek());

		System.out.println("Видалено: " + stack.pop());
		System.out.println("Видалено: " + stack.pop());

		System.out.println("Розмір після видалення: " + stack.size());

	}

}
