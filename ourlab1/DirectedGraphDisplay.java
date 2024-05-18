package ourlab1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;

public class DirectedGraphDisplay extends Application {
    
    private ArrayList<Circle> nodes = new ArrayList<>();
    private ArrayList<Line> edges = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        // Add nodes
        addNode(100, 100);
        addNode(200, 100);
        addNode(300, 200);
        addNode(200, 300);
        
        // Add edges
        addEdge(nodes.get(0), nodes.get(1));
        addEdge(nodes.get(1), nodes.get(2));
        addEdge(nodes.get(2), nodes.get(3));
        addEdge(nodes.get(3), nodes.get(0));

        // Add nodes and edges to pane
        pane.getChildren().addAll(nodes);
        pane.getChildren().addAll(edges);

        // Create scene and set it in the stage
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Directed Graph");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addNode(double x, double y) {
        Circle circle = new Circle(x, y, 10);
        nodes.add(circle);
    }

    private void addEdge(Circle start, Circle end) {
        Line line = new Line();
        line.setStartX(start.getCenterX());
        line.setStartY(start.getCenterY());
        line.setEndX(end.getCenterX());
        line.setEndY(end.getCenterY());
        edges.add(line);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

