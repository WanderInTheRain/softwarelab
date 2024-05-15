package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * JavaFX主应用程序
 * @author YSJ
 * @version 1.1.0
 * @date 2017-09-18
 */
public class MainApplication extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("BaseWindow.fxml"));
		Parent root = loader.load();
		//获取主窗口上的控件对象
		MenuItem saveMI = (MenuItem)loader.getNamespace().get("saveMenuItem");
		Button textBT = (Button)loader.getNamespace().get("textButton");
		Button showBT = (Button)loader.getNamespace().get("showButton");
		Button queryBT = (Button)loader.getNamespace().get("queryButton");
		Button generateBT = (Button)loader.getNamespace().get("generateButton");
		Button pathBT = (Button)loader.getNamespace().get("pathButton");
		Button walkBT = (Button)loader.getNamespace().get("walkButton");
		//将暂时不可用的控件设置为不可用
		saveMI.setDisable(true);
		textBT.setDisable(true);
		showBT.setDisable(true);
		queryBT.setDisable(true);
		generateBT.setDisable(true);
		pathBT.setDisable(true);
		walkBT.setDisable(true);
		Scene scene = new Scene(root);
		stage.setTitle("软件工程实验一");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
