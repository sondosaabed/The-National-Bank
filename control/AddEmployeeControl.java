package control;

import java.sql.Date;

import application.Address;
import application.Employee;
import application.Phone;
import dataAccess.AddressQuery;
import dataAccess.DepartmentQuery;
import dataAccess.EmployeeQuery;
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
import presentation.AddEmployeeScene;

public class AddEmployeeControl {
	//feilds
	private AddEmployeeScene addemployeescene;
	private AddressQuery addressQuery;
	private PhoneQuery phoneQuery;
	private DepartmentQuery departmentQuery;
    private EmployeeQuery employeeQuery;

	private TextField nameC1;
	private TextField phoneE1;
	private TextField salaryE1;
	private ComboBox<String> dep1;
	private ComboBox<String> city1;
	private TextField citynameT;
	private ComboBox<String> gender;
	private TextField birth1;
	private TextField address1;
	private TextField street1;
	private TextField postal1;
	private TextField emailT;
	
	private Button add;
	private Button cancel;
	
	public AddEmployeeControl(Stage stage) {
		initialize(stage);
	}
	
	private void initialize(Stage stage) {
		setAddemployeescene(new AddEmployeeScene(stage));
		setAddressQuery(new AddressQuery());
		setDepartmentQuery(new DepartmentQuery());
		setEmployeeQuery(new EmployeeQuery());
		setPhoneQuery(new PhoneQuery());
		
		setNameC1(getAddemployeescene().getNameC1());
		setPhoneE1(getAddemployeescene().getPhoneE1());
		setSalaryE1(getAddemployeescene().getSalaryE1());
		setDep1(getAddemployeescene().getDep1());
		setCity1(getAddemployeescene().getCity1());
		setCitynameT(getAddemployeescene().getCitynameT());
		setGender(getAddemployeescene().getGender());
		setBirth1(getAddemployeescene().getBirth1());
		setAddress1(getAddemployeescene().getAddress1());
		setStreet1(getAddemployeescene().getStreet1());
		setPostal1(getAddemployeescene().getPostal1());
		setEmailT(getAddemployeescene().getEmailT());
		setAdd(getAddemployeescene().getAdd());
		setCancel(getAddemployeescene().getCancel0());
		
		handle_add(getAdd(),stage);
		handle_cancecl(getCancel(),stage);
	}

	private void handle_cancecl(Button cancel2, Stage stage) {
        cancel2.setOnAction(i -> stage.close());
	}

	private void handle_add(Button add2, Stage stage) {
	    BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c1);

		getAddressQuery().comboBox(getCity1());
        getDepartmentQuery().comboBox(getDep1());
        getAdd().setOnAction(l -> {
            if(getNameC1().getText().trim().equals("")
        		|| getPhoneE1().getText().trim().equals("")
        		|| getGender().getSelectionModel().getSelectedItem().trim().equals("")
        		||getBirth1().getText().trim().equals("")
        		|| getEmailT().getText().trim().equals("")
        		||getSalaryE1().getText().trim().equals("")
        		||getDep1().getSelectionModel().getSelectedItem().trim().equals("")) {
            	
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
                        Employee employee1 = new Employee(getNameC1().getText().trim(), 
                        								Integer.parseInt(getPhoneE1().getText().trim()), 
                        								getGender().getSelectionModel().getSelectedItem().trim(), 
                        								Date.valueOf(getBirth1().getText().trim()), 
                        								getEmailT().getText().trim(), 
                        								Double.parseDouble(getSalaryE1().getText().trim()), 
                        								Integer.parseInt(getDep1().getSelectionModel().getSelectedItem().trim()),
                        								Integer.parseInt(getAddress1().getText().trim()));
                        getEmployeeQuery().insertData(employee1);
                    } else {
                        getAddress1().setText(getAddressQuery().data.size() + 1 + "");
                        Address addresss = new Address(Integer.parseInt(getPostal1().getText().trim()), getCitynameT().getText().trim(), getStreet1().getText().trim());
                        getAddressQuery().insertData(addresss);
                        Phone phone = new Phone(Integer.parseInt(getPhoneE1().getText().trim()));
                        getPhoneQuery().insertData(phone);
                        Employee employee1 = new Employee(getNameC1().getText().trim(),
                        								Integer.parseInt(getPhoneE1().getText()),
                        								getGender().getSelectionModel().getSelectedItem().trim(),
                        								Date.valueOf(getBirth1().getText().trim()), 
                        								getEmailT().getText().trim(), 
                        								Double.parseDouble(getSalaryE1().getText().trim()),
                        								Integer.parseInt(getDep1().getSelectionModel().getSelectedItem().trim()),
                        								Integer.parseInt(getAddress1().getText().trim()));
                        getEmployeeQuery().insertData(employee1);
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
                } catch (Exception e){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("Look, a Warning Dialog");
                    alert.setContentText("Please Make sure you are inputting the right input");
                    alert.showAndWait();
                }
            }
        });		
	}

	public AddEmployeeScene getAddemployeescene() {
		return addemployeescene;
	}

	public void setAddemployeescene(AddEmployeeScene addemployeescene) {
		this.addemployeescene = addemployeescene;
	}

	public AddressQuery getAddressQuery() {
		return addressQuery;
	}

	public void setAddressQuery(AddressQuery addressQuery) {
		this.addressQuery = addressQuery;
	}

	public PhoneQuery getPhoneQuery() {
		return phoneQuery;
	}

	public void setPhoneQuery(PhoneQuery phoneQuery) {
		this.phoneQuery = phoneQuery;
	}

	public DepartmentQuery getDepartmentQuery() {
		return departmentQuery;
	}

	public void setDepartmentQuery(DepartmentQuery departmentQuery) {
		this.departmentQuery = departmentQuery;
	}

	public EmployeeQuery getEmployeeQuery() {
		return employeeQuery;
	}

	public void setEmployeeQuery(EmployeeQuery employeeQuery) {
		this.employeeQuery = employeeQuery;
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

	public TextField getSalaryE1() {
		return salaryE1;
	}

	public void setSalaryE1(TextField salaryE1) {
		this.salaryE1 = salaryE1;
	}

	public ComboBox<String> getDep1() {
		return dep1;
	}

	public void setDep1(ComboBox<String> dep1) {
		this.dep1 = dep1;
	}

	public ComboBox<String> getCity1() {
		return city1;
	}

	public void setCity1(ComboBox<String> city1) {
		this.city1 = city1;
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

	public TextField getEmailT() {
		return emailT;
	}

	public void setEmailT(TextField emailT) {
		this.emailT = emailT;
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
