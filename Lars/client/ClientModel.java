package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientModel {
	
	private Socket sockel1=null;
	private String line=null;
	private BufferedReader bread=null;
	private BufferedReader ist=null;
	private PrintWriter pwrite=null;
	private String gettext= "Verbindungslog \n";
	
	public ClientModel(){
	}
	
	

		public void clientcon() throws IOException{
			
			InetAddress address=InetAddress.getLocalHost();
			
			//System.out.println("Client buffer");
			this.gettext= gettext+ "Client Buffer \n";
			
				try { 
				
					sockel1= new Socket(address,8080);
					bread= new BufferedReader(new InputStreamReader(System.in));
					ist=new BufferedReader(new InputStreamReader(sockel1.getInputStream()));
					pwrite= new PrintWriter(sockel1.getOutputStream());
					
				

				} catch (IOException e) {
					e.printStackTrace();
					System.err.println("IO Exception");
				}
				//System.out.println("Client Address : "+address);
				this.gettext= gettext+"Client Address : "+address;
				
				
				
			}
		
		public void sendenClient() throws IOException{
			
			System.out.println("Enter Data to echo Server ( Enter QUIT to end):");
			
			String response=null;
		    try{
		        line=bread.readLine(); 
		        while(line.compareTo("QUIT")!=0){
		                pwrite.println(line);
		                pwrite.flush();
		                response=ist.readLine();
		                //System.out.println("Server Response : "+response);
		                this.gettext= gettext+"Server Response : "+response;
		                line=bread.readLine();
	
		            }
			
		}
		    
		    catch(IOException e){
		        e.printStackTrace();
		    System.out.println("Socket read Error");
		    }
		    finally{
	
		        ist.close();pwrite.close();bread.close();sockel1.close();
		                //System.out.println("Connection Closed");
		                this.gettext= gettext+"Connection Closed";
		    }
		}
		
		public String getText(){
			
			return this.gettext;
			
			
		}
		
		//(Socket client = new Socket("localhost", 8080);
		/*BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					
					PrintWriter out = new PrintWriter(client.getOutputStream(),true);) {

				out.print("Hallo Hitler");
				System.out.println("Client site message");
				in.close();
				out.close();*/
		

}
