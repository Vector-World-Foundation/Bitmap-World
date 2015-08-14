package libCR;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CloudPainter extends JPanel {

	private static final long serialVersionUID = -4664013610056707507L;
	
	public void clearArea(Graphics g, Color bg, int startX, int startY, int endX, int endY) {
		g.setColor(bg);
		g.fillRect(startX, startY, endX, endY);
		g.setColor(Color.BLACK);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color sky = new Color(135, 206, 235);
		int loops = 0;
		int secondaryLoops = 0;
		int xPos = 360 - (Main.cloudSize / 2);
		int yPos = 240 + (Main.cloudSize / 4);
		int colorR = Main.randomWithRange(0, 128), colorG = colorR, colorB = colorR;
		int colorMin = 0;
		int colorMax = 128;
		int firstColor = colorR;
		int rand = Main.randomWithRange(5, 10);
		int firstR = rand;
		int minHeight = 10;
		int maxHeight = Main.cloudSize / 2;
		
		while(secondaryLoops < Main.cloudSize) {
			while(loops < Main.randomWithRange(minHeight, maxHeight)) {
				colorMin = colorR;
				g.setColor(new Color(colorR, colorG, colorB));
				g.fillOval(xPos, yPos, rand, rand);
				yPos -= rand / 2;
				colorMax += 128 / ((Main.cloudSize / 2) / rand);
				if (colorMax > 255) {
					colorMax = 255;
				}
				colorR += rand;
				colorG = colorR;
				colorB = colorR;
				if (colorR > colorMax) {
					colorR = colorMax;
					colorG = colorMax;
					colorB = colorMax;
				} else if (colorR < colorMin) {
					colorR = colorMin;
					colorG = colorMin;
					colorB = colorMin;
				}
				loops += (rand / 2);
				rand = Main.randomWithRange(5 + (5 - (5 * (loops / (Main.cloudSize / 2)))), 10 - (5 * (loops / (Main.cloudSize / 2))));
				if (rand > 10) {
					rand = 10;
				} else if (rand < 5) {
					rand = 5;
				}
			}
			
			xPos += (firstR / 2);
			yPos = 240 + (Main.cloudSize / 4);
			colorMax = 128;
			colorMin = firstColor;
			colorR = colorMin;
			colorG = colorMin;
			colorB = colorMin;
			loops = 0;
			secondaryLoops += (firstR / 2);
		}
		
		clearArea(g, sky, 0, 0, 112, 20);
		g.drawString("Done!", 10, 15);
	}
}
