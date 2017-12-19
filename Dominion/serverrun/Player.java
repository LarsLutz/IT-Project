package serverrun;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Platform;

/**
 * @author Lars Lutz
 */
public class Player{

    private Socket socket;
    private Thread thread;
    private int id;
    private String dataOut;
    private String dataIn;
    private boolean dataInAvailable = false;
    private boolean dataOutAvailable = false;
    private boolean running = true;

    public Player(Socket socket, int id){
        this.socket = socket;
        this.id = id;
        this.thread = new Thread(new Handler(socket, this)); //Neuer Thread wird angelegt mit den Playerdaten
        this.thread.start();
        System.out.println("Player: "+ this.id + " - sock: " + socket.toString());
    }

    public int getId() {
        return this.id;
    }

    //Daten werden in den Thread gelesen(synchronized macht das nicht mehrer Trheads gleichzeitig versuchen auf die Methode zuzugreifen
    synchronized public void setDataIn(String message){
        this.dataIn = message;
        this.dataInAvailable = true;
        System.out.println("Player update: "+ this.id + " - msg: " + message + this.dataIn);
    }

    synchronized public boolean isDataInAvailable(){
        return this.dataInAvailable;
    }

    synchronized public String getDataIn(){
        this.dataInAvailable = false;
        return this.dataIn;
    }

    synchronized public boolean isDataOutAvailable(){
        return this.dataOutAvailable;
    }

    synchronized public String getDataOut() throws InterruptedException{
        this.dataOutAvailable = false;
        return this.dataOut;
    }

    synchronized public void setDataOut(String data){
        this.dataOut = "player"+ this.id+"-"+data;
        this.dataOutAvailable = true;
    }

    // Daten werden in den Writer geladen
    synchronized public void sendMessage(String message) throws IOException {

        PrintWriter printWriter =
                new PrintWriter(
                        new OutputStreamWriter(
                                this.socket.getOutputStream()));
        printWriter.print(message);
        printWriter.flush();
    }

    
    //Schaut ob der Thread noch l�uft und schliesst ihn bei bedarf
    synchronized public boolean isRunning(){
        if (!thread.isAlive()){
            close();
        }
        return this.running;
    }

    public void close(){
        System.out.println("closing");
        this.running = false;
        while(thread.isAlive()){

        }
        try {
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        Platform.exit();
        System.out.println("closed");
    }

}
