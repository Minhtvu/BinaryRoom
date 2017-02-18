package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import gameplay.Board;
import gameplay.GUI;

public class KeyPressedTests {
	static Board board;
	
	@BeforeClass
	public static void init(){
		board = new Board(new GUI());
	}
	
	@Test
	public void test() {
		if (board.isKeyTest())
		{
			assertEquals(board.getMoveChoice(), Board.Direction.UP);
		}
	}

	
	@Test
	public void moveTests(){
		board.getPlayer().setRow(5);
		board.getPlayer().setColumn(4);
		
		board.setMoveChoice(Board.Direction.UP);
		board.movePlayer();
		assertEquals(4, board.getPlayer().getRow());
		assertEquals(4, board.getPlayer().getColumn());
		
		board.setMoveChoice(Board.Direction.DOWN);
		board.movePlayer();
		assertEquals(5, board.getPlayer().getRow());
		assertEquals(4, board.getPlayer().getColumn());
		
		board.setMoveChoice(Board.Direction.LEFT);
		board.movePlayer();
		assertEquals(5, board.getPlayer().getRow());
		assertEquals(3, board.getPlayer().getColumn());
		
		board.setMoveChoice(Board.Direction.RIGHT);
		board.movePlayer();
		assertEquals(5, board.getPlayer().getRow());
		assertEquals(4, board.getPlayer().getColumn());
	}
}
