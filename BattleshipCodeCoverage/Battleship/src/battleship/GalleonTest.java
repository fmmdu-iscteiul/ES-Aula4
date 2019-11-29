package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GalleonTest {

	Galleon galleon1;
	Galleon galleon2;
	Galleon galleon3;
	Galleon galleon4;
	IPosition pos = new Position(5, 5);
	IPosition pos1 = new Position(0, 0);
	Ship ship;
	Ship ship1;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void init() {
		galleon1 = new Galleon(Compass.EAST, pos);
		galleon2 = new Galleon(Compass.NORTH, pos);
		galleon3 = new Galleon(Compass.SOUTH, pos);
		galleon4 = new Galleon(Compass.WEST, pos);
		ship = galleon1;
		ship1 = new Galleon(Compass.EAST, pos1);
	}

	@Test
	public void testGetSize() {
		assertNotNull(galleon1.getSize());
	}

	@Test
	public void testGalleon() {
		assertNotNull(galleon1);
		assertNotNull(galleon2);
		assertNotNull(galleon3);
		assertNotNull(galleon4);
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("ERROR! invalid bearing for the galleon");
//		assertThat(new Galleon(Compass.ERROR, pos), IllegalArgumentException.class);
//		illegalArgumentException??
	}

	@Test
	public void testShip() {
		assertNotNull(ship);
	}

	@Test
	public void testGetCategory() {
		assertNotNull(ship.getCategory());
	}

	@Test
	public void testGetPosition() {
		assertNotNull(ship.getPosition());
	}

	@Test
	public void testGetBearing() {
		assertNotNull(ship.getBearing());
	}

	@Test
	public void testStillFloating() {
		assertTrue(ship.stillFloating());
		for (IPosition p : ship.positions)
			ship.shoot(p);
		assertFalse(ship.stillFloating());
	}

	@Test
	public void testGetTopMostPos() {
		assertNotNull(ship.getTopMostPos());
	}

	@Test
	public void testGetBottomMostPos() {
		assertNotNull(ship.getBottomMostPos());
	}

	@Test
	public void testGetLeftMostPos() {
		assertNotNull(ship.getLeftMostPos());
	}

	@Test
	public void testGetRightMostPos() {
		assertNotNull(ship1.getRightMostPos());
	}

	@Test
	public void testOccupies() {
		assertTrue(ship.occupies(pos));
		assertFalse(ship.occupies(new Position(10, 10)));
	}

	@Test
	public void testTooCloseTo() {
		IPosition pos_temp = new Position(4,4);
		Ship s = new Galleon(Compass.EAST, pos_temp);
		assertTrue(ship.tooCloseTo(s));
		assertFalse(ship.tooCloseTo(ship1));
	}

	@Test
	public void testGetPositions() {
		assertNotNull(ship.getPositions());
	}

	@Test
	public void testShoot() {
		assertFalse(pos1.isHit());
		ship.shoot(pos1);
		assertTrue(pos1.isHit()); // ?????????????????????????????????????????
	}

	@Test
	public void testToString() {
		assertNotNull(ship.toString());
	}

}
