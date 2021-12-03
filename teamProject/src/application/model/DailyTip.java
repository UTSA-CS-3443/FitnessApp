/**
 * 
 */
package application.model;

import java.util.Random;

/**
 * @author Daniel Ferrer-Sosa (tfe646)
 *	List of motivational quotes/tips
 *  If you add to this list, update the size of tips array... thnx
 */
public class DailyTip {
	
	public static String tipsArray() {
		String tips[] = new String[14];
		
		tips[0] = "No pain, no gain. Shut up and train.";
		tips[1] = "Train insane or remain the same.";
		tips[2] = "Push yourself because no one else is going to do it for you.";
		tips[3] = "Good things come to those who sweat.";
		tips[4] = "Motivation is what gets you started. Habit is what keeps you going.";
		tips[5] = "The body achieves what the mind belives.";
		tips[6] = "Hustle for that muscle.";
		tips[7] = "When you feel like quitting think about why you started.";
		tips[8] = "The only bad workout is the one that didn't happen.";
		tips[9] = "Making excuses burns zero calories per hour.";
		tips[10] = "The pain you feel today, will be the strength you feel tomorrow.";
		tips[11]= "Don't limit your challenges, challenge your limits.";
		tips[12] = "Work hard, good results will come.";
		tips[13] = "I may not be there yet, but I'm closer than I was yesterday.";
		
		int rand = new Random().nextInt(tips.length);
		return tips[rand]; // return randomized string from tips[] array
	}

}
