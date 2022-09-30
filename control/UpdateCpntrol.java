package control;

import java.util.ArrayList;

import dataAccess.AccountQuery;
import dataAccess.CardQuery;
import dataAccess.CustomerQuery;
import dataAccess.EmployeeQuery;
import dataAccess.LoanQuery;
import dataAccess.ManagerQuery;
import dataAccess.PaymentQuery;
import dataAccess.TransactionQuery;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import presentation.choice;
import presentation.radio;

public class UpdateCpntrol {
	//feilds
	private OpControl opctrl;

	private AccountQuery accountQuery;
	private CardQuery cardQuery;
	private CustomerQuery customerQuery;
	private EmployeeQuery employeeQuery;
	private LoanQuery loanQuery;
	private ManagerQuery managerQuery;
	private PaymentQuery paymentQuery;
	private TransactionQuery transactionQuery;

	private Button next;
	private Button ok ;
	private Button oka = new Button("Okay");
	private Button okay = new Button("Okay");

	private String answer;
	BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	Background background = new Background(c1);

	private ArrayList<choice> conditions;

	public UpdateCpntrol(Stage stage, String name) {
		initialize(stage,name);
	}

	private void initialize(Stage stage, String name) {
		setOpctrl(new OpControl(stage, name));
		setOk(getOpctrl().getOk());
		setAnswer("");

		setTransactionQuery(new TransactionQuery());
		setPaymentQuery(new PaymentQuery());
		setManagerQuery(new ManagerQuery());
		setLoanQuery(new LoanQuery());
		setCardQuery(new CardQuery());
		setEmployeeQuery(new EmployeeQuery());
		setAccountQuery(new AccountQuery());

		handle_ok(getOk(),stage,name);
		handle_oka(getOka(), stage, name);
		handle_okay(getOkay(), stage, name);
	}

	private void handle_ok(Button ok2, Stage stage, String name) {
		ok2.setOnAction(e->{
			GridPane pane4 = new GridPane();
			pane4.setPadding(new Insets(60, 60, 60, 60));
			pane4.setAlignment(Pos.CENTER);
			pane4.setHgap(10);
			pane4.setVgap(10);
			pane4.setBackground(background);

			Label hello4 = new Label("What to Update");
			hello4.setFont(Font.font(17));
			hello4.setTextFill(Color.GREY);
			pane4.add(hello4, 0, 0);

			Image img2 = new Image("images/TNB.png");
			ImageView v1 = new ImageView(img2);
			v1.setFitWidth(150);
			v1.setFitHeight(70);

			Button logo223 = new Button();
			GridPane.setHalignment(logo223, HPos.CENTER);
			logo223.setPrefSize(180, 100);
			logo223.setGraphic(v1);
			logo223.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
			pane4.add(logo223, 1, 0);

			conditions = new ArrayList<>();

			if (name=="transaction") {
				for(int i1=0;i1<getOpctrl().getTransopsctrl().getChoices().size();i1++) {
					if(getOpctrl().getTransopsctrl().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getTransopsctrl().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getTransopsctrl().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions.add(ch);
					}
				}  
				getOpctrl().setTransopsctrl(new TransactionOptionsControl(pane4));
				for(int i1=0;i1<getOpctrl().getTransopsctrl().getChoices().size();i1++) {
					if(getOpctrl().getTransopsctrl().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getTransopsctrl().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}else if(name=="payment") {
				for(int i1=0;i1<getOpctrl().getPayopsctr().getChoices().size();i1++) {
					if(getOpctrl().getPayopsctr().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getPayopsctr().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getPayopsctr().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions.add(ch);
					}
				}  
				getOpctrl().setPayopsctr(new PaymentOptionsControl(pane4));
				for(int i1=0;i1<getOpctrl().getPayopsctr().getChoices().size();i1++) {
					if(getOpctrl().getPayopsctr().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getPayopsctr().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}else if(name=="manager") {
				for(int i1=0;i1<getOpctrl().getMngropsctrl().getChoices().size();i1++) {
					if(getOpctrl().getMngropsctrl().getChoices().get(i1).getRadio().isSelected()) {
						String type =getOpctrl().getMngropsctrl().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getMngropsctrl().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions.add(ch);
					}
				}  
				getOpctrl().setMngropsctrl(new ManagerOptionsControl(pane4));
				for(int i1=0;i1<getOpctrl().getMngropsctrl().getChoices().size();i1++) {
					if(getOpctrl().getMngropsctrl().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getMngropsctrl().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}else if(name=="loan") {
				for(int i1=0;i1<getOpctrl().getLoanopsctrl().getChoices().size();i1++) {
					if(getOpctrl().getLoanopsctrl().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getLoanopsctrl().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getLoanopsctrl().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions.add(ch);
					}
				}  
				getOpctrl().setLoanopsctrl(new LoanOptionsControl(pane4));
				for(int i1=0;i1<getOpctrl().getLoanopsctrl().getChoices().size();i1++) {
					if(getOpctrl().getLoanopsctrl().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getLoanopsctrl().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}else if(name=="card") {
				for(int i1=0;i1<getOpctrl().getCardopctrl().getChoices().size();i1++) {
					if(getOpctrl().getCardopctrl().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getCardopctrl().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getCardopctrl().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions.add(ch);
					}
				}  
				getOpctrl().setCardopctrl(new CardOptionsControl(pane4));
				for(int i1=0;i1<getOpctrl().getCardopctrl().getChoices().size();i1++) {
					if(getOpctrl().getCardopctrl().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getCardopctrl().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}else if(name=="account") {   
				for(int i1=0;i1<getOpctrl().getAccopctrl().getChoices().size();i1++) {
					if(getOpctrl().getAccopctrl().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getAccopctrl().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getAccopctrl().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions.add(ch);
					}
				}  
				getOpctrl().setAccopctrl(new AccountOptionsControl(pane4));
				for(int i1=0;i1<getOpctrl().getAccopctrl().getChoices().size();i1++) {
					if(getOpctrl().getAccopctrl().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getAccopctrl().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}else if(name=="employee") {
				for(int i1=0;i1<getOpctrl().getEmpopsctr().getChoices().size();i1++) {
					if(getOpctrl().getEmpopsctr().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getEmpopsctr().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getEmpopsctr().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions.add(ch);
					}
				}  
				getOpctrl().setEmpopsctr(new EmployeeOptionsControl(pane4));
				for(int i1=0;i1<getOpctrl().getEmpopsctr().getChoices().size();i1++) {
					if(getOpctrl().getEmpopsctr().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getEmpopsctr().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}else if(name=="customer") {
				for(int i1=0;i1<getOpctrl().getCusopctrl().getChoices().size();i1++) {
					if(getOpctrl().getCusopctrl().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getCusopctrl().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getCusopctrl().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions.add(ch);
					}
				}  
				getOpctrl().setCusopctrl(new CustomerOptionsControl(pane4));
				for(int i1=0;i1<getOpctrl().getCusopctrl().getChoices().size();i1++) {
					if(getOpctrl().getCusopctrl().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getCusopctrl().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}

			oka.setFont(Font.font(14));
			oka.setPrefSize(90, 30);
			GridPane.setHalignment(oka, HPos.RIGHT);
			oka.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
			oka.setTextFill(Color.DARKSLATEBLUE);
			pane4.add(oka, 2, 0);

			//Create Scene
			Scene scene4 = new Scene(pane4);
			stage.setScene(scene4);
			stage.setTitle("The National Bank");
			stage.getIcons().add(new Image("images/TNB.png"));
			stage.show();
		});
	}

	private void handle_oka(Button oka,Stage stage, String name) {
		oka.setOnAction(e->{
			GridPane pane5 = new GridPane();
			pane5.setPadding(new Insets(60, 60, 60, 60));
			pane5.setAlignment(Pos.CENTER);
			pane5.setHgap(10);
			pane5.setVgap(10);
			pane5.setBackground(background);

			Label hello54 = new Label("Values");
			hello54.setFont(Font.font(17));
			hello54.setTextFill(Color.GREY);
			pane5.add(hello54, 0, 0);

			Image img3 = new Image("images/TNB.png");
			ImageView v3 = new ImageView(img3);
			v3.setFitWidth(150);
			v3.setFitHeight(70);

			Button logo5 = new Button();
			GridPane.setHalignment(logo5, HPos.CENTER);
			logo5.setPrefSize(180, 100);
			logo5.setGraphic(v3);
			logo5.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
			pane5.add(logo5, 1, 0);
			
			Label hell3oo= new Label("No conditions on Account");
			hell3oo.setFont(Font.font(17));
			hell3oo.setTextFill(Color.GREY);

			ArrayList<radio> choices = new ArrayList<>() ;
			if (name=="transaction") {
				choices= getOpctrl().getTransopsctrl().getChoices();
			}else if(name=="payment") {
				choices = getOpctrl().getPayopsctr().getChoices();
			}else if(name=="manager") {
				choices = getOpctrl().getMngropsctrl().getChoices();
			}else if(name=="loan") {
				choices = getOpctrl().getLoanopsctrl().getChoices();
			}else if(name=="card") {
				choices = getOpctrl().getCardopctrl().getChoices();
			}else if(name=="account") {   
				choices = getOpctrl().getAccopctrl().getChoices();
			}else if(name=="employee") {
				choices= getOpctrl().getEmpopsctr().getChoices();
			}else if(name=="customer") {
				choices =getOpctrl().getCusopctrl().getChoices();
			}

			int count=0;
			for(int i1=0;i1<choices.size();i1++) {
				if(choices.get(i1).getRadio().isSelected()) {
					pane5.add(choices.get(i1).getName(), 0, i1+2);
					pane5.add(choices.get(i1).getNameT(), 1, i1+2);
					count++;
				}
			}
			if(count==0)
				pane5.add(hell3oo, 1, 1);

			okay.setFont(Font.font(14));
			okay.setPrefSize(90, 30);
			GridPane.setHalignment(okay, HPos.RIGHT);
			okay.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
			okay.setTextFill(Color.DARKSLATEBLUE);
			pane5.add(okay, 2, 0);

			//Create Scene
			Scene scene5 = new Scene(pane5);
			stage.setScene(scene5);
			stage.setTitle("The National Bank");
			stage.getIcons().add(new Image("images/TNB.png"));
			stage.show();	
		});
	}

	private void handle_okay(Button okay,Stage stage, String name) {
		okay.setOnAction(r->{
			GridPane pane6 = new GridPane();
			pane6.setPadding(new Insets(60, 60, 60, 60));
			pane6.setAlignment(Pos.CENTER);
			pane6.setHgap(10);
			pane6.setVgap(10);
			pane6.setBackground(background);

			Label hello6 = new Label();
			hello6.setFont(Font.font(17));
			hello6.setTextFill(Color.GREY);
			pane6.add(hello6, 0, 0);

			Image img4 = new Image("images/TNB.png");
			ImageView v4 = new ImageView(img4);
			v4.setFitWidth(150);
			v4.setFitHeight(70);

			Button logo6 = new Button();
			GridPane.setHalignment(logo6, HPos.CENTER);
			logo6.setPrefSize(180, 100);
			logo6.setGraphic(v4);
			logo6.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");

			pane6.add(logo6, 1, 0);

			ArrayList<choice> conditions1 = new ArrayList<>();

			if (name=="transaction") {
				for(int i1=0;i1<getOpctrl().getTransopsctrl().getChoices().size();i1++) {
					if(getOpctrl().getTransopsctrl().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getTransopsctrl().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getTransopsctrl().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions1.add(ch);
					}
				}  
				
               	answer= transactionQuery.update(conditions, conditions1);

				for(int i1=0;i1<getOpctrl().getTransopsctrl().getChoices().size();i1++) {
					if(getOpctrl().getTransopsctrl().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getTransopsctrl().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}else if(name=="payment") {
				for(int i1=0;i1<getOpctrl().getPayopsctr().getChoices().size();i1++) {
					if(getOpctrl().getPayopsctr().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getPayopsctr().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getPayopsctr().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions1.add(ch);
					}
				}  
				
               	answer= paymentQuery.update(conditions, conditions1);
				
				for(int i1=0;i1<getOpctrl().getPayopsctr().getChoices().size();i1++) {
					if(getOpctrl().getPayopsctr().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getPayopsctr().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}else if(name=="manager") {
				for(int i1=0;i1<getOpctrl().getMngropsctrl().getChoices().size();i1++) {
					if(getOpctrl().getMngropsctrl().getChoices().get(i1).getRadio().isSelected()) {
						String type =getOpctrl().getMngropsctrl().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getMngropsctrl().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions1.add(ch);
					}
				}  
				
               	answer= managerQuery.update(conditions, conditions1);

				for(int i1=0;i1<getOpctrl().getMngropsctrl().getChoices().size();i1++) {
					if(getOpctrl().getMngropsctrl().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getMngropsctrl().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}else if(name=="loan") {
				for(int i1=0;i1<getOpctrl().getLoanopsctrl().getChoices().size();i1++) {
					if(getOpctrl().getLoanopsctrl().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getLoanopsctrl().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getLoanopsctrl().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions1.add(ch);
					}
				}  
				
               	answer= loanQuery.update(conditions, conditions1);

				for(int i1=0;i1<getOpctrl().getLoanopsctrl().getChoices().size();i1++) {
					if(getOpctrl().getLoanopsctrl().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getLoanopsctrl().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}else if(name=="card") {
				for(int i1=0;i1<getOpctrl().getCardopctrl().getChoices().size();i1++) {
					if(getOpctrl().getCardopctrl().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getCardopctrl().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getCardopctrl().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions1.add(ch);
					}
				}  
				
               	answer= cardQuery.update(conditions, conditions1);

				for(int i1=0;i1<getOpctrl().getCardopctrl().getChoices().size();i1++) {
					if(getOpctrl().getCardopctrl().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getCardopctrl().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}else if(name=="account") {   
				for(int i1=0;i1<getOpctrl().getAccopctrl().getChoices().size();i1++) {
					if(getOpctrl().getAccopctrl().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getAccopctrl().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getAccopctrl().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions1.add(ch);
					}
				}  
				
               	answer= accountQuery.update(conditions, conditions1);

				for(int i1=0;i1<getOpctrl().getAccopctrl().getChoices().size();i1++) {
					if(getOpctrl().getAccopctrl().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getAccopctrl().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}else if(name=="employee") {
				for(int i1=0;i1<getOpctrl().getEmpopsctr().getChoices().size();i1++) {
					if(getOpctrl().getEmpopsctr().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getEmpopsctr().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getEmpopsctr().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions1.add(ch);
					}
				}  
				
               	answer= employeeQuery.update(conditions, conditions1);

				for(int i1=0;i1<getOpctrl().getEmpopsctr().getChoices().size();i1++) {
					if(getOpctrl().getEmpopsctr().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getEmpopsctr().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}else if(name=="customer") {
				for(int i1=0;i1<getOpctrl().getCusopctrl().getChoices().size();i1++) {
					if(getOpctrl().getCusopctrl().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getCusopctrl().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getCusopctrl().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions1.add(ch);
					}
				}  
				
               	answer= customerQuery.update(conditions, conditions1);

				for(int i1=0;i1<getOpctrl().getCusopctrl().getChoices().size();i1++) {
					if(getOpctrl().getCusopctrl().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getCusopctrl().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}

			Label ans = new Label(answer);
			ans.setFont(Font.font(17));
			ans.setTextFill(Color.GREY);
			pane6.add(ans, 1, 1);

			Button okay6 = new Button("Okay");
			okay6.setFont(Font.font(14));
			okay6.setPrefSize(90, 30);
			GridPane.setHalignment(okay6, HPos.RIGHT);
			okay6.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
			okay6.setTextFill(Color.DARKSLATEBLUE);
			pane6.add(okay6, 2, 0);

			//Create Scene
			Scene scene6 = new Scene(pane6);
			stage.setScene(scene6);
			stage.setTitle("The National Bank");
			stage.getIcons().add(new Image("images/TNB.png"));
			stage.show();

			okay6.setOnAction(r6->{
				answer="";
				stage.close();
			});
		});	
	}
	public OpControl getOpctrl() {
		return opctrl;
	}

	public void setOpctrl(OpControl opctrl) {
		this.opctrl = opctrl;
	}

	public Button getNext() {
		return next;
	}

	public void setNext(Button next) {
		this.next = next;
	}

	public Button getOk() {
		return ok;
	}

	public void setOk(Button ok) {
		this.ok = ok;
	}

	public Button getOka() {
		return oka;
	}

	public Button getOkay() {
		return okay;
	}

	public void setOkay(Button okay) {
		this.okay = okay;
	}

	public void setOka(Button oka) {
		this.oka = oka;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	public void setCardQuery(CardQuery cardQuery) {
		this.cardQuery = cardQuery;
	}

	public EmployeeQuery getEmployeeQuery() {
		return employeeQuery;
	}

	public void setEmployeeQuery(EmployeeQuery employeeQuery) {
		this.employeeQuery = employeeQuery;
	}

	public CustomerQuery getCustomerQuery() {
		return customerQuery;
	}

	public void setCustomerQuery(CustomerQuery customerQuery) {
		this.customerQuery = customerQuery;
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

	public TransactionQuery getTransactionQuery() {
		return transactionQuery;
	}

	public void setTransactionQuery(TransactionQuery transactionQuery) {
		this.transactionQuery = transactionQuery;
	}
}
