package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class SportvereineModel {

	private Sportverein sportverein;

	public SportvereineModel() {

	}

	public void nehmeSportvereinAuf(String name, String ort, int anzahlMitglieder, int anzahlEhemaligerMitglieder,
			String[] sportarten) {

		this.sportverein = new Sportverein(name, ort, anzahlMitglieder, anzahlEhemaligerMitglieder, sportarten);

	}

	public void leseAusDatei(String typ) throws java.io.IOException {

		BufferedReader ein = new BufferedReader(new FileReader("Sportverein.csv"));
		String[] zeile = ein.readLine().split(";");
		this.sportverein = new Sportverein(zeile[0], zeile[1], Integer.parseInt(zeile[2]), Integer.parseInt(zeile[3]),
				zeile[4].split("_"));
		ein.close();

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
