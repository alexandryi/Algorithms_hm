package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	private class Node {
		final String id;
		Object data;
		List<Node> adjacentNodes = new ArrayList<>();

		public Node(String id) {
			super();
			this.id = id;
		}
	}

	private final Map<String, Node> nodes = new HashMap<>();

	public void addNode(String id, Object data) {
		if (nodes.get(id) != null) {
			throw new IllegalArgumentException("Node with this ID already exists");
		}
		Node newNode = new Node(id);
		newNode.data = data;
		nodes.put(id, newNode);
	}

	public void addNode(String id) {
		addNode(id, null);
	}

	public void addEdge(String idFrom, String idTo) {
		Node nodeFrom = nodes.get(idFrom);
		Node nodeTo = nodes.get(idTo);
		if (nodeFrom == null || nodeTo == null) {
			throw new IllegalArgumentException("Node with this id does not exist");
		}
		if (nodeFrom == nodeTo) {
			throw new IllegalArgumentException("Loop edge");
		}
		nodeFrom.adjacentNodes.add(nodeTo);
		nodeTo.adjacentNodes.add(nodeFrom);
	}

	public void removeNode(String id) {
		Node removeNode = nodes.get(id);
		if (removeNode == null) {
			return;
		}
		for (Node node : removeNode.adjacentNodes) {
			node.adjacentNodes.remove(removeNode);
		}
		nodes.remove(id);
	}

	public void removeEdge(String idFrom, String idTo) {
		Node nodeFrom = nodes.get(idFrom);
		Node nodeTo = nodes.get(idTo);
		if (nodeFrom == null || nodeTo == null) {
			throw new IllegalArgumentException("Node with this id does not exist");
		}
		nodeFrom.adjacentNodes.remove(nodeTo);
		nodeTo.adjacentNodes.remove(nodeFrom);
	}

	public boolean isAdjacent(String idFrom, String idTo) {
		Node nodeFrom = nodes.get(idFrom);
		Node nodeTo = nodes.get(idTo);
		if (nodeFrom == null || nodeTo == null) {
			return false;
		}
		return nodeFrom.adjacentNodes.contains(nodeTo);
	}

	public String[] getAdjacentNodesId(String id) {
		Node node = nodes.get(id);
		if (node == null) {
			return null;
		}
		String[] ids = new String[node.adjacentNodes.size()];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = node.adjacentNodes.get(i).id;
		}
		return ids;
	}

	public Object getNodeDataById(String id) {
		Node node = nodes.get(id);
		if (node == null) {
			return null;
		}
		return node.data;
	}

	public void setNodeDataById(String id, Object data) {
		Node node = nodes.get(id);
		if (node == null) {
			return;
		}
		node.data = data;
	}

	public static void main(String[] args) {
		Graph graph = new Graph();

		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");

		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("B", "D");

		System.out.println("Наявність ребра між A і B: " + graph.isAdjacent("A", "B")); 
		System.out.println("Наявність ребра між A і D: " + graph.isAdjacent("A", "D")); 

		System.out.print("Суміжні вершини для A: ");
		for (String id : graph.getAdjacentNodesId("A")) {
			System.out.print(id + " ");
		}
		System.out.println();

		graph.removeEdge("A", "B");
		System.out.println("Чи є ребро між A і B після видалення? " + graph.isAdjacent("A", "B")); 

		graph.removeNode("B");
		System.out.println("Чи існує вузол B після видалення? " + (graph.getNodeDataById("B") != null)); 
	}

}
 