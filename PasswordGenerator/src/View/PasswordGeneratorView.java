package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Controller.PasswordGeneratorController;

public class PasswordGeneratorView extends JFrame implements ActionListener {

	/**
	 * Default Id.
	 */
	private static final long serialVersionUID = 1L;
	
	static Logger LOG = LoggerFactory.getLogger(PasswordGeneratorView.class);

	private String password;

	private PasswordGeneratorController controller;

	JButton button;
	JTextField textArea;
	JPanel panel;
	JTextField minIntField;
	JTextField maxIntField;

	public void setUpFrame() {
		this.setTitle("PasswordGenerator");
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		textArea = new JTextField("A Textarea");
		minIntField = new JTextField("Min. Länge");
		minIntField.addMouseListener(new MouseAdapter(){
			 @Override
			  public void mouseClicked(MouseEvent e) {
			    minIntField.setText("");
			    repaint();
			  }
		});
		maxIntField = new JTextField("Max. Länge");
		maxIntField.addMouseListener(new MouseAdapter() {
			 @Override
			  public void mouseClicked(MouseEvent e) {
			    maxIntField.setText("");
			    repaint();
			  }
		});
		button = new JButton("Generieren");
		button.addActionListener(this);
		panel.add(new JLabel("Minimale Passwortlänge"));
		panel.add(minIntField);
		panel.add(new JLabel("Maximale Passwortlänge"));
		panel.add(maxIntField);
		panel.add(button);
		panel.add(textArea);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width - this.getWidth()) / 2, (dim.height - this.getHeight()) / 2);

		this.add(panel);
		this.setVisible(true);
	}
	public void repaint() {
		textArea.setText(password);
		panel.repaint();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		controller.viewPasswordRequest();
		PasswordGeneratorController.copy(textArea.getText());
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PasswordGeneratorController getController() {
		return controller;
	}

	public void setController(PasswordGeneratorController controller) {
		this.controller = controller;
	}
	public JTextField getMinIntField() {
		return minIntField;
	}
	public void setMinIntField(JTextField minIntField) {
		this.minIntField = minIntField;
	}
	public JTextField getMaxIntField() {
		return maxIntField;
	}
	public void setMaxIntField(JTextField maxIntField) {
		this.maxIntField = maxIntField;
	}

}