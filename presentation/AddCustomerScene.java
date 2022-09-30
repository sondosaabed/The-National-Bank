package presentation;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AddCustomerScene {
	private TextField nameC1;
	private TextField phoneE1;
	private ComboBox<String> city1;
	private TextField address1;
	private TextField street1;
	private TextField postal1;
	private TextField citynameT;
	private ComboBox<String> gender;
	private TextField birth1;
	private Button add;
	private Button cancel0;

	public AddCustomerScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {                
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c1);
	    
        GridPane pane2 = new GridPane();
        pane2.setPadding(new Insets(60, 60, 60, 60));
        pane2.setAlignment(Pos.CENTER);
        pane2.setHgap(10);
        pane2.setVgap(10);
        pane2.setBackground(background);
        
        Label hello1 = new Label(("Add a new Customer"));
        hello1.setFont(Font.font(17));
        hello1.setTextFill(Color.GREY);
        pane2.add(hello1, 0, 0);

        Image img9 = new Image("TNB.png");
        ImageView v10 = new ImageView(img9);
        v10.setFitWidth(150);
        v10.setFitHeight(70);

        Button logo2 = new Button();
        GridPane.setHalignment(logo2, HPos.CENTER);
        logo2.setPrefSize(180, 100);
        logo2.setGraphic(v10);
        logo2.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
        pane2.add(logo2, 1, 0);

        Label nameC = new Label(("Customer Name: "));
        nameC.setFont(Font.font(16));
        nameC.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(nameC, HPos.CENTER);
        pane2.add(nameC, 0, 1);

        nameC1 = new TextField();
        GridPane.setHalignment(nameC1, HPos.CENTER);
        nameC1.setPrefSize(200, 30);
        nameC1.setPromptText("Noor Saed Hamza");
        pane2.add(nameC1, 1, 1);

        Label phoneE = new Label(("Customer Phone: "));
        phoneE.setFont(Font.font(16));
        phoneE.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(phoneE, HPos.CENTER);
        pane2.add(phoneE, 0, 2);

        phoneE1 = new TextField();
        GridPane.setHalignment(phoneE1, HPos.CENTER);
        phoneE1.setPrefSize(200, 30);
        phoneE1.setPromptText("0595959999");
        pane2.add(phoneE1, 1, 2);

        Label city = new Label(("Address: "));
        city.setFont(Font.font(16));
        city.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(city, HPos.CENTER);
        pane2.add(city, 0, 3);

        city1 = new ComboBox<String>();
        city1.setBackground(background);
        city1.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
        city1.setPrefSize(200, 30);
        pane2.add(city1, 1, 3);

        Label addressId = new Label("Address ID");
        addressId.setFont(Font.font(16));
        addressId.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(addressId, HPos.CENTER);
        pane2.add(addressId, 0, 4);

        address1 = new TextField();
        GridPane.setHalignment(address1, HPos.CENTER);
        address1.setPrefSize(200, 30);
        address1.setPromptText("Al-Irsal St.");
        pane2.add(address1, 1, 4);

        Label street = new Label(("Street Name: "));
        street.setFont(Font.font(16));
        street.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(street, HPos.CENTER);
        pane2.add(street, 0, 5);

        street1 = new TextField();
        GridPane.setHalignment(street1, HPos.CENTER);
        street1.setPrefSize(200, 30);
        street1.setPromptText("Al-Irsal St.");
        pane2.add(street1, 1, 5);

        Label postal = new Label(("Postal Code: "));
        postal.setFont(Font.font(16));
        postal.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(postal, HPos.CENTER);
        pane2.add(postal, 0, 6);

        postal1 = new TextField();
        GridPane.setHalignment(postal1, HPos.CENTER);
        postal1.setPrefSize(200, 30);
        postal1.setPromptText("P000");
        pane2.add(postal1, 1, 6);

        //Label for City name
        Label citynam = new Label(("City name: "));
        citynam.setFont(Font.font(16));
        citynam.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(citynam, HPos.CENTER);
        pane2.add(citynam, 0, 7);

        citynameT = new TextField();
        GridPane.setHalignment(street1, HPos.CENTER);
        citynameT.setPrefSize(200, 30);
        citynameT.setPromptText("Ramallah");
        pane2.add(citynameT, 1, 7);

        Label genderl = new Label(("Gender: "));
        genderl.setFont(Font.font(16));
        genderl.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(genderl, HPos.CENTER);
        pane2.add(genderl, 0, 8);

        gender = new ComboBox<String>();
        gender.getItems().add("Female");
        gender.getItems().add("Male");
        gender.getItems().add("Other");
        gender.setBackground(background);
        gender.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
        gender.setPrefSize(200, 30);
        gender.setValue("Female");
        pane2.add(gender, 1, 8);

        Label birth = new Label(("Date of Birth: "));
        birth.setFont(Font.font(16));
        birth.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(birth, HPos.CENTER);
        pane2.add(birth, 0, 9);

        birth1 = new TextField();
        GridPane.setHalignment(birth1, HPos.CENTER);
        birth1.setPrefSize(200, 30);
        birth1.setPromptText("1998-2-15");
        pane2.add(birth1, 1, 9);

        add = new Button("Add Customer");
        add.setFont(Font.font(14));
        add.setPrefSize(90, 30);
        add.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
        add.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(add, HPos.CENTER);
        pane2.add(add, 0, 10);
        
        cancel0  = new Button("Cancel");
        cancel0.setFont(Font.font(14));
        cancel0.setPrefSize(90, 30);
        cancel0.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
        cancel0.setTextFill(Color.DARKSLATEBLUE);
        pane2.add(cancel0, 1, 10);
        GridPane.setHalignment(cancel0, HPos.RIGHT);

        Scene scene2 = new Scene(pane2);
        stage.setScene(scene2);
        stage.setTitle("The National Bank");
        stage.getIcons().add(new Image("images/TNB.png"));
        stage.show();
    }

	public TextField getNameC1() {
		return nameC1;
	}

	public void setNameC1(TextField nameC1) {
		this.nameC1 = nameC1;
	}

	public TextField getPhoneE1() {
		return phoneE1;
	}

	public void setPhoneE1(TextField phoneE1) {
		this.phoneE1 = phoneE1;
	}

	public ComboBox<String> getCity1() {
		return city1;
	}

	public void setCity1(ComboBox<String> city1) {
		this.city1 = city1;
	}

	public TextField getAddress1() {
		return address1;
	}

	public void setAddress1(TextField address1) {
		this.address1 = address1;
	}

	public TextField getStreet1() {
		return street1;
	}

	public void setStreet1(TextField street1) {
		this.street1 = street1;
	}

	public TextField getPostal1() {
		return postal1;
	}

	public void setPostal1(TextField postal1) {
		this.postal1 = postal1;
	}

	public TextField getCitynameT() {
		return citynameT;
	}

	public void setCitynameT(TextField citynameT) {
		this.citynameT = citynameT;
	}

	public ComboBox<String> getGender() {
		return gender;
	}

	public void setGender(ComboBox<String> gender) {
		this.gender = gender;
	}

	public TextField getBirth1() {
		return birth1;
	}

	public void setBirth1(TextField birth1) {
		this.birth1 = birth1;
	}

	public Button getAdd() {
		return add;
	}

	public void setAdd(Button add) {
		this.add = add;
	}

	public Button getCancel0() {
		return cancel0;
	}

	public void setCancel0(Button cancel0) {
		this.cancel0 = cancel0;
	}
}
