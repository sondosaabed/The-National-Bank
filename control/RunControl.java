package control;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import presentation.RunScene;

public class RunControl {
	private RunScene runScene;
	private ChoicesControl choiceControl;
	private Button exit;
	private Button delete;
	private Button search;
	private Button update;
	private Button view;
	private Button add;
	
	public RunControl(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		setRunScene(new RunScene(stage));
		
		setAdd(runScene.getAdd());
		setDel(runScene.getDel());
		setExit(runScene.getExit());
		setSearch(runScene.getSearch());
		setUpdate(runScene.getUpdate());
		setView(runScene.getView());
		
		handle_ext(exit);
		handle_add(add,stage);
		handle_del(delete,stage);
		handle_search(search,stage);
		handle_update(update,stage);
		handle_view(view,stage);
	}

	private void handle_ext(Button exit2) {
		exit2.setOnAction(e->{
			Platform.exit();		
		});
	}
	
	private void handle_add(Button add, Stage stage) {
		add.setOnAction(e->{
			setChoiceControl(new ChoicesControl(stage));
			getChoiceControl().handleChoiceSceneForAdd(stage);
		});
	}
	
	private void handle_del(Button del, Stage stage) {
		del.setOnAction(e->{
			setChoiceControl(new ChoicesControl(stage));
			getChoiceControl().handleChoiceSceneForDelete(stage);
		});
	}
	
	private void handle_view(Button view2, Stage stage) {
		view2.setOnAction(e->{
			setChoiceControl(new ChoicesControl(stage));
			getChoiceControl().handleChoiceSceneForView(stage);
		});		
	}

	private void handle_update(Button update2, Stage stage) {
		update2.setOnAction(e->{
			setChoiceControl(new ChoicesControl(stage));
			getChoiceControl().handleChoiceSceneForUpdate(stage);
		});		
	}

	private void handle_search(Button search2, Stage stage) {
		search2.setOnAction(e->{
			setChoiceControl(new ChoicesControl(stage));
			getChoiceControl().handleChoiceSceneForSearch(stage);
		});		
	}
	
	public RunScene getRunScene() {
		return runScene;
	}

	public void setRunScene(RunScene runScene) {
		this.runScene = runScene;
	}
	
	public ChoicesControl getChoiceControl() {
		return choiceControl;
	}

	public void setChoiceControl(ChoicesControl choiceScene) {
		this.choiceControl = choiceScene;
	}

	public Button getExit() {
		return exit;
	}

	public void setExit(Button exit) {
		this.exit = exit;
	}

	public Button getDel() {
		return delete;
	}

	public void setDel(Button del) {
		this.delete = del;
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
}
