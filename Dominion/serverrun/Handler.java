package serverrun;

import java.io.*;
import java.net.Socket;
/**
 * @author Lars Lutz
 */
class Handler implements Runnable {
    private final Socket socket;
    private Player player;
    private BufferedReader input;
    private PrintWriter output;
    private final String terminate="$CLOSE$";

    Handler(Socket socket, Player player) {
        this.socket = socket;
        this.player = player;
    }
// Thread wird gestartet und die Reader und Writer Instanziert
    @Override
    public void run() {
        try {
            input = new BufferedReader(
                    new InputStreamReader(
                            this.socket.getInputStream()));
            output =
                    new PrintWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream()));
        } catch (IOException e){
            e.printStackTrace();
        }
        processConnection();
    }
// �berpr�ft das nur gesendet und empfangen wird wennauch wirklich Daten vorhanden sind
    private void processConnection() {
        try {
            String message;
            while (this.player.isRunning()){
                if (input.ready()){
                    System.out.println("reading");
                    message = input.readLine();
                    if (message == null || message.equals(terminate)){
                        System.out.println("read null");
                        return;
                    }
                    player.setDataIn(message);
                    System.out.println("read" + message);
                }
                if (player.isDataOutAvailable()) {
                    try {
                        message = player.getDataOut();
                        System.out.println("sending");
                        output.println(message);
                        output.flush();
                        System.out.println("sent");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
