package fileCreatorsCzernicki;

import java.io.FileNotFoundException;

public class ConcreteReaderCsvCreatorCzernicki extends ReaderCreatorCzernicki {

	@Override
	public ReaderProductCzernicki factoryMethod() throws FileNotFoundException {
		return new ConcreteReaderCsvProductCzernicki();
	}

}
