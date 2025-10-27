package main;

import gui.SportvereineControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new SportvereineControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
