package view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.ChemicalElement;
import model.PeriodicTable;


public class PeriodicTablePanel extends JPanel {

	private static final long serialVersionUID = 2976253493187321715L;
	private ChemicalElementPanel[] elements = new ChemicalElementPanel[PeriodicTable.tabela.length];
	private BlackBodyFunction function;

	public PeriodicTablePanel(BlackBodyFunction function) { 
		this.function = function;
		for (int i = 0; i < elements.length; i++) {
			final int j = i;
			elements[i] = new ChemicalElementPanel(PeriodicTable.tabela[i]);
			elements[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					setChemicalElement(elements[j].getElement());
				}
			});
			add(elements[i]);
		}
		setOpaque(false);
	}

	private void setChemicalElement(ChemicalElement element) {
		function.setChemicalElement(element);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int elementWidth = getWidth() / 20;
		int elementHeight = getHeight() / 13;
		for (int i = 0; i < elements.length; i++) {
			int x = elements[i].getElement().getColumn() * elementWidth;
			int y = elements[i].getElement().getLines() * elementHeight;
			elements[i].setBounds(x, y, elementWidth, elementHeight);
		}
	}
}
