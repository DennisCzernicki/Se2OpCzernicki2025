package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import fileCreatorsCzernicki.ConcreteReaderCsvCreatorCzernicki;
import fileCreatorsCzernicki.ConcreteReaderTxtCreatorCzernicki;
import fileCreatorsCzernicki.ReaderCreatorCzernicki;
import fileCreatorsCzernicki.ReaderProductCzernicki;
import ownUtil.Observable;
import ownUtil.Observer;

public class SportvereineModel implements Observable {

	private Sportverein sportverein;
	private static SportvereineModel sportvereineModel;
	public Vector<Observer> observers = new Vector<Observer>();

	private SportvereineModel() {
	}
	
	public static SportvereineModel getInstance() {
		if(sportvereineModel == null) {
			sportvereineModel = new SportvereineModel();
		}
		
		return sportvereineModel;
	}

	public void nehmeSportvereinAuf(String name, String ort, int anzahlMitglieder, int anzahlEhemaligerMitglieder,
			String[] sportarten) {

		this.sportverein = new Sportverein(name, ort, anzahlMitglieder, anzahlEhemaligerMitglieder, sportarten);
		notifyObserver();


	}

	public void leseAusCsvDatei() throws java.io.IOException {
		ReaderCreatorCzernicki readerCreator = new ConcreteReaderCsvCreatorCzernicki();
		ReaderProductCzernicki readerProduct = readerCreator.factoryMethod();
		String[] zeile = readerProduct.leseAusDatei();
		this.sportverein = new Sportverein(zeile[0], zeile[1], Integer.parseInt(zeile[2]), Integer.parseInt(zeile[3]),
				zeile[4].split("_"));
		readerProduct.schliesseDatei();
		notifyObserver();
	}

	public void leseAusTxtDatei() throws java.io.IOException {
		ReaderCreatorCzernicki readerCreator = new ConcreteReaderTxtCreatorCzernicki();
		ReaderProductCzernicki readerProduct = readerCreator.factoryMethod();
		String[] zeile = readerProduct.leseAusDatei();
		this.sportverein = new Sportverein(zeile[0], zeile[1], Integer.parseInt(zeile[2]), Integer.parseInt(zeile[3]),
				zeile[4].split("_"));
		readerProduct.leseAusDatei();
		readerProduct.schliesseDatei();
		notifyObserver();
	}

	public void schreibeSportvereineInCsvDatei() throws IOException {

		BufferedWriter aus = new BufferedWriter(new FileWriter("SportvereineAusgabe.csv", true));
		aus.write(sportverein.gibSportvereinZurueck(';'));
		aus.close();

	}

	public Sportverein getSportverein() {
		return sportverein;
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
