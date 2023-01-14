package coins.game.application;
import coins.game.control.MainControl;
import javafx.application.Application;
import javafx.stage.Stage;
/*
 * This is the Main Class that runs the Main Controller and Show the first scene of the program
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		MainControl mainctrl = new MainControl(stage);
		mainctrl.showRowInputScene();
	}
}