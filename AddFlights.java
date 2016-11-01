import java.util.Scanner;

public class AddFlights {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Flight[] flightArray = new Flight[2];

		for (int i = 0; i < flightArray.length; i++) {
			String flightCode;
			String from;
			String to;
			int length;
			boolean changed = false;

			System.out.print(
					"Please enter a flight code that begins with two letters followed by a space and then 2 to 4 digits: ");
			if (i!=0) input.next();
			flightCode = input.nextLine();

			System.out.print("Enter the departure city: ");
			from = input.nextLine();

			System.out.print("Enter the arrival city: ");
			to = input.nextLine();

			System.out.print("Enter the flight duration in minutes: ");
			length = input.nextInt();
			
			Flight flight = new Flight(flightCode, from, to, length);
			
			System.out.println();
			System.out.println(flight);
			System.out.println();
			
			
			while (Flight.validateCode(flight.getFlightCode()).equals("Unassigned")) {			
				System.out.print("The flight code for the newly created flight is invalid. Please re-enter: ");
				input.next();
				flightCode = input.nextLine();
				changed = true;
				flight = new Flight(flightCode, from, to, length);
			}
			if (changed) {
				System.out.println();
				System.out.println(flight);
				System.out.println();

			}
			flightArray[i] = flight;
		}
		if (flightArray[1].connectsTo(flightArray[0]))
			System.out.println("The two flights are connecting.");
		else
			System.out.println("The two flights are not connecting.");
		input.close();
	}

}
