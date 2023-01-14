package coins.game.presentation;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
 * Create the first scene in which the user is asked to input data either by keyboard or by browse
 */
public class RowInputScene {
	//Attributes
	private GridPane pane;
	private Button browse;
	private Button cancel;
	private Button input;

	public RowInputScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100, 100, 100, 100));
		pane.setHgap(15);
		pane.setVgap(15);
		pane.setBackground(background);

		Image img = new Image("images/logo.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(150);
		v.setFitHeight(150);

		Button logo = new Button();
		logo.setPrefSize(150, 150);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 0, 0);

		Label hello = new Label(("Hello user, chose how you enter values!"));
		hello.setFont(Font.font("Lucida Sans Unicode", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 30));
		hello.setTextFill(Color.GOLD);
		pane.add(hello, 0, 1);

		browse =  new Button("Browse file");
		browse.setFont(Font.font(14));
		browse.setPrefSize(200, 70);        
		browse.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 25));
		browse.setStyle("-fx-background-radius: 10, 10;-fx-background-color:#B2F7F9;");
		browse.setTextFill(Color.valueOf("#CC5144"));//#CC5144
		GridPane.setHalignment(browse, HPos.CENTER);
		pane.add(browse, 0, 4);		

		input =  new Button("By keyboard");
		input.setFont(Font.font(14));
		input.setPrefSize(200, 70);        
		input.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 25));
		input.setStyle("-fx-background-radius: 10, 10;-fx-background-color:#B2F7F9;");
		input.setTextFill(Color.valueOf("#CC5144"));//#CC5144
		GridPane.setHalignment(input, HPos.CENTER);
		pane.add(input, 0, 5);	

		cancel = new Button("Exit");
		cancel.setFont(Font.font(14));
		cancel.setPrefSize(200, 70);
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 25));
		cancel.setStyle("-fx-background-radius: 10, 10;-fx-background-color:#B2F7F9;");        
		cancel.setTextFill(Color.valueOf("#CC5144"));
		GridPane.setHalignment(cancel, HPos.CENTER);
		pane.add(cancel, 0, 8);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Win Max Money Game");
		stage.getIcons().add(new Image("images/logo.png"));
		stage.show();
	}
	/*
	 * Getters and setters
	 */
	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public Button getBrowse() {
		return browse;
	}

	public void setBrowse(Button run) {
		this.browse = run;
	}

	public Button getCancel() {
		return cancel;
	}

	public Button getInput() {
		return input;
	}

	public void setInput(Button input) {
		this.input = input;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
}