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
 * Create a scene that shows a new window with some specific alert for the user
 */
public class AlertBoxScene {
	//Attributes
	private Stage window;
	private Label message;
	private Button cancel;
	private GridPane pane;;
	
	public AlertBoxScene() {
		initialize();
	}

	private void initialize() {
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
		v.setFitWidth(70);
		v.setFitHeight(70);

		Button logo = new Button();
		logo.setPrefSize(70, 70);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 0, 0);
		
		message=new Label();
		message.setFont(Font.font("Lucida Sans Unicode", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 20));
		message.setTextFill(Color.ORANGERED);
		pane.add(message, 0, 1);
		
		cancel = new Button("Cancel");
		cancel.setFont(Font.font(14));
		cancel.setPrefSize(100, 50);
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		cancel.setStyle("-fx-background-radius: 10, 10;-fx-background-color:#B2F7F9;");        
		cancel.setTextFill(Color.valueOf("#CC5144"));
		GridPane.setHalignment(cancel, HPos.CENTER);
		pane.add(cancel, 0, 2);

		Scene scene = new Scene(pane);
		window=new Stage();
		window.setScene(scene);
		window.getIcons().add(new Image("images/logo.png"));
	}
	/*
	 * Getters and Setters
	 */
	public Stage getWindow() {
		return window;
	}

	public void setWindow(Stage window) {
		this.window = window;
	}

	public Label getMessage() {
		return message;
	}

	public void setMessage(Label message) {
		this.message = message;
	}

	public Button getCance() {
		return cancel;
	}

	public void setCance(Button cance) {
		this.cancel = cance;
	}
}