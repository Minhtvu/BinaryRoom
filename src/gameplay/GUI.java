package gameplay;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class GUI extends JFrame implements KeyListener{
	private static Board map;
	private JMenuBar menu;
	private BinaryHelp helper = new BinaryHelp();
	private JDialog gamerules;
	public GUI()
	{
		setTitle("Bin goes to school!");
		setSize(1110, 1040);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		map = new Board(this);
		add(map,BorderLayout.CENTER);
		add(map.getSchedule(),BorderLayout.EAST);
		addKeyListener(this);
		menu = new JMenuBar();
		setJMenuBar(menu);
		menu.add(createMenu());
		gamerules = createGameRules();
	}
	private JDialog createGameRules()
	{
		JDialog instance = new JDialog();
		instance.setSize(440,400);
		instance.setLayout(new GridLayout(6,0));
		instance.setTitle("Game rules");
		instance.add(new JLabel("Welcome to High School, Bin!"));
		instance.add(new JLabel("Your schedule is printed on the right hand of the screen in binary."));
		instance.add(new JLabel("But this is high school now, and the classrooms are in decimal!"));
		instance.add(new JLabel("Find your way to each classroom in the order on the right (top to bottom)."));
		instance.add(new JLabel("Use the arrow keys to move around the school!"));
		instance.add(new JLabel("Good luck!"));
		return instance;
	}
	private JMenu createMenu()
	{
		JMenu instance = new JMenu("Miracle");
		instance.add(createBinaryHelper());
		instance.add(createManual());
		return instance;
	}
	private JMenuItem createBinaryHelper()
	{
		JMenuItem instance = new JMenuItem("Binary Helper");
		class ImageListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				helper.setVisible(true);
				helper.repaint();
			}
		}
		instance.addActionListener(new ImageListener());
		return instance;
	}
	private JMenuItem createManual()
	{
		JMenuItem instance = new JMenuItem("Game Rules");
		class ImageListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				gamerules.setVisible(true);
			}
		}
		instance.addActionListener(new ImageListener());
		return instance;
	}
	public static void main(String[] args){
		GUI temp = new GUI();
		temp.setVisible(true);
		JOptionPane.showMessageDialog(temp, "Welcome to High School, Bin!\nYour schedule is printed on the right hand of the screen in binary.\nBut this is high school now, and the classrooms are in decimal!\nFind your way to each classroom in the order on the right (top to bottom).\nUse the arrow keys to move around the school!\nGood luck!");
	}


	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("almost done for the semester");
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			//System.out.println("go up");
			map.setMoveChoice(Board.Direction.UP);
			map.movePlayer();
			repaint();
			break;
		case KeyEvent.VK_LEFT:
			//System.out.println("go left");
			map.setMoveChoice(Board.Direction.LEFT);
			map.movePlayer();
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
			//System.out.println("go right");
			map.setMoveChoice(Board.Direction.RIGHT);
			map.movePlayer();
			repaint();
			break;
		case KeyEvent.VK_DOWN:
			//System.out.println("go down");
			map.setMoveChoice(Board.Direction.DOWN);
			map.movePlayer();
			repaint();
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
}
