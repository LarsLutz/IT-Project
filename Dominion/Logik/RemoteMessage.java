//package Logik;
//import Karte.SuperKarte;
//import Logik.Spieler;
//
////Robin Widmer
//public class RemoteMessage {
//
//	//kei ahnig wie vell
//	public static enum Handlung{aktionsKarteSpielen, karteKaufen, geldkartenSpielen, zugBeenden, kartenAbwerfen}
//	public final Handlung handlung;
//	public final SuperKarte karte;
//	public final int spielerNummer;
//	
//	//TODO kei ahnig ob da mitem spieler so goht
//	public RemoteMessage(Handlung handlung, SuperKarte karte, int spielerNummer){
//		this.handlung = handlung;
//		this.karte = karte;
//		this.spielerNummer = spielerNummer;
//		
//	}
//	//um alli aktione vom spielfeld ufem server uszf�hre
//	public void nachrichtBekommen(RemoteMessage m){
//		switch(m.handlung){
//		case aktionsKarteSpielen:
//			m.karte.getAktionsKarteSpielen();
//			break;
//		case karteKaufen:
//			break;
//		case geldkartenSpielen:
//			//TODO wie zum rechtige spieler objekt cho
//		//	spieler1.geldKarteSpielen(m.karte);
//			break;
//		case zugBeenden:
//			break;
//		case kartenAbwerfen:
//			break;
//		}
//	}
//}


	