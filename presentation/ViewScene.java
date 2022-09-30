package presentation;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ViewScene {
	private GridPane pane2;

	public ViewScene(Stage stage, String name) {
		initialize(stage, name);
	}

	private void initialize(Stage stage, String name) {
	    BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c1);
	            
         pane2 = new GridPane();
        pane2.setBackground(background);
        pane2.setPadding(new Insets(60, 60, 60, 60));
        pane2.setAlignment(Pos.CENTER);
        pane2.setHgap(10);
        pane2.setVgap(10);
        
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

        stage.setTitle("View table of "+ name);
        stage.getIcons().add(new Image("images/TNB.png"));
        stage.show();
	}

	public GridPane getPane2() {
		return pane2;
	}

	public void setPane2(GridPane pane2) {
		this.pane2 = pane2;
	}
}
