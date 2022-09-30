package control;

import java.io.IOException;

import dataAccess.LoginQuery;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.LoginScene;

public class LoginControl {
	private LoginScene loginScene;
	private RunControl runControl;
	private TextField name;
	private PasswordField pass;
	private Button run;
	private Button cancel;

	public LoginControl(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		setLoginScene(new LoginScene(stage));
		setName(loginScene.getName());
		setPass(loginScene.getPass());
		setRun(loginScene.getRun());
        setCancel(loginScene.getCancel());

        handle_cancel(cancel);
        handle_run(run, stage);
	}

	public void handle_cancel(Button cancel) {
        cancel.setOnAction(e -> Platform.exit());
	}
	
	public void handle_run(Button run, Stage stage) {
		run.setOnAction(e->{
	        LoginQuery login = new LoginQuery();
	        try {
				if(login.login(getName().getText().trim(),getPass().getText().trim()) == true) {
					showRunScene(stage);
				}else {
					getName().clear();
					getPass().clear();
					getName().setPromptText("Enter the correct Name");
					getPass().setPromptText("Enter the correct password");
	            }
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}
	
	public void showRunScene(Stage stage) {
		setRunControl(new RunControl(stage));
	}
	
	public RunControl getRunControl() {
		return runControl;
	}

	public void setRunControl(RunControl runControl) {
		this.runControl = runControl;
	}
	
	public Button getRun() {
		return run;
	}

	public void setRun(Button run) {
		this.run = run;
	}

	public PasswordField getPass() {
		return pass;
	}

	public void setPass(PasswordField pass) {
		this.pass = pass;
	}

	public TextField getName() {
		return name;
	}

	public void setName(TextField name) {
		this.name = name;
	}
	
	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public LoginScene getLoginScene() {
		return loginScene;
	}

	public void setLoginScene(LoginScene loginScene) {
		this.loginScene = loginScene;
	}
}
