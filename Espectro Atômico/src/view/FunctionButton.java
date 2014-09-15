package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class FunctionButton extends JButton {

	private static final long serialVersionUID = -6333664793255443487L;
	private String text;
	
	public FunctionButton(String text) {
		this.text = text;
	}

	private void drawAlignedText(Graphics g, String text, int x, int y) {
		g.drawString(text, x - g.getFontMetrics().stringWidth(text) / 2, y + g.getFont().getSize() / 2);
	}

	private void setFontSize(Graphics g, int newSize) {
		g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, newSize));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		RenderingHints rh = new RenderingHints(
	            RenderingHints.KEY_TEXT_ANTIALIASING,
	            RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		((Graphics2D)g).setRenderingHints(rh);
		int strokeWidth = (int)((getWidth() > getHeight() ? getHeight() : getWidth()) * 0.05);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.WHITE);
		g.fillRect(strokeWidth, strokeWidth, getWidth() - 2*strokeWidth, getHeight() - 2*strokeWidth);
		setFontSize(g, (int)((getWidth() > getHeight() ? getHeight() : getWidth()) * 0.4));
		g.setColor(Color.BLACK);
		drawAlignedText(g, text, getWidth() / 2, getHeight() / 2);
	}
	
}
