package control;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import presentation.TransactionOptionsScene;
import presentation.radio;

public class TransactionOptionsControl {
	private TransactionOptionsScene tranopscene;
	private ArrayList<radio> choices;
	private radio customeri;
	private radio loanAmoun;
	private radio id;
	private radio transactionAmoun;
	private radio loanTyp;
	private radio dateL;
	
	public TransactionOptionsControl(GridPane stage) {
		initialize(stage);
	}

	private void initialize(GridPane stage) {
		setTranopscene(new TransactionOptionsScene(stage));
		setChoices(new ArrayList<>());
		
		setCustomeri(getTranopscene().getCustomeri());
		setLoanAmoun(getTranopscene().getLoanAmoun());
		setId(getTranopscene().getId());
		setTransactionAmoun(getTranopscene().getTransactionAmoun());
		setLoanTyp(getTranopscene().getLoanTyp());
		setDateL(getTranopscene().getDateL());
		
	    getChoices().add(0, getId());
	    getChoices().add(1, getCustomeri());
	    getChoices().add(2, getLoanAmoun());
	    getChoices().add(3, getLoanTyp());
		getChoices().add(4, getDateL());
	    getChoices().add(5, getTransactionAmoun());		
	}

	public TransactionOptionsScene getTranopscene() {
		return tranopscene;
	}

	public void setTranopscene(TransactionOptionsScene tranopscene) {
		this.tranopscene = tranopscene;
	}

	public ArrayList<radio> getChoices() {
		return choices;
	}

	public void setChoices(ArrayList<radio> choices) {
		this.choices = choices;
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

	public radio getId() {
		return id;
	}

	public void setId(radio id) {
		this.id = id;
	}

	public radio getTransactionAmoun() {
		return transactionAmoun;
	}

	public void setTransactionAmoun(radio transactionAmoun) {
		this.transactionAmoun = transactionAmoun;
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
