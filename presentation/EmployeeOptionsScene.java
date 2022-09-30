package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class EmployeeOptionsScene {
	private radio employee2;
	private radio emoloyeeName;
	private radio empoyeeP;
	private radio employG;
	private radio employeeD;
	private radio employeeE;
	private radio empoyeeS;
	private radio depID;
	private radio address;

	public EmployeeOptionsScene(GridPane stage) {
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
        
        setEmployee2(new radio("images/employeeID.png",pane,0,1,"ID:","employee_ID"));
        setEmoloyeeName(new radio("images/employeeName.png",pane,1,1,"Name:","employee_name"));
        setEmpoyeeP(new radio("images/phone.png",pane,2,1,"Phone:","employee_phone"));
        setEmployG(new radio("images/gender.png",pane,0,2,"Gender:","employee_gender"));
        setEmployeeD(new radio("images/calendar(1).png",pane,1,2,"Date of birth:","employee_DOB"));
        setEmployeeE(new radio("images/email.png",pane,2,2,"Email:","employee_Email"));
        setEmpoyeeS(new radio("images/pay.png",pane,0,3,"Salary","employee_Salary"));
        setDepID(new radio("images/DepartmentID.png",pane,1,3,"Department ID:","Department_ID"));
        setAddress(new radio("images/address.png",pane,2,3,"Adress:","address_ID"));
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

	public radio getEmpoyeeP() {
		return empoyeeP;
	}

	public void setEmpoyeeP(radio empoyeeP) {
		this.empoyeeP = empoyeeP;
	}

	public radio getEmployG() {
		return employG;
	}

	public void setEmployG(radio employG) {
		this.employG = employG;
	}

	public radio getEmployeeD() {
		return employeeD;
	}

	public void setEmployeeD(radio employeeD) {
		this.employeeD = employeeD;
	}

	public radio getEmployeeE() {
		return employeeE;
	}

	public void setEmployeeE(radio employeeE) {
		this.employeeE = employeeE;
	}

	public radio getEmpoyeeS() {
		return empoyeeS;
	}

	public void setEmpoyeeS(radio empoyeeS) {
		this.empoyeeS = empoyeeS;
	}

	public radio getDepID() {
		return depID;
	}

	public void setDepID(radio depID) {
		this.depID = depID;
	}

	public radio getAddress() {
		return address;
	}

	public void setAddress(radio address) {
		this.address = address;
	}
}
