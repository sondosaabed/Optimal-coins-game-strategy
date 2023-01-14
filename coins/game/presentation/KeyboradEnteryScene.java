package coins.game.presentation;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
/*
 * Create a scene that allows user to enter the input by the keyboard
 */
public class KeyboradEnteryScene {
	//Attributes
	private GridPane pane;
	private Label enter;
	private Label enter2;
	private Button ok;
	private Button exit;
	private TextField number;
	private TextField entery;
	
	public KeyboradEnteryScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100, 150, 100, 150));
		pane.setHgap(15);
		pane.setVgap(15);
		pane.setBackground(background);

		Image img = new Image("images/logo.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(100);
		v.setFitHeight(100);

		Button logo = new Button();
		logo.setPrefSize(100, 100);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 0, 0);
				
		enter = new Label("Enter number of values:");	
		enter.setFont(Font.font("Lucida Sans Unicode", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 20));
		enter.setTextFill(Color.GOLD);
		pane.add(enter, 0, 1);
		
		number = new TextField();	
		number.setPrefHeight(50);
		number.setPrefWidth(200);
		pane.add(number, 0, 2);

		enter2= new Label("Seprate inputs with commas:");	
		enter2.setFont(Font.font("Lucida Sans Unicode", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 20));
		enter2.setTextFill(Color.GOLD);
		pane.add(enter2, 0, 3);
		
		entery = new TextField();
		entery.setPrefHeight(200);
		number.setPrefWidth(200);
		pane.add(entery, 0, 4);
		
		ok = new Button("Okay");
		ok.setFont(Font.font(14));
		ok.setPrefSize(100, 50);        
		ok.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		ok.setStyle("-fx-background-radius: 7, 7;-fx-background-color:#B2F7F9;");
		ok.setTextFill(Color.valueOf("#CC5144"));//#CC5144
		GridPane.setHalignment(ok, HPos.CENTER);
		pane.add(ok, 0, 5);	
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Win Max Money Game");
		stage.getIcons().add(new Image("images/logo.png"));
		stage.show();
	}
	/*
	 * Getters and setters
	 */
	public Label getEnter() {
		return enter;
	}

	public void setEnter(Label enter) {
		this.enter = enter;
	}

	public TextField getEntery() {
		return entery;
	}

	public void setEntery(TextField entery) {
		this.entery = entery;
	}

	public TextField getNumber() {
		return number;
	}

	public void setNumber(TextField number) {
		this.number = number;
	}

	public Label getEnter2() {
		return enter2;
	}

	public void setEnter2(Label enter2) {
		this.enter2 = enter2;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public Button getOk() {
		return ok;
	}

	public void setOk(Button ok) {
		this.ok = ok;
	}

	public Button getExit() {
		return exit;
	}

	public void setExit(Button exit) {
		this.exit = exit;
	}
}