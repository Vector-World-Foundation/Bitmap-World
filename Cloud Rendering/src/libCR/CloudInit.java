package libCR;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CloudInit extends JPanel {
	
	private static final long serialVersionUID = 8199065465323472404L;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color sky = new Color(31, 90, 214);
		this.setBackground(sky);
		g.drawString("Rendering Cloud...", 10, 15);
	}

}
