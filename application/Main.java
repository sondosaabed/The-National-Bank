package application;
import control.MainControl;
import javafx.application.Application;
import javafx.stage.Stage;

/* 
    This class is main driver for the program
*/

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    	MainControl mainControl = new MainControl(stage);
    	mainControl.showLoginScene();
    }
}