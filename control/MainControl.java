package control;

import javafx.stage.Stage;

public class MainControl {
	//to clear choices same session
	private Stage stage;
	private LoginControl loginControl;
	private AddAccountControl addaccControl;
	
	public MainControl(Stage stage) {
		this.stage= stage;
	}
	
	public void showLoginScene() {
		setLoginControl(new LoginControl(stage));
	}

	public LoginControl getLoginControl() {
		return loginControl;
	}

	public void setLoginControl(LoginControl loginControl) {
		this.loginControl = loginControl;
	}

	public AddAccountControl getAddaccControl() {
		return addaccControl;
	}

	public void setAddaccControl(AddAccountControl addaccControl) {
		this.addaccControl = addaccControl;
	}
}
