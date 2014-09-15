package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import model.ScientificNotation;
import model.SpectralLines;


public class CartesianPlane extends JPanel {

	private enum FontSize { BIG, MEDIUM, SMALL };
	
	private static final long serialVersionUID = -7076299511612096856L;
	private static final int QUANTIFY_OF_VALUES = 10;
	public static final double ELETROVOLT = 6.2415e18;
	private SpectralLines lineGenerator;
	protected double lowestY, highestY, lowestX = 100e-9, highestX = 1000e-9;
	private int x0, y0, x1, y1, initialLevel1, initialLevel2, finalLevel1, finalLevel2;
	private int screenX, screenY;
	private boolean absorptionMode;
	private boolean isOnScreen;
	public boolean joules = false;
	public boolean meters = true;
	
	public CartesianPlane() { 
		/*try {
			setLinesGenerator(new LinhasEspectrais(TabelaPeriodica.tabela[0]), false, 2, 2, 3, 6);
		} catch(Exception e) { }*/
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) { }
			
			@Override
			public void mousePressed(MouseEvent arg0) { }
			
			@Override
			public void mouseExited(MouseEvent arg0) { 
				isOnScreen = false;
				repaint();
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) { 
				isOnScreen = true;
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) { }
		});
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(100);
						if (isOnScreen) {
							repaint();
						}
							
					} catch(Exception e) { }
				}
			}
		}).start();
	}
	
	public void setLinesGenerator(SpectralLines linesGenerator, boolean absorptionMode,
			int initialLevel1, int initialLevel2, int finalLevel1, int finalLevel2) {
		this.lineGenerator = linesGenerator;
		this.absorptionMode = absorptionMode;
		this.initialLevel1 = initialLevel1;
		this.finalLevel1 = finalLevel1;
		this.initialLevel2 = initialLevel2;
		this.finalLevel2 = finalLevel2;
		lowestY = Integer.MAX_VALUE;
		highestY = Integer.MIN_VALUE;
		for (SpectralLinePanel line : lines) {
			remove(line);
		}
		int count = 0;
		for (int i = initialLevel1; i <= initialLevel2; i++) {
			for (int j = finalLevel1; j <= finalLevel2; j++) {
				try {
					double waveLength = linesGenerator.getPosition(i, j);
					double energy = linesGenerator.getEnergy(waveLength);
					int posX = cartesianToPixels(waveLength, 0)[0];
					if (posX >= x0 && posX <= x1) {
						
						if (energy < lowestY) {
							lowestY = energy;
						}
						if (energy > highestY) {
							highestY = energy;
						}
					}
					SpectralLinePanel line = new SpectralLinePanel(this, getWavelengthColor(waveLength, true), waveLength, energy, j);
					line.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {
							((SpectralLinePanel)e.getComponent()).hideTooltip();
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							((SpectralLinePanel)e.getComponent()).showTooltip();
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							
							((SpectralLinePanel)e.getComponent()).isEntered = false;
							((SpectralLinePanel)e.getComponent()).hideTooltip();
							//((SpectralLine)e.getComponent()).repaint();
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							((SpectralLinePanel)e.getComponent()).isEntered = true;
							((SpectralLinePanel)e.getComponent()).repaint();
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
					lines.add(count++, line);
					add(line);
				} catch(Exception e) {
					break;
				}
			}
		}
		setLimitsWaveLength();
		repaint();
	}
	
	public int[] getPlaneBounds() { 
		return new int[]{x0, y0, x1, y1};
	}
	
	public void moveXForward() { 
		double intensity = highestX / lowestX;
		lowestX *= intensity;
		highestX *= intensity;
		repaint();
	}
	
	public void moveXBackward() { 
		double intensity = highestX / lowestX;
		lowestX /= intensity;
		highestX /= intensity;
		repaint();
	}
	
	public void moveYForward() { 
		double intensity = highestY / lowestY;
		lowestY *= intensity;
		highestY *= intensity;
		repaint();
	}
	
	public void moveYBackward() { 
		double intensity = highestY / lowestY;
		lowestY /= intensity;
		highestY /= intensity;
		repaint();
	}
	
	public void zoomPlus() { 
		double intensity = (highestX - lowestX) / 4;
		if (highestX - intensity > lowestX + intensity) {
			lowestX += intensity;
			highestX -= intensity;
		}
		repaint();
	}
	
	public void zoomMinus() { 
		double intensity = (highestX - lowestX) / 4;
		if (lowestX - intensity > 0) {
			lowestX -= intensity;
			highestX += intensity;
		}
		repaint();
	}
	
	private int getFontSize(FontSize size) { 
		switch (size) {
		case BIG:
			return (int)((getWidth() > getHeight() ? getHeight() : getWidth()) * 0.05);
		case SMALL:
			return (int)((getWidth() > getHeight() ? getHeight() : getWidth()) * 0.02);
		default:
			return (int)((getWidth() > getHeight() ? getHeight() : getWidth()) * 0.035);
		}
	}
	
	private void setFontSize(Graphics g, int newSize) {
		g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, newSize));
	}
	
	private void drawAlignedText(Graphics g, String text, int x, int y) {
		g.drawString(text, x - g.getFontMetrics().stringWidth(text) / 2, y - g.getFont().getSize());
	}
	
	private void drawAlignedTextUpward(Graphics2D g2D, String text, int x, int y) {
        AffineTransform orig = g2D.getTransform();
        AffineTransform at = new AffineTransform();
        at.setToRotation(Math.PI / 2.0);
        g2D.setTransform(at);
        drawAlignedText(g2D, text, y, x + g2D.getFont().getSize() / 2);
        g2D.setTransform(orig);
	}
	
	private void drawCartesianPlane(Graphics g) { 
		g.setColor(Color.BLACK);
		setFontSize(g, getFontSize(FontSize.BIG));
		
		if (!meters) {
			drawAlignedText(g, "Número de onda (m    )", getWidth() / 2, getHeight() - g.getFont().getSize() / 2);
			drawAlignedText(g, "-1", getWidth() / 2 + g.getFontMetrics().stringWidth("Número de onda (m") / 2, getHeight() - g.getFont().getSize());
		} else {
			drawAlignedText(g, "Comprimento de onda (m)", getWidth() / 2, getHeight() - g.getFont().getSize() / 2);
		}
		if (!joules) {
			drawAlignedTextUpward((Graphics2D)g, "Elétron-volts (eV)", 0, getHeight() / 2);
		} else {
			drawAlignedTextUpward((Graphics2D)g, "Energia (J)", 0, getHeight() / 2);
		}
		
		g.drawLine(x0, y0, x1, y0);
		g.drawLine(x0, y0, x0, y1);
		
		setFontSize(g, getFontSize(FontSize.MEDIUM));
		int lineBigness = g.getFont().getSize() / 2;
		for (int i = 0; i <= QUANTIFY_OF_VALUES; i++) {
			g.setColor(Color.BLACK);
			String valueX;
			if (!meters) {
				valueX = new ScientificNotation(1/(lowestX + (highestX - lowestX) / QUANTIFY_OF_VALUES * i)).toString();
			} else {
				valueX = new ScientificNotation(lowestX + (highestX - lowestX) / QUANTIFY_OF_VALUES * i).toString();
			}
			String valueY;
			if (!joules) {
				valueY = String.format("%.3f", ELETROVOLT * (lowestY + (highestY - lowestY) / QUANTIFY_OF_VALUES * i));
			} else {
				valueY = new ScientificNotation(lowestY + (highestY - lowestY) / QUANTIFY_OF_VALUES * i).toString();
			}
			
			int valueXPosX = x0 + (x1 - x0) / QUANTIFY_OF_VALUES * i;
			int valueXPosY = y0 +  g.getFont().getSize() * 3;
			int valueYPosX = getFontSize(FontSize.BIG) + 2*g.getFont().getSize();
			int valueYPosY = y0 + (y1 - y0) / QUANTIFY_OF_VALUES * i;
			drawAlignedText(g, valueX, valueXPosX, valueXPosY);
			if (i != 0) {
				g.drawLine(valueXPosX, y0 - lineBigness, valueXPosX, y0 + lineBigness);
				g.drawLine(x0 - lineBigness, valueYPosY, x0 + lineBigness, valueYPosY);
				g.drawString(valueY, valueYPosX, valueYPosY + g.getFont().getSize() / 2);
				if (absorptionMode) {
					g.setColor(Color.LIGHT_GRAY);
				} else {
					g.setColor(Color.DARK_GRAY);
				}
				g.drawLine(valueXPosX, y0, valueXPosX, y1);
				g.drawLine(x0, valueYPosY, x1, valueYPosY);
			}
				
		} 
	}
	
	private int[] cartesianToPixels(double x, double y) { 
		int pixelsX = (int)(x0 + (x - lowestX) / (highestX - lowestX) * (x1 - x0));
		int pixelsY = (int)(y0 + (y - lowestY) / (highestY - lowestY) * (y1 - y0));
		return new int[]{pixelsX, pixelsY};
	}
	
	private double[] pixelsToCartesian(double x, double y) {
		double cartesianX = lowestX + (x - x0) / (x1 - x0) * (highestX - lowestX);
		double cartesianY = lowestY + (y - y0) / (y1 - y0) * (highestY - lowestY);
		return new double[]{cartesianX, cartesianY};
	}
	
	private Color getWavelengthColor(double waveLength, boolean isElement) {
		/*if (!meters) {
			waveLength = 1 / waveLength;
		}*/
		double r = 0, g = 0, b = 0, newWaveLength = waveLength * 1e9;
		double newX1 = highestX * 1e9;
		if (newWaveLength >= 380 && newWaveLength < 410) {
			r = 0.6 - 0.41 * ((newWaveLength - 380) / 30);
			g = 0;
			b = 0.39 + 0.6 * ((newWaveLength - 380) / 30);
		} else if (newWaveLength >= 410 && newWaveLength < 440) { 
			r = 0.19 - 0.19 * ((440 - newWaveLength) / 30);
			g = 0;
			b = 1;
		} else if (newWaveLength >= 440 && newWaveLength < 490) { 
			r = 0;
			g = 1 - ((490 - newWaveLength) / 50);
			b = 1;
		} else if (newWaveLength >= 490 && newWaveLength < 510) { 
			r = 0;
			g = 1; 
			b = (510 - newWaveLength) / 20;
		} else if (newWaveLength >= 510 && newWaveLength < 580) { 
			r = 1 - ((580 - newWaveLength) / 70);
			g = 1;
			b = 0;
		} else if (newWaveLength >= 580 && newWaveLength < 640) {
			r = 1;
			g = (640 - newWaveLength) / 60;
			b = 0;
		} else if (newWaveLength >= 640 && newWaveLength < 700) { 
			r = 1;
			g = 0;
			b = 0;
		} else if (newWaveLength < 380) {
			r = newWaveLength / (380 < newX1 ? 380 : newX1) * 0.39;
			g = 0;
			b = newWaveLength / (380 < newX1 ? 380 : newX1) * 0.6;
			g = 1 - (r + b);
			r = 1 - r;
			b = 1 - b;
		} else if (newWaveLength >= 700) {
			r = 1;
			g = (newWaveLength - 700) / (newX1 - 700);
			b = (newWaveLength - 700) / (newX1 - 700);
		} 
		if (absorptionMode) {
			if (isElement) {
				r = 0;
				g = 0;
				b = 0;
				/*r /= 3;
				g /= 3;
				b /= 3;*/
			}
		} else {
			if (!isElement) {
				r /= 3;
				g /= 3;
				b /= 3;
			}
		}
		float[] color = Color.RGBtoHSB((int)(255*r), (int)(255*g), (int)(255*b), null);
		return Color.getHSBColor(color[0], color[1], color[2]);
	}
	
	private void drawSpectrumLines(Graphics g) { 
		for (int i = x0; i <= x1; i++) {
			g.setColor(getWavelengthColor(pixelsToCartesian(i, 0)[0], false));
			g.drawLine(i, y0, i + 1, y1);
		}
	}
	
	private List<SpectralLinePanel> lines = new ArrayList<>();
	
	private void drawElementLines(Graphics g) {
		/*for (SpectralLine line : lines) {
			remove(line);
		}*/
		int count = 0;
		if (lineGenerator != null) {
			for (int i = initialLevel1; i <= initialLevel2; i++) {
				for (int j = finalLevel1; j <= finalLevel2; j++) {
					try {
						double waveLength = lineGenerator.getPosition(i, j);
						double energy = lineGenerator.getEnergy(waveLength);
						int[] coord = cartesianToPixels(waveLength, energy);
						SpectralLinePanel line = lines.get(count);
						if (coord[0] >= x0 && coord[0] <= x1 && coord[1] <= x0) { 
							line.doDraw(true);
							g.setColor(getWavelengthColor(waveLength, true));
							if (coord[1] < y1) {
								line.setBounds(coord[0], y1, 5, y0 - y1);
								//g.drawLine(coord[0], y1, coord[0], y0);
							} else {
								line.setBounds(coord[0], coord[1], 5, y0 - coord[1]);
								//g.drawLine(coord[0], coord[1], coord[0], y0);
							}
							//lines.add(line);
							//add(line);
							g.setColor(Color.WHITE);
							g.drawString(j+"", coord[0], y0);
						} else {
							line.doDraw(false);
							//line.repaint();
						}
						count++;
					} catch(Exception e) {
						e.printStackTrace();
						break;
					}
					
				}
			}
		}
	}

	private void setLimitsWaveLength() { 
		if (lineGenerator != null) {
			try {
				lowestX = lineGenerator.getPosition(initialLevel1, finalLevel1);
				highestX = lineGenerator.getPosition(initialLevel2, finalLevel2);
			} catch(Exception e) {
				lowestX = 100e-9;
				highestX = 1000e-9;
			}
			lowestX = lowestX - 500 * Math.pow(10, new ScientificNotation(lowestX).getExponent());
			if (lowestX < 0) { 
				lowestX /= -10;
			}
			highestX += 500 * Math.pow(10, new ScientificNotation(highestX).getExponent());
			/*if (!meters) {
				lowestX = 1 / lowestX;
				highestX = 1 / highestX;
			}*/
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		RenderingHints rh = new RenderingHints(
	            RenderingHints.KEY_TEXT_ANTIALIASING,
	            RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		((Graphics2D)g).setRenderingHints(rh);
		
		int fontSize = getFontSize(FontSize.BIG);
		x0 = fontSize * 6;
		x1 = getWidth() - fontSize;
		y0 = getHeight() - fontSize * 4;
		y1 = fontSize;
		
		drawSpectrumLines(g);
		drawCartesianPlane(g);
		drawElementLines(g);
		
		if (!absorptionMode) {
			g.setColor(Color.WHITE);
		} else {
			g.setColor(Color.BLACK);
		}
		if (isOnScreen) {
			
			try {
				screenX = getMousePosition().x;
				screenY = getMousePosition().y;
				if (screenX >= x0 && screenX <= x1 && screenY >= y1 && screenY <= y0) {
					double[] cartesian = pixelsToCartesian(screenX, screenY);
					String valueX;
					if (!meters) {
						valueX = new ScientificNotation(1/cartesian[0]).toString();
					} else {
						valueX = new ScientificNotation(cartesian[0]).toString();
					}
					String valueY;
					if (!joules) {
						valueY = String.format("%.3f", ELETROVOLT * cartesian[1]);
					} else {
						valueY = new ScientificNotation(cartesian[1]).toString();
					}
					setFontSize(g, getFontSize(FontSize.MEDIUM));
					g.drawString("(" +  valueX + ", " + valueY + ")", screenX, screenY);
				}
			} catch(Exception e) { }
		}
	}
	
}
