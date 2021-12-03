package application.controller;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import application.model.Login;
import application.model.Reccomendations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
public class DietController {
	 	@FXML
	    private TextArea reccText;
	    @FXML
	    private Label recLabel, nameLbl, dateLbl;
	    @FXML
	    private Button backBtn, calBtn;
	    @FXML
	    private TextField weightLbl, feetLbl, inchesLbl;
	    
	    private final String viewPath = "Main.fxml";
	    Login newLogin = new Login();
	    
	    public void handleDiet(ActionEvent event) {
	    	
	    }
	    
	    public void getUserInfo(Login userName) {
	    	newLogin = userName;
	    	nameLbl.setText(newLogin.getCurrUser());
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
		
		public void handleReccomendations() {
			
			Reccomendations reccDiet = new Reccomendations();
			
			DecimalFormat df = new DecimalFormat ("0.00");
			df.setRoundingMode(RoundingMode.UP);
			
			String strFeet;
			String strInches;
			String strWeight;
			String ans;
			int retFeet;
			int retInches;
			int retWeight;
			double finalBMI;
			
			strFeet = feetLbl.getText();
			strInches = inchesLbl.getText();
			strWeight = weightLbl.getText();
			
			retFeet = Integer.parseInt(strFeet);
			retInches = Integer.parseInt(strInches);
			retWeight = Integer.parseInt(strWeight);
			
			reccText.setText(reccDiet.Reccomendation(retWeight, retFeet, retInches));
			
		}
	
}
