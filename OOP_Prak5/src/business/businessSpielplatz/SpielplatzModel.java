package business.businessSpielplatz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import ownUtil.Observable;
import ownUtil.Observer;

public class SpielplatzModel implements Observable {
	private ArrayList<Spielplatz> spielplatz = new ArrayList<Spielplatz>();
	private static SpielplatzModel spielplatzModel;
	public Vector<Observer> observers = new Vector<Observer>();

	private SpielplatzModel() {
	}

	public static SpielplatzModel getInstance() {
		if (spielplatzModel == null) {
			spielplatzModel = new SpielplatzModel();
		}

		return spielplatzModel;
	}

	public void leseSpielplatzAusCsvDatei() throws IOException {
		BufferedReader ein = new BufferedReader(new FileReader("Spielplatzausgabe.csv"));
		ArrayList<Spielplatz> ergebnis = new ArrayList<>();
		String zeileStr = ein.readLine();

		while (zeileStr != null) {
			String[] zeile = zeileStr.split(";");
			ergebnis.add(new Spielplatz(zeile[0], zeile[1], zeile[2]));
			zeileStr = ein.readLine();
		}
		ein.close();
		this.spielplatz = ergebnis;
	}

	public ArrayList<Spielplatz> getSpielplatz() {
		return spielplatz;
	}

	@Override
	public void addObserver(Observer obs) {
		this.observers.addElement(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		this.observers.removeElement(obs);
	}

	@Override
	public void notifyObserver() {
		for (int i = 0; i < observers.size(); i++) {
			this.observers.elementAt(i).update();

		}
	}
}
