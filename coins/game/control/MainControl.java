package coins.game.control;
/*
 * Create the main controller that shows the first scene in the main
 */
import javafx.stage.Stage;

public class MainControl {
	//Attributes
	private Stage stage;
	private RowInputCtrl firstScene;

	public MainControl(Stage stage) {
		this.stage= stage;
	}

	public void showRowInputScene() {
		setFirstScene(new RowInputCtrl(stage));
	}
	/*
	 * Getters and Setters
	 */
	public RowInputCtrl getFirstScene() {
		return firstScene;
	}

	public void setFirstScene(RowInputCtrl firstScene) {
		this.firstScene = firstScene;
	}
}