package fileCreatorsCzernicki;

import java.io.FileNotFoundException;

public abstract class ReaderCreatorCzernicki {
	public abstract ReaderProductCzernicki factoryMethod() throws FileNotFoundException;

}
