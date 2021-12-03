package application.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

import application.model.Category;
import application.model.DailyTip;
import application.model.Login;
import application.model.Workout;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WorkoutsController implements Initializable {
	@FXML private ImageView bulbImg;
	@FXML private Label quoteLbl, dateLbl, nameLbl, difficultyLbl, yourWorkoutLbl, completedCountLbl;
	@FXML private ComboBox<String> categoryCB;
	@FXML private Button beginnerBtn, intermediateBtn, expertBtn, backBtn, workoutCompleteBtn, confirmCompletedBtn, cancelCompletedBtn;
	@FXML private ListView<Workout> workoutLV;
	@FXML private Pane yourWorkoutPane, confirmationPane, stackSP;
	
	// Helper and Global vars
	private static Category fullBody, push, pull, legs;
	private final String viewPath = "Main.fxml";
	Login newLogin = new Login();

	public void initialize(URL arg0, ResourceBundle arg1) {	
			
		quoteLbl.setText(getRandomTip()); // display random quote
		
		// creating ghosts
		confirmationPane.setVisible(false);
		completedCountLbl.setVisible(false);
		
		fillCategoriesDropDown(); 
		
		loadCategoryView(null);
		
		dateLbl.setText(new SimpleDateFormat("EEEE MMM dd, yyyy").format(new Date())); // populate label with today's date
		
	}
	
	public void getUserInfo(Login userName) {
		newLogin = userName;
		nameLbl.setText(newLogin.getCurrUser());
	}
	
	// Event Listener on Button[#backBtn].onAction
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
	
	// Event Listener on Button[#beginnerBtn].onAction
	@FXML
	public void beginnerBtnClicked(ActionEvent event) {
		displayWorkoutLV(generateWorkout(2));
		yourWorkoutPane.setDisable(false);
		confirmationPane.setVisible(false);
		stackSP.setVisible(true);
	}
	
	// Event Listener on Button[#intermediateBtn].onAction
	@FXML
	public void intermediateBtnClicked(ActionEvent event) {
		displayWorkoutLV(generateWorkout(3));
		yourWorkoutPane.setDisable(false);
		confirmationPane.setVisible(false);
		stackSP.setVisible(true);
	}
	
	// Event Listener on Button[#expertBtn].onAction
	@FXML
	public void expertBtnClicked(ActionEvent event) {
		displayWorkoutLV(generateWorkout(4));
		yourWorkoutPane.setDisable(false);
		confirmationPane.setVisible(false);
		stackSP.setVisible(true);
	}
	
	// Event Listener on Button[#workoutCompleteBtn].onAction
	@FXML
	public void workoutCompleteBtnClicked(ActionEvent event) {
		//System.out.print("completed click");
		yourWorkoutPane.setDisable(true);
		yourWorkoutPane.setOpacity(0.4);
		confirmationPane.setVisible(true);
		confirmationPane.setDisable(false);
		disableChoosingBtns(true);
	}	
	
	// Event Listener on Button[#workoutCompleteBtn].onAction
	@FXML
	public void confirmCompletedBtnClicked(ActionEvent event) {
		yourWorkoutPane.setDisable(false);
		yourWorkoutPane.setOpacity(1);
		confirmationPane.setVisible(false);
		logWorkout(workoutLV.getItems().toString());
		completedCountLbl.setVisible(true);
		completedCountLbl.setText("Total Completed Workouts: " + refreshCompletedCount());
		disableChoosingBtns(false);
	}		
	
	// Event Listener on Button[#workoutCompleteBtn].onAction
	@FXML
	public void cancelCompletedBtnClicked(ActionEvent event) {
		yourWorkoutPane.setDisable(false);
		yourWorkoutPane.setOpacity(1);
		confirmationPane.setVisible(false);
		disableChoosingBtns(false);
	}		
	
	// Event Listener on ComboBox[#categoryCB].onAction
	@FXML
	public void categoryCBSelect(ActionEvent event) {
		
		switch(categoryCB.getValue()) {
			case "Push":
				loadCategoryView(push);
			
			case "Pull":
				loadCategoryView(pull);
				
			case "Legs":
				loadCategoryView(legs);
			
			case "Full Body":
				loadCategoryView(fullBody);
				
			default:
				loadCategoryView(null);
		}
		stackSP.setVisible(false);
		
		if(confirmationPane.isVisible() == true) {
			yourWorkoutPane.setOpacity(1);
		}
		disableChoosingBtns(false);
		
	}
	

	// returns random quote from quotes.txt as String
	public static String getRandomTip() {
		return DailyTip.tipsArray();
	}
	
	// populates a combo box with available categories
	// populate categories dropdown
	// Populate categoryCB with categories
	public void fillCategoriesDropDown() {

		
		fullBody = new Category("Full Body");
		push = new Category("Push");
		pull = new Category("Pull");
		legs = new Category("Legs");
		
		ArrayList<String> options = new ArrayList<String>();
		options.add(push.getName());
		options.add(pull.getName());
		options.add(legs.getName());
		options.add(fullBody.getName());
		
		categoryCB.setVisibleRowCount(options.size());
		categoryCB.getItems().addAll(options);
		categoryCB.setEditable(false);
	}
	
	// Display buttons according to category
	
	// set view per category 
	// *disclaimer, this is poorly modeled, I could've used the Category class better, sorry!
	public void loadCategoryView(Category cat) {
		cat = new Category(categoryCB.getValue());
		
		if(cat.getName() == "Push" ||  cat.getName() == "Legs") {
			difficultyLbl.setVisible(true);
			beginnerBtn.setVisible(true);
			intermediateBtn.setVisible(true);
			expertBtn.setVisible(true);
			
		}
		// these categories don't allow expert workouts
		else if(cat.getName() == "Full Body" || cat.getName() == "Pull") {
			difficultyLbl.setVisible(true);
			beginnerBtn.setVisible(true);
			intermediateBtn.setVisible(true);
			expertBtn.setVisible(false);
			
		}
		else { // no category = no buttons!
			difficultyLbl.setVisible(false);
			beginnerBtn.setVisible(false);
			intermediateBtn.setVisible(false);
			expertBtn.setVisible(false);
			yourWorkoutPane.setVisible(false);
		}
	}
	
	// Return a workout routine which includes 5 workouts tailored to the desired workout difficulty
	
	// returns an ObservableList containing a valid combo of Workouts
	public ObservableList<Workout> generateWorkout(int difficulty) {
		boolean isValid = false;
		
		String line = null, delim = ",";
		String[] sb = null;
		
		Random rand = new Random();
		ArrayList<Workout> exercises = new ArrayList<Workout>();
		ArrayList<Workout> selectedExercises = new ArrayList<Workout>();
		ObservableList<Workout> wkos = FXCollections.observableArrayList();
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("./data/" + categoryCB.getValue().replace(" ", "").toLowerCase() + "Exercises.txt"));
			reader.readLine(); // skip first line

			while((line = reader.readLine()) != null) {						
				sb = line.split(delim);
			
				if(sb!= null) { // create Workout using values from line
					//IT WAS STRIP NOT TRIM
					Workout workout = new Workout(sb[0].trim(), Integer.parseInt(sb[1]), Integer.parseInt(sb[2]), Integer.parseInt(sb[3]));
					exercises.add(workout);
				}
			}
			reader.close();			
			
		} catch(IOException e) { e.printStackTrace(); }
		
		while(!isValid) { // loop until valid exercise combo is found
			double avgRating = 0, count = 0;
			
			for(Workout wko: exercises) {
				if(rand.nextInt(3) == 0) { // give every exercise 33% to be selected
					
					if(selectedExercises.size() < 5) // only add if less than 5 exercises are currently in the list
						selectedExercises.add(wko);
						count++;
						avgRating += wko.getDifficultyRating();
									
					if(count == 5)
					{
						avgRating /= 5; // avg out total rating
						break;
					}						
				}
			}
			
			if(Math.round(avgRating+0.2) == difficulty && selectedExercises.size() == 5) { 
				isValid = true; // valid exercise combo was found
			}
				
			else // didn't find valid combo, clearing list to try again
				selectedExercises.clear();
		}
		
		for(Workout wko: selectedExercises)
			wkos.add(wko); // was unable to cast list, so we create a new one

		selectedExercises.clear(); // giving java trash collector work
		
		return wkos; // return valid returntype list
	}	
	
	// display the ListView containing the generated workout
	public void displayWorkoutLV(ObservableList<Workout> wkos) {
		workoutLV.setItems(wkos);
		yourWorkoutPane.setVisible(true);
	}
	
	// We log your workout!
	public void logWorkout(String log) {
		try {
			File workoutLogs = new File("./data/workoutLog.txt");	
			if(!workoutLogs.exists())
				workoutLogs.createNewFile();
			
			FileWriter outStream = new FileWriter(workoutLogs, true);
			outStream.write(dateLbl.getText() + "\n" + log + "\n\n");
			outStream.close();
		} 
		catch(IOException e) { e.printStackTrace(); }
	}
	
	// We also keep count of your completed workouts
	public int refreshCompletedCount() {
	int logs = 0;
		try {
			int counter = 1;
			BufferedReader reader = new BufferedReader(new FileReader("./data/workoutLog.txt"));
			
			while(reader.readLine() != null) {
				
				if(counter % 3 == 1) // given the static format of the file, this will always read a new log
					logs++;
				
				counter++;
			}
			
			reader.close(); // nathan added. hope it doesnt break something
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return logs;
	}
	
	// disables difficulty choosing btns
	public void disableChoosingBtns(boolean bool) {
		beginnerBtn.setDisable(bool);
		intermediateBtn.setDisable(bool);
		expertBtn.setDisable(bool);
	}
}
