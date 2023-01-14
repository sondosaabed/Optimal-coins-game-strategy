package coins.game.control;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import coins.game.application.OptimalGameStrategy;
import coins.game.presentation.ShowTable;
/*
 * Create controller of The show table scene
 */
public class ShowTableCtrl {
	//Attributes
	private ShowTable scene;
	private Button back;
	private GameCtrl scene1;
	private GameM14Ctrl scene2;
	private GameM20Ctrl scene3;

	public ShowTableCtrl(Stage stage, int []coins,OptimalGameStrategy sol) {
		initialize(stage,coins,sol);
	}
	
	private void initialize(Stage stage, int []coins, OptimalGameStrategy sol) {
		setScene(new ShowTable(stage,coins, sol));
		setBack(getScene().getCancel());
		handle_back(getBack(),stage, coins);
	}

	private void handle_back(Button back2, Stage stage, int []coins) {
		//Handle back button
		back.setOnAction(e->{
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
	 * Getters and setters
	 */
	public ShowTable getScene() {
		return scene;
	}

	public void setScene(ShowTable scene) {
		this.scene = scene;
	}

	public Button getBack() {
		return back;
	}

	public void setBack(Button back) {
		this.back = back;
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
	
}