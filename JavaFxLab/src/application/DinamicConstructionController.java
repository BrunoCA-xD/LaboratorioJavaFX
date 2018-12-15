package application;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;

import com.sun.javafx.tools.packager.bundlers.Bundler.Bundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class DinamicConstructionController implements Initializable {

	private ResourceBundle bundle;
	@FXML
	FlowPane lstActivity;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lstActivity.getChildren().clear();
		AnchorPane[] pnls = new AnchorPane[123];

		for (int i = 0; i < pnls.length; i++) {
			URL url;
			AnchorPane pnl = new AnchorPane();
			
			FXMLLoader fx = new FXMLLoader();
			try {
				url = new File(getClass().getResource("activiteItem.fxml").getPath()).toURI().toURL();
				fx.setLocation(url);
				pnl = pnls[i] = (AnchorPane) fx.load();

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			pnl.getStyleClass().add("activityItem");
			lstActivity.getChildren().add(pnls[i]);
			HashMap<String, Object> params = new HashMap<>();
			params.put("progress", (new Random().nextDouble()));
			params.put("title","atividade"+i);

			ActivityItemController ac = fx.getController();
			
			ac.setParams(params);

		}
	}

}
