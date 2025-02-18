package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {

	private class Node {
		final String id;
		Object data;
		List<Node> adjacentNodes = new ArrayList<>();
		int color = 0;// 0 - white, 1- black

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

	public void addEdge(String idFrom, String idTo) {
		Node nodeFrom = nodes.get(idFrom);
		Node nodeTo = nodes.get(idTo);
		if (nodeFrom == null || nodeTo == null) {
			throw new IllegalArgumentException("One or both vertices do not exist");
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

	public void dfs(Node startNode) {
		if (startNode.color == 1) {
			return;
		}
		startNode.color = 1;
		for (Node node : startNode.adjacentNodes) {
			dfs(node);
		}
	}

	public void dfsWithPrint(Node startNode) {
		if (startNode.color == 1) {
			return;
		}
		startNode.color = 1;
		System.out.print(startNode.id + " ");
		for (Node node : startNode.adjacentNodes) {
			dfsWithPrint(node);
		}
	}

	public void dfsWithPrint(String startNodeId) {
		Node node = nodes.get(startNodeId);
		if (node == null) {
			return;
		}
		repaintNodesToWhiteColor();
		dfsWithPrint(node);
	}

	public boolean isConnectedGraph() {
		boolean result = true;
		repaintNodesToWhiteColor();
		for (String nodeId : nodes.keySet()) {
			dfs(nodes.get(nodeId));
			break;
		}
		for (String nodeId : nodes.keySet()) {
			if (nodes.get(nodeId).color == 0) {
				result = false;
				break;
			}
		}
		repaintNodesToWhiteColor();
		return result;
	}

	public void repaintNodesToWhiteColor() {
		for (String nodeId : nodes.keySet()) {
			nodes.get(nodeId).color = 0;
		}
	}

	public static void main(String[] args) {
		DFS graph = new DFS();

		graph.addNode("A", graph);
		graph.addNode("B", graph);
		graph.addNode("C", graph);
		graph.addNode("D", graph);
		graph.addNode("E", graph);

		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("B", "D");
		graph.addEdge("C", "E");

		System.out.println("Чи є граф зв'язним? " + graph.isConnectedGraph());

		System.out.println("Обхід у глибину з вершини A:");
		graph.dfsWithPrint("A");
		System.out.println();

		graph.removeEdge("A", "B");
		System.out.println("Чи є граф зв'язним після видалення ребра A-B? " + graph.isConnectedGraph());

		System.out.println("Обхід у глибину з вершини A:");
		graph.dfsWithPrint("A");
		System.out.println();

		graph.removeNode("C");
		System.out.println("Чи є граф зв'язним після видалення вершини C? " + graph.isConnectedGraph());

	}

}
