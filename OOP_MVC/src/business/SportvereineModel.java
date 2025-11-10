package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import fileCreatorsCzernicki.ConcreteReaderCsvCreatorCzernicki;
import fileCreatorsCzernicki.ConcreteReaderTxtCreatorCzernicki;
import fileCreatorsCzernicki.ReaderCreatorCzernicki;
import fileCreatorsCzernicki.ReaderProductCzernicki;

public class SportvereineModel {

	private Sportverein sportverein;

	public SportvereineModel() {

	}

	public void nehmeSportvereinAuf(String name, String ort, int anzahlMitglieder, int anzahlEhemaligerMitglieder,
			String[] sportarten) {

		this.sportverein = new Sportverein(name, ort, anzahlMitglieder, anzahlEhemaligerMitglieder, sportarten);

	}

	public void leseAusCsvDatei() throws java.io.IOException {
		ReaderCreatorCzernicki readerCreator = new ConcreteReaderCsvCreatorCzernicki();
		ReaderProductCzernicki readerProduct = readerCreator.factoryMethod();
		String[] zeile = readerProduct.leseAusDatei();
		this.sportverein = new Sportverein(zeile[0], zeile[1], Integer.parseInt(zeile[2]), Integer.parseInt(zeile[3]),
				zeile[4].split("_"));
		readerProduct.schliesseDatei();
	}

	public void leseAusTxtDatei() throws java.io.IOException {
		ReaderCreatorCzernicki readerCreator = new ConcreteReaderTxtCreatorCzernicki();
		ReaderProductCzernicki readerProduct = readerCreator.factoryMethod();
		String[] zeile = readerProduct.leseAusDatei();
		this.sportverein = new Sportverein(zeile[0], zeile[1], Integer.parseInt(zeile[2]), Integer.parseInt(zeile[3]),
				zeile[4].split("_"));
		readerProduct.leseAusDatei();
		readerProduct.schliesseDatei();
	}

	public void schreibeSportvereineInCsvDatei() throws IOException {

		BufferedWriter aus = new BufferedWriter(new FileWriter("SportvereineAusgabe.csv", true));
		aus.write(sportverein.gibSportvereinZurueck(';'));
		aus.close();

	}

	public Sportverein getSportverein() {
		return sportverein;
	}

}
