package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import model.ScientificNotation;


public class FunctionOptions extends JFrame {

	private static final long serialVersionUID = 4575540039385146211L;
	private JLabel medida, intervalo, x, y;
	private BlackBodyFunction function;
	private JTextField x0, x1, y0, y1;
	private JRadioButton metros, numero, joule, eletro;
	private JButton concluir;
	
	private void initComponents() { 
		if (!function.plane.meters) {
			x0 = new JTextField(new ScientificNotation(1/function.plane.lowestX).toString());
			x1 = new JTextField(new ScientificNotation(1/function.plane.highestX).toString());
		} else {
			x0 = new JTextField(new ScientificNotation(function.plane.lowestX).toString());
			x1 = new JTextField(new ScientificNotation(function.plane.highestX).toString());
		}
		if (!function.plane.joules) {
			y0 = new JTextField(String.format("%.3f", CartesianPlane.ELETROVOLT * function.plane.lowestY));
			y1 = new JTextField(String.format("%.3f", CartesianPlane.ELETROVOLT * function.plane.highestY));
		} else {
			y0 = new JTextField(new ScientificNotation(function.plane.lowestY).toString());
			y1 = new JTextField(new ScientificNotation(function.plane.highestY).toString());
		}
		x = new JLabel("x:");
		y = new JLabel("y:");
		metros = new JRadioButton("Metros", function.plane.meters);
		metros.setOpaque(false);
		numero = new JRadioButton("Número de onda", !function.plane.meters);
		numero.setOpaque(false);
		ButtonGroup g1 = new ButtonGroup();
		g1.add(metros);
		g1.add(numero);
		joule = new JRadioButton("Joules", function.plane.joules);
		joule.setOpaque(false);
		eletro = new JRadioButton("Elétron-volts", !function.plane.joules);
		eletro.setOpaque(false);
		ButtonGroup g2 = new ButtonGroup();
		g2.add(joule);
		g2.add(eletro);
		medida = new JLabel("Unidades de medida:");
		intervalo = new JLabel("Intervalos:"); 
		concluir = new FunctionButton("OK");
		concluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				double newX0, newX1, newY0, newY1;
				FunctionOptions.this.dispose();
				try {
					newX0 = Double.valueOf(x0.getText());
					newX1 = Double.valueOf(x1.getText());
					newY0 = Double.valueOf(y0.getText().replaceAll(",", "."));
					newY1 = Double.valueOf(y1.getText().replaceAll(",", "."));
				} catch(Exception e) { 
					JOptionPane.showMessageDialog(FunctionOptions.this, "Número inválido", "Oops..", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!function.plane.meters) {
					newX0 = 1 / newX0;
					newX1 = 1 / newX1;
				}
				if (!function.plane.joules) {
					newY0 /= CartesianPlane.ELETROVOLT;
					newY1 /= CartesianPlane.ELETROVOLT;
				}
				if (newX0 > newX1 || newY0 > newY1) {
					JOptionPane.showMessageDialog(FunctionOptions.this, "Intervalo inicial não pode ser maior que o final");
					return;
				}
				function.plane.lowestX = newX0;
				function.plane.highestX = newX1;
				function.plane.lowestY = newY0;
				function.plane.highestY = newY1;
				function.plane.meters = metros.isSelected();
				function.plane.joules = joule.isSelected();
				function.plane.repaint();
			}
		});
		add(x);
		add(y);
		add(concluir);
		add(x0);
		add(x1);
		add(y0);
		add(y1);
		add(metros);
		add(numero);
		add(joule);
		add(eletro);
		add(medida);
		add(intervalo);
		add(new JLabel(""));
		getContentPane().setBackground(Color.WHITE);
	}
	
	public FunctionOptions(BlackBodyFunction function) { 
		this.function = function;
		initComponents();
		setTitle(MainScreen.APP_NAME + " " + MainScreen.APP_VERSION + " - Configurações");
		setSize(250, 245);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		medida.setBounds(0, 0, getWidth(), g.getFont().getSize());
		metros.setBounds(0, g.getFont().getSize() + 10, getWidth() / 2, g.getFont().getSize() + 10);
		numero.setBounds(getWidth() / 2, g.getFont().getSize() + 10, getWidth() / 2, g.getFont().getSize() + 10);
		joule.setBounds(0, g.getFont().getSize() * 2 + 20, getWidth() / 2, g.getFont().getSize() + 10);
		eletro.setBounds(getWidth() / 2, g.getFont().getSize() * 2 + 20, getWidth() / 2, g.getFont().getSize() + 10);
		intervalo.setBounds(0, g.getFont().getSize() * 3 + 30, getWidth(), g.getFont().getSize() + 10);
		x.setBounds(0, g.getFont().getSize() * 4 + 50, 100, 20);
		x0.setBounds(20, g.getFont().getSize() * 4 + 50, 100, 20);
		x1.setBounds(getWidth() / 2, g.getFont().getSize() * 4 + 50, 100, 20);
		y.setBounds(0, g.getFont().getSize() * 4 + 100, 100, 20);
		y0.setBounds(20, g.getFont().getSize() * 4 + 100, 100, 20);
		y1.setBounds(getWidth() / 2, g.getFont().getSize() * 4 + 100, 100, 20);
		concluir.setBounds(0, getHeight() - 30, getWidth(), 30);
		//concluir.repaint();
	}
	
}
