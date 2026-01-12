package gui.guiFreizeitangebote;

import business.businessSpielplatz.Spielplatz;
import business.businessSpielplatz.SpielplatzModel;
import business.businessSportverein.Sportverein;
import business.businessSportverein.SportvereineModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class FreizeitangeboteView {

	private FreizeitangeboteControl freizeitangeboteControl;
	private SportvereineModel sportvereineModel;
	private SpielplatzModel spielplatzModel;
	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeSpielplatz = new Label("Anzeige Spielplätze");
	private TextArea txtAnzeigeSpielplatz = new TextArea();
	private Button btnAnzeigeSpielplatz = new Button("csv-Import und Anzeige");
	private Label lblAnzeigeSportvereine = new Label("Anzeige Sportvereine");
	private TextArea txtAnzeigeSportvereine = new TextArea();
	private Button btnAnzeigeSportvereine = new Button("Anzeige");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public FreizeitangeboteView(FreizeitangeboteControl freizeitangeboteControl, Stage primaryStage,
			SportvereineModel sportvereineModel, SpielplatzModel spielplatzModel) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Freizeitangeboten");
		primaryStage.show();
		this.freizeitangeboteControl = freizeitangeboteControl;
		this.sportvereineModel = sportvereineModel;
		this.spielplatzModel = spielplatzModel;
		this.initKomponentenSpielplatz();
		this.initKomponentenSportvereine();
		this.initListenerSpielplatz();
		this.initListenerSportvereine();
	}

	/*
	 * private void initKomponenten() { // Label Font font = new Font("Arial", 20);
	 * lblAnzeigeSportvereine.setLayoutX(310);
	 * lblAnzeigeSportvereine.setLayoutY(40); lblAnzeigeSportvereine.setFont(font);
	 * lblAnzeigeSportvereine.setStyle("-fx-font-weight: bold;");
	 * pane.getChildren().add(lblAnzeigeSportvereine); // Textbereich
	 * txtAnzeigeSportvereine.setEditable(false);
	 * txtAnzeigeSportvereine.setLayoutX(310);
	 * txtAnzeigeSportvereine.setLayoutY(90);
	 * txtAnzeigeSportvereine.setPrefWidth(220);
	 * txtAnzeigeSportvereine.setPrefHeight(185);
	 * pane.getChildren().add(txtAnzeigeSportvereine); // Button
	 * btnAnzeigeSportvereine.setLayoutX(310);
	 * btnAnzeigeSportvereine.setLayoutY(290);
	 * pane.getChildren().add(btnAnzeigeSportvereine); }
	 * 
	 * private void initListener() { btnAnzeigeSportvereine.setOnAction(new
	 * EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent e) { zeigeSportvereineAn(); } }); }
	 */

	private void initKomponentenSportvereine() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeSportvereine.setLayoutX(310);
		lblAnzeigeSportvereine.setLayoutY(40);
		lblAnzeigeSportvereine.setFont(font);
		lblAnzeigeSportvereine.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeSportvereine);
		// Textbereich
		txtAnzeigeSportvereine.setEditable(false);
		txtAnzeigeSportvereine.setLayoutX(310);
		txtAnzeigeSportvereine.setLayoutY(90);
		txtAnzeigeSportvereine.setPrefWidth(220);
		txtAnzeigeSportvereine.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeSportvereine);
		// Button
		btnAnzeigeSportvereine.setLayoutX(310);
		btnAnzeigeSportvereine.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeSportvereine);
	}

	private void initListenerSportvereine() {
		btnAnzeigeSportvereine.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeSportvereineAn();
			}
		});
	}

	private void initKomponentenSpielplatz() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeSpielplatz.setLayoutX(20);
		lblAnzeigeSpielplatz.setLayoutY(40);
		lblAnzeigeSpielplatz.setFont(font);
		lblAnzeigeSpielplatz.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeSpielplatz);
		// Textbereich
		txtAnzeigeSpielplatz.setEditable(false);
		txtAnzeigeSpielplatz.setLayoutX(20);
		txtAnzeigeSpielplatz.setLayoutY(90);
		txtAnzeigeSpielplatz.setPrefWidth(220);
		txtAnzeigeSpielplatz.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeSpielplatz);
		// Button
		btnAnzeigeSpielplatz.setLayoutX(20);
		btnAnzeigeSpielplatz.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeSpielplatz);
	}

	private void initListenerSpielplatz() {
		btnAnzeigeSpielplatz.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeSpielplatzAn();
			}
		});
	}

	public void zeigeSportvereineAn() {
		if (sportvereineModel.getSportverein().size() > 0) {
			StringBuffer text = new StringBuffer();
			for (Sportverein sportverein : sportvereineModel.getSportverein()) {
				text.append(sportverein.gibSportvereinZurueck(' ') + "\n");
			}
			this.txtAnzeigeSportvereine.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Sportverein aufgenommen!");
		}
	}

	public void zeigeSpielplatzAn() {
		freizeitangeboteControl.leseSpielplatzAusCsvDatei();

		if (spielplatzModel.getSpielplatz().size() > 0) {
			StringBuffer text = new StringBuffer();
			for (Spielplatz spielplatz : spielplatzModel.getSpielplatz()) {
				text.append(spielplatz.gibSpielplatzZurueck(' ') + "\n");
			}
			this.txtAnzeigeSpielplatz.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Sportverein aufgenommen!");
		}
	}

	private void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	public void zeigeFehlermeldungsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung).zeigeMeldungsfensterAn();
	}

}
