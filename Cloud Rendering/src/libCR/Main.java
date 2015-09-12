package libCR;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Main {
	
	public static int cloudSize = 0;
	
	public static int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int) ((Math.random() * range) + min);
	}

	public static void main(String[] args) {
		boolean done = false;
		String cloudSizeRaw;
		while (done == false) {
			cloudSizeRaw = JOptionPane.showInputDialog("Enter size of cloud (\"r\" for random)").toString();
			done = cloudSizeRaw.equals("") ? false : true;
			if (cloudSizeRaw.equals("r")) {
				cloudSize = randomWithRange(240, 720);
			} else if(done == true) {
				cloudSize = Integer.parseInt(cloudSizeRaw);
			}
		}
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CloudPainter cloud = new CloudPainter();
		CloudInit preOps = new CloudInit();
		
		window.add(preOps);
		window.add(cloud);
		window.setSize(720, 480);
		window.setVisible(true);
		ImageIcon icon = new ImageIcon("pictures/clouds icon.png");
		window.setIconImage(icon.getImage());
		window.setTitle("Cloud Renderer (v.1.0)");
		window.setLocation(323, 144);
	}

}
