package gui;

import java.io.IOException;

import business.SportvereineModel;
import javafx.stage.Stage;

public class SportvereineControl {
	private SportvereineView view;
	private SportvereineModel model;

	public SportvereineControl(Stage primaryStage) {
		this.model = new SportvereineModel();
		this.view = new SportvereineView(this, primaryStage, model);
	}

	public void nehmeSportvereinAuf() {
		try {
			model.nehmeSportvereinAuf(view.getTxtName().getText(), view.getTxtOrt().getText(),
					Integer.parseInt(view.getTxtAnzahlMitglieder().getText()),
					Integer.parseInt(view.getTxtAnzahlEhemaligerMitglieder().getText()),
					view.getTxtSportarten().getText().split(";"));
			view.zeigeInformationsfensterAn("Der Sportverein wurde aufgenommen!");
		} catch (Exception exc) {
			view.zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
	}

	public void leseAusDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				model.leseAusDatei(typ);
				view.zeigeInformationsfensterAn("Der Sportverein wurde gelesen!");
			} else {
				view.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			view.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			view.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}

	public void schreibeSportvereineInCsvDatei() {
		try {
			model.schreibeSportvereineInCsvDatei();
			view.zeigeInformationsfensterAn("Die Sportvereine wurden gespeichert!");
		} catch (IOException exc) {
			view.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			view.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}
}
