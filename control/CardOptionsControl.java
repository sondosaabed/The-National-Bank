package control;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import presentation.CardOptionsScene;
import presentation.radio;

public class CardOptionsControl {
	private CardOptionsScene cardopscene;
	private ArrayList<radio> choices;
	private radio id;
	private radio customeri;
	private radio loanAmoun;
	private radio loanTyp;
	
	public CardOptionsControl(GridPane stage) {
		initialize(stage);
	}

	private void initialize(GridPane stage) {
		setChoices(new ArrayList<>());
		setCardopscene(new CardOptionsScene(stage));
		
		setCustomeri(getCardopscene().getCustomeri());
		setId(getCardopscene().getId());
		setLoanAmoun(getCardopscene().getLoanAmoun());
		setLoanTyp(getCardopscene().getLoanTyp());
		
	    getChoices().add(0, getId());
	    getChoices().add(1, getCustomeri());
	    getChoices().add(2, getLoanAmoun());
	    getChoices().add(3, getLoanTyp());
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

	public ArrayList<radio> getChoices() {
		return choices;
	}

	public void setChoices(ArrayList<radio> choices) {
		this.choices = choices;
	}

	public CardOptionsScene getCardopscene() {
		return cardopscene;
	}

	public void setCardopscene(CardOptionsScene cardopscene) {
		this.cardopscene = cardopscene;
	}
}
