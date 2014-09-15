package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

import model.ChemicalElement;
import model.PeriodicTable;


public class ChemicalElementPanel extends JButton {
//http://www.ptable.com/Images/tabela%20peri%C3%B3dica.png
	private static final long serialVersionUID = 8984547811410211887L;
	private ChemicalElement element;
	
	public ChemicalElementPanel(ChemicalElement element) {
		this.element = element;
	}
	
	private Color getColor(int r, int g, int b) {
		float[] colorValues = Color.RGBtoHSB(r, g, b, null);
		return Color.getHSBColor(colorValues[0], colorValues[1], colorValues[2]);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		RenderingHints rh = new RenderingHints(
	            RenderingHints.KEY_TEXT_ANTIALIASING,
	            RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		((Graphics2D)g).setRenderingHints(rh);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		Color cor;
		switch (element.getClassification()) {
		case ACTINIDEOS:
			cor = getColor(221, 170, 204);
			break;
		case GASES_NOBRES:
			cor = getColor(85, 247, 247);
			break;
		case METAIS_ALCALINOS:
			cor = getColor(255, 170, 0);
			break;
		case METAIS_DE_TRANSICAO:
			cor = getColor(255, 119, 153);
			break;
		case LANTANIDEOS:
			cor = getColor(255, 170, 136);
			break;
		case METAIS_ALCALINOS_TERROSOS:
			cor = getColor(247, 247, 0);
			break;
		case NAO_METAIS:
			cor = getColor(0, 247, 0);
			break;
		case METAIS_REPRESENTATIVOS:
			cor = getColor(0, 204, 204);
			break;
		case SEMI_METAIS:
			cor = getColor(0, 247, 0);
			break;
		case HALOGENIOS:
			cor = getColor(0, 247, 0);
			break;
		default:
			cor = Color.WHITE;
			break;
		}
		if (element.equals(PeriodicTable.tabela[0])) {
			cor = Color.LIGHT_GRAY;
		}
		g.setColor(cor);
		
		int strokeWidth = (int)((getWidth() > getHeight() ? getHeight() : getWidth()) * 0.07);
		g.fillRect(strokeWidth, strokeWidth, getWidth() - strokeWidth * 2, getHeight() - strokeWidth * 2);
		g.setColor(Color.black);
		g.setFont(new Font(g.getFont().getName(), Font.BOLD, (int)((getWidth() > getHeight() ? getHeight() : getWidth()) * 0.35)));
		g.drawString(""+element.getAtomicNumber(), getWidth() / 2 - g.getFontMetrics().stringWidth(""+element.getAtomicNumber()) / 2, g.getFont().getSize());
		g.setFont(new Font(g.getFont().getName(), Font.BOLD, g.getFont().getSize()));
		g.drawString(element.getSymbol(), getWidth() / 2 - g.getFontMetrics().stringWidth(element.getSymbol()) / 2, g.getFont().getSize() * 2);
		int y = g.getFont().getSize() * 2 + (int)(g.getFont().getSize() * 0.7);
		g.setFont(new Font(g.getFont().getName(), Font.PLAIN, (int)(g.getFont().getSize() * 0.7)));
		g.drawString(element.getName(), getWidth() / 2 - g.getFontMetrics().stringWidth(element.getName()) / 2, y);
	}
	
	public ChemicalElement getElement() { 
		return element;
	}
	
}
