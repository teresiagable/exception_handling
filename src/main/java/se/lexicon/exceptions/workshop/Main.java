package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.List;

import Utils.HelpMe;
import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.DuplicateNameException;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {

	public static void main(String[] args) {
		
		List <String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        List <String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();

        List<String> lastNames = null;
		try {
			lastNames = CSVReader_Writer.getLastNames();
		} catch (IOException e) {
			e.printStackTrace();
		}

        NameService nameService = new NameService(maleFirstNames, femaleFirstNames,lastNames);

        boolean condition = true;
		do {
			printMenu();
			int num = HelpMe.readIntegerfromUser("Enter number: ", "x");
			try {
				switch (num) {
				case 1:
					nameService.addFemaleFirstName(HelpMe.readStringfromUser("Enter a female name: "));

					break;
				case 2:
					nameService.addMaleFirstName(HelpMe.readStringfromUser("Enter a male name: "));
					break;
				case 3:
					nameService.addLastName(HelpMe.readStringfromUser("Enter a lastname: "));
					break;
				case 4:
					Person test = nameService.getNewRandomPerson();
					System.out.println(test);
					break;
				case (int) 1E+9:
					System.out.println("Goodbye!");
					System.exit(0);
					break;
				default:
					break;
				}
			} catch (DuplicateNameException e) {
				System.out.println("Duplicate name " + e.getName());
				e.printStackTrace();
			}
		} while (condition);

	}

	private static void printMenu() {
		System.out.println("1. Add female name \n2. Add male name \n3. Add lastname "
				+ "\n4. Get a random person \nEnter x for exit ");
	}

}
