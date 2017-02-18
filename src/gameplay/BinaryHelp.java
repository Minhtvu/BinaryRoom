package gameplay;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class BinaryHelp extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;

	public BinaryHelp(){
		setTitle("Binary Helper");
		setSize(700,625);
		add(new BinPic());
	}
	
	class BinPic extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
//		private BufferedImage image;

		public BinPic(){
			MediaTracker tracker = new MediaTracker(this);
			URL url = getClass().getResource("/data/binhelp.png");
			image = Toolkit.getDefaultToolkit().getImage(url);
			tracker.addImage(image, 0);
			
			try{
//				image = ImageIO.read(new File("/data/binhelp.png"));
				tracker.waitForID(0);
			}
//			catch(IOException e){
//				System.out.println("Whoops, no picture help file");
//			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Whoops, something interrupted the program!");
			}

		}

		protected void paintComponent(Graphics g){
			super.paintComponents(g);
			g.drawImage(image, 0, 0, null);
		}
	}
}
