package coins.game.control;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import coins.game.presentation.RelationScene;
/*
 * Create a Controller of the Relation scene 
 * In which shows the Dynamic programming relation
 */
public class RelationCtrl {
	//Attributes
	private RelationScene scene;
	private GameCtrl scene1;
	private GameM14Ctrl scene2;
	private GameM20Ctrl scene3;
	
	private Button back;
	private Label relation;
	private Label relation2;
	private Label relation3;
	private Label max;

	public RelationCtrl(Stage stage, int []coins) {
		initialize(stage, coins);
	}
	
	private void initialize(Stage stage, int []coins) {
		setScene(new RelationScene(stage));
		setExit(getScene().getExit());
		setRelation(getScene().getRelation());
		setRelation2(getScene().getRelation2());
		setRelation3(getScene().getRelation3());
		setMax(getScene().getMax());
		
		getRelation().setText("\r\n"
				+ "There is one coin"
				+ "		dpTable[j][j] = coins[j]; //Pick that one coin\r\n"
				);
		getRelation2().setText("\r\n"
				+"There are two coins"
				+ "		dpTable[j][j + 1] = max(coins[j], coins[j + 1]);//Pick the max\r\n"
				);
		getRelation3().setText(
				  "else\r\n"
				+ "		choice1 = coins[j] + min(dpTable[j + 2][j + i], dpTable[j + 1][j + i - 1]);\r\n"
				+ "     	choice2 = coins[j + i] + min(dpTable[j + 1][j + i - 1], dpTable[j][j + i - 2]);\r\n"
				+ "     	dpTable[j][j + i] = max(choice1, choice2);\r\n"
				);
		getMax().setText("max= dpTable[0][size - 1];");
		handle_exit(getExit(), stage, coins);
	}

	private Label getRelation2() {
		return relation2;		
	}

	private void setRelation2(Label relation22) {
		this.relation2=relation22;
	}

	private void handle_exit(Button exit,Stage stage, int []coins) {
		//This method handle back for the scenes
		exit.setOnAction(e->{
			if(coins.length<14) {
				setScene1(new GameCtrl(stage, coins));
			}else if(coins.length>=14) {
				setScene2(new GameM14Ctrl(stage, coins));
			}else {
				setScene3(new GameM20Ctrl(stage, coins));
			}
		});
	}
	/*
	 * Getters and Setters
	 */
	public RelationScene getScene() {
		return scene;
	}

	public void setScene(RelationScene scene) {
		this.scene = scene;
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

	public GameCtrl getScene1() {
		return scene1;
	}

	public void setScene1(GameCtrl scene1) {
		this.scene1 = scene1;
	}

	public GameM14Ctrl getScene2() {
		return scene2;
	}

	public void setScene2(GameM14Ctrl scene2) {
		this.scene2 = scene2;
	}

	public GameM20Ctrl getScene3() {
		return scene3;
	}

	public void setScene3(GameM20Ctrl scene3) {
		this.scene3 = scene3;
	}

	public Label getRelation3() {
		return relation3;
	}

	public void setRelation3(Label relation3) {
		this.relation3 = relation3;
	}

	public Label getMax() {
		return max;
	}

	public void setMax(Label max) {
		this.max = max;
	}
}