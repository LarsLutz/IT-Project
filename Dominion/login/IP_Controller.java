package login;


/**
 * @author Lars Lutz
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kommunikation.Kommunikation;

public class IP_Controller {
	
	
	@FXML
	Button bOK, blokal;
	
	@FXML
	Label lInfoText, lIPAdresse;
	
	@FXML
	TextField tEingabe;
	
	

	
@FXML
    
    public void okKlick(){
	
		// schliesst aktuelles Fenster
		
    	String ipadresse;
    	ipadresse= tEingabe.getText();
    	Kommunikation.setIpadresse(ipadresse);
    	Stage currentStage = (Stage) bOK.getScene().getWindow();
		currentStage.close();
    }

	public void localKlick() throws UnknownHostException{
		
		String ipadresse;
		InetAddress adress= InetAddress.getLocalHost();
		ipadresse= adress.toString();
		String [] part =ipadresse.split("/");
		
		ipadresse= part[1];
				
		
		tEingabe.setText(ipadresse);
	
	
}



	
	
	
}
