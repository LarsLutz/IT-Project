package sceneBuilderMVCframework;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Controller {
	
	private final int STARTING_NUMBER = 0;
	
	public Controller(){
		
	}
	
	Model m = new Model(STARTING_NUMBER);
	
	
	
	@FXML
	Button b1;
	
	@FXML
	Label lab1;
	
	
	@FXML
	public void erhoehung(MouseEvent e){
		lab1.setText(m.increment()+"");
		
	}
	
	

}
