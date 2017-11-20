package SammlungP;

import Karte.AktionsKarte;
import java.util.ArrayList;
import Karte.SuperKarte;
import Karte.AKBazaar;
import Karte.AKChancellor;
import Karte.AKKeller;
import Karte.AKMarkt;
import Karte.AKSmithy;
import Karte.GeldKarte;
import Karte.PunkteKarte;
import SammlungP.Spielfeldkarte;
import SammlungP.Sammlung;

public class Spielfeldkarte {
	
	public SuperKarte art;
	public int anzahlVorhanden;
	
	
// KonstrukTorte
	public Spielfeldkarte(SuperKarte art, int anzahlVorhanden) {
		this.art = art;
		this.anzahlVorhanden = anzahlVorhanden;
	}
	
	
}

//
//	
//	final int anzahlKupfer = 20;
//	final int anzahlSilber = 20;
//	final int anzahlGold = 20;
//	final int anzahlAnwesen = 20;
//	final int anzahlHerzogtum = 10;
//	final int anzahlProvinz = 10;
//	final int anzahlAK = 10;
//	
//	ArrayList<GeldKarte> kupferspielfeld = new ArrayList<GeldKarte>();{
//	for(int i=0; i>anzahlKupfer;i++){
//		kupferspielfeld.add(new GeldKarte(1,"Kupfer",0));
//		}
//	ArrayList<GeldKarte> silberspielfeld = new ArrayList<GeldKarte>();
//	for(int i=0; i>anzahlSilber;i++){
//		silberspielfeld.add(new GeldKarte(2,"Silber",3));
//		}
//	ArrayList<GeldKarte> goldspielfeld = new ArrayList<GeldKarte>();
//	for(int i=0; i>anzahlGold;i++){
//		goldspielfeld.add(new GeldKarte(3,"Gold",6));
//		}
//	ArrayList<PunkteKarte> anwesenspielfeld = new ArrayList<PunkteKarte>();
//	for(int i=0; i>anzahlAnwesen;i++){
//		anwesenspielfeld.add(new PunkteKarte(1,"Anwesen",2));
//		}
//	ArrayList<PunkteKarte> herzogtumspielfeld = new ArrayList<PunkteKarte>();
//	for(int i=0; i>anzahlHerzogtum;i++){
//		herzogtumspielfeld.add(new PunkteKarte(3,"Herzogtum",5));
//			}
//	ArrayList<PunkteKarte> provinzspielfeld = new ArrayList<PunkteKarte>();
//	for(int i=0; i>anzahlProvinz;i++){
//		provinzspielfeld.add(new PunkteKarte(6,"Provinz",8));
//		}
//	ArrayList<AKBazaar> bazaarspielfeld = new ArrayList<AKBazaar>();
//	for(int i=0; i>anzahlAK;i++){
//		bazaarspielfeld.add(new AKBazaar());
//		}
//	ArrayList<AKChancellor> chancellorspielfeld = new ArrayList<AKChancellor>();
//	for(int i=0; i>anzahlAK;i++){
//		chancellorspielfeld.add(new AKChancellor());
//		}
//	ArrayList<AKKeller> kellerspielfeld = new ArrayList<AKKeller>();
//	for(int i=0; i>anzahlAK;i++){
//		kellerspielfeld.add(new AKKeller());
//		}
//	ArrayList<AKMarkt> marktspielfeld = new ArrayList<AKMarkt>();
//	for(int i=0; i>anzahlAK;i++){
//		marktspielfeld.add(new AKMarkt());
//		}
//	ArrayList<AKSmithy> smithyspielfeld = new ArrayList<AKSmithy>();
//	for(int i=0; i>anzahlAK;i++){
//		smithyspielfeld.add(new AKSmithy());
//		}
//
//	
//	
//	ArrayList<SuperKarte> deckliste = new ArrayList<SuperKarte>();
//	GeldKarte testobjekt = new GeldKarte(1,"Kupfer",0);
//	PunkteKarte testobjekt2 = new PunkteKarte(1,"Anwesen",1);{
//	
//	for ( int i=0; i>5; i++){
////		deckliste.add(testobjekt.GeldKarte(1,"Kupfer",0));
//	}
	
//	private GeldKarte[] kupfer;
//	private GeldKarte[] silber;
//	private GeldKarte[] gold;
//	private PunkteKarte[] anwesen;
//	private PunkteKarte[] herzogtum;
//	private PunkteKarte[] provinz;
//	private AKBazaar[] bazaar;
//	private AKChancellor[] chancellor;
//	private AKKeller[] keller;
//	private AKMarkt[] markt;
//	private AKSmithy[] smithy;