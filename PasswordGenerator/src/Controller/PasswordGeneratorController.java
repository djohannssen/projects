package Controller;

import Model.PasswordGenerator;
import View.PasswordGeneratorView;

public class PasswordGeneratorController {

	PasswordGeneratorView view = new PasswordGeneratorView();
	PasswordGenerator model = new PasswordGenerator();
	
	public void viewPasswordRequest(){
		String password;
		password = model.generatePassword();
		view.setPassword(password);
		view.repaint();
	}
	
	public void initiateView(){
		view.setUpFrame();
	}

	public void initiate() {
		initiateView();
		view.setController(this);
		model.setController(this);
		
	}
}
