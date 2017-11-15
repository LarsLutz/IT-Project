package server;

import javafx.application.Application;
import javafx.stage.Stage;

public class Server extends Application {
	
	private ServerModelneu model;
	private ServerView view;
	private ServerController controller;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		model = new ServerModelneu() ;
		view = new ServerView(primaryStage);
		controller= new ServerController();
		
		
		
	}
	
	
	    public static void main(String[] args) {
			launch(args);
		}
			
		
}
