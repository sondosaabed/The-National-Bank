package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CardOptionsScene {

	private radio id;
	private radio customeri;
	private radio loanAmoun;
	private radio loanTyp;

	public CardOptionsScene(GridPane stage) {
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

		setId(new radio("images/cardID.png",pane,0,1,"ID:","card_ID"));
		setCustomeri(new radio("images/cardLimit.png",pane,0,2,"Card Limit:","card_limit"));
		setLoanAmoun(new radio("images/cardExpDate.png",pane,2,1,"Card Expiration Date:","card_exp_date"));
		setLoanTyp(new radio("images/customer ID.png",pane,1,1,"Customer ID:","customer_id"));
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
}
