/**
 * 
 */

package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class MainScreen extends JFrame {

	private static final long serialVersionUID = -801245182128661394L;
	public static final String APP_NAME = "Espectro Atômico";
	public static final String APP_VERSION = "1.0";
	
	private BlackBodyFunction function;
	private PeriodicTablePanel table;
	private FunctionControls controls;
	
	public MainScreen() { 
		initComponents();
		setTitle(APP_NAME + " " + APP_VERSION);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	private void initComponents() { 
		function = new BlackBodyFunction();
		table = new PeriodicTablePanel(function);
		controls = new FunctionControls(function);
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().add(function);
		getContentPane().add(table);
		getContentPane().add(controls);
		
		//menu
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Ajuda");
		JMenuItem itemSobre = new JMenuItem("Sobre");
		itemSobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MainScreen.this, "Criado por:\nAbner Matheus, Daniela Costa, Andreza Raquel e Marcos Antônio\nCampina Grande, UFCG / 2013.2", "Espectro Atômico - Versão 1.0", JOptionPane.PLAIN_MESSAGE);
			}
		});
		menu.add(itemSobre);
		bar.add(menu);
		setJMenuBar(bar);
		
		this.pack();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		function.setBounds(0, 0, getWidth(), getHeight() / 2);
		table.setBounds(0, getHeight() / 2, (int)(getWidth() * 0.7), getHeight() / 2);
		controls.setBounds((int)(getWidth() * 0.7), getHeight() / 2, (int)(getWidth() * 0.3), getHeight() / 4);
	}
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				try {
					new MainScreen().setVisible(true);
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Oops..!", JOptionPane.ERROR_MESSAGE);
					System.exit(ERROR);
				}
			}
		}).start();
	}
	
}
