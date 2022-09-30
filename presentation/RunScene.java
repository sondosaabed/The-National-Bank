package presentation;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RunScene {
	private Button exit;
	private Button del;
	private Button search;
	private Button update;
	private Button view;
	private Button add;
	private GridPane pane;

	public RunScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	    Background background = new Background(c1);
	    
        pane = new GridPane();
        pane.setPadding(new Insets(60, 60, 60, 60));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setBackground(background);

        Image img0 = new Image("images/TNB.png");
        ImageView v0 = new ImageView(img0);
        v0.setFitWidth(190);
        v0.setFitHeight(100);

        Button logo0 = new Button();
        GridPane.setHalignment(logo0, HPos.CENTER);
        logo0.setPrefSize(180, 100);
        logo0.setGraphic(v0);
        logo0.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
        pane.add(logo0, 1, 0);

        add = bigButton("images/add.png");
        pane.add(add, 0, 1);

        del = bigButton("images/delete.png");
        pane.add(del, 1, 1);

        search = bigButton("images/search.png");
        pane.add(search, 2, 1);

        update = bigButton("images/update.png");
        pane.add(update, 0, 2);

        view = bigButton("images/view.png");
        pane.add(view, 1, 2);

        exit = bigButton("images/exit.png");
        pane.add(exit, 2, 2);

        Scene scene1 = new Scene(pane);
        stage.setScene(scene1);
        stage.setTitle("The National Bank");
        stage.getIcons().add(new Image("images/TNB.png"));
        stage.show();
	}
	
	public Button bigButton(String url) {
        Image img = new Image(url);
        ImageView v5 = new ImageView(img);
        v5.setFitWidth(190);
        v5.setFitHeight(190);

        Button view = new Button();
        view.setTextFill(Color.BROWN);
        view.setPrefSize(200, 200);
        view.setGraphic(v5);
        view.setStyle("-fx-background-radius: 7;-fx-background-color:lightblue;");
        return view;
	 }

	public Button getExit() {
		return exit;
	}

	public void setExit(Button exit) {
		this.exit = exit;
	}

	public Button getDel() {
		return del;
	}

	public void setDel(Button del) {
		this.del = del;
	}

	public Button getSearch() {
		return search;
	}

	public void setSearch(Button search) {
		this.search = search;
	}

	public Button getUpdate() {
		return update;
	}

	public void setUpdate(Button update) {
		this.update = update;
	}

	public Button getView() {
		return view;
	}

	public void setView(Button view) {
		this.view = view;
	}

	public Button getAdd() {
		return add;
	}

	public void setAdd(Button add) {
		this.add = add;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}
}
