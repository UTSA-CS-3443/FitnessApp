package application.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import application.model.DailyTip;
import application.model.Login;
import application.model.Profile;


public class ProfileController implements Initializable {
	
	@FXML private Button backBtn, saveBtn;
	@FXML private Label quoteLbl, dateLbl, nameWelcome;
	@FXML private TextField payTxt, curActTxt, nameTxt, weightTxt, heightTxt, genderTxt;
	@FXML private Pane welcomePane, profilePane, profilePane2;
	Login newLogin = new Login();
	
	String name;
	String height;
	String weight;
	String gender;
	String curAct;
	String payment;
	
	String user;
	String password;
	
	
	private final String viewPath = "Main.fxml";
	
	public void initialize(URL arg0, ResourceBundle arg1) {	
			
		quoteLbl.setText(getRandomTip()); // display random quote
		dateLbl.setText(new SimpleDateFormat("EEEE MMM dd, yyyy").format(new Date())); // populate label with today's date
		welcomePane.setVisible(true);
		
	}
	
	public void getUserInfo(Login userName) {
		newLogin = userName;
		nameWelcome.setText(userName.getCurrUser());
		this.user = userName.getCurrUser();
		this.password = userName.getCurrPassword();
		
	}
	
	public static String getRandomTip() {
		return DailyTip.tipsArray();
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
		
		public void getNewLogin() {
			// stuff
			
		}
		
		
		// Event Listener on Button[#saveBtn].onAction
		@FXML
		public void saveBtnClicked(ActionEvent event) {
			try {
				System.out.print(user);
				name = nameTxt.getText();
				height = heightTxt.getText();
				weight = weightTxt.getText();
				gender = genderTxt.getText();
				curAct = curActTxt.getText();
				payment = payTxt.getText();
				// String name, String height, String weight, String gender, String currentActivies, String paymentMethod
				//System.out.println(name + height + weight + gender + curAct + payment);
				//Profile user = new Profile(name, height, weight, gender, curAct, payment);
				Profile updateUser = new Profile(user, password, name, height, weight, gender, curAct, payment);
				updateUser.updateUserInfo(user, password,updateUser.toString());
				
			}
			catch(Exception e) {
				System.out.println("Error");
			}
			
		}
		
		
		public void saveUser(String userInfo) {
			try {
				File userProfileFile = new File("./data/userProfile.txt");	
				if(!userProfileFile.exists())
					userProfileFile.createNewFile();
				
				FileWriter outStream = new FileWriter(userProfileFile, true);
				outStream.write(userInfo + "\n");
				outStream.close();
			} 
			catch(IOException e) { e.printStackTrace(); }
		}
		
		
		
		

}


