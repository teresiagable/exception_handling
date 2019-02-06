package Utils;

import java.time.LocalDate;
import java.util.Scanner;

public class HelpMe {

	private static Scanner scanner = new Scanner(System.in);

	public static int readIntegerfromUser() {
		try {
			System.out.println("Enter a number: ");
			String input = scanner.nextLine();
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Not a valid number");
			return readIntegerfromUser();
		}
	}

	public static int readIntegerfromUser(String question) {
		try {
			if (question != null)
				System.out.println(question);
			String input = scanner.nextLine();
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Not a valid number");
			return readIntegerfromUser(question);
		}
	}

	/**
	 * @param String question to be shown on the screen
	 * @param        int min value (inclusive)
	 * @param        int max value (inclusive)
	 * 
	 * @return
	 */
	public static int readIntegerfromUser(String question, int min, int max) {
		try {
			if (question != null)
				System.out.println(question);
			String input = scanner.nextLine();
			int theInt = Integer.parseInt(input);
			if (theInt < min && theInt > max) {
				throw new NumberFormatException();
			} else
				return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Not a valid number");
			return readIntegerfromUser(question, min, max);
		}
	}

	/**
	 * @param String question to be shown on the screen
	 * @param        int[] validInts an array of valid ints
	 * 
	 * @return
	 */
	public static int readIntegerfromUser(String question, int[] validInts) {
		try {
			if (question != null)
				System.out.println(question);
			String input = scanner.nextLine();
			int theInt = Integer.parseInt(input);
			for (int i : validInts) {
				if (theInt == i)
					return theInt;
			}
			throw new NumberFormatException();
		} catch (NumberFormatException e) {
			System.out.print("Not a valid number. Valid numbers are: ");
			for (int i : validInts) {
				System.out.print(" " + i + " ");
			}
			System.out.println("");

			return readIntegerfromUser(question, validInts);
		}
	}

	/**
	 * @param question
	 * @param exitString
	 * @return will return -1 when exitString is entered
	 */
	public static int readIntegerfromUser(String question, String exitString) {
		String input=null;
		try {
			if (question != null)
				System.out.println(question);
			input = scanner.nextLine();
			return Integer.parseInt(input);
		} 
		catch (NumberFormatException e) {
			if (input.equalsIgnoreCase(exitString))
				return (int) 1E+9; // not perfect but ok for now
			else {
				System.out.println("Not a valid number");
				return readIntegerfromUser(question);
			}
		}
	}
	/**
	 * @return false if user has entered N or n, else true
	 */
	public static boolean readYesNoFromUser() {
		String input = scanner.nextLine();
		boolean returnValue = true;
		switch (input) {
		case "Y":
		case "y":
			returnValue = true;
			break;
		case "N":
		case "n":
			returnValue = false;
			break;
		default:
			System.out.println("I'll take that as a YES");
			returnValue = true;
			break;
		}
		return returnValue;
	}
	
	/**
	 * @return a string made by all data in the array
	 */
	public static String intArrayToString(int[] denominationValues) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String readStringfromUser(String question) {
		if (question != null)
			System.out.println(question);
		String input = scanner.nextLine();
		return input;

	}

	public static LocalDate readDatefromUser(String string) {
		return LocalDate.now();
	}

	


}
