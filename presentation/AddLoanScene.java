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

public class AddLoanScene {
	private TextField amount;
	private ComboBox<String> type;
	private ComboBox<String> branchID;
	private ComboBox<String> customerID;
	private Button add;
	private Button cancel0;

	public AddLoanScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
	    
        GridPane pane2 = new GridPane();
        pane2.setPadding(new Insets(60, 60, 60, 60));
        pane2.setAlignment(Pos.CENTER);
        pane2.setHgap(10);
        pane2.setVgap(10);
        pane2.setBackground(background);
        
        Label hello1 = new Label(("Add a new Loan"));
        hello1.setFont(Font.font(17));
        hello1.setTextFill(Color.GREY);
        pane2.add(hello1, 0, 0);

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

        Label amountl = new Label(("Loan amount: "));
        amountl.setFont(Font.font(16));
        amountl.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(amountl , HPos.CENTER);
        pane2.add(amountl , 0, 1);

        amount = new TextField();
        GridPane.setHalignment(amount, HPos.CENTER);
        amount.setPrefSize(200, 30);
        amount.setPromptText("26000");
        pane2.add(amount, 1, 1);

        Label typel = new Label(("Loan type: "));
        typel.setFont(Font.font(16));
        typel.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(typel , HPos.CENTER);
        pane2.add(typel , 0, 2);

        type = new ComboBox<String>();
        type.getItems().add("Student loan");
        type.getItems().add("Project loan");
        type.getItems().add("House loan");
        type.getItems().add("Car loan");
        type.setBackground(background);
        type.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
        type.setPrefSize(200, 30);
        type.setValue("Student loan");
        pane2.add(type, 1, 2);

        Label BIL = new Label(("Branch ID: "));
        BIL.setFont(Font.font(16));
        BIL.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(BIL , HPos.CENTER);
        pane2.add(BIL, 0, 3);

        branchID = new ComboBox<String>();
        branchID.setBackground(background);
        branchID.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
        branchID.setPrefSize(200, 30);
        pane2.add(branchID , 1, 3);

        Label IDC = new Label(("Customer ID: "));
        IDC.setFont(Font.font(16));
        IDC.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(IDC , HPos.CENTER);
        pane2.add(IDC , 0, 4);

        customerID = new ComboBox<String>();
        customerID.setBackground(background);
        customerID.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
        customerID.setPrefSize(200, 30);
        pane2.add(customerID, 1, 4);

        add = new Button("Give Loan");
        add.setFont(Font.font(14));
        add.setPrefSize(90, 30);
        add.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
        add.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(add, HPos.CENTER);
        pane2.add(add, 0, 5);

        //User button to exit
        cancel0 = new Button("Cancel");
        cancel0.setFont(Font.font(14));
        cancel0.setPrefSize(90, 30);
        cancel0.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
        cancel0.setTextFill(Color.DARKSLATEBLUE);
        pane2.add(cancel0, 1, 5);
        GridPane.setHalignment(cancel0, HPos.RIGHT);

        //Create Scene
        Scene scene2 = new Scene(pane2);
        stage.setScene(scene2);
        stage.setTitle("The National Bank");
        stage.getIcons().add(new Image("images/TNB.png"));
        stage.show();		
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

	public Button getCancel0() {
		return cancel0;
	}

	public void setCancel0(Button cancel0) {
		this.cancel0 = cancel0;
	}
}
