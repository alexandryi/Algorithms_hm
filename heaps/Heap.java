package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap {
	private class Node {
		int key;
		Object data;

		public Node(int key, Object data) {
			this.key = key;
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", data=" + data + "]";
		}
	}

	private List<Node> nodes = new ArrayList<>();

	public Heap() {
		super();
	}

	private void siftUp(int i) {
		for (; i > 0;) {
			int j = (i - 1) / 2;
			if (nodes.get(i).key > nodes.get(j).key) {
				Collections.swap(nodes, i, j);
			} else {
				break;
			}
			i = j;
		}
	}

	private void siftDown(int i) {
		for (;;) {
			int leftIndex = 2 * i + 1;
			int rightIndex = 2 * i + 2;
			int j = i;
			if (leftIndex <= nodes.size() - 1 && nodes.get(leftIndex).key > nodes.get(j).key) {
				j = leftIndex;
			}
			if (rightIndex <= nodes.size() - 1 && nodes.get(rightIndex).key > nodes.get(j).key) {
				j = rightIndex;
			}
			if (i != j) {
				Collections.swap(nodes, i, j);
				i = j;
			} else {
				break;
			}
		}
	}

	private void heapRecovery(int i) {
		int parentIndex = (i - 1) / 2;
		if (i > 0 && nodes.get(i).key > nodes.get(parentIndex).key) {
			siftUp(i);
		} else {
			siftDown(i);
		}
	}

	private int findIndexByKey(int key) {
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).key == key) {
				return i;
			}
		}
		return -1;
	}

	public void add(int key, Object data) {
		nodes.add(new Node(key, data));
		siftUp(nodes.size() - 1);
	}

	public Object extract() {
		if (nodes.size() == 0) {
			return null;
		}
		Object result = nodes.get(0).data;
		nodes.set(0, nodes.remove(nodes.size() - 1));
		siftDown(0);
		return result;
	}

	public Object inserAndExtract(int key, Object data) {
		Object result = null;
		if (nodes.size() > 0) {
			result = nodes.get(0);
			nodes.set(0, new Node(key, data));
			siftDown(0);
		}
		return result;
	}

	public void delete(int key) {
		int i = findIndexByKey(key);
		if (i != -1) {
			Node node = nodes.remove(nodes.size() - 1);
			nodes.set(i, node);
			heapRecovery(i);
		}
	}

	public void changeKey(int oldKey, int newKey) {
		int i = findIndexByKey(oldKey);
		if (i != -1) {
			nodes.get(i).key = newKey;
			heapRecovery(i);

		}
	}

	public void printHeap() {
		System.out.println("Стан купи:");
		for (Node node : nodes) {
			System.out.print(node.key + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Heap heap = new Heap();

		heap.add(50, 50);
		heap.add(30, 30);
		heap.add(70, 70);
		heap.add(20, 20);
		heap.add(40, 40);
		heap.add(60, 60);
		heap.add(80, 80);

		heap.printHeap();

		System.out.println("Максимальний елемент: " + heap.extract());

		System.out.println("Вставка 90 і видалення кореня: " + heap.inserAndExtract(90, 90));

		System.out.println("Перевірка максимального елементу: " + heap.extract());

		heap.delete(40);
		System.out.println("Видалено 40");

		System.out.println("Змінено ключ 30 на 100");
		heap.changeKey(30, 100);
		heap.printHeap();
	}

}
