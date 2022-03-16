package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class GameGUI extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Battle Network Game");
		Button button = new Button();
		button.setText("Start Game");
		StackPane root = new StackPane();
		root.getChildren().add(button);
		primaryStage.setScene(new Scene(root, 1000, 600));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
