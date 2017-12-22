package serverrun;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/** Controller für das Server Fenster
 * Startet die Threads
 * @author Lars Lutz
 */
public class Server_Controller {
	
	
	private Thread thread;
	private Server server;
	private String ip;
	public  Server_Controller() {
		
	}
	
	@FXML
	Label l1, l2, lStatus, lAdresse;
	
	@FXML
	Button bSchliessen;
	
	public void initialize(){
		
		InetAddress address;
		try {
			address = InetAddress.getLocalHost();
			ip = address.toString();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		server= new Server();
		this.thread=new Thread(server);
		this.thread.start();
		lStatus.setText("running");
		
		
		String [] part =ip.split("/");
		
		ip= part[1];
		lAdresse.setText(ip);
		
	}
	
	@FXML
	public void schliessenKlick(){
		lStatus.setText("stopped");
		server.setClose("$end");
		Platform.exit();
		
	}
	
}
