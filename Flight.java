import java.util.regex.Pattern;

public class Flight {
	private String flightCode;// a string representing a flight designator
	private String from;// a string representing the departure city
	private String to;// a string representing the arrival city
	private int length;// an integer representing the duration of the flight in
						// minutes
	static Pattern pattern = Pattern.compile("^[a-z A-Z]{2}\\s[0-9]{2,4}$");

	/** 4-arg constructor for setting flight to value passed */
	public Flight(String flightCode, String from, String to, int length) {
		this.setFlightCode(flightCode);
		this.setFrom(from);
		this.setTo(to);
		this.length = length;
	}

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

	public static String validateCode(String flightCode) {
		if (pattern.matcher(flightCode).matches()) {
			return toUpperCase(flightCode);
		} else
			return "Unassigned";
	}

	// mutator method for flightCode instance variable
	public void setFlightCode(String flightCode) {
		// invokes the above static method, validateCode, using the string
		// passed to it as an argument and
		// sets the corresponding instance variable to the value returned by
		// that method.
		this.flightCode = validateCode(flightCode);
	}

	public void setFrom(String from) {
		this.from = toUpperCase(from);
	}

	public void setTo(String to) {
		this.to = toUpperCase(to);
	}

	public String getFlightCode() {
		return this.flightCode;
	}

	public boolean includeMeal() {
		if (length >= 120)
			return true;
		else
			return false;
	}


	/**
	 * Define method deposit that increases the balance by the amount passed as
	 * a parameter as long as the deposit is a positive number. Return a value
	 * of true if the deposit is successful or false otherwise
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

	/** return description with formatted balance */
	public String toString() {
		String meal;
		if (includeMeal())
			meal = " - Meal included";
		else
			meal = " - No meal";
		return "Flight code: " + flightCode + " From: " + from + " To: " + to + " Length: " + length + meal;

	}

}
