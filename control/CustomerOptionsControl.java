package control;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import presentation.CustomerOptionsScene;
import presentation.radio;

public class CustomerOptionsControl {
	private CustomerOptionsScene cusopscene;
	private ArrayList<radio> choices; 
	private radio employee2;
	private radio emoloyeeName;
	private radio employeeD;
	private radio employG;
	private radio empoyeeP;
	private radio address;
	
	public CustomerOptionsControl(GridPane stage) {
		initilize(stage);
	}

	private void initilize(GridPane stage) {
		setCusopscene(new CustomerOptionsScene(stage));
		setChoices( new ArrayList<>());
		
		setAddress(getCusopscene().getAddress());
		setEmoloyeeName(getCusopscene().getEmoloyeeName());
		setEmployeeD(getCusopscene().getEmployeeD());
		setEmployee2(getCusopscene().getEmployee2());
		setEmployG(getCusopscene().getEmployG());
		setEmpoyeeP(getCusopscene().getEmpoyeeP());
		
		getChoices().add(0, getEmployee2());
		getChoices().add(1, getEmoloyeeName());
		getChoices().add(2, getEmployG());
		getChoices().add(3, getEmployeeD());
		getChoices().add(4, getEmpoyeeP());
		getChoices().add(5, getAddress());			
	}

	public ArrayList<radio> getChoices() {
		return choices;
	}

	public void setChoices(ArrayList<radio> choices) {
		this.choices = choices;
	}

	public CustomerOptionsScene getCusopscene() {
		return cusopscene;
	}

	public void setCusopscene(CustomerOptionsScene cusopscene) {
		this.cusopscene = cusopscene;
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
