package serverrun;

import java.io.*;
import java.net.Socket;
/** Thread welcher die Inputs und Outputs entgegen nimmt
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
	/**
	 * Überprüft das nur gesendet und empfangen wird wennauch wirklich Daten vorhanden sind
	 *Wenn die termination gesendet wird soll der Thread geschlossen werden
	 */
	private void processConnection() {
		try {
			String message;
			while (this.player.isRunning()){
				if (input.ready()){
					message = input.readLine();
					if (message == null || message.equals(terminate)){
						return;
					}
					player.setDataIn(message);
				}
				if (player.isDataOutAvailable()) {
					try {
						message = player.getDataOut();
						output.println(message);
						output.flush();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
