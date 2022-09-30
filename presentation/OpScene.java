package presentation;

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

public class OpScene {

	private Button next;
	private GridPane pane2;

	public OpScene(Stage stage, String name) {
		initialize(stage, name);
	}

	private void initialize(Stage stage, String name) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		
        pane2 = new GridPane();
        pane2.setPadding(new Insets(60, 60, 60, 60));
        pane2.setAlignment(Pos.CENTER);
        pane2.setHgap(10);
        pane2.setVgap(10);
        pane2.setBackground(background);
                
        Label hello = new Label("Conditions for "+ name);
        hello.setFont(Font.font(17));
        hello.setTextFill(Color.GREY);
        pane2.add(hello, 0, 0);
        
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
        
		next = new Button("Next");
        next.setFont(Font.font(14));
        next.setPrefSize(90, 30);
        GridPane.setHalignment(next, HPos.RIGHT);
        next.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
        next.setTextFill(Color.DARKSLATEBLUE);
        pane2.add(next, 2, 0);
        
        //Create Scene
        Scene scene2 = new Scene(pane2);
        stage.setScene(scene2);
        stage.setTitle("The National Bank");
        stage.getIcons().add(new Image("images/TNB.png"));
        stage.show();
	}

	public Button getNext() {
		return next;
	}

	public void setNext(Button next) {
		this.next = next;
	}

	public GridPane getPane2() {
		return pane2;
	}

	public void setPane2(GridPane pane2) {
		this.pane2 = pane2;
	}

}
