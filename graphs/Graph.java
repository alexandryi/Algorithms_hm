package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	private class Node {
		String id;
		Object data;
		List<Node> nodes = new ArrayList<>();

		public Node(String id, Object data) {
			this.id = id;
			this.data = data;
		}
	}

	private Map<String, Node> graphNodes = new HashMap<>();

	public void addNode(String s, Object o) {
		if (graphNodes.containsKey(s)) {
			graphNodes.get(s).data = o;
		} else {
			graphNodes.put(s, new Node(s, o));
		}
	}

	public void addEdge(String s1, String s2) {
		Node n1 = graphNodes.get(s1);
		Node n2 = graphNodes.get(s2);
		if (n1 == null || n2 == null) {
			return;
		}
		n1.nodes.add(n2);
		n2.nodes.add(n1);
	}

	public void removeNode(String s) {
		Node n = graphNodes.get(s);
		if (n == null) {
			return;
		}
		for (Node nn : n.nodes) {
			nn.nodes.remove(n);
		}
		graphNodes.remove(s);
	}

	public void removeEdge(String s1, String s2) {
		Node n1 = graphNodes.get(s1);
		Node n2 = graphNodes.get(s2);
		if (n1 == null || n2 == null) {
			return;
		}
		n1.nodes.remove(n2);
		n2.nodes.remove(n1);
	}

	public boolean isAdjacentNodes(String s1, String s2) {
		Node n1 = graphNodes.get(s1);
		Node n2 = graphNodes.get(s2);

		if (n1 == null || n2 == null) {
			return false;
		}
		return n1.nodes.contains(n2);
	}

	public List<String> getAdjacentNodeList(String s) {
		Node n = graphNodes.get(s);

		List<String> l = new ArrayList<>();
		if (n == null) {
			return l;
		}

		for (Node nn : n.nodes) {
			l.add(nn.id);
		}
		return l;
	}

	@Override
	public String toString() {
		String str = new String("");
		for (String s : graphNodes.keySet()) {
			str += s + " -> " + getAdjacentNodeList(s) + System.lineSeparator();
		}
		return str;
	}

	public static void main(String[] args) {
		Graph graph = new Graph();

		graph.addNode("A", null);
		graph.addNode("B", null);
		graph.addNode("C", null);
		graph.addNode("D", null);

		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("B", "D");

		System.out.println("Початковий граф:");
		System.out.println(graph);

		System.out.println("Чи є ребро між A і B? " + graph.isAdjacentNodes("A", "B"));
		System.out.println("Чи є ребро між A і D? " + graph.isAdjacentNodes("A", "D"));

		System.out.println("Сусідні вершини для A: " + graph.getAdjacentNodeList("A"));

		graph.removeEdge("A", "B");
		System.out.println("Граф після видалення ребра A-B:");
		System.out.println(graph);

		graph.removeNode("B");
		System.out.println("Граф після видалення вузла B:");
		System.out.println(graph);
	}
}
