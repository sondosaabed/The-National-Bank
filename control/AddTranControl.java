package control;

import java.sql.Date;
import java.util.ArrayList;

import application.Transaction;
import application.TransactionAccount;
import dataAccess.AccountQuery;
import dataAccess.CustomerQuery;
import dataAccess.EmployeeQuery;
import dataAccess.TransactionAccountQuery;
import dataAccess.TransactionQuery;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import presentation.AddTranScene;

public class AddTranControl {
	//feilds
	private AddTranScene addtranscene;
	private AccountQuery accountQuery; 
	private CustomerQuery customerQuery;
	private EmployeeQuery employeeQuery;
    private TransactionQuery transactionQuery;
    private TransactionAccountQuery transactionAccountQuery;
    private ComboBox<String> customerID;
	private ComboBox<String> accountID; 
	private ComboBox<String> empID;
	private Button cancel0;
	private Button add;
	private TextField amount1;
	private ComboBox<String> type; 
	
	public AddTranControl(Stage stage) {
		initialize(stage);
	}
	
	private void initialize(Stage stage) {
		setAddtranscene(new AddTranScene(stage));
		setAccountQuery(new AccountQuery());
		setCustomerQuery(new CustomerQuery());		
		setEmployeeQuery(new EmployeeQuery());
		setTransactionQuery(new TransactionQuery());
		setTransactionAccountQuery(new TransactionAccountQuery());
		
		setAccountID(getAddtranscene().getAccountID());
		setAdd(getAddtranscene().getAdd());
		setAmount1(getAddtranscene().getAmount1());
		setCancel0(getAddtranscene().getCancel0());
		setCustomerID(getAddtranscene().getCustomerID());

		setEmpID(getAddtranscene().getEmpID());

		setType(getAddtranscene().getType());
		handle_cancel(getCancel0());
		handle_add(getAdd(),stage);
	}
	
	private void handle_cancel(Button cancel) {
		
	}
	
	private void handle_add(Button add, Stage stage) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c1);
	    getCustomerQuery().comboBox(getCustomerID());
	    getAccountQuery().comboBox(getAccountID());
	    getEmployeeQuery().comboBox(getEmpID());
	  
	    add.setOnAction(l -> {
	      try{
	          long millis=System.currentTimeMillis();
	          Date date =new Date(millis);
	          Transaction transaction1 = new Transaction(date,
	          										getType().getSelectionModel().getSelectedItem().trim(),
	          										Double.parseDouble(amount1.getText().trim()),
	          										Integer.parseInt(getEmpID().getSelectionModel().getSelectedItem().trim()),
	          										Integer.parseInt(getCustomerID().getSelectionModel().getSelectedItem().trim()));
	          transactionQuery.insertData(transaction1);
	
	          ArrayList<Integer> tr = transactionQuery.id();
	          TransactionAccount ta = new TransactionAccount(Integer.parseInt(getAccountID().getSelectionModel().getSelectedItem().trim()),
	          		tr.get(tr.size()-1));
	          transactionAccountQuery.insertData(ta);
	
	          String choicee = getType().getSelectionModel().getSelectedItem();
	          String sign="";
	          if(choicee.equalsIgnoreCase("Withdraw")) {
	          	sign ="-";
	          }else {
	          	sign ="+";
	          }
	          
	          boolean x = transactionAccountQuery.update(ta, sign);
	          if(x== true) {
	  	        GridPane pane = new GridPane();
	  	        pane.setPadding(new Insets(60, 60, 60, 60));
	  	        pane.setAlignment(Pos.CENTER);
	  	        pane.setHgap(10);
	  	        pane.setVgap(10);
	  	        pane.setBackground(background);
	              
	              Label hello54 = new Label("inserted successfully");
	              hello54.setFont(Font.font(17));
	              hello54.setTextFill(Color.GREY);
	              pane.add(hello54, 0, 0);
	
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
	              
	              //Create Scene
	              Scene scene5 = new Scene(pane);
	              stage.setScene(scene5);
	              stage.setTitle("The National Bank");
	              stage.getIcons().add(new Image("images/TNB.png"));
	              stage.show();
	          }
	      }catch (Exception e){
	          Alert alert = new Alert(Alert.AlertType.WARNING);
	          alert.setTitle("Warning Dialog");
	          alert.setHeaderText("Look, a Warning Dialog");
	          alert.setContentText("Please Make sure you are inputting the right input\n" +e.getMessage());
	          alert.showAndWait();
	      }
	  });
	}

	public ComboBox<String> getCustomerID() {
		return customerID;
	}

	public void setCustomerID(ComboBox<String> customerID) {
		this.customerID = customerID;
	}

	public ComboBox<String> getAccountID() {
		return accountID;
	}

	public void setAccountID(ComboBox<String> accountID) {
		this.accountID = accountID;
	}

	public ComboBox<String> getEmpID() {
		return empID;
	}

	public void setEmpID(ComboBox<String> empID) {
		this.empID = empID;
	}

	public Button getCancel0() {
		return cancel0;
	}

	public void setCancel0(Button cancel0) {
		this.cancel0 = cancel0;
	}

	public Button getAdd() {
		return add;
	}

	public void setAdd(Button add) {
		this.add = add;
	}

	public TextField getAmount1() {
		return amount1;
	}

	public void setAmount1(TextField amount1) {
		this.amount1 = amount1;
	}

	public ComboBox<String> getType() {
		return type;
	}

	public void setType(ComboBox<String> type) {
		this.type = type;
	}

	public AddTranScene getAddtranscene() {
		return addtranscene;
	}

	public void setAddtranscene(AddTranScene addtranscene) {
		this.addtranscene = addtranscene;
	}

	public AccountQuery getAccountQuery() {
		return accountQuery;
	}

	public void setAccountQuery(AccountQuery accountQuery) {
		this.accountQuery = accountQuery;
	}

	public CustomerQuery getCustomerQuery() {
		return customerQuery;
	}

	public void setCustomerQuery(CustomerQuery customerQuery) {
		this.customerQuery = customerQuery;
	}

	public EmployeeQuery getEmployeeQuery() {
		return employeeQuery;
	}

	public void setEmployeeQuery(EmployeeQuery employeeQuery) {
		this.employeeQuery = employeeQuery;
	}

	public TransactionQuery getTransactionQuery() {
		return transactionQuery;
	}

	public void setTransactionQuery(TransactionQuery transactionQuery) {
		this.transactionQuery = transactionQuery;
	}

	public TransactionAccountQuery getTransactionAccountQuery() {
		return transactionAccountQuery;
	}

	public void setTransactionAccountQuery(TransactionAccountQuery transactionAccountQuery) {
		this.transactionAccountQuery = transactionAccountQuery;
	}
	

}
