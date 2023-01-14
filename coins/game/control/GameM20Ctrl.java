package coins.game.control;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import coins.game.application.OptimalGameStrategy;
import coins.game.presentation.GameM20Scene;
/*
 * Create the game scene controller when the coins size is more than 20
 */
public class GameM20Ctrl {
	//Attributes
	private GridPane pane;
	private GameM20Scene scene;
	private RelationCtrl scene1;
	private Button relation;
	private Button exit;
	private Label max;
	
	public GameM20Ctrl(Stage stage, int[] coins) {
		initialize(stage,coins);
	}

	private void initialize(Stage stage, int[] coins) {
		setScene(new GameM20Scene(stage, coins));
		setRelation(getScene().getRelation());
		setMax(getScene().getMax());
		OptimalGameStrategy sol = new OptimalGameStrategy(coins);
		getMax().setText("Max win is:" + sol.getMax());
		setExit(getScene().getExit());
		
		handle_exit(getExit());
		handle_relation(getRelation(), stage,coins);
	}

	private void handle_relation(Button relation, Stage stage, int []coins) {
		//Show the dynamic program relation
		relation.setOnAction(e->{
			setScene1(new RelationCtrl(stage, coins));
		});
	}
	private void handle_exit(Button exit) {
		exit.setOnAction(e->{
			Platform.exit();
		});
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

	public GameM20Scene getScene() {
		return scene;
	}

	public void setScene(GameM20Scene scene) {
		this.scene = scene;
	}

	public Button getRelation() {
		return relation;
	}

	public void setRelation(Button relation) {
		this.relation = relation;
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

	public RelationCtrl getScene1() {
		return scene1;
	}

	public void setScene1(RelationCtrl scene1) {
		this.scene1 = scene1;
	}
}