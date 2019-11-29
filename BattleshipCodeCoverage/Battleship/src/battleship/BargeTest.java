package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BargeTest {

	Barge barge;
	Compass compass = Compass.NORTH;
	IPosition pos = new Position(10, 10);

	@Before
	public void init() {
		barge = new Barge(compass, pos);
	}

	@Test
	public void testGetSize() {
		assertNotNull(barge.getSize());
	}

	@Test
	public void testBarge() {
		assertNotNull(barge);
	}

}