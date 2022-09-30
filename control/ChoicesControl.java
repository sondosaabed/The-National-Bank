package control;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import presentation.ChoiceScene;

public class ChoicesControl {
	//feilds
	private ChoiceScene choiceScene;
	private ViewSceneControl viewcardctrl;
	private DeleteSceneControl deletecontrol;
	private SearchControl searchctrl;
	private UpdateCpntrol updatectrl;
	private AddAccountControl addaccontrol;
	private AddCustomerControl addcuscontrol;
	private AddCardControl addcardcontrol;
	private AddEmployeeControl addempcontrol;
	private AddManagerControl addmangercontrol;
	private AddTranControl addtranControl;
	private AddLoanControl addloancontrol;
	private AddPaymentControl addpaymemntcontrol;
	private Button employee;
	private Button manager;
	private Button transaction;
	private Button card;
	private Button payment;
	private Button loan;
	private Button account;
	private Button customer;
	private Button exit;
	
	ChoicesControl(Stage stage){
		initialize(stage);
	}

	private void initialize(Stage stage) {
		setChoiceScene(new ChoiceScene(stage));
		
		setAccount(getChoiceScene().getAccount());
		setCard(getChoiceScene().getCard());
		setCustomer(getChoiceScene().getCustomer());
		setEmployee(getChoiceScene().getEmployee());
		setExit(getChoiceScene().getExit());
		setLoan(getChoiceScene().getLoan());
		setManager(getChoiceScene().getManager());
		setPayment(getChoiceScene().getPayment());
		setTransaction(getChoiceScene().getTransaction());
		
		handle_exit(getExit(),stage);
	}

	private void handle_exit(Button exit, Stage stage) {
        exit.setOnAction(k -> {
            stage.close();
        });			
	}
	
	public void handleChoiceSceneForSearch(Stage stage) {
		account.setOnAction(a->{
			setSearchctrl(new SearchControl(stage, "account"));
		});
		card.setOnAction(c->{
			setSearchctrl(new SearchControl(stage, "card"));
		});
		customer.setOnAction(q->{
			setSearchctrl(new SearchControl(stage, "customer"));
		});
		employee.setOnAction(e->{
			setSearchctrl(new SearchControl(stage, "employee"));
		});
		loan.setOnAction(e->{
			setSearchctrl(new SearchControl(stage, "loan"));
		});
		manager.setOnAction(e->{
			setSearchctrl(new SearchControl(stage, "manager"));
		});
		payment.setOnAction(e->{
			setSearchctrl(new SearchControl(stage, "payment"));
		});
		transaction.setOnAction(t->{
			setSearchctrl(new SearchControl(stage, "transaction"));
		});
	}
	
	public void handleChoiceSceneForUpdate(Stage stage) {
		account.setOnAction(a->{
			setUpdatectrl(new UpdateCpntrol(stage, "account"));
		});
		card.setOnAction(c->{
			setUpdatectrl(new UpdateCpntrol(stage, "card"));
		});
		customer.setOnAction(q->{
			setUpdatectrl(new UpdateCpntrol(stage, "customer"));
		});
		employee.setOnAction(e->{
			setUpdatectrl(new UpdateCpntrol(stage, "employee"));
		});
		loan.setOnAction(e->{
			setUpdatectrl(new UpdateCpntrol(stage, "loan"));
		});
		manager.setOnAction(e->{
			setUpdatectrl(new UpdateCpntrol(stage, "manager"));
		});
		payment.setOnAction(e->{
			setUpdatectrl(new UpdateCpntrol(stage, "payment"));
		});
		transaction.setOnAction(t->{
			setUpdatectrl(new UpdateCpntrol(stage, "transaction"));
		});
	}
	
	public void handleChoiceSceneForAdd(Stage stage) {
		account.setOnAction(a->{
			setAddaccontrol(new AddAccountControl(stage));
		});
		card.setOnAction(c->{
			setAddcardcontrol(new AddCardControl(stage));
		});
		customer.setOnAction(q->{
			setAddcuscontrol(new AddCustomerControl(stage));
		});
		employee.setOnAction(e->{
			setAddempcontrol(new AddEmployeeControl(stage));
		});
		loan.setOnAction(e->{
			setAddloancontrol(new AddLoanControl(stage));
		});
		manager.setOnAction(e->{
			setAddmangercontrol(new AddManagerControl(stage));
		});
		payment.setOnAction(e->{
			setAddpaymemntcontrol(new AddPaymentControl(stage));
		});
		transaction.setOnAction(t->{
			setAddtranControl(new AddTranControl(stage));
		});	
	}
	
	public void handleChoiceSceneForDelete(Stage stage) {
		account.setOnAction(a->{
			setDeletecontrol(new DeleteSceneControl(stage, "account"));
		});
		card.setOnAction(c->{
			setDeletecontrol(new DeleteSceneControl(stage, "card"));
		});
		customer.setOnAction(q->{
			setDeletecontrol(new DeleteSceneControl(stage, "customer"));
		});
		employee.setOnAction(e->{
			setDeletecontrol(new DeleteSceneControl(stage, "employee"));
		});
		loan.setOnAction(e->{
			setDeletecontrol(new DeleteSceneControl(stage, "loan"));
		});
		manager.setOnAction(e->{
			setDeletecontrol(new DeleteSceneControl(stage, "manager"));
		});
		payment.setOnAction(e->{
			setDeletecontrol(new DeleteSceneControl(stage, "payment"));
		});
		transaction.setOnAction(t->{
			setDeletecontrol(new DeleteSceneControl(stage, "transaction"));
		});
	}
	
	public void handleChoiceSceneForView(Stage stage) {
		account.setOnAction(a->{
			setViewcardctrl(new ViewSceneControl(stage, "account"));
		});
		card.setOnAction(c->{
			setViewcardctrl(new ViewSceneControl(stage, "card"));
		});
		loan.setOnAction(l->{
			setViewcardctrl(new ViewSceneControl(stage, "loan"));
		});
		transaction.setOnAction(o->{
			setViewcardctrl(new ViewSceneControl(stage, "transaction"));
		});
		employee.setOnAction(r->{
			setViewcardctrl(new ViewSceneControl(stage, "employee"));
		});
		manager.setOnAction(m->{
			setViewcardctrl(new ViewSceneControl(stage, "manager"));
		});
		customer.setOnAction(v->{
			setViewcardctrl(new ViewSceneControl(stage, "customer"));
		});
		payment.setOnAction(y->{
			setViewcardctrl(new ViewSceneControl(stage, "payment"));
		});	}
	
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

	public ChoiceScene getChoiceScene() {
		return choiceScene;
	}

	public void setChoiceScene(ChoiceScene choiceScene) {
		this.choiceScene = choiceScene;
	}

	public DeleteSceneControl getDeletecontrol() {
		return deletecontrol;
	}

	public void setDeletecontrol(DeleteSceneControl deletecontrol) {
		this.deletecontrol = deletecontrol;
	}

	public AddAccountControl getAddaccontrol() {
		return addaccontrol;
	}

	public void setAddaccontrol(AddAccountControl addaccontrol) {
		this.addaccontrol = addaccontrol;
	}

	public AddCustomerControl getAddcuscontrol() {
		return addcuscontrol;
	}

	public void setAddcuscontrol(AddCustomerControl addcuscontrol) {
		this.addcuscontrol = addcuscontrol;
	}

	public AddCardControl getAddcardcontrol() {
		return addcardcontrol;
	}

	public void setAddcardcontrol(AddCardControl addcardcontrol) {
		this.addcardcontrol = addcardcontrol;
	}

	public AddEmployeeControl getAddempcontrol() {
		return addempcontrol;
	}

	public void setAddempcontrol(AddEmployeeControl addempcontrol) {
		this.addempcontrol = addempcontrol;
	}

	public AddManagerControl getAddmangercontrol() {
		return addmangercontrol;
	}

	public void setAddmangercontrol(AddManagerControl addmangercontrol) {
		this.addmangercontrol = addmangercontrol;
	}

	public AddTranControl getAddtranControl() {
		return addtranControl;
	}

	public void setAddtranControl(AddTranControl addtranControl) {
		this.addtranControl = addtranControl;
	}

	public AddLoanControl getAddloancontrol() {
		return addloancontrol;
	}

	public void setAddloancontrol(AddLoanControl addloancontrol) {
		this.addloancontrol = addloancontrol;
	}

	public AddPaymentControl getAddpaymemntcontrol() {
		return addpaymemntcontrol;
	}

	public void setAddpaymemntcontrol(AddPaymentControl addpaymemntcontrol) {
		this.addpaymemntcontrol = addpaymemntcontrol;
	}

	public ViewSceneControl getViewcardctrl() {
		return viewcardctrl;
	}

	public void setViewcardctrl(ViewSceneControl viewcardctrl) {
		this.viewcardctrl = viewcardctrl;
	}

	public SearchControl getSearchctrl() {
		return searchctrl;
	}

	public void setSearchctrl(SearchControl searchctrl) {
		this.searchctrl = searchctrl;
	}

	public UpdateCpntrol getUpdatectrl() {
		return updatectrl;
	}

	public void setUpdatectrl(UpdateCpntrol updatectrl) {
		this.updatectrl = updatectrl;
	}
	
}
