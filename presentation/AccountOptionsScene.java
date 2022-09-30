package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;	

public class AccountOptionsScene {
	private radio employee2;
	private radio emoloyeeName;
	private radio employG;
	private radio employeeD;
	private radio employeeE;
	private radio empoyeeS;
	private radio Interest;
	private radio initialDeposit;

	public AccountOptionsScene(GridPane pane) {
		initialzie(pane);
	}

	private void initialzie(GridPane pane) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		   
        pane.setPadding(new Insets(60, 60, 60, 60));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setBackground(background);
        
        setEmployee2(new radio("images/employeeID.png",pane,0,1,"Account ID:","account_id"));
        setEmoloyeeName(new radio("images/customer ID.png",pane,1,1,"Customer ID:","customer_id"));
        setEmployG(new radio("images/accountType.png",pane,2,1,"Account Type:","Account_Type"));
        setEmployeeD(new radio("images/regestrationDate.png",pane,0,2,"REgesteration Date:","Registration_Date"));
        setEmployeeE(new radio("images/activationDate.png",pane,1,2,"Activation Date:","Activation_Date"));
        setEmpoyeeS(new radio("images/branchID.png",pane,2,2,"Barnch ID:","branch_ID"));
        setInterest(new radio("images/Interest.png",pane,0,3,"Interest:","Interest"));
        setInitialDeposit(new radio("images/initial_deposity.png",pane,1,3,"Initial Deposity:","initial_deposity"));
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

	public radio getInterest() {
		return Interest;
	}

	public void setInterest(radio interest) {
		Interest = interest;
	}

	public radio getInitialDeposit() {
		return initialDeposit;
	}

	public void setInitialDeposit(radio initialDeposit) {
		this.initialDeposit = initialDeposit;
	}
}
