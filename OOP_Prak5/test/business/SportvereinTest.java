package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.businessSportverein.Sportverein;

class SportvereinTest {
	
	private Sportverein sportverein;

	@BeforeEach
	void setUp() throws Exception {
		sportverein = new Sportverein("Gymnastikverein 99", "Bochum", 167, 69, new String[] {"Turnen", "Gymnastik"});
	}

	@AfterEach
	void tearDown() throws Exception {
		this.sportverein = null;
	}

	@Test
	void test() {
		assertTrue(() -> this.sportverein.getOrt() == "Bochum", "Muss True ausgeben");
		
		Throwable exc = assertThrows(IllegalArgumentException.class, () -> {new Sportverein("Gymnastikverein 99", "Bochum", 167, 69, null);});
		assertNotEquals("null", exc.getMessage());
		
	}

}