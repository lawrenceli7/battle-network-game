package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
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
	private MediaPlayer openingMusic;
	private Music music;
	private String playerName;
	private playerChar player;

	public GameGUI() {
		isSwordsmen = false;
		isMage = false;
		isDruid = false;
		isGunner = false;
		isMartialArtist = false;
		charInfo = new VBox(15);
		charInfoTwo = new VBox(15);
		music = new Music();
		openingMusic = music.openingMusic();
		player = new playerChar();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Starts the scene
		Scene start = startScreen(primaryStage);

		// Sets title to the top left corner
		primaryStage.setTitle("Battle Network Game");
		primaryStage.setScene(start);
		primaryStage.show();
	}

	// Starting screen when launching JavaFX
	private Scene startScreen(Stage primaryStage) {
		// Creating Pane to display everything on the screen
		Pane root = new Pane();

		// Creating the image and setting the dimensions
		Image logo = new Image("player.png");
		ImageView logo1 = new ImageView(logo);
		logo1.setLayoutX(350);
		logo1.setLayoutY(80);
		logo1.setFitWidth(580);
		logo1.setFitHeight(520);
		logo1.setId("logo");
		DropShadow ds = new DropShadow(20, Color.BLUE);
		logo1.setEffect(ds);

		// Creating a text message
		Text start = new Text("CLICK TO START GAME!");

		// Mouse clicking on the image
		logo1.setOnMouseEntered(event -> {
			logo1.setLayoutX(350);
			logo1.setLayoutY(80);
			logo1.setFitWidth(580);
			logo1.setFitHeight(520);
			start.setId("whiteBtnText");
			start.setLayoutX(480);
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
		
		//plays music
		openingMusic.play();

		// Adding background image
		root.setId("startBackground");

		// Setting dimensions and the scene and starting the scene
		root.getChildren().addAll(logo1, start);
		Scene startScene = new Scene(root, 1280, 720);
		startScene.getStylesheets().add(getClass().getResource("GameGUI.css").toExternalForm());
		return startScene;
	}

	// Creating text buttons types for the different player options
	public StackPane createButtons(String type) {
		// Creating image, text, and color outline
		Image button = new Image("playerButton.png", 250, 80, false, false);
		ImageView iv = new ImageView(button);
		DropShadow ds = new DropShadow(10, Color.ANTIQUEWHITE);
		iv.setEffect(ds);
		Text buttonText = new Text();

		// Determine text buttons for player type
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

		// creating the pane and positioning it to be centered
		StackPane pane = new StackPane();
		pane.getChildren().addAll(iv, buttonText);
		pane.setAlignment(Pos.CENTER);
		pane.setId("buttonText");
		return pane;
	}

	// Screen where you can choose what player to use
	private void chooseCharacterScreen(Stage primaryStage) {
		// Displaying text for player option and setting the dimensions onto the screen
		Text playerOption = new Text();
		playerOption.setText("CHOOSE PLAYER TYPE");
		playerOption.setX(280);
		playerOption.setY(100);
		playerOption.setId("playerOptionText");

		// Creating the buttons for each player option
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

		// Creating event handlers for when each player is clicked
		eventHandleCharBtns(SwordPane, "Swordsmen", primaryStage);
		eventHandleCharBtns(MagePane, "Mage", primaryStage);
		eventHandleCharBtns(DruidPane, "Druid", primaryStage);
		eventHandleCharBtns(GunnerPane, "Gunner", primaryStage);
		eventHandleCharBtns(MartialArtistPane, "Martial Artist", primaryStage);

		// Creating the boxes for buttons and positioning it to be centered
		// Also setting the dimensions
		VBox btns = new VBox(30);
		btns.setAlignment(Pos.CENTER);
		btns.setLayoutX(525);
		btns.setLayoutY(180);
		btns.getChildren().addAll(SwordPane, MagePane, DruidPane, GunnerPane, MartialArtistPane);

		// Adding background image
		Pane display = new Pane();
		display.getChildren().addAll(playerOption, btns, charInfo, charInfoTwo);
		display.setId("startTwoBackground");

		// Displaying the screen
		Scene chooseChar = new Scene(display, 1280, 720);
		chooseChar.getStylesheets().add(getClass().getResource("GameGUI.css").toExternalForm());
		primaryStage.setScene(chooseChar);
		primaryStage.show();
	}

	// When player button is pressed
	private void eventHandleCharBtns(StackPane pane, String type, Stage primaryStage) {
		// Determine the character based on mouse click
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
			playerNameScreen(primaryStage);
		});

		pane.setOnMouseEntered(event -> {
			pane.getChildren().remove(1);
			Text buttonText = new Text(type);
			buttonText.setId("whiteBtnText");
			pane.getChildren().add(buttonText);
			charInfoBox(type);
			charInfo.setVisible(true);
			charInfoTwo.setVisible(true);
		});

		pane.setOnMouseExited(event -> {
			pane.getChildren().remove(1);
			Text buttonText = new Text(type);
			buttonText.setId("buttonText");
			pane.getChildren().add(buttonText);
			charInfo.setVisible(false);
			charInfoTwo.setVisible(false);
		});

	}

	private VBox charInfoBox(String type) {
		charInfo.setId("charInfoBox");
		charInfoTwo.setId("charInfoBox");
		
		if (type.equals("Swordsmen")) {
			charInfo.getChildren().clear();
			charInfo.setLayoutX(180);
			charInfo.setLayoutY(180);
			charInfoTwo.getChildren().clear();
			charInfoTwo.setLayoutX(820);
			charInfoTwo.setLayoutY(180);
			
			Text info = new Text();
			playerChar swordsmen = new Swordsmen();
			info.setText("HP = 100" + "\n" 
					+ "Speed = 5" + "\n" 
					+ "Element = none" + "\n" 
					+ "Weapon Damage = 40");
			charInfo.getChildren().add(info);
			
			Text infoTwo = new Text();
			infoTwo.setText("Swordsmen are the masters of the sword as they are" + "\n"
					+ "strong both offensively and defensively, conquering" + "\n"
					+ "battlefields and providing protection for teammates." + "\n"
					+ "Swordsmen do not demonstrate physical strength" + "\n"
					+ "unwillingly to their enemies, for that is not the way of" + "\n" + "a Swordsman.");
			charInfoTwo.getChildren().add(infoTwo);
			
		} else if (type.equals("Mage")) {
			charInfo.getChildren().clear();
			charInfo.setLayoutX(180);
			charInfo.setLayoutY(280);
			charInfoTwo.getChildren().clear();
			charInfoTwo.setLayoutX(800);
			charInfoTwo.setLayoutY(280);
			
			Text info = new Text();
			playerChar mage = new Mage();
			info.setText("HP = 120" + "\n" 
					+ "Speed = 0" + "\n" 
					+ "Element = 1" + "\n" 
					+ "Weapon Damage = 0");
			charInfo.getChildren().add(info);
			
			Text infoTwo = new Text();
			infoTwo.setText("The mage is a damage-dealing spell-caster that specializes" + "\n"
					+ "in burst damage and area of effect spells. Mages are well" + "\n"
					+ "known for their formidable damage output, as well as their" + "\n"
					+ "range of crowd control abilities.");
			charInfoTwo.getChildren().add(infoTwo);
			
		} else if (type.equals("Druid")) {
			charInfo.getChildren().clear();
			charInfo.setLayoutX(180);
			charInfo.setLayoutY(390);
			charInfoTwo.getChildren().clear();
			charInfoTwo.setLayoutX(790);
			charInfoTwo.setLayoutY(385);
			
			Text info = new Text();
			playerChar druid = new Druid();
			info.setText("HP = 150" + "\n" 
					+ "Speed = 0" + "\n" 
					+ "Element = 3" + "\n" 
					+ "Weapon Damage = 0");
			charInfo.getChildren().add(info);
			
			Text infoTwo = new Text();
			infoTwo.setText("Whether calling on the elemental forces of nature or" + "\n"
					+ "emulating the creatures of the animal world, druids are an" + "\n"
					+ "embodiment of nature's resilience, cunning, and fury. They" + "\n"
					+ "claim no mastery over nature. Instead, they see themselves as" + "\n"
					+ "extensions of nature's indomitable will.");
			charInfoTwo.getChildren().add(infoTwo);
			
		} else if (type.equals("Gunner")) {
			charInfo.getChildren().clear();
			charInfo.setLayoutX(180);
			charInfo.setLayoutY(500);
			charInfoTwo.getChildren().clear();
			charInfoTwo.setLayoutX(785);
			charInfoTwo.setLayoutY(495);
			
			Text info = new Text();
			playerChar gunner = new Gunner();
			info.setText("HP = 140" + "\n" 
					+ "Speed = 0" + "\n" 
					+ "Element = 4" + "\n" 
					+ "Weapon Damage = 0");
			charInfo.getChildren().add(info);
			
			Text infoTwo = new Text();
			infoTwo.setText("The ability to generate electricity. Sub-power of Electricity" + "\n"
					+ "Manipulation. Variation of Elemental Generation and Energy" + "\n"
					+ "Generation. The user can generate electricity, the energy" + "\n"
					+ "emitted from charged particles. Users can become creative" + "\n"
					+ "and use it in various methods.");
			charInfoTwo.getChildren().add(infoTwo);
			
		} else if (type.equals("Martial Artist")) {
			charInfo.getChildren().clear();
			charInfo.setLayoutX(180);
			charInfo.setLayoutY(600);
			charInfoTwo.getChildren().clear();
			charInfoTwo.setLayoutX(785);
			charInfoTwo.setLayoutY(600);
			
			Text info = new Text();
			playerChar martial_artist = new Martial_Artist();
			info.setText("HP = 110" + "\n" 
					+ "Speed = 0" + "\n" 
					+ "Element = 2" + "\n" 
					+ "Weapon Damage = 0");
			charInfo.getChildren().add(info);
			
			Text infoTwo = new Text();
			infoTwo.setText("Martial arts are codified systems and traditions of combat" + "\n"
					+ "practiced for a number of reasons such as self-defense;" + "\n"
					+ "military and law enforcement applications; competition;" + "\n"
					+ "physical, mental, and spiritual development; entertainment;" + "\n"
					+ "and the preservation of a nation's intangible cultural heritage.");
			charInfoTwo.getChildren().add(infoTwo);
			
		}
		return charInfo;

	}
	
	private void playerNameScreen(Stage primaryStage) {
		GridPane getName = new GridPane();
		
		Label charName = new Label("Character Name: ");
		charName.setId("characterNameText");
		TextField charNameBox = new TextField();
		
		Button submitBtn = new Button("PLAY");
		submitBtn.setId("yellowBtn");
		submitBtn.setLayoutX(1050);
		submitBtn.setLayoutY(600);
		
		Button backBtn = new Button("BACK");
		backBtn.setId("yellowBtn");
		backBtn.setLayoutX(100);
		backBtn.setLayoutY(600);
		
		backBtn.setOnAction(event -> {chooseCharacterScreen(primaryStage);
		});
		
		Text error = new Text();

		submitBtn.setOnMouseClicked(event -> {
			if (charNameBox.getText().isEmpty() == true) {
				error.setId("errorText");
				error.setText("Please Enter A Name");
			} else {
				openingMusic.stop();
				String name = charNameBox.getText();
				setplayerName(name);
				createPlayer();
				battleScreen(primaryStage);
			}
		});
		
		getName.add(charName, 0, 0);
		getName.add(charNameBox, 0, 1);
		getName.add(error, 0, 2);
		GridPane.setHalignment(error, HPos.CENTER);
		
		for (int i = 0; i < 3; i++) {
			RowConstraints row = new RowConstraints(40);
			getName.getRowConstraints().add(row);
		}
		
		getName.setId("getNameGrid");
		getName.setLayoutX(430);
		getName.setLayoutY(250);
		;
		
		Pane display = new Pane();
		display.getChildren().addAll(getName, backBtn, submitBtn);
		display.setId("startTwoBackground");
		
		Scene chooseCharName = new Scene(display, 1280, 720);
		chooseCharName.getStylesheets().add(getClass().getResource("GameGUI.css").toExternalForm());
		primaryStage.setScene(chooseCharName);
		primaryStage.show();
	}
	
	private void createPlayer() {
		if (isSwordsmen == true) {
			player = new Swordsmen();
			player.setName(playerName);
		} else if (isMage == true) {
			player = new Mage();
			player.setName(playerName);
		} else if (isDruid == true) {
			player = new Druid();
			player.setName(playerName);
		} else if (isGunner == true) {
			player = new Gunner();
			player.setName(playerName);
		} else if (isMartialArtist == true) {
			player = new Martial_Artist();
			player.setName(playerName);
		}
	}
	
	public void battleScreen(Stage primaryStage) {
		primaryStage.show();
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
	
	private String getplayerName() {
		return playerName;
	}
	
	public void setplayerName(String playerName) {
		this.playerName = playerName;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
