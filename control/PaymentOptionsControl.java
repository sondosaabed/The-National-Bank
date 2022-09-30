package control;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import presentation.PaymentOptionsScene;
import presentation.radio;

public class PaymentOptionsControl {
	private PaymentOptionsScene payopscene;
	private ArrayList<radio> choices;
	private radio loanNumber;
	private radio id;
	private radio customeri;
	private radio loanTyp;
	
	public PaymentOptionsControl(GridPane stage) {
		initialize(stage);
	}

	private void initialize(GridPane stage) {
		setPayopscene(new PaymentOptionsScene(stage));
		setChoices(new ArrayList<>());
		
		setLoanNumber(getPayopscene().getLoanNumber());
		setId(getPayopscene().getId());
		setCustomeri(getPayopscene().getCustomeri());
		setLoanNumber(getPayopscene().getLoanNumber());
		
		getChoices().add(0, getLoanNumber());
	    getChoices().add(1, getId());
	    getChoices().add(2, getCustomeri());
	    getChoices().add(3, getLoanNumber());			
	}

	public PaymentOptionsScene getPayopscene() {
		return payopscene;
	}

	public void setPayopscene(PaymentOptionsScene payopscene) {
		this.payopscene = payopscene;
	}

	public ArrayList<radio> getChoices() {
		return choices;
	}

	public void setChoices(ArrayList<radio> choices) {
		this.choices = choices;
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

	public radio getLoanTyp() {
		return loanTyp;
	}

	public void setLoanTyp(radio loanTyp) {
		this.loanTyp = loanTyp;
	}
}
