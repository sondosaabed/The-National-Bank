package presentation;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

public class AddAccountScene {
	//feilds
	private ComboBox<String> branchID;
	private ComboBox<String> type;
	private ComboBox<String> IDC;
	private Button add;
	private Button cancel0;
	
	public AddAccountScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c1);
	    
        GridPane pane= new GridPane();
        pane.setPadding(new Insets(60, 60, 60, 60));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setBackground(background);

        Label hello1 = new Label(("Add a new Account"));
        hello1.setFont(Font.font(17));
        hello1.setTextFill(Color.GREY);
        pane.add(hello1, 0, 0);

        Image img9 = new Image("images/TNB.png");
        ImageView v10 = new ImageView(img9);
        v10.setFitWidth(150);
        v10.setFitHeight(70);

        Button logo01 = new Button();
        GridPane.setHalignment(logo01, HPos.CENTER);
        logo01.setPrefSize(180, 100);
        logo01.setGraphic(v10);
        logo01.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
        pane.add(logo01, 1, 0);

        Label cid = new Label(("Customer ID: "));
        cid.setFont(Font.font(16));
        cid.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(cid , HPos.CENTER);
        pane.add(cid , 0, 1);

        IDC = new ComboBox<String>();
        IDC.setBackground(background);
        IDC.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
        IDC.setPrefSize(200, 30);
        pane.add(IDC, 1, 1);
 
        Label typea = new Label(("Account type: "));
        typea.setFont(Font.font(16));
        typea.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(typea , HPos.CENTER);
        pane.add(typea , 0, 2);

        type = new ComboBox<String>();
        type.getItems().add("Deposit");
        type.getItems().add("Savings");
        type.getItems().add("Current");
        type.setBackground(background);
        type.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
        type.setPrefSize(200, 30);
        type.setValue("Savings");
        pane.add(type, 1, 2);

        Label branch = new Label(("Branch ID: "));
        branch.setFont(Font.font(16));
        branch.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(branch , HPos.CENTER);
        pane.add(branch , 0, 3);

        branchID = new ComboBox<String>();
        branchID.setBackground(background);
        branchID.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
        branchID.setPrefSize(200, 30);
        pane.add(branchID, 1, 3);

        //User button to create account
        add = new Button("Create Account");
        add.setFont(Font.font(14));
        add.setPrefSize(90, 30);
        add.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
        add.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(add, HPos.CENTER);
        pane.add(add, 0, 4);

        //User button to exit
        cancel0 = new Button("Cancel");
        cancel0.setFont(Font.font(14));
        cancel0.setPrefSize(90, 30);
        cancel0.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
        cancel0.setTextFill(Color.DARKSLATEBLUE);
        pane.add(cancel0, 1, 4);
        GridPane.setHalignment(cancel0, HPos.RIGHT);

        //Create Scene
        Scene scene2 = new Scene(pane);
        stage.setScene(scene2);
        stage.setTitle("The National Bank");
        stage.getIcons().add(new Image("images/TNB.png"));
        stage.show();		
	}

	public ComboBox<String> getBranchID() {
		return branchID;
	}

	public void setBranchID(ComboBox<String> branchID) {
		this.branchID = branchID;
	}

	public ComboBox<String> getType() {
		return type;
	}

	public void setType(ComboBox<String> type) {
		this.type = type;
	}

	public ComboBox<String> getIDC() {
		return IDC;
	}

	public void setIDC(ComboBox<String> iDC) {
		IDC = iDC;
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
