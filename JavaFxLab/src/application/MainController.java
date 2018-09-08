package application;

import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.skin.TextFieldSkin;

public class MainController {

	@FXML
	private Button btnTest;
	@FXML
	private PasswordField txtPass;

	@FXML
	ToggleButton btnToggle;
	textSkin tx = null;

	@FXML
	public void initialize() {
		tx = new textSkin(txtPass);
		tx.setDoMask(true);
		txtPass.setSkin(tx);
		
		
	}

	public void btnTestClicked() {
		tx.setDoMask(!btnToggle.isSelected());
	}
}

class textSkin extends TextFieldSkin {

	private boolean _doMask = true;

	public textSkin(TextField control) {
		super(control);
		// TODO Auto-generated constructor stub
	}

	public void setDoMask(boolean pValue) {

		_doMask = pValue;

		TextField textField = this.getSkinnable();

		String vText = textField.getText();
		textField.setText(vText);
	}

	@Override
	protected String maskText(String txt) {
		if (_doMask) {
			return super.maskText(txt);
		} else {
			return txt;
		}
	}
}
