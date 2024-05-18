package src;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class JavaFX_Sample extends Application {
 
    @Override
    public void start(Stage primaryStage) {
        // 创建一个标签控件
        Label label = new Label("Hello, JavaFX!");
 
        // 创建一个面板并将标签添加到面板中
        StackPane root = new StackPane();
        root.getChildren().add(label);
 
        // 创建一个场景并将面板添加到场景中
        Scene scene = new Scene(root, 300, 250);
 
        // 设置舞台的标题和场景，然后显示舞台
        primaryStage.setTitle("Simple JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}