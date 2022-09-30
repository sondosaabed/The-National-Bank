package control;

import java.sql.Date;

import application.Address;
import application.Customer;
import application.Phone;
import dataAccess.AddressQuery;
import dataAccess.CustomerQuery;
import dataAccess.PhoneQuery;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import presentation.AddCustomerScene;

public class AddCustomerControl {
	private AddCustomerScene addcustomerscene;
    private AddressQuery addressQuery;
    private CustomerQuery customerQuery;
    private PhoneQuery phoneQuery;
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
	private Button cancel;

	public AddCustomerControl(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		setAddcustomerscene(new AddCustomerScene(stage));
		setAddressQuery(new AddressQuery());
		setCustomerQuery(new CustomerQuery());
		setPhoneQuery(new PhoneQuery());
		
		setAdd(getAddcustomerscene().getAdd());
		setAddress1(getAddcustomerscene().getAddress1());
		setBirth1(getAddcustomerscene().getBirth1());
		setCancel(getAddcustomerscene().getCancel0());
		setCity1(getAddcustomerscene().getCity1());
		setCitynameT(getAddcustomerscene().getCitynameT());
		setGender(getAddcustomerscene().getGender());
		setNameC1(getAddcustomerscene().getNameC1());
		setPhoneE1(getAddcustomerscene().getPhoneE1());
		setPostal1(getAddcustomerscene().getPostal1());
		setStreet1(getAddcustomerscene().getStreet1());
		
		handle_add(getAdd(),stage);
		handle_cancel(getCancel(),stage);
	}

	private void handle_cancel(Button cancel2, Stage stage) {
		getCancel().setOnAction(i -> stage.close());		
	}

	private void handle_add(Button add2, Stage stage) {
	    BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c1);
	    
		getAddressQuery().comboBox(city1);
        getAdd().setOnAction(l -> {
            if(getNameC1().getText().equals("")|| getPhoneE1().getText().equals("")|| getGender().getSelectionModel().getSelectedItem().equals("")||getBirth1().getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Look, a Warning Dialog");
                alert.setContentText("Please check if all required fields are filled!");
                alert.showAndWait();
            }else {
                try {
                    String line = "";
                    if (getCity1().getSelectionModel().isEmpty() == false) {
                        line = getCity1().getSelectionModel().getSelectedItem();
                        String[] arrayOfAddressInformation = line.split(",");
                        
                        getAddress1().setText(arrayOfAddressInformation[0]);
                        getPostal1().setText(arrayOfAddressInformation[1]);
                        getCitynameT().setText(arrayOfAddressInformation[2]);
                        getStreet1().setText(arrayOfAddressInformation[3]);
                        
                        Phone phone = new Phone(Integer.parseInt(getPhoneE1().getText()));
                        getPhoneQuery().insertData(phone);
                        
                        Customer customers = new Customer(nameC1.getText().trim(),
                        								Integer.parseInt(phoneE1.getText().trim()),
                        								Date.valueOf(birth1.getText().trim()),
                        								gender.getSelectionModel().getSelectedItem().trim(),
                        								Integer.parseInt(address1.getText().trim()));
                        
                        getCustomerQuery().insertData(customers);
                    } else {
                        getAddress1().setText(getAddressQuery().data.size() + 1 + "");
                        Address address = new Address(Integer.parseInt(getPostal1().getText()), getCitynameT().getText(), getStreet1().getText());
                        getAddressQuery().insertData(address);
                        Phone phone = new Phone(Integer.parseInt(getPhoneE1().getText()));
                        getPhoneQuery().insertData(phone);
                        Customer customers = new Customer(getNameC1().getText().trim(),
				        								Integer.parseInt(getPhoneE1().getText().trim()),
				        								Date.valueOf(getBirth1().getText().trim()),
				        								getGender().getSelectionModel().getSelectedItem().trim(),
				        								getAddressQuery().data.size() + 1);
                        getCustomerQuery().insertData(customers);
                    }

        	        GridPane pane2 = new GridPane();
        	        pane2.setPadding(new Insets(60, 60, 60, 60));
        	        pane2.setAlignment(Pos.CENTER);
        	        pane2.setHgap(10);
        	        pane2.setVgap(10);
        	        pane2.setBackground(background);
        	        
        	        Label hello54 = new Label("inserted successfully");
                    hello54.setFont(Font.font(17));
                    hello54.setTextFill(Color.GREY);
                    pane2.add(hello54, 0, 0);
                    
        	        Image img9 = new Image("images/TNB.png");
        	        ImageView v10 = new ImageView(img9);
        	        v10.setFitWidth(150);
        	        v10.setFitHeight(70);

        	        Button logo2 = new Button();
        	        GridPane.setHalignment(logo2, HPos.CENTER);
        	        logo2.setPrefSize(180, 100);
        	        logo2.setGraphic(v10);
        	        logo2.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
        	        
        	        pane2.add(logo2, 1, 0);
                    
                    //Create Scene
                    Scene scene5 = new Scene(pane2);
                    stage.setScene(scene5);
                    stage.setTitle("The National Bank");
                    stage.getIcons().add(new Image("images/TNB.png"));
                    stage.show();
                }catch (Exception e){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("Look, a Warning Dialog");
                    alert.setContentText("Please Make sure you are inputting the right input\n"+e.getMessage());
                    alert.showAndWait();
                }
            }});		
	}
	

	public AddCustomerScene getAddcustomerscene() {
		return addcustomerscene;
	}

	public void setAddcustomerscene(AddCustomerScene addcustomerscene) {
		this.addcustomerscene = addcustomerscene;
	}

	public AddressQuery getAddressQuery() {
		return addressQuery;
	}

	public void setAddressQuery(AddressQuery addressQuery) {
		this.addressQuery = addressQuery;
	}

	public CustomerQuery getCustomerQuery() {
		return customerQuery;
	}

	public void setCustomerQuery(CustomerQuery customerQuery) {
		this.customerQuery = customerQuery;
	}

	public PhoneQuery getPhoneQuery() {
		return phoneQuery;
	}

	public void setPhoneQuery(PhoneQuery phoneQuery) {
		this.phoneQuery = phoneQuery;
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

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
}
