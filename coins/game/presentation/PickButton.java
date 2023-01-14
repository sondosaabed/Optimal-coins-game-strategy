package coins.game.presentation;

import coins.game.application.Pick;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
/*
 * Create a Pick Button and it's Label
 * Set the button's Graphic based on the amount of money it is (value)
 */
public class PickButton {
	//Attributes
	private Label value;
	private Button photo;
	private Pick pick;
	private int index;
	
	public PickButton(int value, boolean picked, int size, int font,int index) {
		initialize(value, picked, size, font,index);
	}
	
	private void initialize(int value, boolean picked, int size, int font,int index) {
		setPick(new Pick(value, picked ));	
		setValue(new Label(value+" coins"));
		setIndex(index);
		
		setPhoto(new Button());
        getPhoto().setPrefSize(size, size);
        getPhoto().setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
        getValue().setFont(Font.font("Lucida Sans Unicode", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, font));
        getValue().setTextFill(Color.valueOf("#F8664F"));
        getValue().setAlignment(Pos.CENTER);
        
        //Different photos for different values
        String name ="";
        
        if(value <= 10) {
        	name ="images/1-10-coins.png";
		}else if(value >= 11 && value <= 26) {
			name="images/11-25-coins.png";
		}else {
			name="images/26-up-coins.png";
		}
        
		Image img0 = new Image(name);
        ImageView v0 = new ImageView(img0);
        v0.setFitWidth(size);
        v0.setFitHeight(size);
        getPhoto().setGraphic(v0);
	}
	
	/*
	 * Getters and setters
	 */
	public Label getValue() {
		return value;
	}
	
	public void setValue(Label value) {
		this.value = value;
	}
	
	public Button getPhoto() {
		return photo;
	}
	
	public void setPhoto(Button photo) {
		this.photo = photo;
	}
	
	public Pick getPick() {
		return pick;
	}
	
	public void setPick(Pick pick) {
		this.pick = pick;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}	
}