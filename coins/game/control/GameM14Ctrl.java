package coins.game.control;

import coins.game.application.OptimalGameStrategy;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import coins.game.presentation.GameM14Scene;
/*
 * Create a Controller for teh scene where the coins array has more than 14 elemnts,
 * Shows DP table,
 * Gets the Optimal solution
 */
public class GameM14Ctrl {
	//Attributes
	private GameM14Scene scene;
	private RelationCtrl scene1;
	private ShowTableCtrl scene2;
	private GridPane pane;
	private Button table;
	private Button relation;
	private Button exit;
	private Label max;
	
	public GameM14Ctrl(Stage stage, int[] coins) {
		initialize(stage, coins);
	}
	
	private void initialize(Stage stage, int [] coins) {
		setScene(new GameM14Scene(stage, coins));
		setPane(getScene().getPane());
		setTable(getScene().getTable());
		setRelation(getScene().getRelation());
		setExit(getScene().getExit());
		setMax(getScene().getMax());
		
		OptimalGameStrategy sol = new OptimalGameStrategy(coins);
		getMax().setText("Win:"+ sol.getMax()+" coins");
		handle_exit(getExit());
		handle_table(getTable(),stage, coins,sol);
		handle_relation(getRelation(), stage,coins);
	}

	private void handle_relation(Button relation, Stage stage,int []coins) {
		//Shows the dp relation
		relation.setOnAction(e->{
			setScene1(new RelationCtrl(stage,coins));
		});
	}
	private void handle_table(Button table, Stage stage,int []coins,OptimalGameStrategy sol) {
		table.setOnAction(e->{
			//shows the dynamic programming table
			setScene2(new ShowTableCtrl(stage,coins,sol));
		});
	}
	
	private void handle_exit(Button exit) {
		//Handles exit
		exit.setOnAction(e->{
			Platform.exit();
		});
	}
	/*
	 * Getters and Setters
	 */
	public GameM14Scene getScene() {
		return scene;
	}
	
	public void setScene(GameM14Scene scene) {
		this.scene = scene;
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

	public Button getRelation() {
		return relation;
	}

	public void setRelation(Button relation) {
		this.relation = relation;
	}

	public Button getTable() {
		return table;
	}

	public void setTable(Button table) {
		this.table = table;
	}

	public RelationCtrl getScene1() {
		return scene1;
	}

	public void setScene1(RelationCtrl scene1) {
		this.scene1 = scene1;
	}

	public ShowTableCtrl getScene2() {
		return scene2;
	}

	public void setScene2(ShowTableCtrl scene2) {
		this.scene2 = scene2;
	}
}