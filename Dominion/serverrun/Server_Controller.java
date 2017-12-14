package serverrun;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Server_Controller {
	
	
	private Thread thread;
	private Server server;
	private String ip;
	private Player player;
	
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
		lAdresse.setText(ip);
		
	}
	
	@FXML
	public void schliessenKlick(){
		lStatus.setText("stopped");
		server.setClose("$end");
		Platform.exit();
		
	}
	
}
