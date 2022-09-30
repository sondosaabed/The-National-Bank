package control;

import java.util.ArrayList;

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
import presentation.OpScene;
import presentation.radio;

public class OpControl {
	//feilds
	private OpScene opscene;
	private Button next;
	private AccountOptionsControl accopctrl;
	private CardOptionsControl cardopctrl;
	private CustomerOptionsControl cusopctrl;
	private EmployeeOptionsControl empopsctr;
	private LoanOptionsControl loanopsctrl;
	private ManagerOptionsControl mngropsctrl;
	private PaymentOptionsControl payopsctr;
	private TransactionOptionsControl transopsctrl;
	BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	Background background = new Background(c1);
	private Button ok= new Button("Okay");
	
	public OpControl(Stage stage, String name) {
		initialize(stage,name);
	}

	private void initialize(Stage stage, String name) {
		setOpScene(new OpScene(stage,name));
		setNext(getOpScene().getNext());
		
		if (name=="transaction") {
			setTransopsctrl(new TransactionOptionsControl(getOpScene().getPane2()));
		}else if(name=="payment") {
			setPayopsctr(new PaymentOptionsControl(getOpScene().getPane2()));
		}else if(name=="manager") {
			setMngropsctrl(new ManagerOptionsControl(getOpScene().getPane2()));
		}else if(name=="loan") {
			setLoanopsctrl(new LoanOptionsControl(getOpScene().getPane2()));
		}else if(name=="card") {
			setCardopctrl(new CardOptionsControl(getOpScene().getPane2()));
		}else if(name=="account") {
			setAccopctrl(new AccountOptionsControl(getOpScene().getPane2()));
		}else if(name=="employee") {
			setEmpopsctr(new EmployeeOptionsControl(getOpScene().getPane2()));
		}else if(name=="customer") {
			setCusopctrl(new CustomerOptionsControl(getOpScene().getPane2()));
		}
		handle_next(next, stage, name);
	}
	
	private void handle_next(Button next, Stage stage, String name) {
		next.setOnAction(e->{
			GridPane pane3 = new GridPane();
			pane3.setPadding(new Insets(60, 60, 60, 60));
			pane3.setAlignment(Pos.CENTER);
			pane3.setHgap(10);
			pane3.setVgap(10);
			pane3.setBackground(background);

			Label helloo= new Label("Which "+name);
			helloo.setFont(Font.font(17));
			helloo.setTextFill(Color.GREY);
			pane3.add(helloo, 0, 0);

			Label hell3oo= new Label("No conditions on Account");
			hell3oo.setFont(Font.font(17));
			hell3oo.setTextFill(Color.GREY);

			ArrayList<radio> choices = new ArrayList<>() ;
			if (name=="transaction") {
				choices= getTransopsctrl().getChoices();
			}else if(name=="payment") {
				choices = getPayopsctr().getChoices();
			}else if(name=="manager") {
				choices = getMngropsctrl().getChoices();
			}else if(name=="loan") {
				choices = getLoanopsctrl().getChoices();
			}else if(name=="card") {
				choices = getCardopctrl().getChoices();
			}else if(name=="account") {   
				choices = getAccopctrl().getChoices();
			}else if(name=="employee") {
				choices= getEmpopsctr().getChoices();
			}else if(name=="customer") {
				choices =getCusopctrl().getChoices();
			}

			int count=0;
			for(int i1=0;i1<choices.size();i1++) {
				if(choices.get(i1).getRadio().isSelected()) {
					pane3.add(choices.get(i1).getName(), 0, i1+2);
					pane3.add(choices.get(i1).getNameT(), 1, i1+2);
					count++;
				}
			}
			if(count==0)
				pane3.add(hell3oo, 1, 1);
			
			Image img = new Image("images/TNB.png");
			ImageView v0 = new ImageView(img);
			v0.setFitWidth(150);
			v0.setFitHeight(70);

			Button logo = new Button();
			GridPane.setHalignment(logo, HPos.CENTER);
			logo.setPrefSize(180, 100);
			logo.setGraphic(v0);
			logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
			pane3.add(logo, 1, 0);

			ok.setFont(Font.font(14));
			ok.setPrefSize(90, 30);
			GridPane.setHalignment(ok, HPos.RIGHT);
			ok.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
			ok.setTextFill(Color.DARKSLATEBLUE);
			pane3.add(ok, 2, 0);

			//Create Scene
			Scene scene3 = new Scene(pane3);
			stage.setScene(scene3);
			stage.setTitle("The National Bank");
			stage.getIcons().add(new Image("images/TNB.png"));
			stage.show();
		});
	}
	
	public OpScene getOpScene() {
		return opscene;
	}

	public void setOpScene(OpScene adelaccountScene) {
		this.opscene = adelaccountScene;
	}

	public AccountOptionsControl getAccopctrl() {
		return accopctrl;
	}

	public void setAccopctrl(AccountOptionsControl accopctrl) {
		this.accopctrl = accopctrl;
	}

	public CardOptionsControl getCardopctrl() {
		return cardopctrl;
	}

	public void setCardopctrl(CardOptionsControl cardopctrl) {
		this.cardopctrl = cardopctrl;
	}

	public CustomerOptionsControl getCusopctrl() {
		return cusopctrl;
	}

	public void setCusopctrl(CustomerOptionsControl cusopctrl) {
		this.cusopctrl = cusopctrl;
	}

	public EmployeeOptionsControl getEmpopsctr() {
		return empopsctr;
	}

	public void setEmpopsctr(EmployeeOptionsControl empopsctr) {
		this.empopsctr = empopsctr;
	}

	public LoanOptionsControl getLoanopsctrl() {
		return loanopsctrl;
	}

	public void setLoanopsctrl(LoanOptionsControl loanopsctrl) {
		this.loanopsctrl = loanopsctrl;
	}

	public ManagerOptionsControl getMngropsctrl() {
		return mngropsctrl;
	}

	public void setMngropsctrl(ManagerOptionsControl mngropsctrl) {
		this.mngropsctrl = mngropsctrl;
	}

	public PaymentOptionsControl getPayopsctr() {
		return payopsctr;
	}

	public void setPayopsctr(PaymentOptionsControl payopsctr) {
		this.payopsctr = payopsctr;
	}

	public TransactionOptionsControl getTransopsctrl() {
		return transopsctrl;
	}

	public void setTransopsctrl(TransactionOptionsControl transopsctrl) {
		this.transopsctrl = transopsctrl;
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
}
