package control;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import presentation.LoanOptionsScene;
import presentation.radio;

public class LoanOptionsControl {
	private ArrayList<radio> choices;
	private LoanOptionsScene loanopscene;
	private radio loanNumber;
	private radio id;
	private radio customeri;
	private radio loanAmoun;
	private radio loanTyp;
	private radio dateL;
	
	public LoanOptionsControl(GridPane stage) {
		initialize(stage);
	}

	private void initialize(GridPane stage) {
		setLoanopscene(new LoanOptionsScene(stage));
		setChoices(new ArrayList<>());
		
		setLoanNumber(getLoanopscene().getLoanNumber());
		setId(getLoanopscene().getId());
		setCustomeri(getLoanopscene().getCustomeri());
		setLoanAmoun(getLoanopscene().getLoanAmoun());
		setLoanTyp(getLoanopscene().getLoanTyp());
		setDateL(getLoanopscene().getDateL());
		
		getChoices().add(0, getLoanNumber());
		getChoices().add(1, getId());
		getChoices().add(2, getCustomeri());
		getChoices().add(3, getLoanAmoun());
		getChoices().add(4, getLoanTyp());
		getChoices().add(5, getDateL());			
	}

	public ArrayList<radio> getChoices() {
		return choices;
	}

	public void setChoices(ArrayList<radio> choices) {
		this.choices = choices;
	}

	public LoanOptionsScene getLoanopscene() {
		return loanopscene;
	}

	public void setLoanopscene(LoanOptionsScene loanopscene) {
		this.loanopscene = loanopscene;
	}

	public radio getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(radio loanNumber) {
		this.loanNumber = loanNumber;
	}

	public radio getId() {
		return id;
	}

	public void setId(radio id) {
		this.id = id;
	}

	public radio getCustomeri() {
		return customeri;
	}

	public void setCustomeri(radio customeri) {
		this.customeri = customeri;
	}

	public radio getLoanAmoun() {
		return loanAmoun;
	}

	public void setLoanAmoun(radio loanAmoun) {
		this.loanAmoun = loanAmoun;
	}

	public radio getLoanTyp() {
		return loanTyp;
	}

	public void setLoanTyp(radio loanTyp) {
		this.loanTyp = loanTyp;
	}

	public radio getDateL() {
		return dateL;
	}

	public void setDateL(radio dateL) {
		this.dateL = dateL;
	}
}
