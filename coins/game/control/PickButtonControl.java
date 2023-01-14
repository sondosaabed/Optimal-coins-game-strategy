package coins.game.control;

import coins.game.application.Pick;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import coins.game.presentation.PickButton;
/*
 * Create a Controller of the Pick Button
 */
public class PickButtonControl {
	//Attributes
	private PickButton pickb;
	private Label value;
	private Button photo;
	private Pick pick;

	public PickButtonControl(int value, boolean picked, int size, int font,int index) {
		initialize(value, picked, size, font,index);
	}

	private void initialize(int value, boolean picked, int size, int font,int index) {
		setPickb(new PickButton(value, picked, size, font,index));
		setValue(getPickb().getValue());
		setPhoto(getPickb().getPhoto());
		setPick(getPickb().getPick());
	}

	public void select() {
		//Select the button
		getPhoto().setOnAction(e->{
			getPhoto().setStyle("-fx-background-color:lightgreen;");
		});
		getPhoto().fire();
	}

	public void unselect() {
		//Unselect the button
		getPhoto().setOnAction(e->{
			getPhoto().setStyle("-fx-background-color:lightpink;");
		});
		getPhoto().fire();
	}
	public void handle_off(Button button, int value, Label label) {
		button.setOnAction(e->{
			button.setStyle("-fx-background-color:lightgrey;");
		});
	}
	/*
	 * Getters and Setters
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

	public PickButton getPickb() {
		return pickb;
	}

	public void setPickb(PickButton pickb) {
		this.pickb = pickb;
	}
}