package gameplay;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Schedule extends JPanel{
	private static final long serialVersionUID = 1L;
	private ArrayList<String> binary;
	private ArrayList<Integer> decimal;
	private final static int NUMROOMS = 7; 
	public Schedule(){
        binary = new ArrayList<String>();
        decimal = new ArrayList<Integer>();
		generator();
		setLayout(new GridLayout(0,1));
		add(new JLabel("List of rooms:"));
	}
	private void generator(){
		// Generates 7 random numbers and their binary representation
		Random r = new Random();
		while(decimal.size() < NUMROOMS){
			int temp = r.nextInt(99);
			if(!decimal.contains(temp)){
				decimal.add(temp);
				//binary.add(Integer.toBinaryString(temp));
			}
		}
	}
	public void shuffleDecimal()
	{
		Collections.shuffle(decimal);
		for(Integer s:decimal)
		{
			binary.add(Integer.toBinaryString(s));
		}
		for(String s:binary)
		{
			add(new JLabel(s));
		}
	}
	public void reduceList()
	{
		binary.remove(0);
		decimal.remove(0);
	}
	public ArrayList<String> getBinary() {
		return binary;
	}

	public ArrayList<Integer> getDecimal() {
		return decimal;
	}
}
