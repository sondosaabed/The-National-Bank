package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CustomerOptionsScene {
	private radio employee2;
	private radio emoloyeeName;
	private radio employeeD;
	private radio employG;
	private radio empoyeeP;
	private radio address;

	public CustomerOptionsScene(GridPane stage) {
		initialize(stage);
	}

	private void initialize(GridPane pane) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		   
        pane.setPadding(new Insets(60, 60, 60, 60));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setBackground(background);
        
        setEmployee2(new radio("images/employeeID.png",pane,0,1,"ID:","customer_id"));
        setEmoloyeeName(new radio("images/employeeName.png",pane,1,1,"Name:","customer_name"));
        setEmployG(new radio("images/gender.png",pane,2,1,"Gender:","customer_Gender"));
        setEmployeeD(new radio("images/calendar(1).png",pane,0,2,"Calender:","customer_DOB"));
        setEmpoyeeP(new radio("images/phone.png",pane,1,2,"Phone:","customer_phone"));
        setAddress(new radio("images/address.png",pane,2,2,"Adress:","address_ID"));
	}

	public radio getEmployee2() {
		return employee2;
	}

	public void setEmployee2(radio employee2) {
		this.employee2 = employee2;
	}

	public radio getEmoloyeeName() {
		return emoloyeeName;
	}

	public void setEmoloyeeName(radio emoloyeeName) {
		this.emoloyeeName = emoloyeeName;
	}

	public radio getEmployeeD() {
		return employeeD;
	}

	public void setEmployeeD(radio employeeD) {
		this.employeeD = employeeD;
	}

	public radio getEmployG() {
		return employG;
	}

	public void setEmployG(radio employG) {
		this.employG = employG;
	}

	public radio getEmpoyeeP() {
		return empoyeeP;
	}

	public void setEmpoyeeP(radio empoyeeP) {
		this.empoyeeP = empoyeeP;
	}

	public radio getAddress() {
		return address;
	}

	public void setAddress(radio address) {
		this.address = address;
	}
}
