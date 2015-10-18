package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.PasswordGeneratorController;

public class PasswordGeneratorView extends JFrame implements ActionListener {

	/**
	 * Default Id.
	 */
	private static final long serialVersionUID = 1L;

	private String password;

	private PasswordGeneratorController controller;

	JButton button;
	JTextField textArea;
	JPanel panel;

	public void setUpFrame() {
		this.setTitle("PasswordGenerator");
		this.setSize(400, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		textArea = new JTextField("A Textarea");
		textArea.addMouseListener(new MouseAdapter() {
			 @Override
			  public void mouseClicked(MouseEvent e) {
				 copy(textArea.getText());
				 System.out.println(textArea.getText());
			    textArea.setText("Passwort in Zwischenablage");
			  }
			});

		button = new JButton("Generieren");
		button.addActionListener(this);
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
	}

	public static void copy(String text) {
		Clipboard clipboard = getSystemClipboard();

		clipboard.setContents(new StringSelection(text), null);
	}

	private static Clipboard getSystemClipboard() {
		Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
		Clipboard systemClipboard = defaultToolkit.getSystemClipboard();

		return systemClipboard;
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