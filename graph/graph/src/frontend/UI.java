package frontend;
import javax.swing.*;

import backend.Graph;
import backend.Node;
import backend.PointedGraph;

public class UI extends JFrame {
    public UI() {
        super("Graph Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showGraph(Graph graph) {
        PointedGraph pointgraph = new PointedGraph();
        pointgraph.genPointedGraphFromGraph(graph);
        GraphPanel graphPanel = new GraphPanel(pointgraph);
        add(graphPanel);
        setVisible(true);
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

        UI ui = new UI();
        ui.showGraph(graph);
    }
}