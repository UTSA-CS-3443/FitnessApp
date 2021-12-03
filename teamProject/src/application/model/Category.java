/**
 * 
 */
package application.model;

/**
 * @author Daniel Ferrer-Sosa (tfe646)
 *
 */
public class Category {
	// class attributes
	String name;
	
	// default constructor
	public Category() { }
	
	// constructor given @param values
	public Category(String name) {
		this.name = name;
	}
	
	// getters and setters
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
