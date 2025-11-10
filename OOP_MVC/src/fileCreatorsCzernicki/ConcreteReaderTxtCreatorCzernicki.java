package fileCreatorsCzernicki;

import java.io.FileNotFoundException;

public class ConcreteReaderTxtCreatorCzernicki extends ReaderCreatorCzernicki {

	@Override
	public ReaderProductCzernicki factoryMethod() throws FileNotFoundException {

		return new ConcreteReaderTxtProductCzernicki();
	}

}
