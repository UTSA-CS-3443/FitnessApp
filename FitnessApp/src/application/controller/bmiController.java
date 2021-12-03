/**
 * 
 */
package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import application.model.Login;
import application.model.bmiCalc;

/**
 * 
 * Handles calling to BMI method in bmiCalc.java, takes in input of users height and weight. Prints out their BMI as well as their BMI Status
 * 
 * @author Sarah Stout
 *
 */
public class bmiController {

	@FXML private Label BMI;
	@FXML private TextField feet;
	@FXML private TextField inches;
	@FXML private TextField pounds;
	@FXML private Button back;
	@FXML private Button calculate;
	@FXML private Label calculatedBMI;
	@FXML private Label BMIRange;
	
	private final String viewPath = "Main.fxml";
	Login newLogin = new Login();
	
	public void handleBMI(ActionEvent event){
		
	}
	
	public void getUserInfo(Login userName) {
		newLogin = userName;
	}
	
	//Event Listener on Button[#backBtn].onAction from Daniel
	@FXML
	public void backBtnClicked(ActionEvent event) {
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		try {
			FXMLLoader loader = new FXMLLoader (getClass().getResource(viewPath));
			Parent root = (Parent) loader.load();
			MainController controller = loader.getController();
    		controller.getUserInfo(newLogin);
			Scene scene = new Scene(root, 750, 750);
			stage.setScene(scene);
			stage.setTitle("Main");
			
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	public void handleBMICalc() {
		
		bmiCalc BMI = new bmiCalc();
		
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.UP);
		
		String strFeet;
		String strInches;
		String strPounds;
		String ans;
		int retFeet;
		int retInches;
		int retPounds;
		double finalBMI;
		
		strFeet = feet.getText();
		strInches = inches.getText();
		strPounds = pounds.getText();
		
		retFeet = Integer.parseInt(strFeet);
		retInches = Integer.parseInt(strInches);
		retPounds = Integer.parseInt(strPounds);
		
		finalBMI = BMI.calculateBMI(retFeet, retInches, retPounds);
		BMIRange.setText(BMI.BMIStatus(finalBMI));
		
		//System.out.print(finalBMI);
		ans = String.valueOf(df.format(finalBMI));
		
		calculatedBMI.setText(ans);

		
	}
}
