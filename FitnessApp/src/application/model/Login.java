/**
 * Login.java interacts with the CSV file by reading in current users, appending new users, and validating user login.
 * 
 * @author Ashley Nordquist (dbb246)
 * UTSA CS 3443 - Lab 5
 * Fall 2021
 * 
 * VERSION 2.0 - UPDATED 11/27/2021
 */
package application.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Login {
	
	User[] listOfUsers = new User[100];
	int count = 0;
	String currUser;
	String currPassword; // adding password.
	
	//Create new user and append to the CSV file
	public void createUser(String username, String password) throws IOException {
		User newUser = new User();
		newUser.username = username;
		newUser.password = password;
		listOfUsers[count++] = newUser;
		currUser = username;
		currPassword = password;
		addUserToCSV(username, password);
	}
		
	//Read CSV file
	public void readCSVFile() {
		try {
			BufferedReader readFile = new BufferedReader(new FileReader("data/userInfo.csv"));
			String readFilerow;
			while ((readFilerow = readFile.readLine()) != null) {
				String[] data = readFilerow.split(",");
			}
			readFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Validates users in accordance with the CSV file
	public int validateUserPass(String username, String password) {
		try {
			BufferedReader readFile = new BufferedReader(new FileReader("data/userInfo.csv"));
			String readFilerow;
			while ((readFilerow = readFile.readLine()) != null) {
				String[] data = readFilerow.split(",");
				if(data[0].equals(username) && data[1].equals(password)) {
					readFile.close();
					return 0;
				}
			}
			readFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return 1;
	}
		
	//Write to CSV file
	public void addUserToCSV(String username, String password) throws IOException{
		
		FileWriter writer = new FileWriter("data/userInfo.csv",true);
		//String[] data = {username, password, "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"};
		writer.append(username);
		writer.append(',');
		writer.append(password);
		writer.append(',');
		writer.append("N/A");
		writer.append(',');
		writer.append("N/A"); // adding new slot for fName
		writer.append(',');
		writer.append("N/A");
		writer.append(',');
		writer.append("N/A");
		writer.append(',');
		writer.append("N/A");
		writer.append(',');
		writer.append("N/A");
		writer.append(',');
		writer.append("N/A");
		writer.append('\n');
		
		writer.close();
	}
	

	/**
	 * @return the currPassword
	 */
	public String getCurrPassword() {
		return currPassword;
	}

	/**
	 * @param currPassword the currPassword to set
	 */
	public void setCurrPassword(String currPassword) {
		this.currPassword = currPassword;
	}

	//Call validateUserPass() to verify login credentials
	public int validateUser(String username, String password) {	
		if(validateUserPass(username, password) == 0){
			currUser = username;
			currPassword = password; // nathan adding password.
			return 0;
		}
		return 1;
	}

	/**
	 * @return the listOfUsers
	 */
	public User[] getListOfUsers() {
		return listOfUsers;
	}

	/**
	 * @param listOfUsers the listOfUsers to set
	 */
	public void setListOfUsers(User[] listOfUsers) {
		this.listOfUsers = listOfUsers;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the currUser
	 */
	public String getCurrUser() {
		return currUser;
	}

	/**
	 * @param currUser the currUser to set
	 */
	public void setCurrUser(String currUser) {
		this.currUser = currUser;
	}
	
}
