package presentation;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/*
	This class is used to show the user selection of what to "update or delete or search"
*/

public class radio {
	private RadioButton radio = new RadioButton();
	private ToggleGroup group = new ToggleGroup();
	private Label name;
	private TextField nameT = new TextField();

	private Label val = new Label("Value:");
	private TextField valT = new TextField();
	
	public radio(String url, GridPane pane, int x,int y,String name, String ID) {
	    Image image = new Image(url);
	    
	    ImageView v12 = new ImageView(image);
	    v12.setFitWidth(170);
	    v12.setFitHeight(170);
	    
	    radio.setPrefSize(170, 170);
	    radio.setGraphic(v12);	
	    radio.setToggleGroup(group);
	    pane.add(radio, x, y);
	    
	    this.setName(new Label(name));
	    this.getName().setId(ID);
	    this.getName().setFont(Font.font(16));
	    this.getName().setTextFill(Color.DARKSLATEBLUE);
        this.getNameT().setPrefSize(200, 30);
        GridPane.setHalignment(getName(), HPos.CENTER);
        
	    this.getVal().setFont(Font.font(16));
	    this.getVal().setTextFill(Color.DARKSLATEBLUE);
        this.getValT().setPrefSize(200, 30);
        GridPane.setHalignment(getVal(), HPos.CENTER);
	}

	public RadioButton getRadio() {
		return radio;
	}

	public void setRadio(RadioButton radio) {
		this.radio = radio;
	}

	public ToggleGroup getGroup() {
		return group;
	}

	public void setGroup(ToggleGroup group) {
		this.group = group;
	}

	public Label getName() {
		return name;
	}

	public void setName(Label name) {
		this.name = name;
	}

	public TextField getNameT() {
		return nameT;
	}

	public void setNameT(TextField nameT) {
		this.nameT = nameT;
	}

	public Label getVal() {
		return val;
	}

	public void setVal(Label val) {
		this.val = val;
	}

	public TextField getValT() {
		return valT;
	}

	public void setValT(TextField valT) {
		this.valT = valT;
	}
}
