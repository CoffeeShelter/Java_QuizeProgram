package quizeprogram.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setSize(100,100);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		setOpaque(false);
	}
}
