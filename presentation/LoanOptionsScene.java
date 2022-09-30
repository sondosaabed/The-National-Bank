package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class LoanOptionsScene {
    
	private radio loanNumber;
	private radio id;
	private radio customeri;
	private radio loanAmoun;
	private radio loanTyp;
	private radio dateL;

	public LoanOptionsScene(GridPane stage) {
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
        
        setLoanNumber(new radio("images/loanNumber.png",pane,0,1,"Loan number:","Loan_number"));
        setId(new radio("images/branchID.png",pane,1,1,"Branch ID:","Branch_ID"));
        setCustomeri(new radio("images/customer ID.png",pane,2,1,"Customer ID:","customer_id"));
        setLoanAmoun(new radio("images/loanAmount.png",pane,0,2,"Loan Amount:","Loan_amount"));
        setLoanTyp(new radio("images/loanType.png",pane,1,2,"Loan Type:","Loan_type"));
        setDateL(new radio("images/loanDate.png",pane,2,2,"Loan Date:","loan_date"));
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

	public radio getDateL() {
		return dateL;
	}

	public void setDateL(radio dateL) {
		this.dateL = dateL;
	}

	public radio getLoanAmoun() {
		return loanAmoun;
	}

	public void setLoanAmoun(radio loanAmoun) {
		this.loanAmoun = loanAmoun;
	}
}
