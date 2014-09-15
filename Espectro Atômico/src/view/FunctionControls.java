package view;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FunctionControls extends JPanel {

	private static final long serialVersionUID = -4558269883065239787L;
	private BlackBodyFunction function;
	private JCheckBox n1Check, n2Check;
	private JRadioButton absorption, emission;
	private JSpinner n1Spin, n2Spin, n1SpinEnd, n2SpinEnd;
	private JPanel n1Spinner, n2Spinner, n1Label, n2Label;
	private JLabel n1l, n2l;
	
	public FunctionControls(BlackBodyFunction function) {
		this.function = function;
		n1Label = new JPanel(new FlowLayout(FlowLayout.LEFT));
		n1l = new JLabel("n1:");
		n1Label.add(n1l);
		n1Check = new JCheckBox("Fixo", true);
		n2Check = new JCheckBox("Fixo");
		ButtonGroup group = new ButtonGroup();
		n1Spin = new JSpinner();
		n2Spin = new JSpinner();
		n1SpinEnd = new JSpinner();
		n2SpinEnd = new JSpinner();
		n1Spinner = new JPanel(new FlowLayout(FlowLayout.LEFT));
		n1Spinner.add(n1Spin);
		n1Spinner.add(n1SpinEnd);
		n2Label = new JPanel(new FlowLayout(FlowLayout.LEFT));
		n2l = new JLabel("n2:");
		n2Label.add(n2l);
		n2Label.add(n2Check);
		group.add(n1Check);
		group.add(n2Check);
		n1Label.add(n1Check);
		n2Spinner = new JPanel(new FlowLayout(FlowLayout.LEFT));
		n2Spinner.add(n2Spin);
		n2Spinner.add(n2SpinEnd);
		emission = new JRadioButton("Emissão", true);
		absorption = new JRadioButton("Absorção");
		emission.setOpaque(false);
		absorption.setOpaque(false);
		emission.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limitSpin();
			}
		});
		absorption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limitSpin();
			}
		});
		ButtonGroup botoes = new ButtonGroup();
		botoes.add(emission);
		botoes.add(absorption);
		this.add(n1Label);
		this.add(n1Spinner);
		this.add(n2Label);
		this.add(n2Spinner);
		this.add(emission);
		this.add(absorption);
		this.setLayout(null);
		n1Label.setLayout(null);
		n2Label.setLayout(null);
		n1Check.setLayout(null);
		n2Check.setLayout(null);
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setOpaque(false);
		n1Label.setOpaque(false);
		n1Check.setOpaque(false);
		n1Spinner.setOpaque(false);
		n2Label.setOpaque(false);
		n2Check.setOpaque(false);
		n2Spinner.setOpaque(false);
		n1Spin.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		n1SpinEnd.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		n2Spin.setModel(new SpinnerNumberModel(2, 2, 99, 1));
		n2SpinEnd.setModel(new SpinnerNumberModel(2, 2, 99, 1));
		n1Spin.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				limitSpin();
			}
		});
		n2Spin.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				limitSpin();
			}
		});
		n1SpinEnd.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				limitSpin();
			}
		});
		n2SpinEnd.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				limitSpin();
			}
		});
		n1Check.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				n1SpinEnd.setEnabled(false);
				n2SpinEnd.setEnabled(true);
				limitSpin();
			}
		});
		n2Check.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				n1SpinEnd.setEnabled(true);
				n2SpinEnd.setEnabled(false);
				limitSpin();
			}
		});
		n1SpinEnd.setEnabled(false);
	}
	
	private boolean isFixing = false;
	private void limitSpin() { 
		if (!isFixing) {
			isFixing = true;
			if (!n1SpinEnd.isEnabled()) {
				n1SpinEnd.setValue(n1Spin.getValue());
			} else {
				int n1Value = (int)n1Spin.getValue();
				int n1EndValue = (int)n1SpinEnd.getValue();
				if (n1Value > n1EndValue) {
					n1SpinEnd.setValue(n1Spin.getValue());
				}
			}
			int n1EndValue = (int)n1SpinEnd.getValue();
			int n2Value = (int)n2Spin.getValue();
			if (n1EndValue >= n2Value) {
				n2Spin.setValue(n1EndValue + 1);
			}
			if (!n2SpinEnd.isEnabled()) {
				n2SpinEnd.setValue(n2Spin.getValue());
			} else {
				n2Value = (int)n2Spin.getValue();
				int n2EndValue = (int)n2SpinEnd.getValue();
				if (n2Value > n2EndValue) {
					n2SpinEnd.setValue(n2Spin.getValue());
				}
			}
			int n11 = (int)n1Spin.getValue();
			int n12 = (int)n1SpinEnd.getValue();
			int n21 = (int)n2Spin.getValue();
			int n22 = (int)n2SpinEnd.getValue();
			boolean absorptionMode = absorption.isSelected();
			function.setLimites(n11, n12, n21, n22, absorptionMode);
			isFixing = false;
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		n1Label.setBounds(0, 0, getWidth(), getHeight() / 4);
		n1Spinner.setBounds(0, getHeight() / 5, getWidth(), getHeight() / 5);
		n2Label.setBounds(0, 2 * getHeight() / 5, getWidth(), getHeight() / 5);
		n2Spinner.setBounds(0, 3 * getHeight() / 5, getWidth(), getHeight() / 5);
		emission.setBounds(0,4*getHeight() / 5, getWidth() / 2, getHeight() / 5);
		absorption.setBounds(getWidth() / 2, 4*getHeight() / 5, getWidth() / 2, getHeight() / 5);
		n1l.setBounds(0, 0, n1Label.getWidth() / 2, n1Label.getHeight());
		n1Check.setBounds(n1Label.getWidth() / 2, 0, n1Label.getWidth()/2, n1Label.getHeight());
		n2l.setBounds(0, 0, n2Label.getWidth() / 2, n2Label.getHeight());
		n2Check.setBounds(n2Label.getWidth() / 2, 0, n2Label.getWidth()/2, n2Label.getHeight());
		n1Spin.setBounds(0, 0, n1Spin.getWidth(), n1Spin.getHeight());
		n1SpinEnd.setBounds(n1Spinner.getWidth() / 2, 0, n1SpinEnd.getWidth(), n1Spin.getHeight());
		n2Spin.setBounds(0, 0, n2Spin.getWidth(), n2Spin.getHeight());
		n2SpinEnd.setBounds(n2Spinner.getWidth() / 2, 0, n2SpinEnd.getWidth(), n2Spin.getHeight());
	}
	
}
