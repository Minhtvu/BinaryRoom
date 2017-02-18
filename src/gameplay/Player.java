package gameplay;
import java.awt.Color;
import java.awt.Graphics;

public class Player {
	private int row, column;
	private final static int WIDTH = 50;
	private final static int HEIGHT = 50;
	
	public Player(int row, int column){
		this.row = row;
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(column*WIDTH, row*HEIGHT, WIDTH, HEIGHT);
	}
}
