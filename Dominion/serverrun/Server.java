package serverrun;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Server{

    static boolean running = true;
    
    
    public static void serverStart(){
        try {
        	System.out.println("Sever startet");
            ServerSocket serverSocket = new ServerSocket(50663); // Generiert Serversocket
            Player player1 = new Player(serverSocket.accept(), 1); //Instansiert die Klasse Player
            Player player2 = new Player(serverSocket.accept(), 2);
            while (player1.isRunning()&player2.isRunning()){ //Soblad beide Verbunden sind
                //Daten zuerst verarbeiten bevor weitergeleitet wird

                if(player1.isDataInAvailable()){
                    String data = player1.getDataIn();
                    //Verarbeiter.verarbeite(player1.getdatain(),player1,player2)
                    System.out.println("1 - 2");
                    player2.setDataOut(data);
                    System.out.println("echo");
                    player1.setDataOut(data);
                }
                if(player2.isDataInAvailable()){
                    String data = player2.getDataIn();
                    System.out.println("2 - 1");
                    player1.setDataOut(data);
                    System.out.println("echo");
                    player2.setDataOut(data);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
	
}
