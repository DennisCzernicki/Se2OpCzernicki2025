package main;

import gui.guiFreizeitangebote.FreizeitangeboteControl;
import gui.guiSportvereine.SportvereineControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new SportvereineControl(primaryStage);
		Stage fensterFreizeitangebote = new Stage();
		new FreizeitangeboteControl(fensterFreizeitangebote);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
