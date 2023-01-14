package coins.game.control;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import coins.game.presentation.KeyboradEnteryScene;
/*
 * Create a Controller for the Keyboard Entry Scene
 * In which Gets the input and store it into the coins array
 */
public class KeyBoardEntryCtrl {
	//Attributes
	private KeyboradEnteryScene scene;
	private GameCtrl scene2;
	private GameM14Ctrl scene3;
	private GameM20Ctrl scene4;
	private GridPane pane;
	private Label enter;
	private Label enter2;
	private Button logo;
	private Button ok;
	private TextField number;
	private TextField entery;
	
	public KeyBoardEntryCtrl(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		setScene(new KeyboradEnteryScene(stage));
		
		setPane(getScene().getPane());
		setEnter(getScene().getEnter());
		setEnter2(getScene().getEnter2());
		setNumber(getScene().getNumber());
		setEntery(getScene().getEntery());
		setOk(getScene().getOk());		
		handle_ok(getOk(), stage);
	}

	private void handle_ok(Button ok2, Stage stage) {
		ok2.setOnAction(e->{
			text_array(getNumber().getText().trim(), getEntery().getText().trim(),stage);
		});
	}
	
	private int[] text_array(String text1, String text2, Stage stage ) {
		/*
		 * Take the text input of the user, check of both are entered, and of the number is even
		 * and the inputs match then read the inputs and store onto an array of coins return it
		 * otherwise an alert window
		 */
		int[] coins = null;
		if(text1.equals("") || text2.equals("")) {	    	 
	    	 AlertBoxCtrl a = new AlertBoxCtrl("Enter both values!!","Fill the texfeilds");
	    	 a.show();
		}else {
			int n =Integer.parseInt(text1);
			coins = new int[n];
			String s[]= text2.trim().split(",");
			     
			if(n%2!=0) {		    	 
		    	 AlertBoxCtrl a = new AlertBoxCtrl("Your input doesn't have an even number of coins!","Number Mismatch");
		    	 a.show();
			}else if(s.length!=n) {		    	 
		    	 AlertBoxCtrl a = new AlertBoxCtrl("There is a missing input!!","Missing Number!");
		    	 a.show();
			}else {
		    	 //File was successfully read
		    	 //create an array of n and start the game scene
			     for(int i=0; i<n;i++) {
			    	 coins[i]= Integer.parseInt(s[i].trim());
			     }
				if(coins.length<14) {
				     setScene2(new GameCtrl(stage, coins));
				}else if (coins.length<20){
					//create scene for more than 14
					setScene3(new GameM14Ctrl(stage,coins));
				} else {
					//create scene when more than 20
					setScene4(new GameM20Ctrl(stage, coins));
				}
			}
		}   
		return coins;
	}
	/*
	 * Getters and Setters
	 */
	public KeyboradEnteryScene getScene() {
		return scene;
	}

	public void setScene(KeyboradEnteryScene scene) {
		this.scene = scene;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public Label getEnter() {
		return enter;
	}

	public void setEnter(Label enter) {
		this.enter = enter;
	}

	public Label getEnter2() {
		return enter2;
	}

	public void setEnter2(Label enter2) {
		this.enter2 = enter2;
	}

	public Button getLogo() {
		return logo;
	}

	public void setLogo(Button logo) {
		this.logo = logo;
	}

	public TextField getNumber() {
		return number;
	}

	public void setNumber(TextField number) {
		this.number = number;
	}

	public TextField getEntery() {
		return entery;
	}

	public void setEntery(TextField entery) {
		this.entery = entery;
	}

	public Button getOk() {
		return ok;
	}

	public void setOk(Button ok) {
		this.ok = ok;
	}

	public GameCtrl getScene2() {
		return scene2;
	}

	public void setScene2(GameCtrl gameCtrl) {
		this.scene2 = gameCtrl;
	}

	public GameM14Ctrl getScene3() {
		return scene3;
	}

	public void setScene3(GameM14Ctrl scene3) {
		this.scene3 = scene3;
	}

	public GameM20Ctrl getScene4() {
		return scene4;
	}

	public void setScene4(GameM20Ctrl scene4) {
		this.scene4 = scene4;
	}
}