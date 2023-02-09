package it.castelli.ConverterApp;
//<---------- Swing ---------->
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//<---------- AWT ---------->
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener, ChangeListener{
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JSlider slider = new JSlider(0,100,50);  //0 = val minimo - 100 = val massimo - 50 = val di default
	private JButton button = new JButton();
	private JLabel label = new JLabel();
	private JOptionPane alert;
	private ImageIcon icon = new ImageIcon("ConverterAppIcon.PNG");
	
	Window(){
		setSliderProprieties();
		label.setText("°C = " + slider.getValue());
		label.setFont(new Font("MV Boli", Font.PLAIN, 15));
		setButtonProprieties();
		setPanelProprieties();
		setFrameProprieties();
	}
	
	private void setSliderProprieties() {
		slider.setPreferredSize(new Dimension(400,200));
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(10);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(25);
		slider.setPaintLabels(true);
		slider.setFont(new Font("MV Boli", Font.PLAIN, 15));
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.addChangeListener(this);
		slider.setBackground(new Color(102,255,178));
		slider.setVisible(true);
	}
	
	private void setButtonProprieties() {
		//button = new 	JButton("Converti");
		button.setSize(100,30);
		button.setText("Converti");
		button.addActionListener(this);
		button.setVisible(true);
	}
	
	private void setPanelProprieties() {
		panel.add(slider);
		panel.add(label);
		panel.add(button);
		panel.setBackground(new Color(102,255,178));
		panel.setVisible(true);
	}

	private void setFrameProprieties() {
		frame.setTitle("Convertitore di Temperatura: C --> F");
		//frame.setSize(420,420);
		frame.setSize(new Dimension(420,420));
		frame.add(panel);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(icon.getImage());
		frame.setVisible(true);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		label.setText("°C = " + slider.getValue());
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
            double result = (slider.getValue() * 1.8) + 32;
            alert.showMessageDialog(null, slider.getValue() + "°C = " + result + "°F", "ConverterApp", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
