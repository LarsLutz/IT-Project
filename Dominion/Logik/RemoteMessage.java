package Logik;
import Karte.SuperKarte;

//Robin Widmer
public class RemoteMessage {

	//kei ahnig wie vell
	public static enum Handlung{aktionsKarteSpielen, karteKaufen, geldkartenSpielen, zugBeenden, kartenAbwerfen}
	public final Handlung handlung;
	public final SuperKarte karte;
	
	public RemoteMessage(Handlung handlung, SuperKarte karte){
		this.handlung = handlung;
		this.karte = karte;
	}
	//um alli aktione vom spielfeld ufem server uszführe
	public void nachrichtBekommen(RemoteMessage m){
		switch(m.handlung){
		case aktionsKarteSpielen:
			break;
		case karteKaufen:
			break;
		case geldkartenSpielen:
			break;
		case zugBeenden:
			break;
		case kartenAbwerfen:
			break;
		}
	}
}


	