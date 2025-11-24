package fileCreatorsCzernicki;

import java.io.IOException;

public abstract class ReaderProductCzernicki {
	public abstract String[] leseAusDatei() throws IOException;
	public abstract void schliesseDatei() throws IOException;

}
