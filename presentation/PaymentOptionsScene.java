package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class PaymentOptionsScene {
	private radio loanNumber;
	private radio id;
	private radio customeri;
	private radio loanTyp;

	public PaymentOptionsScene(GridPane stage) {
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

		setLoanNumber(new radio("images/employeeID.png",pane,0,1,"ID:","Payment_Number"));
		setId(new radio("images/loanNumber.png",pane,1,1,"Loan number:","Loan_number"));      
		setCustomeri(new radio("images/paymnetAmount.png",pane,1,2,"Payment Amount:","Payment_amount"));
		setLoanTyp(new radio("images/paymentDate.png",pane,2,1,"Payment Date:","Payment_date"));
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
