package presentation;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

public class AddTranScene {
	private ComboBox<String> customerID;
	private ComboBox<String> accountID; 
	private ComboBox<String> empID;
	private Button cancel0;
	private Button add;
	private TextField amount1;
	private ComboBox<String> type; 
	
	public AddTranScene(Stage stage) {
		initialize(stage);
	}
	
	private void initialize(Stage stage) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c1);

		//Creating grid pane
        GridPane pane2 = new GridPane();
        pane2.setPadding(new Insets(60, 60, 60, 60));
        pane2.setAlignment(Pos.CENTER);
        pane2.setHgap(10);
        pane2.setVgap(10);
        pane2.setBackground(background);
        
        //A label to show the number of power sources
        Label hello1 = new Label(("Make Transaction"));
        hello1.setFont(Font.font(17));
        hello1.setTextFill(Color.GREY);
        pane2.add(hello1, 0, 0);

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

        //A label to show the number of power sources
        Label IDC = new Label(("Customer ID: "));
        IDC.setFont(Font.font(16));
        IDC.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(IDC , HPos.CENTER);
        pane2.add(IDC , 0, 1);

        customerID = new ComboBox<String>();
        customerID.setBackground(background);
        customerID.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
        customerID.setPrefSize(200, 30);
        pane2.add(customerID, 1, 1);
        
        //A label to show the number of power sources
        Label IDC2 = new Label(("Account ID: "));
        IDC2.setFont(Font.font(16));
        IDC2.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(IDC2 , HPos.CENTER);
        pane2.add(IDC2 , 0, 2);

        accountID = new ComboBox<String>();
        accountID.setBackground(background);
        accountID.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
        accountID.setPrefSize(200, 30);
        pane2.add(accountID, 1, 2);

        //A label to show the number of power sources
        Label IDE = new Label(("Employee ID: "));
        IDE.setFont(Font.font(16));
        IDE.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(IDE , HPos.CENTER);
        pane2.add(IDE , 0, 3);

        empID = new ComboBox<String>();
        empID.setBackground(background);
        empID.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
        empID.setPrefSize(200, 30);
        pane2.add(empID, 1, 3);

        //A label to show the number of power sources
        Label typel = new Label(("Transaction Type: "));
        typel.setFont(Font.font(16));
        typel.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(typel , HPos.CENTER);
        pane2.add(typel , 0, 4);

        type = new ComboBox<String>();
        type.getItems().add("Withdraw");
        type.getItems().add("Deposit");
        type.setBackground(background);
        type.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
        type.setPrefSize(200, 30);
        type.setValue("Withdraw");
        pane2.add(type, 1, 4);

        Label amount = new Label(("Transaction amount: "));
        amount.setFont(Font.font(16));
        amount.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(amount , HPos.CENTER);
        pane2.add(amount , 0, 5);

        amount1 = new TextField();
        GridPane.setHalignment(amount1, HPos.CENTER);
        amount1.setPrefSize(200, 30);
        amount1.setPromptText("1000");
        pane2.add(amount1, 1, 5);

        add = new Button("Add Transaction");
        add.setFont(Font.font(14));
        add.setPrefSize(90, 30);
        add.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
        add.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(add, HPos.CENTER);
        pane2.add(add, 0, 6);

        cancel0 = new Button("cancel");
        cancel0.setFont(Font.font(14));
        cancel0.setPrefSize(90, 30);
        cancel0.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
        cancel0.setTextFill(Color.DARKSLATEBLUE);
        pane2.add(cancel0, 1, 6);
        GridPane.setHalignment(cancel0, HPos.RIGHT);
        cancel0.setOnAction(i -> stage.close());

        //Create Scene
        Scene scene2 = new Scene(pane2);
        stage.setScene(scene2);
        stage.setTitle("The National Bank");
        stage.getIcons().add(new Image("images/TNB.png"));
        stage.show();		
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
}
