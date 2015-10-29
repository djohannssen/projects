package de.johannssen.hh.pwgenerator.frontend.impl;

import de.johannssen.hh.pwgenerator.frontend.api.IMainView;
import de.johannssen.hh.pwgenerator.model.InputCredencials;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application implements IMainView{
	
	private InputCredencials input;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InputCredencials getInputCredentials() {
		return input;
	}

}
