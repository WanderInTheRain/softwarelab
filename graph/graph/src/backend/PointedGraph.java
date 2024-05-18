package backend;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointedGraph {
    List<PointedNode> nodes;
    List<PointedEdge> edges;
    Random random;

    public PointedGraph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        random = new Random();
    }

    public void genPointedGraphFromGraph(Graph graph) {
        for (Node node : graph.getNodes()) {
            int x = random.nextInt(100,300); // Assuming width of 400
            int y = random.nextInt(100,300); // Assuming height of 400
            PointedNode pointedNode = new PointedNode(node.word, x, y);
            addNode(pointedNode);
        }

        for (Edge edge : graph.getEdges()) {
            PointedNode from = findNode(edge.from.word);
            PointedNode to = findNode(edge.to.word);
            addEdge(from, to, edge.weight);
        }
    }

    public void addNode(PointedNode node) {
        nodes.add(node);
    }

    public void addEdge(PointedNode from, PointedNode to, int weight) {
        PointedEdge edge = new PointedEdge(from, to, weight);
        edges.add(edge);
    }

    public List<PointedNode> getNodes() {
        return nodes;
    }

    public List<PointedEdge> getEdges() {
        return edges;
    }

    public PointedNode findNode(String word) {
        for (PointedNode node : nodes) {
            if (node.word.equals(word)) {
                return node;
            }
        }
        return null;
    }

    public void displayGraph() {
        System.out.println("Nodes:");
        for (PointedNode node : nodes) {
            System.out.println(node);
        }
        System.out.println("Edges:");
        for (PointedEdge edge : edges) {
            System.out.println(edge);
        }
    }

}
