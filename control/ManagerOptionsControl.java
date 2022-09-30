package control;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import presentation.ManagerOptionsScene;
import presentation.radio;

public class ManagerOptionsControl {
	private ManagerOptionsScene mngopscene;
	private ArrayList<radio> choices;
	private radio employee2;
	private radio emoloyeeName;
	private radio employG;
	private radio employeeD;
	private radio empoyeeS;
	private radio employeeE;
	private radio empoyeeP;
	private radio address;

	public ManagerOptionsControl(GridPane stage) {
		initialize(stage);
	}
	
	private void initialize(GridPane stage) {
		setMngopscene(new ManagerOptionsScene(stage));
		setChoices(new ArrayList<>());
		
		setEmployee2(getMngopscene().getEmployee2());
		setEmoloyeeName(getMngopscene().getEmoloyeeName());
		setEmployG(getMngopscene().getEmployG());
		setEmployeeD(getMngopscene().getEmployeeD());
		setEmpoyeeS(getMngopscene().getEmpoyeeS());
		setEmployeeE(getMngopscene().getEmployeeE());
		setEmpoyeeP(getMngopscene().getEmpoyeeP());
		setAddress(getMngopscene().getAddress());
		
		getChoices().add(0,getEmployee2());
		getChoices().add(1,getEmoloyeeName());
		getChoices().add(2,getEmployG());
		getChoices().add(3,getEmployeeD());
		getChoices().add(4,getEmployeeE());
		getChoices().add(5,getEmpoyeeS());
		getChoices().add(6,getEmpoyeeP());
		getChoices().add(7,getAddress());		
	}

	public ManagerOptionsScene getMngopscene() {
		return mngopscene;
	}
	public void setMngopscene(ManagerOptionsScene mngopscene) {
		this.mngopscene = mngopscene;
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

	public radio getEmployG() {
		return employG;
	}

	public void setEmployG(radio employG) {
		this.employG = employG;
	}

	public radio getEmpoyeeS() {
		return empoyeeS;
	}

	public void setEmpoyeeS(radio empoyeeS) {
		this.empoyeeS = empoyeeS;
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
