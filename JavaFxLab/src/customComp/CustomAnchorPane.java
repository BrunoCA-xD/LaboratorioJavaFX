package customComp;

import javafx.scene.layout.AnchorPane;

public class CustomAnchorPane extends AnchorPane{

	public CustomAnchorPane() {
		// TODO Auto-generated constructor stub
		this.setStyle("-fx-background-color:red");
	}
	
	
	public String getCustomAttribute() {
		return customAttribute;
	}


	public void setCustomAttribute(String customAttribute) {
		this.customAttribute = customAttribute;
	}


	private String customAttribute;
}
