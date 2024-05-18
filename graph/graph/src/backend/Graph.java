package backend;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<Node> nodes;
    List<Edge> edges;

    public Graph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addNode(String word) {
        Node node = new Node(word);
        nodes.add(node);
    }

    public void addEdge(Node from, Node to, int weight) {
        Edge edge = new Edge(from, to, weight);
        edges.add(edge);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Node findNode(String word) {
        for (Node node : nodes) {
            if (node.word.equals(word)) {
                return node;
            }
        }
        return null;
    }

    public void displayGraph() {
        System.out.println("Nodes:");
        for (Node node : nodes) {
            System.out.println(node);
        }
        System.out.println("Edges:");
        for (Edge edge : edges) {
            System.out.println(edge);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        Node nodeA = graph.findNode("A");
        Node nodeB = graph.findNode("B");
        Node nodeC = graph.findNode("C");

        graph.addEdge(nodeA, nodeB, 5);
        graph.addEdge(nodeB, nodeC, 3);
        graph.addEdge(nodeA, nodeC, 10);

        graph.displayGraph();
    }
}
