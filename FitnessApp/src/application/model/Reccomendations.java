package application.model;

/**
 * 
 * @author Carlos Zambrano KMV055
 *
 */

public class Reccomendations extends bmiCalc {
	double finalHeight;
	
	
	public String Reccomendation(double weight, double feet, double inches)
	{
		double bmi = calculateBMI(feet, inches, weight);
		String line1 = "";
		String line2 = "";
		String line3 = "";
		String complete = "";
		if(bmi < 18.50) {
			line1 = "Eat at least 5 portions a day";
			line2 = "Focus on heavy carbohydrates, this may include:";
			line3 = "Potatoes, pasta, bread, rice";
			complete = line1 + "\n" + line2 + "\n" + line3;
			return complete;
		}
		if(bmi < 24.99 && bmi > 18.50) {
		line1 = "Maintain 3 meals a day";
		line2 = "Fruits, whole grain products are highly recommended";
		line3 = "Select products low in saturated fats, trans fats, cholesterol, and added sugars";
		complete = line1 + "\n" + line2 + "\n" + line3;
		return complete;
		}
		if(bmi >= 25 && bmi < 40) {
		line1 = "Cut off food and drinks high in fat and sugar";
		line2 = "Get plenty of fruits and vegetables to your diet";
		line3 = "Chia seeds and raisin water help with digestion and bowel movement";
		complete = line1 + "\n" + line2 + "\n" + line3;
		return complete;
		}
		if(bmi >= 40) {
		line1 = "Prepare your meals before the start of the week";
		line2 = "Focus on base proteins such as steak and chicken";
		line3 = "For snacks, try nuts, oats, yogurt, and fruit to maintain your appetite";
		complete = line1 + "\n" + line2 + "\n" + line3;
		return complete;	
		}
		return "Unable to calculate diet";
	}

}
