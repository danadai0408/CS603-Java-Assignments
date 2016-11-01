/**CS603 - Assignment 4
 * This	class has a	single main method that provides the following functionalities with Object Flight
 * @author Danna Dai
 *
 */
import java.util.Scanner;

public class AddFlights {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Flight[] flightArray = new Flight[2];// define an array of type Flight
												// of size 2
		/**
		 * Prompt the user for the information required to create a Flight
		 * object in the following order: flight code, departure city, arrival
		 * city, and the length of the flight.
		 */
		for (int i = 0; i < flightArray.length; i++) {
			String flightCode;
			String from;
			String to;
			int length;
			boolean changed = false;

			System.out.print(
					"Please enter a flight code that begins with two letters followed by a space and then 2 to 4 digits: ");
			if (i != 0)
				input.next();
			flightCode = input.nextLine();

			System.out.print("Enter the departure city: ");
			from = input.nextLine();

			System.out.print("Enter the arrival city: ");
			to = input.nextLine();

			System.out.print("Enter the flight duration in minutes: ");
			length = input.nextInt();
			/**
			 * Create the Flight object with the values input by the user and
			 * print its description
			 */
			Flight flight = new Flight(flightCode, from, to, length);

			System.out.println();
			System.out.println(flight);
			System.out.println();
			/**
			 * Get the flight code of the newly created Flight object and use
			 * the static validateCode method to check if it is “unassigned.” If
			 * it is, continue to prompt until a valid code has been entered,
			 * and then set the flight code for the flight to this new value.
			 * Then print the description of the flight again.
			 * 
			 */
			while (Flight.validateCode(flight.getFlightCode()).equals("Unassigned")) {
				System.out.print("The flight code for the newly created flight is invalid. Please re-enter: ");
				input.next();
				flightCode = input.nextLine();
				flight.setFlightCode(flightCode);
				changed = true;
			}
			if (changed) {
				System.out.println();
				System.out.println(flight);
				System.out.println();

			}

			flightArray[i] = flight;
			// store the two Flight objects to
			// an array of type Flight
		}
		/**
		 * Print if the first Flight object connects to the second Flight
		 * object, making use of the connectsTo() method.
		 */
		if (flightArray[1].connectsTo(flightArray[0]))
			System.out.println("The two flights are connecting.");
		else
			System.out.println("The two flights are not connecting.");
		input.close();
	}

}
