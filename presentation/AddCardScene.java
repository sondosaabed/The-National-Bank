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

public class AddCardScene {
	private Button add;
	private Button cancel;
	private ComboBox<String> IDC;

	public AddCardScene(Stage stage) {
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
        
        Label hello1 = new Label(("Add a new card"));
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

        Label cID = new Label(("Customer ID: "));
        cID.setFont(Font.font(16));
        cID.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(cID , HPos.CENTER);
        pane2.add(cID , 0, 1);

        IDC = new ComboBox<String>();
        IDC.setBackground(background);
        IDC.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
        IDC.setPrefSize(200, 30);
        pane2.add(IDC, 1, 1);

        add = new Button("Add card");
        add.setFont(Font.font(14));
        add.setPrefSize(90, 30);
        add.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
        add.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(add, HPos.CENTER);
        pane2.add(add, 0, 2);

        cancel = new Button("Cancel");
        cancel.setFont(Font.font(14));
        cancel.setPrefSize(90, 30);
        cancel.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
        cancel.setTextFill(Color.DARKSLATEBLUE);
        pane2.add(cancel, 1, 2);
        GridPane.setHalignment(cancel, HPos.RIGHT);

        Scene scene2 = new Scene(pane2);
        stage.setScene(scene2);
        stage.setTitle("The National Bank");
        stage.getIcons().add(new Image("images/TNB.png"));
        stage.show();		
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

	public ComboBox<String> getIDC() {
		return IDC;
	}

	public void setIDC(ComboBox<String> iDC) {
		IDC = iDC;
	}
}
