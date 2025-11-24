package fileCreatorsCzernicki;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteReaderTxtProductCzernicki extends ReaderProductCzernicki {
	
	private BufferedReader ein;
	
	

	public ConcreteReaderTxtProductCzernicki() throws FileNotFoundException {
		ein = new BufferedReader(new FileReader("Sportverein.txt"));

	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String[] ergebnisZeile = new String[5];
		String zeile = ein.readLine();
		int i = 0;
		while(i<ergebnisZeile.length) {
			ergebnisZeile[i] = zeile;
			zeile = ein.readLine();
			i++;
		}
		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
	}

}
