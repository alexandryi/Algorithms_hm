package trees;

public class BinaryTree {
	private class Node {
		int key;
		Object data;
		Node leftNode;
		Node rightNode;

		public Node(int key, Object data) {
			this.key = key;
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", data=" + data + "]";
		}
	}

	private Node root;

	public void addNode(int key, Object data) {
		root = addNodeRecursive(root, key, data);
	}

	private Node addNodeRecursive(Node node, int key, Object data) {
		if (node == null) {
			return new Node(key, data);
		}
		if (key == node.key) {
			node.data = data;
			return node;
		}
		if (key < node.key) {
			node.leftNode = addNodeRecursive(node.leftNode, key, data);
		} else {
			node.rightNode = addNodeRecursive(node.rightNode, key, data);
		}
		return node;
	}

	public Object findByKey(int key) {
		return findByKeyRecursive(root, key);
	}

	private Object findByKeyRecursive(Node node, int key) {
		if (node == null) {
			return null;
		}
		if (node.key == key) {
			return node.data;
		}
		return (key < node.key) ? findByKeyRecursive(node.leftNode, key) : findByKeyRecursive(node.rightNode, key);
	}

	public void deleteNode(int key) {
		root = deleteNodeRewcursive(root, key);
	}

	private Node deleteNodeRewcursive(Node node, int key) {
		if (node == null) {
			return node;
		}
		if (key == node.key) {
			// node has no child node
			if (node.leftNode == null && node.rightNode == null) {
				return null;
			}
			// node has exactly one child
			if (node.leftNode == null) {
				return node.rightNode;
			}
			if (node.rightNode == null) {
				return node.leftNode;
			}
			// node has two child node
			if (node.rightNode != null && node.leftNode != null) {
				Node smallestNode = findSmallestValue(node.rightNode);
				node.key = smallestNode.key;
				node.data = smallestNode.data;
				node.rightNode = deleteNodeRewcursive(node.rightNode, smallestNode.key);
				return node;
			}
		}
		if (key < node.key) {
			node.leftNode = deleteNodeRewcursive(node.leftNode, key);
			return node;
		} else {
			node.rightNode = deleteNodeRewcursive(node.rightNode, key);
			return node;
		}
	}

	private Node findSmallestValue(Node node) {
		return node.leftNode == null ? node : findSmallestValue(node.leftNode);
	}

	public int size() {
		return sizeRecursive(root);
	}

	private int sizeRecursive(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + sizeRecursive(node.leftNode) + sizeRecursive(node.rightNode);
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

        tree.addNode(50, "Root");
        tree.addNode(30, "Left child");
        tree.addNode(70, "Right child");
        tree.addNode(20, "Left-Left child");
        tree.addNode(40, "Left-Right child");
        tree.addNode(60, "Right-Left child");
        tree.addNode(80, "Right-Right child");

        System.out.println("Розмір дерева: " + tree.size());

        int keyToFind = 40;
        System.out.println("Дані за ключем " + keyToFind + ": " + tree.findByKey(keyToFind));

        int keyToDelete = 30;
        tree.deleteNode(keyToDelete);
        System.out.println("Розмір дерева після видалення " + keyToDelete + ": " + tree.size());

        System.out.println("Спроба знайти " + keyToDelete + ": " + tree.findByKey(keyToDelete));
	}

}
