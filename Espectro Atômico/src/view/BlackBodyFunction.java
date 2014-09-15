package view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLayeredPane;

import model.ChemicalElement;
import model.SpectralLines;


public class BlackBodyFunction extends JLayeredPane {

	private static final long serialVersionUID = 7433651798981501045L;
	protected CartesianPlane plane;
	private ChemicalElement element;
	private JButton xNext, xPrevious, yNext, yPrevious, zoomPlus, zoomMinus, configurations;
	private int n11 = 1, n12 = 1, n21 = 2, n22 = 2;
	private boolean absorptionMode;
	
	public BlackBodyFunction() {
		plane = new CartesianPlane();
		plane.setOpaque(false);
		xNext = new FunctionButton(">");
		xPrevious = new FunctionButton("<");
		yNext = new FunctionButton("/\\");
		yPrevious = new FunctionButton("\\/");
		configurations = new FunctionButton("...");
		zoomPlus = new FunctionButton("+");
		zoomMinus = new FunctionButton("-");
		xNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				plane.moveXForward();
				repaint();
			}
		});
		xPrevious.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				plane.moveXBackward();
				repaint();
			}
		});
		yNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				plane.moveYForward();
				repaint();
			}
		});
		yPrevious.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				plane.moveYBackward();
				repaint();
			}
		});
		zoomPlus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				plane.zoomPlus();
				repaint();
			}
		});
		zoomMinus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				plane.zoomMinus();
				repaint();
			}
		});
		configurations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new FunctionOptions(BlackBodyFunction.this).setVisible(true);
			}
		});
		add(plane);
		add(xNext);
		add(xPrevious);
		add(yNext);
		add(yPrevious);
		add(configurations);
		add(zoomPlus);
		add(zoomMinus);
		setComponentZOrder(plane, 1);
		setComponentZOrder(xNext, 0);
		setComponentZOrder(xPrevious, 0);
		setComponentZOrder(yNext, 0);
		setComponentZOrder(yPrevious, 0);
		setComponentZOrder(configurations, 0);
		setComponentZOrder(zoomPlus, 0);
		setComponentZOrder(zoomMinus, 0);
	}
	
	public void setChemicalElement(ChemicalElement element) {
		this.element = element;
		try {
			plane.setLinesGenerator(new SpectralLines(element), absorptionMode, n11, n12, n21, n22);
			plane.setLinesGenerator(new SpectralLines(element), absorptionMode, n11, n12, n21, n22);
		} catch(Exception e) { }
	}
	
	public void setLimites(int n11, int n12, int n21, int n22, boolean absorptionMode) {
		this.n11 = n11;
		this.n12 = n12;
		this.n21 = n21;
		this.n22 = n22;
		this.absorptionMode = absorptionMode;
		try {
			plane.setLinesGenerator(new SpectralLines(element), absorptionMode, n11, n12, n21, n22);
			plane.setLinesGenerator(new SpectralLines(element), absorptionMode, n11, n12, n21, n22);
		} catch(Exception e) { }
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		plane.setBounds(0, 0, getWidth(), getHeight());
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (Arrays.toString(plane.getPlaneBounds()).equals("[0, 0, 0, 0]")) {
					
				}
				int[] planeBounds = plane.getPlaneBounds();
				int dx = planeBounds[2] - planeBounds[0];
				int dy = planeBounds[3] - planeBounds[1];
				int buttonBigness = (int)Math.abs(dx > dy ? dy * 0.1 : dx * 0.1);
				xPrevious.setBounds(planeBounds[0] + buttonBigness, planeBounds[1] - buttonBigness, buttonBigness, buttonBigness);
				xNext.setBounds(planeBounds[2] - buttonBigness, planeBounds[1] - buttonBigness, buttonBigness, buttonBigness);
				yNext.setBounds(planeBounds[0], planeBounds[3], buttonBigness, buttonBigness);
				yPrevious.setBounds(planeBounds[0], planeBounds[1] - 2 * buttonBigness, buttonBigness, buttonBigness);
				configurations.setBounds(planeBounds[0], planeBounds[1] - buttonBigness, buttonBigness, buttonBigness);
				zoomPlus.setBounds(planeBounds[2] - buttonBigness, planeBounds[3], buttonBigness, buttonBigness);
				zoomMinus.setBounds(planeBounds[2] - buttonBigness, planeBounds[3] + buttonBigness, buttonBigness, buttonBigness);
			}
		}).start();
		
	}
	
}
