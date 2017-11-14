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
	private static int client_id = 0;
	private BufferedReader in;
	private PrintWriter out;
	private int id;
	
	public ServerModel() {
		
	}
	
	
		
		
	
	
		public ServerModel(int id, Socket socket) throws IOException {
			this.sockel = socket;
			this.id = id;
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			System.out.println("Servermodel");
		}

		public void start() {
			try {
				listen();
				System.out.println("Servermodel");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}

		public void listen() throws IOException {

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
				System.out.println("listen");
			}
		}
		
		
public void  serverstart() {
			
			
			try {
				srvsocket = new ServerSocket(8080);
				System.out.println("Läuft \n");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			while (true) {
			try {
				sockel = srvsocket.accept();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			client_id++;
			System.out.println("Neuer Client mit ID: " + client_id);
			try {
				new ServerModel(client_id, sockel).start();
				System.out.println("Neuer Sockel");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} 
			
			
			

		}

		
		
		

		
		
		
	}
	

//class ServerThread extends Thread{  
//
//    String line=null;
//    BufferedReader  is = null;
//    PrintWriter os=null;
//    Socket s=null;
//
//    public ServerThread(Socket s){
//        this.s=s;
//    }
//
//    public void run() {
//    try{
//        is= new BufferedReader(new InputStreamReader(s.getInputStream()));
//        os=new PrintWriter(s.getOutputStream());
//
//    }catch(IOException e){
//        System.out.println("IO error in server thread");
//    }
//
//    try {
//        line=is.readLine();
//        while(line.compareTo("QUIT")!=0){
//
//            os.println(line);
//            os.flush();
//            System.out.println("Response to Client  :  "+line);
//            line=is.readLine();
//        }   
//    } catch (IOException e) {
//
//        line=this.getName(); //reused String line for getting thread name
//        System.out.println("IO Error/ Client "+line+" terminated abruptly");
//    }
//    catch(NullPointerException e){
//        line=this.getName(); //reused String line for getting thread name
//        System.out.println("Client "+line+" Closed");
//    }
//
//    finally{    
//    try{
//        System.out.println("Connection Closing..");
//        if (is!=null){
//            is.close(); 
//            System.out.println(" Socket Input Stream Closed");
//        }
//
//        if(os!=null){
//            os.close();
//            System.out.println("Socket Out Closed");
//        }
//        if (s!=null){
//        s.close();
//        System.out.println("Socket Closed");
//        }
//
//        }
//    catch(IOException ie){
//        System.out.println("Socket Close Error");
//    }
//    }//end finally
//    }

