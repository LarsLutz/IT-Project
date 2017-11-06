package server;

import javafx.application.Application;
import javafx.stage.Stage;

public class Server extends Application {
	
	private ServerModel model;
	private ServerView view;
	private ServerController controller;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		model = new ServerModel() ;
		view = new ServerView(primaryStage);
		controller= new ServerController();
		
		
		
	}
	
	
	
	    public static void main(String[] args) {
			launch(args);
		}
			
		
}
