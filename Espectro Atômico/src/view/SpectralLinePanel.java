package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.ScientificNotation;


public class SpectralLinePanel extends JPanel {

	private static final long serialVersionUID = 8218974488145888090L;
	private CartesianPlane parent;
	private Color color;
	private double waveLength, energy;
	private int number;
	public boolean isEntered;
	private boolean showTooltip, doDraw;
	
	public SpectralLinePanel(CartesianPlane parent, Color color, double waveLength, double energy, int number) {
		this.parent = parent;
		this.color = color;
		this.waveLength = waveLength;
		this.energy = energy;
		this.number = number;
		setOpaque(false);
	}
	
	public void showTooltip() { 
		showTooltip = true;
		repaint();
	}
	
	public void hideTooltip() { 
		showTooltip = false;
		//repaint();
		parent.repaint();
	}
	
	public void doDraw(boolean doIt) {
		doDraw = doIt;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (doDraw) {
			if (isEntered) {
				g.setColor(Color.WHITE);
				//g.setColor(color.brighter().brighter().brighter());
			} else {
				g.setColor(color);
			}
			g.fillRect(0, 0, (int)(getWidth() / 5), getHeight());
			if (showTooltip) {
				Graphics g2 = parent.getGraphics();
				int strokeWidth = 1;
				int boxX = getLocation().x + strokeWidth;
				int boxY = parent.getMousePosition().y + strokeWidth;
				int boxWidth = g2.getFontMetrics().stringWidth("Comprimento de onda:    " + new ScientificNotation(waveLength).toString()) - strokeWidth * 2;
				int boxHeight = g2.getFont().getSize() * 4 - strokeWidth * 2;
				g2.setColor(Color.BLACK);
				g2.fillRect(boxX - strokeWidth, boxY - strokeWidth, boxWidth + 2 * strokeWidth, boxHeight + 2 * strokeWidth);
				g2.setColor(Color.WHITE);
				g2.fillRect(boxX, boxY, boxWidth, boxHeight);
				g2.setColor(Color.BLACK);
				g2.drawString("Numero da linha: " + number, boxX + 5 * strokeWidth, boxY + g2.getFont().getSize());
				if (!parent.meters) {
					g2.drawString("Numero de onda: " + new ScientificNotation(1/waveLength).toString(), boxX + 5 * strokeWidth, boxY + 2 * g2.getFont().getSize());
				} else {
					g2.drawString("Comprimento de onda: " + new ScientificNotation(waveLength).toString(), boxX + 5 * strokeWidth, boxY + 2 * g2.getFont().getSize());
				}
				if (!parent.joules) {
					g2.drawString("Elétron-volts: " + String.format("%.3f", CartesianPlane.ELETROVOLT * energy), boxX + 5 * strokeWidth, boxY + 3 * g2.getFont().getSize());
				} else {
					g2.drawString("Joules: " + new ScientificNotation(energy).toString(), boxX + 5 * strokeWidth, boxY + 3 * g2.getFont().getSize());
				}
			}
		}
	}
	
}
