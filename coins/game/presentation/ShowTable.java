package coins.game.presentation;

import coins.game.application.OptimalGameStrategy;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
 * Create a scene that shows the dynamic table
 */

public class ShowTable {
	//Attributes
	private GridPane pane;
	private Button back;

	public ShowTable(Stage stage,int []coins, OptimalGameStrategy sol) {
		initialize(stage,coins,sol);
	}

	private void initialize(Stage stage, int []coins, OptimalGameStrategy sol) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		pane = new GridPane();
		pane.setPadding(new Insets(100, 100, 100, 100));
		pane.setAlignment(Pos.CENTER);
		pane.setBackground(background);
		pane.setHgap(5);
		pane.setVgap(5);

		back =  new Button("back");
		back.setFont(Font.font(14));
		back.setPrefSize(60, 60);        
		back.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		back.setStyle("-fx-background-radius: 10, 10;-fx-background-color:lightgreen;");
		back.setTextFill(Color.valueOf("#CC5144"));
		GridPane.setHalignment(back, HPos.CENTER);
		pane.add(back, 0, 0);

		for(int y = 1; y < coins.length+1; y++){
			Label num = new Label();
			num.setPrefHeight(60);
			num.setPrefWidth(60);
			num.setAlignment(Pos.CENTER);
			num.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));

			num.setStyle("-fx-background-radius: 3, 3;-fx-background-color:lightpink;");
			num.setText( coins[y-1]+"\r\n"+"j= "+(y-1));
			num.setTextFill(Color.valueOf("#CC5144"));

			//Iterate the Index using the loops
			GridPane.setRowIndex(num,0);
			GridPane.setColumnIndex(num,y);    
			pane.getChildren().add(num);
		}

		for(int y = 1; y < coins.length+1; y++){
			Label num = new Label();
			num.setPrefHeight(60);
			num.setPrefWidth(60);
			num.setAlignment(Pos.CENTER);
			num.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));

			num.setStyle("-fx-background-radius: 3, 3;-fx-background-color:lightpink;");
			num.setText( coins[y-1]+"\r\n"+"i= "+(y-1));
			num.setTextFill(Color.valueOf("#CC5144"));

			//Iterate the Index using the loops
			GridPane.setRowIndex(num,y);
			GridPane.setColumnIndex(num,0);    
			pane.getChildren().add(num);
		}

		// Fill the dynamic table in the interface
		for (int i = 1; i < coins.length+1; i++) {
			for (int j = 1; j < coins.length+1; j++) {
				Label num = new Label();// Create a new Label in each Iteration
				num.setPrefHeight(60);
				num.setPrefWidth(60);
				num.setAlignment(Pos.CENTER);
				num.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
				num.setStyle("-fx-background-radius: 3, 3;-fx-background-color:#B2F7F9;");
				num.setTextFill(Color.valueOf("#CC5144"));

				num.setText(sol.getDp()[i-1][j-1]+"");

				GridPane.setRowIndex(num,i);
				GridPane.setColumnIndex(num,j);    
				pane.getChildren().add(num);
			}
		}

		//create scene, set to the stage
		Scene scene = new Scene(pane);    
		stage.setTitle("Dynamic Programming Table");
		stage.getIcons().add(new Image("images/logo.png"));
		stage.setScene(scene);
		stage.show();
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

	public Button getCancel() {
		return back;
	}

	public void setCancel(Button cancel) {
		this.back = cancel;
	}
}