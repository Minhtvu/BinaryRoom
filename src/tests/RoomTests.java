package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import gameplay.Board;
import gameplay.GUI;

public class RoomTests {
	static Board board;
	
	@BeforeClass
	public static void init(){
		board = new Board(new GUI());
	}
	
	@Test
	public void test() {
		// Player in a room
		board.getPlayer().setRow(3);
		board.getPlayer().setColumn(2);
		
		assertTrue(board.playerInRoom());
		
		board.getPlayer().setRow(1);
		board.getPlayer().setColumn(8);
		
		assertTrue(board.playerInRoom());
		
		board.getPlayer().setRow(4);
		board.getPlayer().setColumn(16);
		
		assertTrue(board.playerInRoom());
		
		// Not in a room
		board.getPlayer().setRow(1);
		board.getPlayer().setColumn(0);
		
		assertFalse(board.playerInRoom());
	}

}
