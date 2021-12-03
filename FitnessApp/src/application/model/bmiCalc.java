/**
 * 
 */
package application.model;

/**
 * 
 * Calculates the BMI based on height and weight.  Also returns their BMI status to FXML
 * 
 * @author Sarah Stout
 * 
 */
public class bmiCalc {
	
	double finalHeight;
	double BMI;
	
	public bmiCalc() {
		
		
	}
	
	public double calculateBMI(double feet, double inches, double pounds) {
			
		finalHeight = inches + (feet*12);
		//System.out.print(finalHeight);
		BMI = pounds/(finalHeight*finalHeight);
		BMI = BMI * 703;
		
		//System.out.print(BMI);
		return BMI;
		
	}
	
	public String BMIStatus(double bmi) {
		
		if(bmi < 18.50) {
			return "Underweight";
		}
		if(bmi < 24.99 && bmi > 18.50) {
			return "Normal";
		}
		if(bmi >= 25 && bmi <40) {
			return "Overweight";
		}
		if(bmi >=40) {
			return "Obese";
		}
		return "false";
	}

	/**
	 * @return the finalHeight
	 */
	public double getFinalHeight() {
		return finalHeight;
	}

	/**
	 * @param finalHeight the finalHeight to set
	 */
	public void setFinalHeight(double finalHeight) {
		this.finalHeight = finalHeight;
	}

	/**
	 * @return the bMI
	 */
	public double getBMI() {
		return BMI;
	}

	/**
	 * @param bMI the bMI to set
	 */
	public void setBMI(double bMI) {
		BMI = bMI;
	}

}
