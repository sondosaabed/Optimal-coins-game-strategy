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
 * Create a game scene when the size of the coins array is more that 20
 * Shows the relation, 
 * gets the optimal solution
 */
public class GameM20Scene {
	//Attributes
	private GridPane pane;
	private Button relation;
	private Label max;
	private Button exit;
	
	public GameM20Scene(Stage stage, int[] coins) {
		initialize(stage,coins);
	}

	private void initialize(Stage stage, int[] coins) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		
		setPane(new GridPane());
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100, 100,100, 100));
		pane.setHgap(20);
		pane.setVgap(20);
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
		
		max = new Label();
		max.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		max.setTextFill(Color.GOLD);
		GridPane.setHalignment(max, HPos.CENTER);
		pane.add(max, 1, 1);
		
		relation =  new Button("DP relation");
		relation.setFont(Font.font(14));
		relation.setPrefSize(200, 50);        
		relation.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		relation.setStyle("-fx-background-radius: 7, 7;-fx-background-color:#B2F7F9;");
		relation.setTextFill(Color.valueOf("#CC5144"));//#CC5144
		GridPane.setHalignment(relation, HPos.CENTER);
		pane.add(relation, 1, 2);
		
		exit =  new Button("exit");
		exit.setFont(Font.font(14));
		exit.setPrefSize(50, 50);        
		exit.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		exit.setStyle("-fx-background-radius: 10, 10;-fx-background-color:lightpink;");
		exit.setTextFill(Color.valueOf("#CC5144"));//#CC5144
		GridPane.setHalignment(exit, HPos.CENTER);
		pane.add(exit, 1,3);	
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Win Max Money Game");
		stage.getIcons().add(new Image("images/logo.png"));
		stage.show();
	}
	/*
	 * Getters and Setters
	 */
	public Button getRelation() {
		return relation;
	}

	public void setRelation(Button relation) {
		this.relation = relation;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public Label getMax() {
		return max;
	}

	public void setMax(Label max) {
		this.max = max;
	}
	
	public Button getExit() {
		return exit;
	}

	public void setExit(Button exit) {
		this.exit = exit;
	}

}