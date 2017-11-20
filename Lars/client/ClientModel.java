package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientModel {
	
	private Socket socket;
	private String line;
	private BufferedReader input;
	private PrintWriter output;
	private String gettext= "Verbindungslog \n";
	private final String terminate="$CLOSE$";
	
	public ClientModel(){
	}
	
	

	public void clientcon() throws IOException{

		InetAddress address=InetAddress.getLocalHost();

		System.out.println("Client buffer");

		try {
			socket = new Socket(address,8080);
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("IO Exception");
		}
		System.out.println("Client Address : "+address);

	}

	public void sendenClient(String c) throws IOException{
		System.out.println("Sending...");
		String response=null;
		String c1=c;
		output.println(c1);
		output.flush();

	}

	public String readClient() throws IOException{
		System.out.println("reading");
		String textin = "";
		if (input.ready()){
			textin = input.readLine();
		}
		System.out.println("read"+textin);
		return textin;
	}


	public void conclose() throws IOException{
		sendenClient(terminate);
		input.close();
		output.close();
		socket.close();
		System.out.println("Connection Closed");
	}

	public String getText(){

		return this.gettext;

	}
}
