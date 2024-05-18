package frontend;
import javax.swing.*;
import backend.PointedNode;
import backend.PointedEdge;
import backend.PointedGraph;
import backend.Node;
import backend.Edge;
import backend.Graph;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random; 

public class GraphPanel extends JPanel {
    private PointedGraph graph;

    public GraphPanel(PointedGraph graph) {
        this.graph = graph;
    }
    public void setGraph(PointedGraph graph) {
        this.graph = graph;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Anti-aliasing for smoother graphics
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw edges
        for (PointedEdge edge : graph.getEdges()) {
            drawEdge(g2d, edge);
        }

        // Draw nodes
        for (PointedNode node : graph.getNodes()) {
            drawNode(g2d, node);
        }
    }

    private void drawNode(Graphics2D g2d, PointedNode node) {
        int radius = 20;
        int diameter = radius * 2;
        g2d.setColor(Color.BLACK);
        g2d.fillOval(node.x - radius, node.y - radius, diameter, diameter);
        g2d.setColor(Color.WHITE);
        g2d.drawString(node.word, node.x -radius / 2, node.y + radius / 2);
    }

    private void drawEdge(Graphics2D g2d, PointedEdge edge) {
        g2d.setColor(Color.BLACK);
        // Draw edge between from and to nodes
        g2d.draw(new Line2D.Double(edge.from.x, edge.from.y, edge.to.x, edge.to.y));

        // Draw weight
        int midX = (edge.from.x + edge.to.x) / 2;
        int midY = (edge.from.y + edge.to.y) / 2;
        g2d.drawString(String.valueOf(edge.weight), midX, midY);
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

        PointedGraph graph2 = new PointedGraph();
        graph2.genPointedGraphFromGraph(graph);

        JFrame frame = new JFrame("Graph Example");
        GraphPanel graphPanel = new GraphPanel(graph2);
        frame.add(graphPanel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

