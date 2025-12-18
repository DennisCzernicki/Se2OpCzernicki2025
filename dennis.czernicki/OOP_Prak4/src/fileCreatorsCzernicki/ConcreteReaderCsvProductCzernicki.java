package fileCreatorsCzernicki;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteReaderCsvProductCzernicki extends ReaderProductCzernicki {
	
	private BufferedReader ein;

	public ConcreteReaderCsvProductCzernicki() throws FileNotFoundException {
		ein = new BufferedReader(new FileReader("Sportverein.csv"));

	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String[] zeile = ein.readLine().split(";");
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
	}

}
