package coins.game.presentation;

import java.util.ArrayList;

import coins.game.application.OptimalGameStrategy;
//import coins.game.application.OptimalGameStrategy;
import coins.game.control.PickButtonControl;
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
 * Create the scene in which it shows the main scene, 
 * the columns shows buttons of coins based on the data read
 * since there is a limitation of interface put the size in a variable and change it
 */
public class GameScene {
	//Attributes
	private GridPane pane;
	private Button play;
	private Button table;
	private Button relation;
	private Button exit;
	private Label max;
	private ArrayList<PickButtonControl> buttons;

	public GameScene(Stage stage, int[] coins) {
		initialize(stage, coins);
	}

	private void initialize(Stage stage, int [] coins) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		buttons=new ArrayList<>();
		setPane(new GridPane());
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(60, 60, 60, 60));
		pane.setHgap(5);
		pane.setVgap(5);
		pane.setBackground(background);

		max = new Label();
		max.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		max.setTextFill(Color.GOLD);
		GridPane.setHalignment(max, HPos.CENTER);
		pane.add(max, 1, 1);

		Image img = new Image("images/logo.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(70);
		v.setFitHeight(70);

		Button logo = new Button();
		logo.setPrefSize(70, 70);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 1, 0);

		play =  new Button("Simulation");
		play.setFont(Font.font(14));
		play.setPrefSize(150, 50);        
		play.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		play.setStyle("-fx-background-radius: 10, 10;-fx-background-color:#B2F7F9;");
		play.setTextFill(Color.valueOf("#CC5144"));
		GridPane.setHalignment(play, HPos.CENTER);
		pane.add(play, 0, 2);

		table =  new Button("DP table");
		table.setFont(Font.font(14));
		table.setPrefSize(150, 50);        
		table.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		table.setStyle("-fx-background-radius: 7, 7;-fx-background-color:#B2F7F9;");
		table.setTextFill(Color.valueOf("#CC5144"));
		GridPane.setHalignment(table, HPos.CENTER);
		pane.add(table, 1, 2);	

		relation =  new Button("DP relation");
		relation.setFont(Font.font(14));
		relation.setPrefSize(150, 50);        
		relation.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		relation.setStyle("-fx-background-radius: 7, 7;-fx-background-color:#B2F7F9;");
		relation.setTextFill(Color.valueOf("#CC5144"));
		GridPane.setHalignment(relation, HPos.CENTER);
		pane.add(relation, 2, 2);

		exit =  new Button("exit");
		exit.setFont(Font.font(14));
		exit.setPrefSize(50, 50);        
		exit.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
		exit.setStyle("-fx-background-radius: 10, 10;-fx-background-color:lightpink;");
		exit.setTextFill(Color.valueOf("#CC5144"));
		GridPane.setHalignment(exit, HPos.RIGHT);
		pane.add(exit, 2, 0);	

		int size =0;
		int font =16;
		if(coins.length<=6) {
			size = 100;
		}else if(coins.length <=10) {
			size = 65;
		}else if(coins.length>10 && coins.length <14) {
			size = 45;
		}

		int x=1;		

		for(int i=0; i<coins.length/2;i++) {
			PickButtonControl pbc = new PickButtonControl(coins[i],false, size,font,i);
			x=x+1;
			pane.add(pbc.getPhoto(), 0, x+1);
			GridPane.setHalignment(pbc.getPhoto(), HPos.CENTER);

			x=x+1;
			pane.add(pbc.getValue(), 0, x+1);
			GridPane.setHalignment(pbc.getValue(), HPos.CENTER);
			getButtons().add(pbc);
		}

		int x1=1;		
		for(int i=coins.length/2; i<coins.length;i++) {
			PickButtonControl pbc = new PickButtonControl(coins[i],false, size,font,i);
			x1=x1+1;
			pane.add(pbc.getPhoto(), 2, x1+1);
			GridPane.setHalignment(pbc.getPhoto(), HPos.CENTER);

			x1=x1+1;
			pane.add(pbc.getValue(), 2, x1+1);
			GridPane.setHalignment(pbc.getValue(), HPos.CENTER);
			getButtons().add(pbc);
		}

		OptimalGameStrategy sol = new OptimalGameStrategy(coins);
//		int counter=0;	
//		for(int i=buttons.size();i>0;i--) {
//			PickButtonControl b = buttons.get(i);
//			
//		}
		for (PickButtonControl b : buttons) {
			//checks if the value gives the optimal sol. then set picked to true else set to false
			if (sol.getSolution().contains(b.getPickb().getPick().getValue())) {
				//counter++;
				//if(counter!=sol.getSolution().size())
					b.getPick().setPicked(true);
			} else {
				b.getPick().setPicked(false);
			}
		}
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Win Max Money Game");
		stage.getIcons().add(new Image("images/logo.png"));
		stage.show();
	}

	/*
	 * Getters and Setters
	 */
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

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public Button getRelation() {
		return relation;
	}

	public void setRelation(Button relation) {
		this.relation = relation;
	}

	public ArrayList<PickButtonControl> getButtons() {
		return buttons;
	}

	public void setButtons(ArrayList<PickButtonControl> buttons) {
		this.buttons = buttons;
	}
}