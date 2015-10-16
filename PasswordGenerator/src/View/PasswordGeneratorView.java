package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.PasswordGeneratorController;

public class PasswordGeneratorView extends JFrame implements ActionListener{
	
	/**
	 * Default Id.
	 */
	private static final long serialVersionUID = 1L;

	private String password;
	
	private PasswordGeneratorController controller;
	
	JButton button;
	JTextField textArea;
	JPanel panel;
	
	public void setUpFrame(){
		this.setTitle("PasswordGenerator");
		this.setSize(400, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		textArea = new JTextField("A Textarea");
		button = new JButton("Generieren");
		button.addActionListener(this);
		panel.add(button);
		panel.add(textArea);
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

}