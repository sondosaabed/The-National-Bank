package control;

import java.sql.SQLException;

import dataAccess.AccountQuery;
import dataAccess.CardQuery;
import dataAccess.CustomerQuery;
import dataAccess.EmployeeQuery;
import dataAccess.LoanQuery;
import dataAccess.ManagerQuery;
import dataAccess.PaymentQuery;
import dataAccess.TransactionQuery;
import javafx.collections.FXCollections;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import presentation.ViewScene;

public class ViewSceneControl {
	private ViewScene viewaccscene;
	private AccountQuery accountQuery;
	private CardQuery cardQuery;
	private CustomerQuery customerQuery;
	private EmployeeQuery employeeQuery;
	private LoanQuery loanQuery;
	private ManagerQuery managerQuery;
	private PaymentQuery paymentQuery;
	private TransactionQuery transactionQuery;

	public ViewSceneControl(Stage stage, String name) {
		initialize(stage, name);
	}

	private void initialize(Stage stage,String name) {
		setViewaccscene(new ViewScene(stage, name));
		
		setTransactionQuery(new TransactionQuery());
		setPaymentQuery(new PaymentQuery());
		setManagerQuery(new ManagerQuery());
		setLoanQuery(new LoanQuery());
		setCardQuery(new CardQuery());
		setEmployeeQuery(new EmployeeQuery());
		setAccountQuery(new AccountQuery());

		try {
			if (name=="transaction") {
				getTransactionQuery().getData();
				getTransactionQuery().dataList = FXCollections.observableArrayList(getTransactionQuery().data);
				getTransactionQuery().tableView(stage, getViewaccscene().getPane2());
			}else if(name=="payment") {
				getPaymentQuery().getData();
				getPaymentQuery().dataList = FXCollections.observableArrayList(paymentQuery.data);
				getPaymentQuery().tableView(stage,getViewaccscene().getPane2());
			}else if(name=="manager") {
				getManagerQuery().getData();
				getManagerQuery().dataList = FXCollections.observableArrayList(managerQuery.data);
				getManagerQuery().tableView(stage,getViewaccscene().getPane2());
			}else if(name=="loan") {
				getLoanQuery().getData();
				getLoanQuery().dataList = FXCollections.observableArrayList(getLoanQuery().data);
				getLoanQuery().tableView(stage,getViewaccscene().getPane2());
			}else if(name=="card") {
				getCardQuery().getData();
				getCardQuery().dataList = FXCollections.observableArrayList(cardQuery.data);
				getCardQuery().tableView(stage,getViewaccscene().getPane2());
			}else if(name=="account") {
				getAccountQuery().getData();
				getAccountQuery().dataList = FXCollections.observableArrayList(accountQuery.data);
				getAccountQuery().tableView(stage,getViewaccscene().getPane2());
			}else if(name=="employee") {
				getEmployeeQuery().getData();
				getEmployeeQuery().dataList = FXCollections.observableArrayList(employeeQuery.data);
				getEmployeeQuery().tableView(stage,getViewaccscene().getPane2());
			}else if(name=="customer") {
				getCustomerQuery().getData();
				getCustomerQuery().dataList = FXCollections.observableArrayList(getCustomerQuery().data);
				getCustomerQuery().tableView(stage, getViewaccscene().getPane2());
			}
		} catch (SQLException | ClassNotFoundException f) {
			f.printStackTrace();
		}

		stage.setTitle("View Table of "+name);
		stage.getIcons().add(new Image("images/TNB.png"));
		stage.show();
	}

	public ViewScene getViewaccscene() {
		return viewaccscene;
	}

	public void setViewaccscene(ViewScene viewaccscene) {
		this.viewaccscene = viewaccscene;
	}

	public AccountQuery getAccountQuery() {
		return accountQuery;
	}

	public void setAccountQuery(AccountQuery accountQuery) {
		this.accountQuery = accountQuery;
	}

	public CardQuery getCardQuery() {
		return cardQuery;
	}

	public TransactionQuery getTransactionQuery() {
		return transactionQuery;
	}

	public void setTransactionQuery(TransactionQuery transactionQuery) {
		this.transactionQuery = transactionQuery;
	}

	public void setCardQuery(CardQuery cardQuery) {
		this.cardQuery = cardQuery;
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
	public LoanQuery getLoanQuery() {
		return loanQuery;
	}

	public void setLoanQuery(LoanQuery loanQuery) {
		this.loanQuery = loanQuery;
	}

	public ManagerQuery getManagerQuery() {
		return managerQuery;
	}

	public void setManagerQuery(ManagerQuery managerQuery) {
		this.managerQuery = managerQuery;
	}

	public PaymentQuery getPaymentQuery() {
		return paymentQuery;
	}

	public void setPaymentQuery(PaymentQuery paymentQuery) {
		this.paymentQuery = paymentQuery;
	}
}
