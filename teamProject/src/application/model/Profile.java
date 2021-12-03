package application.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Profile {

	private String userName;
	private String password;
	private String name;
	private String height;
	private String weight;
	private String gender;
	private String currentActivities;
	private String paymentMethod;
	// private String userid;
	
	

	public Profile(String userName, String password, String name, String height, String weight, String gender, String currentActivities, String paymentMethod) {
		// super();
		// this.userid = userid;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.currentActivities = currentActivities;
		this.paymentMethod = paymentMethod;
	}
	
	@Override
	public String toString() {
		
		String ret = "";
		// ret += userid;
		ret += userName; 
		ret += "," + password;
		ret += "," + name;
		ret += "," + height;
		ret += "," + weight;
		ret += "," + gender;
		ret += "," + currentActivities;
		ret += "," + paymentMethod;
		
		return ret;
	}
	
	public void updateUser(String userInfo) {
		try {
			File userProfileFile = new File("./data/userProfile.txt");	
			if(!userProfileFile.exists())
				userProfileFile.createNewFile();
			
			FileWriter outStream = new FileWriter(userProfileFile, true);
			outStream.write(userInfo);
			outStream.close();
		} 
		catch(IOException e) { e.printStackTrace(); }
	}
	
	// update user info
	public int updateUserInfo(String username, String password, String userInfo) {
		try {
	        FileWriter fw = new FileWriter("data/userInfo_temp.csv");
			BufferedReader readFile = new BufferedReader(new FileReader("data/userInfo.csv"));
			String readFilerow;
			while ((readFilerow = readFile.readLine()) != null) {
				String[] data = readFilerow.split(",");
				String ret = "";
				if(data[0].equals(username) && data[1].equals(password)) {
					//readFile.close();
					//System.out.print("found password matching");
					ret = "\n" + userInfo;
					fw.write(ret);
					
				} else {
					ret = "\n" + readFilerow;
					fw.write(ret , 0, readFilerow.length());
				}
				//readFile.close();
				//fw.close();
			}
			
			readFile.close();
			fw.close();
			
			BufferedWriter br = new BufferedWriter(new FileWriter(new File("data/userInfo.csv")));
			BufferedReader readFile2 = new BufferedReader(new FileReader("data/userInfo_temp.csv"));
			String readFilerow2;
			while ((readFilerow2 = readFile2.readLine()) != null) {
					String ret = "";
					ret += readFilerow2 + "\n";
					//System.out.println(readFilerow2);
					br.write(ret);
			}
			
			readFile2.close();
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return 1;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the currentActivies
	 */
	public String getCurrentActivies() {
		return currentActivities;
	}

	/**
	 * @param currentActivies the currentActivies to set
	 */
	public void setCurrentActivies(String currentActivies) {
		this.currentActivities = currentActivies;
	}

	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
