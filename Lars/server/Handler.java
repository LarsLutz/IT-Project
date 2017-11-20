package server;

import java.io.*;
import java.net.Socket;

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
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
