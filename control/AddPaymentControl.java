package control;

import application.Payment;
import dataAccess.LoanQuery;
import dataAccess.PaymentQuery;
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
import presentation.AddPaymentScene;

public class AddPaymentControl {
	private AddPaymentScene addpaymentScene;
    private LoanQuery loanQuery;// = new LoanQuery();
    private PaymentQuery paymentQuery;
    private Button cancel;
    private Button add;
	private TextField amount1;
	private ComboBox<String> loanID;
    
	public AddPaymentControl(Stage stage) {
		initialize(stage);
	}
	private void initialize(Stage stage) {
		setAddpaymentScene(new AddPaymentScene(stage));
		setAdd(addpaymentScene.getAdd());
		setAmount1(addpaymentScene.getAmount1());
		setCancel(addpaymentScene.getCancel());
		setLoanID(addpaymentScene.getLoanID());
		setLoanQuery(new LoanQuery());
		setPaymentQuery(new PaymentQuery());
		
		handle_add(getAdd(), stage);
		handle_cancel(getCancel(), stage);
	}
	
	private void handle_cancel(Button cancel, Stage stage) {
        cancel.setOnAction(i -> stage.close());		
	}
	
	public void handle_add(Button add, Stage stage) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c1);

		loanQuery.comboBox(loanID);
		add.setOnAction(l -> {
            try{
                long millis=System.currentTimeMillis();
                java.sql.Date date=new java.sql.Date(millis);
                Payment payment1 = new Payment(Double.parseDouble(amount1.getText().trim()),
                								date,
                								Integer.parseInt(loanID.getSelectionModel().getSelectedItem().trim()));
                boolean x = loanQuery.update(Integer.parseInt(loanID.getSelectionModel().getSelectedItem()),Double.parseDouble(amount1.getText()));
                if(x== true) {
                    paymentQuery.insertData(payment1);
        	        
                    GridPane pane2 = new GridPane();
        	        pane2.setPadding(new Insets(60, 60, 60, 60));
        	        pane2.setAlignment(Pos.CENTER);
        	        pane2.setHgap(10);
        	        pane2.setVgap(10);
        	        pane2.setBackground(background);
        	        
                    Label hello54 = new Label("inserted successfully");
                    hello54.setFont(Font.font(17));
                    hello54.setTextFill(Color.GREY);
                    pane2.add(hello54, 0, 0);
                    
                    Image img9 = new Image("TNB.png");
        	        ImageView v10 = new ImageView(img9);
        	        v10.setFitWidth(150);
        	        v10.setFitHeight(70);

        	        Button logo2 = new Button();
        	        GridPane.setHalignment(logo2, HPos.CENTER);
        	        logo2.setPrefSize(180, 100);
        	        logo2.setGraphic(v10);
        	        logo2.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
        	        pane2.add(logo2, 1, 0);
                    
                    //Create Scene
                    Scene scene5 = new Scene(pane2);
                    stage.setScene(scene5);
                    stage.setTitle("The National Bank");
                    stage.getIcons().add(new Image("TNB.png"));
                    stage.show();
                }
            }catch (Exception e){
                e.getMessage();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Look, a Warning Dialog");
                alert.setContentText("Please Make sure you are inputting the right input\n"+e.getMessage());
                alert.showAndWait();
            }
        });
	}
	public AddPaymentScene getAddpaymentScene() {
		return addpaymentScene;
	}
	public void setAddpaymentScene(AddPaymentScene addpaymentScene) {
		this.addpaymentScene = addpaymentScene;
	}
	public LoanQuery getLoanQuery() {
		return loanQuery;
	}
	public void setLoanQuery(LoanQuery loanQuery) {
		this.loanQuery = loanQuery;
	}
	public PaymentQuery getPaymentQuery() {
		return paymentQuery;
	}
	public void setPaymentQuery(PaymentQuery paymentQuery) {
		this.paymentQuery = paymentQuery;
	}
	public Button getCancel() {
		return cancel;
	}
	public void setCancel(Button cancel) {
		this.cancel = cancel;
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
	public ComboBox<String> getLoanID() {
		return loanID;
	}
	public void setLoanID(ComboBox<String> loanID) {
		this.loanID = loanID;
	}
}
