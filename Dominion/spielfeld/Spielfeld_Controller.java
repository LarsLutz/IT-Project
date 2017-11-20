package spielfeld;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Spielfeld_Controller {
	
	//Begonnen von Jan Müller - würde das gerne weiterführen :)
	//aufgrund der komplexität (Dynamik etc) habe ich das GUI nicht vervollständigt
	public Spielfeld_Controller(){
		
	}
	
	@FXML
	ImageView hintergrund, rueckseite, rueckseiteNormal;
	ImageView kupfer, silber, gold, anwesen1, anwesen3, anwesen6;
	ImageView bazaarMiddle, cellarMiddle, chancellorMiddle, marketMiddle, smithyMiddle;
	
	@FXML
	Button bSpeichern, bP1, bP2, bP3, bZugBeenden;
	
	@FXML
	TextArea tVerlauf, tEingabe;
	
	@FXML
	Pane pSeinStapel, pKupfer, pSilber, pGold, p1, p3, p6, pRueckseiteNormal;
	Pane pBazaarMiddle, pCellarMiddle, pChancellorMiddle, pMarketMiddle, pSmithyMiddle;
	
	@FXML
	Label anzahlSeinStapel;
	
	@FXML
	public void testEvent(MouseEvent Moue){
		System.out.println("auf Panes zu klicken scheint zu funktionieren");
	}
	
	
	@FXML
	public void enterKlick(){
		System.out.println("Taste gedrückt.. jetzt noch auf Enter... Bei tastendruck ist es kein MouseEvent sondern ein..?");
	}
	
}
