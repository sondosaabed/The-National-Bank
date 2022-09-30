package control;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import presentation.EmployeeOptionsScene;
import presentation.radio;

public class EmployeeOptionsControl {
	private EmployeeOptionsScene empopscene;
	private ArrayList<radio> choices;
	private radio employee2;
	private radio emoloyeeName;
	private radio empoyeeP;
	private radio employG;
	private radio employeeD;
	private radio employeeE;
	private radio empoyeeS;
	private radio depID;
	private radio address;
	
	public EmployeeOptionsControl(GridPane stage) {
		initialize(stage);
	}

	private void initialize(GridPane stage) {
		setEmpopscene(new EmployeeOptionsScene(stage));
		setChoices(new ArrayList<>());

		setEmployee2(getEmpopscene().getEmployee2());
		setEmoloyeeName(getEmpopscene().getEmoloyeeName());
		setEmpoyeeP(getEmpopscene().getEmpoyeeP());
		setEmployG(getEmpopscene().getEmployG());
		setEmployeeD(getEmpopscene().getEmployeeD());
		setEmployeeE(getEmpopscene().getEmployeeE());
		setEmpoyeeS(getEmpopscene().getEmpoyeeS());
		setDepID(getEmpopscene().getDepID());
		setAddress(getEmpopscene().getAddress());
		
		getChoices().add(0,getEmployee2());
		getChoices().add(1,getEmoloyeeName());
		getChoices().add(2,getEmpoyeeP());
		getChoices().add(3,getEmployG());
		getChoices().add(4,getEmployeeD());
		getChoices().add(5,getEmployeeE());
		getChoices().add(6,getEmpoyeeS());
		getChoices().add(7,getDepID());
		getChoices().add(8,getAddress());		
	}

	public EmployeeOptionsScene getEmpopscene() {
		return empopscene;
	}

	public void setEmpopscene(EmployeeOptionsScene empopscene) {
		this.empopscene = empopscene;
	}

	public ArrayList<radio> getChoices() {
		return choices;
	}

	public void setChoices(ArrayList<radio> choices) {
		this.choices = choices;
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
