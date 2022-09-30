package control;

import application.Loan;
import dataAccess.BranchQuery;
import dataAccess.CustomerQuery;
import dataAccess.LoanQuery;
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
import presentation.AddLoanScene;

public class AddLoanControl {
	//feilds
	private AddLoanScene addloanscene;
    private CustomerQuery customerQuery;
    private BranchQuery branchQuery;
    private LoanQuery loanQuery;
	private TextField amount;
	private ComboBox<String> type;
	private ComboBox<String> branchID;
	private ComboBox<String> customerID;
	private Button add;
	private Button cancel;
	
	public AddLoanControl(Stage stage){
		initialize(stage);
	}

	private void initialize(Stage stage) {
		setAddloanscene(new AddLoanScene(stage));
		setBranchQuery(new BranchQuery());
		setCustomerQuery(new CustomerQuery());
		setLoanQuery(new LoanQuery());
		
		setAmount(getAddloanscene().getAmount());
		setType(getAddloanscene().getType());
		setBranchID(getAddloanscene().getBranchID());
		setCustomerID(getAddloanscene().getCustomerID());
		setAdd(getAddloanscene().getAdd());
		setCancel(getAddloanscene().getCancel0());
		
		handle_add(add,stage);
		handle_cancel(cancel,stage);
	}

	private void handle_add(Button add2, Stage stage) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c1);
	    
	    getBranchQuery().comboBox(branchID);
	    getCustomerQuery().comboBox(customerID);
	    
	    getAdd().setOnAction(l -> {
	        try{
	            long millis=System.currentTimeMillis();
	            java.sql.Date date=new java.sql.Date(millis);
	            Loan loan1 = new Loan(Double.parseDouble(getAmount().getText().trim()),
	            										getType().getSelectionModel().getSelectedItem().trim(),
	            										Integer.parseInt(getBranchID().getSelectionModel().getSelectedItem().trim()),
	            										Integer.parseInt(getCustomerID().getSelectionModel().getSelectedItem().trim()),
	            										date);
	            getLoanQuery().insertData(loan1);
	            Stage stage5 = new Stage();
	            
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
	            
		        Image img9 = new Image("images/TNB.png");
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
	            stage5.setScene(scene5);
	            stage5.setTitle("The National Bank");
	            stage5.getIcons().add(new Image("images/TNB.png"));
	            stage5.show();
	        }catch (Exception e){
	            Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("Warning Dialog");
	            alert.setHeaderText("Look, a Warning Dialog");
	            alert.setContentText("Please Make sure you are inputting the right input\n"+e.getMessage());
	            alert.showAndWait();
	        }
	    });		
	}

	private void handle_cancel(Button cancel2, Stage stage) {
	    cancel.setOnAction(i -> stage.close());		
	}

	public AddLoanScene getAddloanscene() {
		return addloanscene;
	}

	public void setAddloanscene(AddLoanScene addloanscene) {
		this.addloanscene = addloanscene;
	}

	public CustomerQuery getCustomerQuery() {
		return customerQuery;
	}

	public void setCustomerQuery(CustomerQuery customerQuery) {
		this.customerQuery = customerQuery;
	}

	public BranchQuery getBranchQuery() {
		return branchQuery;
	}

	public void setBranchQuery(BranchQuery branchQuery) {
		this.branchQuery = branchQuery;
	}

	public LoanQuery getLoanQuery() {
		return loanQuery;
	}

	public void setLoanQuery(LoanQuery loanQuery) {
		this.loanQuery = loanQuery;
	}

	public TextField getAmount() {
		return amount;
	}

	public void setAmount(TextField amount) {
		this.amount = amount;
	}

	public ComboBox<String> getType() {
		return type;
	}

	public void setType(ComboBox<String> type) {
		this.type = type;
	}

	public ComboBox<String> getBranchID() {
		return branchID;
	}

	public void setBranchID(ComboBox<String> branchID) {
		this.branchID = branchID;
	}

	public ComboBox<String> getCustomerID() {
		return customerID;
	}

	public void setCustomerID(ComboBox<String> customerID) {
		this.customerID = customerID;
	}

	public Button getAdd() {
		return add;
	}

	public void setAdd(Button add) {
		this.add = add;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
}
