package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class GameGUI extends Application {

	private boolean isSwordsmen;
	private boolean isMage;
	private boolean isDruid;
	private boolean isGunner;
	private boolean isMartialArtist;

	public GameGUI() {
		isSwordsmen = false;
		isMage = false;
		isDruid = false;
		isGunner = false;
		isMartialArtist = false;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//
		Scene start = startScreen(primaryStage);
		primaryStage.setTitle("Battle Network Game");
		primaryStage.setScene(start);
		primaryStage.show();
		// Button button = new Button();
		// button.setText("Start Game");
		// StackPane root = new StackPane();
		// root.getChildren().add(button);
		// stage.setScene(new Scene(root, 1000, 600));
		// stage.show();
	}

	private Scene startScreen(Stage primaryStage) {
		Pane root = new Pane();
		Image logo = new Image("welcomeScreen.png");
		ImageView logo1 = new ImageView(logo);
		logo1.setLayoutX(350);
		logo1.setLayoutY(80);
		logo1.setFitWidth(580);
		logo1.setFitHeight(520);
		logo1.setId("logo");
		Text start = new Text("Click to start game!");
		logo1.setOnMouseEntered(event -> {
			logo1.setLayoutX(350);
			logo1.setLayoutY(80);
			logo1.setFitWidth(600);
			logo1.setFitHeight(540);
			start.setId("whiteBtnText");
			start.setLayoutX(590);
			start.setLayoutY(600);
			start.setVisible(true);
		});

		logo1.setOnMouseExited(event -> {
			logo1.setLayoutX(350);
			logo1.setLayoutY(80);
			logo1.setFitWidth(580);
			logo1.setFitHeight(520);
			start.setVisible(false);
		});

		logo1.setOnMouseClicked(event -> {
			chooseCharacterScreen(primaryStage);
		});

		root.getChildren().addAll(logo1, start);
		Scene startScene = new Scene(root, 1280, 720);
		return startScene;
	}

	public StackPane createButtons(String type) {
		Image button = new Image("playerButton.png", 250, 80, false, false);
		Text buttonText = new Text();
		if (type.equals("Swordsmen")) {
			buttonText.setText(type);
		} else if (type.equals("Mage")) {
			buttonText.setText(type);
		} else if (type.equals("Druid")) {
			buttonText.setText(type);
		} else if (type.equals("Gunner")) {
			buttonText.setText(type);
		} else if (type.equals("Martial Artist")) {
			buttonText.setText(type);
		}
		StackPane pane = new StackPane();
		pane.getChildren().add(buttonText);
		pane.setAlignment(Pos.CENTER);
		pane.setId("buttonText");
		return pane;
	}

	private void chooseCharacterScreen(Stage primaryStage) {
		Text playerOption = new Text();
		playerOption.setText("Choose player type");
		playerOption.setX(140);
		playerOption.setY(220);
		playerOption.setId("playerOptionText");

		StackPane SwordPane = createButtons("Swordsmen");
		StackPane MagePane = createButtons("Mage");
		StackPane DruidPane = createButtons("Druid");
		StackPane GunnerPane = createButtons("Gunner");
		StackPane MartialArtistPane = createButtons("Martial Artist");

	}

	private void run(GraphicsContext gc) {

	}

	public static void main(String[] args) {
		launch(args);
	}
}
