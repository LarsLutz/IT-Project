package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerModel {
	
	private  static ServerSocket srvsocket;
	private static Socket sockel;
	private ServerController controller;
	private static int client_id = 0;
	private static Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private int id;
	
	public ServerModel() {
		
	}
		
		
		public ServerModel(int id, Socket socket) throws IOException {
			this.socket = socket;
			this.id = id;
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
		}

		public void start() {
			try {
				listen();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void listen() throws IOException {

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
		}
		
		
public void  serverstart() {
			
			System.out.println("Hallo");
			//srvsocket = new ServerSocket(8080);
			
			//controller.text.appendText("Läuft");
			/*while (true) {
			sockel = srvsocket.accept();
			client_id++;
			controller.text.appendText(client_id + ". Client hinzugefügt");
			new ServerModel(client_id, socket).start();
		} */
			
			
			

		}

		
		
		

		
		
		
	}
	


