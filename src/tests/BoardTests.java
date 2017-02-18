package tests;
import static org.junit.Assert.*;

import org.junit.BeforeClass;

import gameplay.*;

import org.junit.Test;

public class BoardTests {
	static Board board;
	private final static int NUMROWS = 20;
	private final static int NUMCOLUMNS = 20;
	
	@BeforeClass
	public static void init(){
		board = new Board(new GUI());
		
	}
	
	@Test
	public void setUpTest() {
		assertEquals(NUMROWS, board.getNumRows());
		assertEquals(NUMCOLUMNS, board.getNumCols());
	}

	@Test
	public void layoutTests(){
		// Tests that the 7 rooms are in the right place
		
		assertTrue((board.getMap())[3][2].isRoom());
		assertTrue((board.getMap())[1][8].isRoom());
		assertTrue((board.getMap())[4][16].isRoom());
		assertTrue((board.getMap())[15][7].isRoom());
		assertTrue((board.getMap())[16][10].isRoom());
		assertTrue((board.getMap())[10][14].isRoom());
		assertTrue((board.getMap())[16][18].isRoom());
		
		// Tests that hallways don't return as rooms
		assertFalse((board.getMap())[5][9].isRoom());
	}
	
	@Test
	public void playerPostiion(){
		// Tests that the player starts in the right place
		assertEquals(1, board.getPlayer().getRow());
		assertEquals(0, board.getPlayer().getColumn());
	}
}
