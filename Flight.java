
/**CS603 - Assignment 4
 * Define a	class called Flight	for	representing an	airline	flight with the	following private instance variables,
 * define constructors and getter/setter/functional methods	
 * @author Danna Dai
 *
 */
import java.util.regex.Pattern;

public class Flight {
	private String flightCode;// a string representing a flight designator
	private String from;// a string representing the departure city
	private String to;// a string representing the arrival city
	private int length;// an integer representing the duration of the flight in
						// minutes
	static Pattern pattern = Pattern.compile("^[a-z A-Z]{2}\\s[0-9]{2,4}$");

	// define a valid pattern which begins with two
	// letters (representing the airline) followed by a single space and then
	// between 2 and 4 digits
	/** 4-arg constructor for setting flight to value passed */
	public Flight(String flightCode, String from, String to, int length) {
		this.setFlightCode(flightCode);
		this.setFrom(from);
		this.setTo(to);
		this.length = length;
	}

	/**
	 * Pass a string to the method, and return the string in uppercase.
	 */
	public static String toUpperCase(String str) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (Character.isLowerCase(ch)) {
				sb.append(Character.toUpperCase(ch));
			} else {
				sb.append(ch);
			}
		}

		return sb.toString();
	}

	/**
	 * static method with one parameter of type String that returns a string. If
	 * the string passed to it is a valid flight code, then this method returns
	 * that string in uppercase.
	 */
	public static String validateCode(String flightCode) {
		if (pattern.matcher(flightCode).matches()) {
			return toUpperCase(flightCode);
		} else
			return "Unassigned";
	}

	/**
	 * instance method with one parameter of type String that does not return a
	 * value. It invokes the above static method, validateCode, using the string
	 * passed to it as an argument and sets the corresponding instance variable
	 * to the value returned by that method.
	 */
	public void setFlightCode(String flightCode) {
		this.flightCode = validateCode(flightCode);
	}

	/**
	 * instance method with one parameter of type String that does not return a
	 * value. It sets the corresponding instance variable to the uppercase value
	 * of the string passed to it.
	 */
	public void setFrom(String from) {
		this.from = toUpperCase(from);
	}

	/**
	 * instance method with one parameter of type String that does not return a
	 * value. It sets the corresponding instance variable to the uppercase value
	 * of the string passed to it.
	 */
	public void setTo(String to) {
		this.to = toUpperCase(to);
	}

	/**
	 * getFlightCode: instance method with no parameters. It returns the flight
	 * code instance variable of the invoking Flight object.
	 */
	public String getFlightCode() {
		return this.flightCode;
	}

	/**
	 * instance method with no parameters. It returns a boolean value of true if
	 * the duration of the invoking Flight object is at least 120 minutes, or
	 * false otherwise.
	 */
	public boolean includeMeal() {
		if (length >= 120)
			return true;
		else
			return false;
	}

	/**
	 * instance method with one parameter of type Flight. This method returns a
	 * boolean value of true if the arrival city of the invoking Flight object
	 * is the same as the departure city for the Flight object passed as an
	 * argument and if the first two letters in the flight code of each flight
	 * are the same. Otherwise, a value of false is returned.
	 */
	public boolean connectsTo(Flight flight) {
		boolean connect = false;
		if (flight.to.equalsIgnoreCase(this.from)
				&& Character.toUpperCase(flight.flightCode.charAt(0)) == this.getFlightCode().charAt(0)
				&& Character.toUpperCase(flight.flightCode.charAt(1)) == this.getFlightCode().charAt(1)) {

			connect = true;
		}
		return connect;
	}

	/**
	 * instance method with no parameters that returns a string description of
	 * the invoking object, including information on all of the instance
	 * variables as well as whether or not the flight includes a meal.
	 */
	public String toString() {
		String meal;
		if (includeMeal())
			meal = " - Meal included";
		else
			meal = " - No meal";
		return "Flight code: " + flightCode + " From: " + from + " To: " + to + " Length: " + length + meal;

	}

}
