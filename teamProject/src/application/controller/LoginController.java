/**
 * LoginController.java acts as the controller for the Login.fxml view. It handles creating a new user and logging in to an existing profile.
 * 
 * @author Ashley Nordquist (dbb246)
 * UTSA CS 3443 - Lab 5
 * Fall 2021
 * 
 * VERSION 2.0 - UPDATED 11/27/2021
 */
package application.controller;

import java.io.IOException;

import application.Main;
import application.model.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
	
	//New login
	Login newLogin = new Login();
	
	@FXML AnchorPane mainPane;
	@FXML TextField usernameInput;
	@FXML PasswordField passwordInput;
	@FXML Button createUserBtn;
	@FXML Button logInBtn;
	@FXML Label incorrectLogin;
	
    public LoginController() {
    	//Do nothing
    }
    
    public void handle(ActionEvent event) {
    	//Something
    }
    
    //Creates a new user and writes it to the csv file
    public void createUser(ActionEvent event) throws IOException {
    	newLogin.createUser(usernameInput.getText(), passwordInput.getText());
    	
    	//Switch scenes to main scene	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation( Main.class.getResource("controller/Main.fxml") );
    	mainPane = (AnchorPane) loader.load();
    	
    	MainController controller = loader.getController();
		controller.getUserInfo(newLogin);
    	
    	Scene scene = new Scene(mainPane);				
    	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	stage.setScene(scene);
    }
    
    //Logs an existing user into the fitness application
    public void logIn(ActionEvent event) throws IOException {
    	if(newLogin.validateUser(usernameInput.getText(), passwordInput.getText()) != 0) {
    		incorrectLogin.setText("Incorrect Login Credentials");
    	}
    	else {
    		//Switch scenes to main scene
    		FXMLLoader loader = new FXMLLoader();
        	loader.setLocation( Main.class.getResource("controller/Main.fxml") );
        	mainPane = (AnchorPane) loader.load();
        	
        	MainController controller = loader.getController();
    		controller.getUserInfo(newLogin);
        	
        	Scene scene = new Scene(mainPane);				
        	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        	stage.setScene(scene);
    	}
    }
    
    /**
	 * @return the newLogin
	 */
	public Login getNewLogin() {
		return newLogin;
	}

	/**
	 * @param newLogin the newLogin to set
	 */
	public void setNewLogin(Login newLogin) {
		this.newLogin = newLogin;
	}

	/**
	 * @return the mainPane
	 */
	public AnchorPane getMainPane() {
		return mainPane;
	}

	/**
	 * @param mainPane the mainPane to set
	 */
	public void setMainPane(AnchorPane mainPane) {
		this.mainPane = mainPane;
	}

	/**
	 * @return the usernameInput
	 */
	public TextField getUsernameInput() {
		return usernameInput;
	}

	/**
	 * @param usernameInput the usernameInput to set
	 */
	public void setUsernameInput(TextField usernameInput) {
		this.usernameInput = usernameInput;
	}

	/**
	 * @return the passwordInput
	 */
	public PasswordField getPasswordInput() {
		return passwordInput;
	}

	/**
	 * @param passwordInput the passwordInput to set
	 */
	public void setPasswordInput(PasswordField passwordInput) {
		this.passwordInput = passwordInput;
	}

	/**
	 * @return the createUserBtn
	 */
	public Button getCreateUserBtn() {
		return createUserBtn;
	}

	/**
	 * @param createUserBtn the createUserBtn to set
	 */
	public void setCreateUserBtn(Button createUserBtn) {
		this.createUserBtn = createUserBtn;
	}

	/**
	 * @return the logInBtn
	 */
	public Button getLogInBtn() {
		return logInBtn;
	}

	/**
	 * @param logInBtn the logInBtn to set
	 */
	public void setLogInBtn(Button logInBtn) {
		this.logInBtn = logInBtn;
	}

	/**
	 * @return the incorrectLogin
	 */
	public Label getIncorrectLogin() {
		return incorrectLogin;
	}

	/**
	 * @param incorrectLogin the incorrectLogin to set
	 */
	public void setIncorrectLogin(Label incorrectLogin) {
		this.incorrectLogin = incorrectLogin;
	}
    
}
