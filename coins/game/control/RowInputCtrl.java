package coins.game.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import coins.game.presentation.RowInputScene;
/*
 * Create a Controller for the Row Input Scene, in which create the coins Array
 */
public class RowInputCtrl {
	//Attributes
	private RowInputScene scene1;
	private GameCtrl scene2;
	private KeyBoardEntryCtrl scene3;
	private GameM14Ctrl scene4;
	private GameM20Ctrl scene5;
	private GridPane pane;
	private Button browse;
	private Button cancel;
	private Button input;
	private File file;
	private FileChooser fileChooser;
	
	public RowInputCtrl(Stage stage) {
		initialize(stage);
	}
	
	private void initialize(Stage stage) {
		setScene(new RowInputScene(stage));
		setBrowse(getScene().getBrowse());
		setCancel(getScene().getCancel());
		setInput(getScene().getInput());
		
		handle_browse(getBrowse(),stage);
		handle_exit(getCancel());
		handle_Input(getInput(), stage);
	}
	
	private void handle_Input(Button input, Stage stage) {
		//Method that handles input show the Keyboard Entry scene
		input.setOnAction(e->{
			setScene3(new KeyBoardEntryCtrl(stage));
		});
	}
	
	private void handle_browse(Button browse2, Stage stage) {
		//Method that handles the browser button
		browse2.setOnAction(e->{
			Stage stage3 = new Stage();
    		fileChooser = new FileChooser();
    		file=fileChooser.showOpenDialog(stage3); 
			if(file==(null)) {
		    	 AlertBoxCtrl a = new AlertBoxCtrl("You haven't chose a file yet!","No file");
		    	 a.show();
			} else {
				read_file(file, stage);
			}
		});
	}
	
	private void handle_exit(Button exit) {
		//Method that handles exit and exists
		exit.setOnAction(e->{
			Platform.exit();
		});
	}
	
	private void read_file(File file, Stage stage) {
		/*
		 * In this method Get the file and convert it's data into the coins array
		 * checks if the file is null make an alert, if the input size is not enen, and if there is a missing number 
		 * show an Alert Box
		 */
		int n =0;
		try {
			 FileReader fileR = new FileReader(file);
		     BufferedReader buffer = new BufferedReader(fileR);
	
		     if(file.length()==0) {
		    	 System.out.println("Your file is empty file");
		    	 
		    	 AlertBoxCtrl a = new AlertBoxCtrl("Your file is an empty file!","Empty file");
		    	 a.show();
		     }else {
		    	//read the 1st line to get the number of coins row
			     n= Integer.parseInt(buffer.readLine());
		    	 int[] coins = new int[n];
			     String s[]= buffer.readLine().trim().split(",");
			     
			     if(s.length!=n) {
			    	 System.out.println("There is a missing input!");
			    	 AlertBoxCtrl a = new AlertBoxCtrl("There is a missing input!!","Missing input");
			    	 a.show();
			     }else if (n%2 != 0){
			    	 System.out.println("Number of inputs is not even!");
			    	 AlertBoxCtrl a = new AlertBoxCtrl("Your file doesn't have an even number of coins!","Non even input");
			    	 a.show();
			     }else {
			    	 //File was successfully read
			    	 //create an array of n and start the game scene
				     for(int i=0; i<n;i++) {
				    	 coins[i]= Integer.parseInt(s[i]);
				     }
					if(coins.length<14) {
					     setScene2(new GameCtrl(stage, coins));	
					}else if(coins.length <20){
						//create scene for more than 14
						setScene4(new GameM14Ctrl(stage,coins));
					}else if(coins.length>=20) {
						//create scene when the length is more than 20
						setScene5(new GameM20Ctrl(stage,coins));
					}
			     }
		    }		
			buffer.close();
		}catch(NumberFormatException t) {
			System.out.println(t);
		}catch (FileNotFoundException e1) {
			System.out.println(e1);
		}catch (IOException e1) {
			System.out.println(e1);
		} catch (InputMismatchException e) {
			System.out.println(e);
		}
	}
	/*
	 * Getters and Setters
	 */
	public RowInputScene getScene() {
		return scene1;
	}
	public void setScene(RowInputScene scene) {
		this.scene1 = scene;
	}
	public GridPane getPane() {
		return pane;
	}
	public void setPane(GridPane pane) {
		this.pane = pane;
	}
	public Button getBrowse() {
		return browse;
	}
	public void setBrowse(Button browse) {
		this.browse = browse;
	}
	public Button getCancel() {
		return cancel;
	}
	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
	public Button getInput() {
		return input;
	}
	public void setInput(Button input) {
		this.input = input;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public GameCtrl getScene2() {
		return scene2;
	}
	public void setScene2(GameCtrl scene2) {
		this.scene2 = scene2;
	}
	public KeyBoardEntryCtrl getScene3() {
		return scene3;
	}
	public void setScene3(KeyBoardEntryCtrl scene3) {
		this.scene3 = scene3;
	}
	public GameM14Ctrl getScene4() {
		return scene4;
	}
	public void setScene4(GameM14Ctrl scene4) {
		this.scene4 = scene4;
	}
	public GameM20Ctrl getScene5() {
		return scene5;
	}
	public void setScene5(GameM20Ctrl scene5) {
		this.scene5 = scene5;
	}
}