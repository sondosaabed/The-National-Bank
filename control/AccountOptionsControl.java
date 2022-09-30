package control;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import presentation.AccountOptionsScene;
import presentation.radio;

public class AccountOptionsControl {
	private AccountOptionsScene accopscene;
	private ArrayList<radio> choices;
	private radio employee2;
	private radio emoloyeeName;
	private radio employG;
	private radio employeeD;
	private radio employeeE;
	private radio empoyeeS;
	private radio Interest;
	private radio initialDeposit;
	
	public AccountOptionsControl(GridPane pane) {
		initialize(pane);
	}
	
	private void initialize(GridPane pane) {
		setAccopscene(new AccountOptionsScene(pane));
		setChoices(new ArrayList<>());
		
		setEmoloyeeName(getAccopscene().getEmoloyeeName());
		setEmployee2(getAccopscene().getEmployee2());
		setEmployeeD(getAccopscene().getEmployeeD());
		setEmployeeE(getAccopscene().getEmployeeE());
		setEmployG(getAccopscene().getEmployG());
		setEmpoyeeS(getAccopscene().getEmpoyeeS());
		setInitialDeposit(getAccopscene().getInitialDeposit());
		setInterest(getAccopscene().getInterest());
		
		getChoices().add(0, getEmployee2());
		getChoices().add(1, getEmoloyeeName());
		getChoices().add(2, getEmployG());
		getChoices().add(3, getEmployeeD());
		getChoices().add(4, getEmployeeE());
		getChoices().add(5, getEmpoyeeS());
		getChoices().add(6, getInterest());
		getChoices().add(7, getInitialDeposit());
	}
	
	public AccountOptionsScene getAccopscene() {
		return accopscene;
	}

	public void setAccopscene(AccountOptionsScene accopscene) {
		this.accopscene = accopscene;
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
