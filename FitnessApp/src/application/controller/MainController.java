/**
 * MainController.java acts as the controller for the Main.fxml view. It handles displaying the current user and switching scenes between the profile, BMI calculator, work out plans, and diet plans.
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author ashle
 *
 */
public class MainController {
	
	Login userLogins;
	
	@FXML AnchorPane mainPane;
	@FXML Button logOutBtn;
	@FXML Button profileBtn;
	@FXML Button bmiCalcBtn;
	@FXML Button workoutBtn;
	@FXML Button dietBtn;
	@FXML Label currUser;
	
	public MainController() {
		//Do nothing
    }
    
    public void handle(ActionEvent event) {
    	//Something
    }
    
    //Displays the current user
    public void setCurrUser(String username) {
    	currUser.setText("Current User: " + username);
    }
    
    //Gets the current user array
    public void getUserInfo(Login login) {
        userLogins = login;
        currUser.setText("Current User: " + userLogins.getCurrUser());
    }
    
    //Switch scenes back to Login.fxml
    public void logOut(ActionEvent event) throws IOException {
    	//Switch scenes back to Login scene
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation( Main.class.getResource("controller/Login.fxml") );
    	mainPane = (AnchorPane) loader.load();
    	Scene scene = new Scene(mainPane);				
    	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	stage.setScene(scene);
    }
    
    //Switch scenes to the Profile.fxml
    public void viewProfile(ActionEvent event) throws IOException {
    	//Switch scenes back to Login scene
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation( Main.class.getResource("controller/Profile.fxml") );
    	mainPane = (AnchorPane) loader.load();
    	ProfileController controller = loader.getController();
		controller.getUserInfo(userLogins);
    	Scene scene = new Scene(mainPane);				
    	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	stage.setScene(scene);
    }
    
    //Switch scenes to the BMI.fxml
    public void viewBMI(ActionEvent event) throws IOException {
    	//Switch scenes back to Login scene
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation( Main.class.getResource("controller/BMI.fxml") );
    	mainPane = (AnchorPane) loader.load();
    	bmiController controller = loader.getController();
		controller.getUserInfo(userLogins);
    	Scene scene = new Scene(mainPane);				
    	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	stage.setScene(scene);
    }
    
    //Switch scenes to the Workouts.fxml
    public void viewWorkouts(ActionEvent event) throws IOException {
    	//Switch scenes back to Login scene
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation( Main.class.getResource("controller/Workouts.fxml") );
    	mainPane = (AnchorPane) loader.load();
    	WorkoutsController controller = loader.getController();
		controller.getUserInfo(userLogins);
    	Scene scene = new Scene(mainPane);				
    	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	stage.setScene(scene);
    }
    
    //Switch scenes to the Diets.fxml
    public void viewDiet(ActionEvent event) throws IOException {
    	//Switch scenes back to Login scene
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation( Main.class.getResource("controller/Diets.fxml") );
    	mainPane = (AnchorPane) loader.load();
    	DietController controller = loader.getController();
    	controller.getUserInfo(userLogins);
    	Scene scene = new Scene(mainPane);				
    	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	stage.setScene(scene);
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
	 * @return the logOutBtn
	 */
	public Button getLogOutBtn() {
		return logOutBtn;
	}

	/**
	 * @param logOutBtn the logOutBtn to set
	 */
	public void setLogOutBtn(Button logOutBtn) {
		this.logOutBtn = logOutBtn;
	}

	/**
	 * @return the profileBtn
	 */
	public Button getProfileBtn() {
		return profileBtn;
	}

	/**
	 * @param profileBtn the profileBtn to set
	 */
	public void setProfileBtn(Button profileBtn) {
		this.profileBtn = profileBtn;
	}

	/**
	 * @return the bmiCalcBtn
	 */
	public Button getBmiCalcBtn() {
		return bmiCalcBtn;
	}

	/**
	 * @param bmiCalcBtn the bmiCalcBtn to set
	 */
	public void setBmiCalcBtn(Button bmiCalcBtn) {
		this.bmiCalcBtn = bmiCalcBtn;
	}

	/**
	 * @return the workoutBtn
	 */
	public Button getWorkoutBtn() {
		return workoutBtn;
	}

	/**
	 * @param workoutBtn the workoutBtn to set
	 */
	public void setWorkoutBtn(Button workoutBtn) {
		this.workoutBtn = workoutBtn;
	}

	/**
	 * @return the dietBtn
	 */
	public Button getDietBtn() {
		return dietBtn;
	}

	/**
	 * @param dietBtn the dietBtn to set
	 */
	public void setDietBtn(Button dietBtn) {
		this.dietBtn = dietBtn;
	}

	/**
	 * @return the currUser
	 */
	public Label getCurrUser() {
		return currUser;
	}

	/**
	 * @param currUser the currUser to set
	 */
	public void setCurrUser(Label currUser) {
		this.currUser = currUser;
	}

	/**
	 * @return the userLogins
	 */
	public Login getUserLogins() {
		return userLogins;
	}

	/**
	 * @param userLogins the userLogins to set
	 */
	public void setUserLogins(Login userLogins) {
		this.userLogins = userLogins;
	}
    
    
}
