/**
 * 
 */
package application.model;

/**
 * @author Daniel Ferrer-Sosa (tfe646)
 *
 */
public class Workout {
	// class attributes
	private String name;
	private int difficultyRating = 1; // base 1 | max 4
	private int reps, sets;
	
	// default constructor
	public Workout() { }
	
	// constructor given @param values
	public Workout(String name, int sets, int reps, int rating) {
		this.name = name;
		this.difficultyRating = rating;
		this.reps = reps;
		this.sets = sets;
	}
	
	// getters and setters
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDifficultyRating() {
		return difficultyRating;
	}
	
	public void setDifficultyRating(int rating) {
		this.difficultyRating = rating;
	}
	
	public int getSets() {
		return sets;
	}
	
	public void setSets(int sets) {
		this.sets = sets;
	}
	
	public int getReps() {
		return reps;
	}
	
	public void setReps(int reps) {
		this.reps = reps;
	}
	
	// Return formatted Workout.toString()
	@Override
	public String toString() {
		String retval = "";
		retval += getSets() + "x" + getReps() + " " + getName();
		
		return retval;
	}

}
