package control;

import java.sql.Date;

import application.Account;
import dataAccess.AccountQuery;
import dataAccess.BranchQuery;
import dataAccess.CustomerQuery;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import presentation.AddAccountScene;

public class AddAccountControl {
	//feilds
	private AccountQuery accountQuery; 
	private CustomerQuery customerQuery; 
	private AddAccountScene addaccountScene;
	public BranchQuery branchQuery; 
	private ComboBox<String> branchID;
	private ComboBox<String> type;
	private ComboBox<String> IDC;
	private Button add;
	private Button cancel0;

	public AddAccountControl(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		setAddaccountScene(new AddAccountScene(stage));
		setAccountQuery(new AccountQuery());
		setCustomerQuery(new CustomerQuery());
		setBranchQuery(new BranchQuery());
		setAdd(addaccountScene.getAdd());
		setCancel0(addaccountScene.getCancel0());
		setBranchID(addaccountScene.getBranchID());
		setIDC(addaccountScene.getIDC());
		setType(addaccountScene.getType());

		handle_add(add,stage);
	}

	@SuppressWarnings("deprecation")
	public void handle_add(Button add, Stage stage) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		customerQuery.comboBox(IDC);
		branchQuery.comboBox(branchID);
		cancel0.setOnAction(i -> stage.close());

		add.setOnAction(l -> {
			try {
				long millis = System.currentTimeMillis();
				Date date = new Date(millis);
				Date logicalDate = new Date(millis);
				logicalDate.setDate(logicalDate.getDay() + 23);
				Account account1 = new Account(Integer.parseInt(IDC.getSelectionModel().getSelectedItem().trim()),
						type.getSelectionModel().getSelectedItem().trim(),
						date, 
						logicalDate, 
						Integer.parseInt(branchID.getSelectionModel().getSelectedItem().trim()), 0, 0);
				accountQuery.insertData(account1);

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
			}catch (Exception e){
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Look, a Warning Dialog");
				alert.setContentText("Please Make sure you are inputting the right input\n"+e.getMessage());
				alert.showAndWait();
			}
		});	
	}
	public AddAccountScene getAddaccountScene() {
		return addaccountScene;
	}

	public void setAddaccountScene(AddAccountScene addaccountScene) {
		this.addaccountScene = addaccountScene;
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

	public AccountQuery getAccountQuery() {
		return accountQuery;
	}

	public void setAccountQuery(AccountQuery accountQuery) {
		this.accountQuery = accountQuery;
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
}
