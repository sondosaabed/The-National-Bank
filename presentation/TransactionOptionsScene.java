package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class TransactionOptionsScene {
    
	private radio customeri;
	private radio loanAmoun;
	private radio id;
	private radio transactionAmoun;
	private radio loanTyp;
	private radio dateL;

	public TransactionOptionsScene(GridPane stage) {
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
        
        setId(new radio("images/transactionId.png",pane,0,1,"ID:","Transaction_ID"));
        setCustomeri(new radio("images/customer ID.png",pane,1,1,"Customer ID:","customer_id"));
        setLoanAmoun(new radio("images/empID.png",pane,2,1,"Employee ID:","employee_ID"));
        setLoanTyp(new radio("images/TranspositionDate.png",pane,0,2,"Transaction Date:","Transposition_date"));
        setDateL(new radio("images/Transpositiontype.png",pane,1,2,"Transaction Type:","Transposition_type"));				
        setTransactionAmoun(new radio("images/transactionAmount.png",pane,2,2,"Transaction Amount:","Transposition_amount"));
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

	public radio getDateL() {
		return dateL;
	}

	public void setDateL(radio dateL) {
		this.dateL = dateL;
	}

	public radio getLoanTyp() {
		return loanTyp;
	}

	public void setLoanTyp(radio loanTyp) {
		this.loanTyp = loanTyp;
	}

	public radio getTransactionAmoun() {
		return transactionAmoun;
	}

	public void setTransactionAmoun(radio transactionAmoun) {
		this.transactionAmoun = transactionAmoun;
	}
}
