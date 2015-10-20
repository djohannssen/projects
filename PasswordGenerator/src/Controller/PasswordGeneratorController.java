package Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Model.PasswordGenerator;
import View.PasswordGeneratorView;

public class PasswordGeneratorController {
	
	static Logger LOG = LoggerFactory.getLogger(PasswordGeneratorController.class);

	PasswordGeneratorView view = new PasswordGeneratorView();
	PasswordGenerator model = new PasswordGenerator();

	public void viewPasswordRequest() {
		String password;
		password = model.generatePassword();
		view.setPassword(password);
		view.repaint();
	}

	public void initiateView() {
		view.setUpFrame();
	}

	public void initiate() {
		initiateView();
		view.setController(this);
		model.setController(this);

	}

	public int getMaxPasswordLength() {
		int max;
		try {
			max = Integer.parseInt(view.getMaxIntField().getText());
		} catch (NumberFormatException e) {
			max = 30;
			LOG.error("NumberFormatException max int " + e.getMessage());
		}
		if (max == (int) max && max > 0) {
			return max;
		} else {
			LOG.error("Min war kein Int oder kleiner 0");
		}
		return 30;
	}

	public int getMinPasswordLength() {
		int min;
		try {
			min = Integer.parseInt(view.getMinIntField().getText());
		} catch (NumberFormatException e) {
			min = 20;
			LOG.error("NumberFormatException min int " + e.getMessage());
		}
		if (min == (int) min && min > 0) {
			return min;
		} else {
			LOG.error("Min war kein int oder kleiner 0");

		}
		return 20;
	}
}
