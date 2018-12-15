package application;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

public class ActivityItemController implements Initializable {

	public ActivityItemController() {

	}

	private HashMap<String, Object> objParams;
	@FXML
	Label lblTitle;
	@FXML
	Label lblStatus;
	@FXML
	ProgressBar pgbProgress;
	@FXML AnchorPane pnlRoot;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		pnlRoot.setOnMouseClicked(e ->{
			System.out.println("clicado");
			pnlRoot.setCursor(javafx.scene.Cursor.HAND);
			pnlRoot.getStyleClass().remove("selected");
			pnlRoot.getStyleClass().add("selected");
			System.out.println(pnlRoot.getStyleClass());
			
		});
	}

	
	public void setParams(HashMap<String, Object> objs) {
		objParams = objs;
		double progress = Double.parseDouble(objParams.get("progress").toString());
		if (pgbProgress == null)
			return;
		pgbProgress.setProgress(progress);
		lblStatus.setText(String.valueOf(progress*100));
		lblTitle.setText(objParams.get("title").toString());
	}
}
