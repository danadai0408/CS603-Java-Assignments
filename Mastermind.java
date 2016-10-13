
/**
 * CS605 - Assignment 3
 * 
 * The computer will generate a random sequence of four letters ranging from ¡®a¡¯ to ¡®f.¡¯
The player will have up to 10 chances to guess the correct sequence.

 @author Danna Dai
 */
import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		final int MAX_GUESS = 10;
		char[] secretCode = { 'e', 'd', 'a', 'b' };
		// char[] secretCode = SecretCode.generateCode();// use the static
		// generateCode() method
		// to generate four
		// random
		// letters ranging from 'a' to 'f'
		char[] guessChar = new char[4];// initialize an array for guessing
										// numbers
		boolean flag = true; // When the player get the correct answer, set flag
								// to false.
		boolean verifyInput = true; // When the player has entered the letter
									// out of the range of 'a 'to 'f ', set the
		// verifyInput to false.
		System.out.println("You have a maximum of 10 chances to correctly guess a sequence of four letters ranging from"
				+ " a to f. ");
		System.out.println("\nEnter four letters, seperated by a space. \n");

		for (int time = 0; time < MAX_GUESS && flag; time++) {
			int exact = 0; // initialize exact matches
			int partial = 0; // initialize partial matches

			for (int i = 0; i < 4; i++) {
				char input = kb.next().charAt(0);
				guessChar[i] = input;
			} // prompt the user to enter each letter using a loop
			System.out.print("Guess " + (time + 1) + ": ");

			for (int i = 0; i < 4; i++) {
				System.out.print(guessChar[i] + " ");
				// Print the entered letters
				guessChar[i] = Character.toLowerCase(guessChar[i]);
				// store the input as lowercase values
			}

			verifyInput = verifyCode(guessChar, 'a', 'f');
			// use a static method to verify that the player enters only
			// letters from 'a' to 'f'

			if (verifyInput == false) {
				System.out.println();
				System.out.println("*** Enter only letters between 'a' and 'f' ***");
				System.out.println();
				time--;
				continue;
			}

			int[] index = { -1, -1, -1, -1 };
			for (int k = 0; k < guessChar.length; k++) {
				// Compare each element with the same index in both guessChar
				// and secretCode to get the exact value
				if (guessChar[k] == secretCode[k]) {
					exact++;
					index[k] = k; // store the index when the player get a exact
									// answer
				}
			}
			for (int i = 0; i < guessChar.length; i++) {
				// Compare each element in guessChar to secretCode and make sure
				// not to count the same letter
				for (int j = 0; j < secretCode.length; j++) {
					if (guessChar[i] == secretCode[j] && (i != j) && (index[j] < 0) ) {
						// make sure the two indexes are not the same
						index[j] = 0;
						partial++;
						break;
					}
				}
			}

			if (exact == 4) {
				flag = false; // If the player has guessed correctly, the game
								// will end.
				System.out.println();
				System.out.println();
				System.out.print("You won!");
			} else {
				System.out.println();
				System.out.println("exact (correct letter and position): " + exact);
				System.out.println("partial (correct letter, incorrect position): " + partial);
				System.out.println();
			}

		}
		/*
		 * If the player hasn't got a correct answer after the maximum guess
		 * time, system will notify the user and indicate the correct code.
		 */
		if (flag)

		{
			System.out.println();
			System.out.print("You lost. The correct code was: ");
			for (int i = 0; i < 4; i++) {
				System.out.print(secretCode[i] + " ");
			}
		}

		kb.close();
	}

	// define a method to verify that the player enters only letters from 'a' to
	// 'f'
	public static boolean verifyCode(char[] test, char start, char end) {
		for (int i = 0; i < test.length; i++) {
			if (test[i] > end || test[i] < start)
				return false;
		}
		return true;
	}
}