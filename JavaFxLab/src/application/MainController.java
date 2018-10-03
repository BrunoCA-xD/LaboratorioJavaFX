package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.skin.TextFieldSkin;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MainController {

	@FXML
	private Button btnTest;
	@FXML
	private PasswordField txtPass;
	@FXML
	private AnchorPane root;
	@FXML
	private ListView<Pane> lstView;

	@FXML
	ToggleButton btnToggle;
	textSkin tx = null;

	@FXML
	public void initialize() {
		tx = new textSkin(txtPass);
		txtPass.setSkin(tx);

		
		
		
	}

	public void btnTestClicked() {

		ObservableList<Pane> observableLst = FXCollections.observableArrayList();
		observableLst.add(root);

		lstView.setItems(observableLst);
	}

	public void btnToggleClicked() {
		tx.setDoMask(!btnToggle.isSelected());
	}
}

class textSkin extends TextFieldSkin {

	private boolean _doMask = true;

	public textSkin(TextField control) {
		super(control);
		if (control instanceof PasswordField) {
			control.getStylesheets().add(textSkin.class.getResource("style.css").toExternalForm());
			control.getStyleClass().addAll("txt","withicon", "showing");
			

			control.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    double vIconsLeftMargin = control.getWidth() - 20;
                    final boolean vDoMask = event.getX() <= vIconsLeftMargin;
                    setDoMask(vDoMask);
                    setIcon(vDoMask);
                }
            });

			control.setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (!_doMask) {
                        setDoMask(true);
                        setIcon(true);
                    }
                }
            });
			control.focusedProperty().addListener(new ChangeListener<Boolean>() {
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if (newValue) {
						setIcon(false);
					}
					if (!newValue) {
						setIcon(true);
					}

				}
			});


			control.setOnMouseMoved((MouseEvent event) -> {
                double vIconsLeftMargin = control.getWidth() - 20;
                if (event.getX() > vIconsLeftMargin) {
                	control.setCursor(Cursor.HAND);
                } else {
                	control.setCursor(Cursor.TEXT);
                }
            });

			control.setOnMouseExited((MouseEvent event) -> {
                setDoMask(true);
                setIcon(true);
            });
        }
		// TODO Auto-generated constructor stub
	
	}
	private void setIcon(boolean pShowing) {
        TextField textField = this.getSkinnable();
        textField.getStyleClass().removeAll("showing", "hiding");
        if (pShowing) {
            textField.getStyleClass().add("showing");
        } else {
            textField.getStyleClass().add("hiding");
        }
    }

	public void setDoMask(boolean pValue) {
		TextField textField = this.getSkinnable();
        textField.getStyleClass().removeAll("showing", "hiding");
		_doMask = pValue;


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
