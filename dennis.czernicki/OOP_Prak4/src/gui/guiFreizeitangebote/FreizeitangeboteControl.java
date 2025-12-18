package gui.guiFreizeitangebote;

import business.SportvereineModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class FreizeitangeboteControl implements Observer {
	private FreizeitangeboteView freizeitangeboteView;
	private SportvereineModel sportvereineModel;

	public FreizeitangeboteControl(Stage primaryStage) {
		this.sportvereineModel = SportvereineModel.getInstance();
		this.freizeitangeboteView = new FreizeitangeboteView(this, primaryStage, sportvereineModel);
		this.sportvereineModel.addObserver(this);
	}

	@Override
	public void update() {
		freizeitangeboteView.zeigeSportvereineAn();
	}
}
