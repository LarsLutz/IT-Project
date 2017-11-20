package Guelle;

import javafx.application.Application;
import javafx.stage.Stage;

public class Client extends Application {

	private ClientModel model;
	private ClientView view;
	private ClientController controller;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		model = new ClientModel() ;
		view = new ClientView(primaryStage);
		controller= new ClientController();
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
