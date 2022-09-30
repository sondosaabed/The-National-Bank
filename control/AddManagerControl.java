package control;

import java.sql.Date;

import application.Address;
import application.Manager;
import application.Phone;
import dataAccess.AddressQuery;
import dataAccess.ManagerQuery;
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
import presentation.AddManagerScene;

public class AddManagerControl {
	private AddManagerScene addmangerscene;
    private AddressQuery addressQuery;
    private ManagerQuery managerQuery;
    private PhoneQuery phoneQuery;
	private Button add;
	private Button cancel0;
	private TextField birth1;
	private ComboBox<String> gender;
	private TextField citynameT;
	private TextField postal1;
	private TextField street1;
	private ComboBox<String> city1;
	private TextField address1;
	private TextField salaryE1;
	private TextField emailE1;
	private TextField phoneE1;
	private TextField nameC1;
	
	public AddManagerControl(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		setAddmangerscene(new AddManagerScene(stage));
		setAddressQuery(new AddressQuery());
		setManagerQuery(new ManagerQuery());
		setPhoneQuery(new PhoneQuery());
		
		setAdd(getAddmangerscene().getAdd());
		setCancel0(getAddmangerscene().getCancel0());
		setBirth1(getAddmangerscene().getBirth1());
		setGender(getAddmangerscene().getGender());
		setCitynameT(getAddmangerscene().getCitynameT());
		setPostal1(getAddmangerscene().getPostal1());
		setStreet1(getAddmangerscene().getStreet1());
		setCity1(getAddmangerscene().getCity1());
		setAddress1(getAddmangerscene().getAddress1());
		setSalaryE1(getAddmangerscene().getSalaryE1());
		setEmailE1(getAddmangerscene().getEmailE1());
		setPhoneE1(getAddmangerscene().getPhoneE1());
		setNameC1(getAddmangerscene().getNameC1());
		
		handle_add(add,stage);
		handle_cancel(cancel0, stage);
	}

	private void handle_cancel(Button cancel, Stage stage) {
        cancel.setOnAction(i -> stage.close());
	}	
	
	private void handle_add(Button add2, Stage stage) {
	    BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c1);

		getAddressQuery().comboBox(city1);
        getAdd().setOnAction(l -> {
            if(getNameC1().getText().equals("")|| getPhoneE1().getText().equals("")|| getGender().getSelectionModel().getSelectedItem().equals("")||getBirth1().getText().equals("")|| getEmailE1().getText().equals("")||getSalaryE1().getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Look, a Warning Dialog");
                alert.setContentText("Please check if all required fields are filled!");
                alert.showAndWait();
            }else {
                try {
                    String line ="";
                    if(getCity1().getSelectionModel().isEmpty()==false) {
                        line = getCity1().getSelectionModel().getSelectedItem();
                        String[] arrayOfAddressInformation = line.split(",");
                        getAddress1().setText(arrayOfAddressInformation[0]);
                        getPostal1().setText(arrayOfAddressInformation[1]);
                        getCitynameT().setText(arrayOfAddressInformation[2]);
                        street1.setText(arrayOfAddressInformation[3]);
                        
                        Phone phone= new Phone(Integer.parseInt(getPhoneE1().getText()));
                        getPhoneQuery().insertData(phone);
                        Manager manager1 = new Manager(getNameC1().getText().trim(),
                        							Integer.parseInt(getPhoneE1().getText().trim()),
                        							Date.valueOf(getBirth1().getText().trim()),
                        							getGender().getSelectionModel().getSelectedItem().trim(),
                        							getEmailE1().getText().trim(),
                        							Double.parseDouble(getSalaryE1().getText().trim()),
                        							Integer.parseInt(getAddress1().getText().trim()));
                        getManagerQuery().insertData(manager1);
                    }else{
                        getAddress1().setText(getAddressQuery().data.size()+1+"");
                        Address addresss = new Address(Integer.parseInt(getPostal1().getText().trim()),getCitynameT().getText().trim(),getStreet1().getText().trim());
                        getAddressQuery().insertData(addresss);
                        Phone phone= new Phone(Integer.parseInt(getPhoneE1().getText()));
                        getPhoneQuery().insertData(phone);
                        Manager manager1 = new Manager(getNameC1().getText().trim(),
                        							Integer.parseInt(getPhoneE1().getText().trim()),
                        							Date.valueOf(getBirth1().getText().trim()),
                        							getGender().getSelectionModel().getSelectedItem().trim(),
                        							getEmailE1().getText().trim(),
                        							Double.parseDouble(getSalaryE1().getText().trim()),
                        							Integer.parseInt(getAddress1().getText().trim()));
                        getManagerQuery().insertData(manager1);
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
                    alert.setContentText("Please Make sure you are inputting the right input");
                    alert.showAndWait();
                }
            }
        });	
	}

	public AddressQuery getAddressQuery() {
		return addressQuery;
	}

	public void setAddressQuery(AddressQuery addressQuery) {
		this.addressQuery = addressQuery;
	}

	public ManagerQuery getManagerQuery() {
		return managerQuery;
	}

	public void setManagerQuery(ManagerQuery managerQuery) {
		this.managerQuery = managerQuery;
	}

	public PhoneQuery getPhoneQuery() {
		return phoneQuery;
	}

	public void setPhoneQuery(PhoneQuery phoneQuery) {
		this.phoneQuery = phoneQuery;
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

	public TextField getBirth1() {
		return birth1;
	}

	public void setBirth1(TextField birth1) {
		this.birth1 = birth1;
	}

	public ComboBox<String> getGender() {
		return gender;
	}

	public void setGender(ComboBox<String> gender) {
		this.gender = gender;
	}

	public TextField getCitynameT() {
		return citynameT;
	}

	public void setCitynameT(TextField citynameT) {
		this.citynameT = citynameT;
	}

	public TextField getPostal1() {
		return postal1;
	}

	public void setPostal1(TextField postal1) {
		this.postal1 = postal1;
	}

	public TextField getStreet1() {
		return street1;
	}

	public void setStreet1(TextField street1) {
		this.street1 = street1;
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

	public TextField getSalaryE1() {
		return salaryE1;
	}

	public void setSalaryE1(TextField salaryE1) {
		this.salaryE1 = salaryE1;
	}

	public TextField getEmailE1() {
		return emailE1;
	}

	public void setEmailE1(TextField emailE1) {
		this.emailE1 = emailE1;
	}

	public TextField getPhoneE1() {
		return phoneE1;
	}

	public void setPhoneE1(TextField phoneE1) {
		this.phoneE1 = phoneE1;
	}

	public TextField getNameC1() {
		return nameC1;
	}

	public void setNameC1(TextField nameC1) {
		this.nameC1 = nameC1;
	}

	public AddManagerScene getAddmangerscene() {
		return addmangerscene;
	}

	public void setAddmangerscene(AddManagerScene addmangerscene) {
		this.addmangerscene = addmangerscene;
	}
}
