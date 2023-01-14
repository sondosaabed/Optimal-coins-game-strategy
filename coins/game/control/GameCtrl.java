package coins.game.control;

import coins.game.application.OptimalGameStrategy;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import coins.game.presentation.GameScene;
/*
 * Create a Controller after getting the input and put it into an array
 * either from the keyboard by interface 
 * or by browsing and reading a file
 * The array is passed to the constructor here
 */
public class GameCtrl {
	//Attributes
	private GameScene scene;
	private RelationCtrl scene1;
	private ShowTableCtrl scene2;
	private Button play;
	private Button table;
	private Button relation;
	private Button exit;
	private Label max;

	public GameCtrl(Stage stage, int[] coins) {
		initialize(stage, coins);
	}

	private void initialize(Stage stage, int[] coins) {
		setScene(new GameScene(stage, coins));

		setPlay(getScene().getPlay());
		setTable(getScene().getTable());
		setRelation(getScene().getRelation());
		setExit(getScene().getExit());
		setMax(getScene().getMax());

		OptimalGameStrategy sol = new OptimalGameStrategy(coins);

		getMax().setText("Win:"+ sol.getMax()+" coins");
		handle_play(getPlay(),sol);
		handle_exit(getExit());
		handle_table(getTable(),stage,coins,sol);
		handle_relation(getRelation(),stage,coins);
	}

	private void handle_exit(Button exit) {
		//this method handles exit
		exit.setOnAction(e->{
			Platform.exit();
		});
	}
	
	private void handle_play(Button play,OptimalGameStrategy sol) { 
		//this method handle the play button
		play.setOnAction(e -> {
			//When clicked the simulation of the game starts
			Label label = new Label("Green is Player1:");
			label.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
			label.setTextFill(Color.GREEN);
			GridPane.setHalignment(label, HPos.CENTER);
			getScene().getPane().add(label, 1, 3);

			Timeline timeline = new Timeline();
			for (int i = 0; i <getScene().getButtons().size(); i++) {
				PickButtonControl pbc =getScene().getButtons().get(i);
				if(pbc.getPick().isPicked()) {
					KeyFrame keyFrame = new KeyFrame(Duration.seconds(i*2), event -> {
			        	pbc.select();	       
					});
					timeline.getKeyFrames().add(keyFrame);
				}else {
					KeyFrame keyFrame = new KeyFrame(Duration.seconds(i*3), event -> {
			        	pbc.unselect();   
					});
					timeline.getKeyFrames().add(keyFrame);
				}
			}
			timeline.setCycleCount(sol.getSize());
			timeline.play();
		});
	}
	
	private void handle_table(Button table, Stage stage,int []coins,OptimalGameStrategy sol) {
		//this method handle the table button
		table.setOnAction(e->{
			setScene2(new ShowTableCtrl(stage,coins,sol));//shows the dynamic programming table
		});
	}

	private void handle_relation(Button relation, Stage stage, int []coins) {
		//This method handles button relation
		relation.setOnAction(e->{
			setScene1(new RelationCtrl(stage,coins));//Shows the Dynamic relation use din the solution
		});
	}

	/*
	 * Getters and setters
	 */
	public GameScene getScene() {
		return scene;
	}
	public void setScene(GameScene scene) {
		this.scene = scene;
	}

	public Button getPlay() {
		return play;
	}

	public void setPlay(Button play) {
		this.play = play;
	}

	public Button getTable() {
		return table;
	}

	public void setTable(Button table) {
		this.table = table;
	}

	public Button getRelation() {
		return relation;
	}

	public void setRelation(Button relation) {
		this.relation = relation;
	}

	public Button getExit() {
		return exit;
	}

	public void setExit(Button exit) {
		this.exit = exit;
	}

	public Label getMax() {
		return max;
	}

	public void setMax(Label max) {
		this.max = max;
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