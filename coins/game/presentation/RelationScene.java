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
 * Create a scene with a label
 * the label contains the DP relation
 * the exit button exits
 */
public class RelationScene {
	//Attributes
	private GridPane pane;
	private Button back;
	private Label relation;
	private Label relation2;
	private Label relation3;
	private Label max;

	public RelationScene(Stage stage) {
		inialize(stage);
	}

	private void inialize(Stage stage) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		
		setPane(new GridPane());
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(5);
		pane.setVgap(5);
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
		pane.add(logo, 1, 0);
		
		Label base1= new Label("Base case1:");
		base1.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		base1.setTextFill(Color.BLUE);
		pane.add(base1, 1, 1);
		
		relation = new Label();
		relation.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		relation.setTextFill(Color.ORANGERED);
		pane.add(relation, 1, 2);
		
		Label base2= new Label("Base case2:");
		base2.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		base2.setTextFill(Color.BLUE);
		pane.add(base2, 1, 3);

		relation2 = new Label();
		relation2.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		relation2.setTextFill(Color.ORANGERED);
		pane.add(relation2, 1, 4);
		
		relation3 = new Label();
		relation3.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		relation3.setTextFill(Color.ORANGERED);
		pane.add(relation3, 1, 5);
		
		max = new Label();
		max.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		max.setTextFill(Color.BLUE);
		pane.add(max, 1, 6);
		
		back =  new Button("back");
		back.setFont(Font.font(14));
		back.setPrefSize(100, 50);        
		back.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		back.setStyle("-fx-background-radius: 10, 10;-fx-background-color:lightpink;");
		back.setTextFill(Color.valueOf("#CC5144"));
		GridPane.setHalignment(back, HPos.CENTER);
		pane.add(back, 1, 7);
		
		Scene scene = new Scene(pane,900,800);
		stage.setScene(scene);
		stage.setTitle("Win Max Money Game");
		stage.getIcons().add(new Image("images/logo.png"));
		stage.show();
	}

	/*
	 * Getters and Setters
	 */
	public Label getRelation2() {
		return relation2;
	}

	public void setRelation2(Label relation2) {
		this.relation2 = relation2;
	}
	
	private void setPane(GridPane gridPane) {
		this.pane = gridPane;
	}

	public Button getExit() {
		return back;
	}

	public void setExit(Button exit) {
		this.back = exit;
	}

	public Label getRelation() {
		return relation;
	}

	public void setRelation(Label relation) {
		this.relation = relation;
	}

	public Label getRelation3() {
		return relation3;
	}
	
	public void setRelation3(Label relation3) {
		this.relation3=relation3;
	}

	public Label getMax() {
		return max;
	}

	public void setMax(Label max) {
		this.max = max;
	}
}