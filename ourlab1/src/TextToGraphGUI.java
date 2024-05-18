package ourlab1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TextToGraphGUI extends JFrame {

    private JTextArea textArea;
    private JButton processButton;
    private JPanel graphPanel;

    private Map<String, Map<String, Integer>> graph;

    public TextToGraphGUI() {
        setTitle("Text To Graph Converter");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane textScrollPane = new JScrollPane(textArea);

        processButton = new JButton("Process Text");
        processButton.addActionListener(new ProcessButtonListener());

        graphPanel = new JPanel();
        graphPanel.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(processButton);

        add(textScrollPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.NORTH);
        add(graphPanel, BorderLayout.SOUTH);

        graph = new HashMap<>();
    }

    private class ProcessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            processText();
            displayGraph();
        }
    }

    private void processText() {
        String text = textArea.getText();
        graph.clear();

        String[] lines = text.split("\\r?\\n");
        for (String line : lines) {
            processLine(line);
        }
    }

    private void processLine(String line) {
        line = line.replaceAll("[^a-zA-Z ]", " "); // Replace non-alphabetic characters with spaces
        line = line.toLowerCase(); // Convert to lowercase
        String[] words = line.split("\\s+"); // Split by whitespace
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (!word1.isEmpty() && !word2.isEmpty()) {
                addEdge(word1, word2);
            }
        }
    }

    private void addEdge(String word1, String word2) {
        graph.putIfAbsent(word1, new HashMap<>());
        Map<String, Integer> neighbors = graph.get(word1);
        neighbors.put(word2, neighbors.getOrDefault(word2, 0) + 1);
    }

    private void displayGraph() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Map<String, Integer>> entry : graph.entrySet()) {
            String word = entry.getKey();
            Map<String, Integer> neighbors = entry.getValue();
            for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
                String neighborWord = neighbor.getKey();
                int weight = neighbor.getValue();
                result.append(word).append(" -> ").append(neighborWord).append(" (Weight: ").append(weight).append(")\n");
            }
        }
        graphPanel.removeAll();
        JTextArea resultArea = new JTextArea(result.toString());
        JScrollPane scrollPane = new JScrollPane(resultArea);
        graphPanel.add(scrollPane, BorderLayout.CENTER);
        graphPanel.revalidate();
        graphPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextToGraphGUI gui = new TextToGraphGUI();
            gui.setVisible(true);
        });
    }
}
