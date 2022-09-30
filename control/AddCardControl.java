package control;

import application.Card;
import dataAccess.CardQuery;
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
import presentation.AddCardScene;

public class AddCardControl {
	//feilds
	private AddCardScene addcardScene;
    private CustomerQuery customerQuery;
    private CardQuery cardQuery;
	private ComboBox<String> IDC;
	private Button cancel;
	private Button add;
	
	public AddCardControl(Stage stage) {
		initialize(stage);
	}
	private void initialize(Stage stage) {
		setAddcardScene(new AddCardScene(stage));
		setAdd(addcardScene.getAdd());
		setCancel(addcardScene.getCancel());
		setCustomerQuery(new CustomerQuery());
		setCardQuery( new CardQuery());
		
		handle_cancel(cancel,stage);
		handle_add(add,stage);
	}
	
	private void handle_cancel(Button cancel, Stage stage) {
		  cancel.setOnAction(i -> stage.close());
	}
	private void handle_add(Button add, Stage stage) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c1);
	    
		customerQuery.comboBox(IDC); 
		add.setOnAction(l -> {
		      try {
		          long millis=System.currentTimeMillis();
		          java.sql.Date date=new java.sql.Date(millis);
		          Card card1 = new Card(4000,
		          					date,
		          					Integer.parseInt(IDC.getSelectionModel().getSelectedItem().trim()));
		          cardQuery.insertData(card1);
		          
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
	public AddCardScene getAddcardScene() {
		return addcardScene;
	}
	public void setAddcardScene(AddCardScene addcardScene) {
		this.addcardScene = addcardScene;
	}
	public CustomerQuery getCustomerQuery() {
		return customerQuery;
	}
	public void setCustomerQuery(CustomerQuery customerQuery) {
		this.customerQuery = customerQuery;
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
	public CardQuery getCardQuery() {
		return cardQuery;
	}
	public void setCardQuery(CardQuery cardQuery) {
		this.cardQuery = cardQuery;
	}
	public ComboBox<String> getIDC() {
		return IDC;
	}
	public void setIDC(ComboBox<String> iDC) {
		IDC = iDC;
	}
}
