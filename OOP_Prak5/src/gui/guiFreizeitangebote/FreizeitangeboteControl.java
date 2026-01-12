package gui.guiFreizeitangebote;

import java.io.IOException;

import business.businessSpielplatz.SpielplatzModel;
import business.businessSportverein.SportvereineModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class FreizeitangeboteControl implements Observer {
	private FreizeitangeboteView freizeitangeboteView;
	private SportvereineModel sportvereineModel;
	private SpielplatzModel spielplatzModel;

	public FreizeitangeboteControl(Stage primaryStage) {
		this.sportvereineModel = SportvereineModel.getInstance();
		this.spielplatzModel = SpielplatzModel.getInstance();
		this.freizeitangeboteView = new FreizeitangeboteView(this, primaryStage, sportvereineModel, spielplatzModel);
		this.sportvereineModel.addObserver(this);
		this.spielplatzModel.addObserver(this);
	}
	
	public void leseSpielplatzAusCsvDatei() {
		try {
			this.spielplatzModel.leseSpielplatzAusCsvDatei();
		} catch (IOException exc) {
			this.freizeitangeboteView.zeigeFehlermeldungsfensterAn("IOException beim Lesen von Spielplatz!");
		} catch (Exception exc) {
			this.freizeitangeboteView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen von Spielplatz");		
			exc.printStackTrace();
		}
	}

	@Override
	public void update() {
		freizeitangeboteView.zeigeSportvereineAn();
	}
}
