package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GameGUI extends Application {

	private boolean isSwordsmen;
	private boolean isMage;
	private boolean isDruid;
	private boolean isGunner;
	private boolean isMartialArtist;
	private VBox charInfo;
	private VBox charInfoTwo;

	public GameGUI() {
		isSwordsmen = false;
		isMage = false;
		isDruid = false;
		isGunner = false;
		isMartialArtist = false;
		charInfo = new VBox(15);
		charInfoTwo = new VBox(15);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene start = startScreen(primaryStage);
		primaryStage.setTitle("Battle Network Game");
		primaryStage.setScene(start);
		primaryStage.show();
	}

	private Scene startScreen(Stage primaryStage) {
		Pane root = new Pane();
		Image logo = new Image("player.png");
		ImageView logo1 = new ImageView(logo);
		logo1.setLayoutX(350);
		logo1.setLayoutY(80);
		logo1.setFitWidth(580);
		logo1.setFitHeight(520);
		logo1.setId("logo");
		DropShadow ds = new DropShadow(20, Color.BLUE);
		logo1.setEffect(ds);
		Text start = new Text("CLICK TO START GAME!");
		logo1.setOnMouseEntered(event -> {
			logo1.setLayoutX(350);
			logo1.setLayoutY(80);
			logo1.setFitWidth(580);
			logo1.setFitHeight(520);
			start.setId("whiteBtnText");
			start.setLayoutX(580);
			start.setLayoutY(600);
			DropShadow ds1 = new DropShadow(20, Color.BLUE);
			start.setVisible(true);
			start.setEffect(ds1);
			ds1.setColor(Color.BLUE);
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
		
		root.setId("startBackground");

		root.getChildren().addAll(logo1, start);
		Scene startScene = new Scene(root, 1280, 720);
		startScene.getStylesheets().add(getClass().getResource("GameGUI.css").toExternalForm());
		return startScene;
	}

	public StackPane createButtons(String type) {
		Image button = new Image("playerButton.png", 250, 80, false, false);
		ImageView iv = new ImageView(button);
		DropShadow ds = new DropShadow(10, Color.ANTIQUEWHITE);
		iv.setEffect(ds);
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
		pane.getChildren().addAll(iv, buttonText);
		pane.setAlignment(Pos.CENTER);
		pane.setId("buttonText");
		return pane;
	}

	private void chooseCharacterScreen(Stage primaryStage) {
		Text playerOption = new Text();
		playerOption.setText("CHOOSE PLAYER TYPE");
		playerOption.setX(600);
		playerOption.setY(100);
		playerOption.setId("playerOptionText");

		StackPane SwordPane = createButtons("Swordsmen");
		StackPane MagePane = createButtons("Mage");
		StackPane DruidPane = createButtons("Druid");
		StackPane GunnerPane = createButtons("Gunner");
		StackPane MartialArtistPane = createButtons("Martial Artist");
		
		setSwordsmen(false);
		setMage(false);
		setDruid(false);
		setGunner(false);
		setMartialArtist(false);
		
		eventHandleCharBtns(SwordPane, "Swordsmen", primaryStage);
		eventHandleCharBtns(MagePane, "Mage", primaryStage);
		eventHandleCharBtns(DruidPane, "Druid", primaryStage);
		eventHandleCharBtns(GunnerPane, "Gunner", primaryStage);
		eventHandleCharBtns(MartialArtistPane, "Martial Artist", primaryStage);

		VBox btns = new VBox(30);
		btns.setAlignment(Pos.CENTER);
		btns.setLayoutX(525);
		btns.setLayoutY(180);
		btns.getChildren().addAll(SwordPane, MagePane, DruidPane, GunnerPane, MartialArtistPane);
		
		Pane display = new Pane();
		display.getChildren().addAll(playerOption, btns, charInfo, charInfoTwo);
		display.setId("startTwoBackground");
		
		Scene chooseChar = new Scene(display, 1280, 720);
		chooseChar.getStylesheets().add(getClass().getResource("GameGUI.css").toExternalForm());
		primaryStage.setScene(chooseChar);
		primaryStage.show();
	}

	private void eventHandleCharBtns(StackPane pane, String type, Stage primaryStage) {
		pane.setOnMouseClicked(event -> {
			if (type.equals("Swordsmen")) {
				setSwordsmen(true);
			} else if (type.equals("Mage")) {
				setMage(true);
			} else if (type.equals("Druid")) {
				setDruid(true);
			} else if (type.equals("Gunner")) {
				setGunner(true);
			} else if (type.equals("Martial Artist")) {
				setMartialArtist(true);
			}
		});
		
		pane.setOnMouseEntered(event->{
			pane.getChildren().remove(1);
			Text btnText = new Text(type);
			btnText.setId("whiteBtnText");
			pane.getChildren().add(btnText);
			charInfoBox(type);
			charInfo.setVisible(true);
			charInfoTwo.setVisible(true);
		});
		
		pane.setOnMouseExited(event->{
			pane.getChildren().remove(1);
			Text btnText = new Text(type);
			btnText.setId("btnText");
			pane.getChildren().add(btnText);
			charInfo.setVisible(false);
			charInfoTwo.setVisible(false);
		});
		
	}

	private VBox charInfoBox(String type) {
		return charInfo;
	
		
	}

	private void run(GraphicsContext gc) {

	}
	
	public boolean isSwordsmen() {
		return isSwordsmen;
	}

	private void setSwordsmen(boolean isSwordsmen) {
		this.isSwordsmen = isSwordsmen;
	}

	public boolean isMage() {
		return isMage;
	}

	private void setMage(boolean isMage) {
		this.isMage = isMage;
	}

	public boolean isDruid() {
		return isDruid();
	}

	private void setDruid(boolean isDruid) {
		this.isDruid = isDruid;
	}

	public boolean isGunner() {
		return isGunner;
	}

	private void setGunner(boolean isGunner) {
		this.isGunner = isGunner;
	}

	public boolean isMartialArtist() {
		return isMartialArtist;
	}

	private void setMartialArtist(boolean isMartialArtist) {
		this.isMartialArtist = isMartialArtist;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
