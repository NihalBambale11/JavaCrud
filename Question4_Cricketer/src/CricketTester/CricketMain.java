package CricketTester;

import static CricketValidation.CricketValidationRules.*;

import java.util.Map;
import java.util.Scanner;

import CricketCore.Cricketer;

public class CricketMain {
	public static void main(String[] args) {
		int choice;
		String name;
		int age;
		String email;
		String Phone;
		int rating;
		Map<String,Cricketer> MapList = populateMap();
		try (Scanner scan = new Scanner(System.in)) {
			do {
				System.out.println(
						"1. ADD CRICKETER \n2. MODIFY CRICKETER RATINGS \n3. SEARCH CRICKETER BY NAME \n4. DISPLAY \n5. SORT BY RATING ");
				System.out.println("Enter the Choice ");
				choice = scan.nextInt();
				try {
					switch(choice) {
					case 1:
						System.out.println("Enter the Name of the Cricketer");
						name = scan.next();
						System.out.println("Enter the Email ");
						email = scan.next();
						System.out.println("Enter the age ");
						age= scan.nextInt();
						System.out.println("Enter Phone Number ");
						Phone = scan.next();
						System.out.println("Enter the rating");
						rating = scan.nextInt();
						Cricketer ct = validateInputs(name,age,email,Phone,rating);
						MapList.put(email,ct);
						break;
						
					case 2:
						System.out.println("Enter the email ");
						String em = scan.next();
						System.out.println("Enter the rating ");
						int r = scan.nextInt();
						
						modifyRating(em,r,MapList);
						break;
					
					case 3:
						System.out.println("Enter the email ");
						String en = scan.next();
						System.out.println("Enter the Name");
						String nm = scan.next();
						
						searchByName(en,nm,MapList);
						break;
						
					case 4: 
						System.out.println("Displaying The Cricket");
						displayCricketer(MapList);
						break;
					
					case 5:
						SortByRating(MapList);
						break;
						
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			} while (choice != 0);
		}
	}
}
