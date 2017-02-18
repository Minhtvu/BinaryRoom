package gameplay;

import java.awt.Color;
import java.awt.Graphics;

public class BoardCell {
	private int row, column;
	private boolean hallway = true;
	public int deciRep;
	private boolean isAlready = false;
	private final static int WIDTH = 50;
	private final static int HEIGHT = 50;
	
	public BoardCell(int row, int column, int deciRep, String binRep){
		this.row = row;
		this.column = column;
		this.deciRep = deciRep;
	}
	
	public void draw(Graphics g){
		if(hallway){
			g.setColor(Color.WHITE);
			g.fillRect(column*WIDTH, row*HEIGHT, WIDTH, HEIGHT);
			g.setColor(Color.BLUE);
			g.drawRect(column*WIDTH, row*HEIGHT, WIDTH, HEIGHT);
		}
		else{
			if(isAlready)
			{
				g.setColor(Color.GRAY);
			}
			else
			{
				g.setColor(Color.BLACK);
			}
			g.fillRect(column*WIDTH, row*HEIGHT, WIDTH, HEIGHT);
			g.setColor(Color.BLUE);
			g.drawRect(column*WIDTH, row*HEIGHT, WIDTH, HEIGHT);
			g.setColor(Color.YELLOW);
			g.drawString(Integer.toString(deciRep),(int)((column+0.5)*WIDTH),(int)((row+0.5)*HEIGHT));
		}
		
	}
	public boolean isAlready() {
		return isAlready;
	}

	public void setDeciRep(int deciRep) {
		this.deciRep = deciRep;
	}

	public boolean isRoom(){
		return !hallway;
	}
	
	public void setHallway(boolean hallway) {
		this.hallway = hallway;
	}

	public Integer getDecimal() {
		return deciRep;
	}

	public void setIsAlready(boolean b) {
		isAlready = b;
		
	}
	
}
