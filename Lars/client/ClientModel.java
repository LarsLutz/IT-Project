package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientModel {
	
	public ClientModel(){
	}

		public void clientcon(){
			System.out.println("Client buffer");
				try (Socket client = new Socket("localhost", 8080);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
						
						PrintWriter out = new PrintWriter(client.getOutputStream(),true);) {

					out.print("Hallo Hitler");
					System.out.println("Client site message");
					in.close();
					out.close();

				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}

		

	

}
