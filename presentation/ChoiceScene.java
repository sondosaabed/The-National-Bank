package presentation;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChoiceScene {
	private GridPane pane;
	private Button employee;
	private Button manager;
	private Button transaction;
	private Button card;
	private Button payment;
	private Button loan;
	private Button account;
	private Button customer;
	private Button exit;

	public ChoiceScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c1);
	    
        pane= new GridPane();
        pane.setPadding(new Insets(60, 60, 60, 60));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setBackground(background);
        
        Image img9 = new Image("images/TNB.png");
        ImageView v10 = new ImageView(img9);
        v10.setFitWidth(150);
        v10.setFitHeight(70);

        Button logo2 = new Button();
        GridPane.setHalignment(logo2, HPos.CENTER);
        logo2.setPrefSize(180, 100);
        logo2.setGraphic(v10);
        logo2.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
        pane.add(logo2, 1, 0);

        employee = midButton("images/employees.png");
        pane.add(employee, 0, 1);

        manager = midButton("images/manager.png");
        pane.add(manager, 1, 1);
        
        transaction = midButton("images/transaction.png");
        pane.add(transaction, 1,3);

        card = midButton("images/card.png");
        pane.add(card, 0,3);

        payment = midButton("images/payment.png");
        pane.add(payment, 2, 2);

        loan = midButton("images/loan.png");
        pane.add(loan, 1, 2);
        
        account = midButton("images/bank-account.png");
        pane.add(account, 0, 2);

        customer = midButton("images/customer.png");
        pane.add(customer, 2, 1);
        
        exit =  midButton("images/close.png");
        pane.add(exit, 2,3);
        
        Scene scene1 = new Scene(pane);
        stage.setScene(scene1);
        stage.setTitle("The National Bank");
        stage.getIcons().add(new Image("images/TNB.png"));
        stage.show();		
	}
	
	public Button midButton(String url){
        Image img = new Image(url);
        ImageView v1 = new ImageView(img);
        v1.setFitWidth(170);
        v1.setFitHeight(170);

        Button button = new Button();
        button.setTextFill(Color.BROWN);
        button.setPrefSize(180, 180);
        button.setGraphic(v1);
        button.setStyle("-fx-background-radius: 7;-fx-background-color:lightblue;");
        return button;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public Button getEmployee() {
		return employee;
	}

	public void setEmployee(Button employee) {
		this.employee = employee;
	}

	public Button getManager() {
		return manager;
	}

	public void setManager(Button manager) {
		this.manager = manager;
	}

	public Button getTransaction() {
		return transaction;
	}

	public void setTransaction(Button transaction) {
		this.transaction = transaction;
	}

	public Button getCard() {
		return card;
	}

	public void setCard(Button card) {
		this.card = card;
	}

	public Button getPayment() {
		return payment;
	}

	public void setPayment(Button payment) {
		this.payment = payment;
	}

	public Button getLoan() {
		return loan;
	}

	public void setLoan(Button loan) {
		this.loan = loan;
	}

	public Button getAccount() {
		return account;
	}

	public void setAccount(Button account) {
		this.account = account;
	}

	public Button getCustomer() {
		return customer;
	}

	public void setCustomer(Button customer) {
		this.customer = customer;
	}

	public Button getExit() {
		return exit;
	}

	public void setExit(Button exit) {
		this.exit = exit;
	}
}
