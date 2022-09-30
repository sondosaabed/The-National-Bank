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

public class DeleteSceneControl {
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
	private Button ok ;
	private Button oka = new Button("Okay");
	private String answer;
	BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	Background background = new Background(c1);

	public DeleteSceneControl(Stage stage, String name) {
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
		handle_oka(getOka(),stage,name);
	}

	private void handle_ok(Button ok, Stage stage, String name) {
		ok.setOnAction(e->{
			GridPane pane4 = new GridPane();
			pane4.setPadding(new Insets(60, 60, 60, 60));
			pane4.setAlignment(Pos.CENTER);
			pane4.setHgap(10);
			pane4.setVgap(10);
			pane4.setBackground(background);

			Label hello4 = new Label("Answer");
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

			ArrayList<choice> conditions = new ArrayList<>();
     
			if (name=="transaction") {
				for(int i1=0;i1<getOpctrl().getTransopsctrl().getChoices().size();i1++) {
					if(getOpctrl().getTransopsctrl().getChoices().get(i1).getRadio().isSelected()) {
						String type = getOpctrl().getTransopsctrl().getChoices().get(i1).getName().getId();
						String value = getOpctrl().getTransopsctrl().getChoices().get(i1).getNameT().getText();

						choice ch = new choice(type,value);
						conditions.add(ch);
					}
				}  
				
				answer= transactionQuery.delete(conditions);

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
				
				answer= paymentQuery.delete(conditions);
				
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
				
				answer= managerQuery.delete(conditions);

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
				
				answer= loanQuery.delete(conditions);

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
				
				answer= cardQuery.delete(conditions);

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
				
				answer= accountQuery.delete(conditions);

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
				
				answer= employeeQuery.delete(conditions);

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
				
				answer= customerQuery.delete(conditions);

				for(int i1=0;i1<getOpctrl().getCusopctrl().getChoices().size();i1++) {
					if(getOpctrl().getCusopctrl().getChoices().get(i1).getRadio().isSelected()) {
						getOpctrl().getCusopctrl().getChoices().get(i1).getRadio().setSelected(false);
					}
				}
			}

			Label hello5 = new Label(answer);
			hello5.setFont(Font.font(17));
			hello5.setTextFill(Color.GREY);
			pane4.add(hello5, 1, 1);
			
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
			stage.close();
		});
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setOk(Button ok) {
		this.ok = ok;
	}

	public void setOka(Button oka) {
		this.oka = oka;
	}

	private Button getOka() {
		return this.oka;
	}

	private Button getOk() {
		return this.ok;
	}
	
	public OpControl getOpctrl() {
		return opctrl;
	}

	public void setOpctrl(OpControl opctrl) {
		this.opctrl = opctrl;
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
