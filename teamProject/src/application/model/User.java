/**
 * User.java resembles the user class which can be defined by having a username, password, height, weight, gender, goals, activity, and payment.
 * 
 * @author Ashley Nordquist (dbb246)
 * UTSA CS 3443 - Lab 5
 * Fall 2021
 * 
 * VERSION 2.0 - UPDATED 11/27/2021
 */
package application.model;

/**
 * @author ashle
 *
 */
public class User {

	String username, password;
	String userHeight, userWeight, userGender, userGoals, userActivity, userPayment;
	
	public User() {
		//Do nothing
	}
	
	//Create user
	public User(String height, String weight, String gender, String goals, String activity, String payment) {
		this.userHeight = height;
		this.userWeight = weight;
		this.userGender = gender;
		this.userGoals = goals;
		this.userActivity = activity;
		this.userPayment = payment;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userHeight
	 */
	public String getUserHeight() {
		return userHeight;
	}

	/**
	 * @param userHeight the userHeight to set
	 */
	public void setUserHeight(String userHeight) {
		this.userHeight = userHeight;
	}

	/**
	 * @return the userWeight
	 */
	public String getUserWeight() {
		return userWeight;
	}

	/**
	 * @param userWeight the userWeight to set
	 */
	public void setUserWeight(String userWeight) {
		this.userWeight = userWeight;
	}

	/**
	 * @return the userGender
	 */
	public String getUserGender() {
		return userGender;
	}

	/**
	 * @param userGender the userGender to set
	 */
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	/**
	 * @return the userGoals
	 */
	public String getUserGoals() {
		return userGoals;
	}

	/**
	 * @param userGoals the userGoals to set
	 */
	public void setUserGoals(String userGoals) {
		this.userGoals = userGoals;
	}

	/**
	 * @return the userActivity
	 */
	public String getUserActivity() {
		return userActivity;
	}

	/**
	 * @param userActivity the userActivity to set
	 */
	public void setUserActivity(String userActivity) {
		this.userActivity = userActivity;
	}

	/**
	 * @return the userPayment
	 */
	public String getUserPayment() {
		return userPayment;
	}

	/**
	 * @param userPayment the userPayment to set
	 */
	public void setUserPayment(String userPayment) {
		this.userPayment = userPayment;
	}
	
	
}
