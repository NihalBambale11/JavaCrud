package ItemTester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import ItemCore.Item;
import static ItemValidation.ItemValidationRules.*;
import static CollectionUtils.ItemUtils.*;
public class ItemMain {
	public static void main(String[] args) {
		int choice;
		 String itemCode;
		 String description;
		 double price;
		 String shipmentDate;
		 ArrayList<Item> ItemList = populateList();
		try(Scanner scan = new Scanner(System.in)){
			do {
		
				System.out.println("1. ADD ITEMS \n2. DISPLAY  \n0. EXIT");
				System.out.println("Enter the Choice");
				choice = scan.nextInt();
				
				switch(choice) {
				case 1:
					System.out.println("Enter the item Code ");
					itemCode = scan.next();
					System.out.println("Enter the description ");
					description = scan.nextLine();
					description  = description + scan.next();
					System.out.println("Enter the price ");
					price = scan.nextDouble();
					System.out.println("Enter the shipment Date ");
					shipmentDate = scan.next();
					
					Item item = validateCode(itemCode,ItemList);
					Item I = new Item(itemCode,description,price,LocalDate.parse(shipmentDate));
					ItemList.add(I);
					break;
				case 2:
					System.out.println("Displaying  Items ");
					displayItem(ItemList);
					break;
					
				case 0:
					sortByItemCode(ItemList);
					
				}
				
				
					
				
			}while(choice!=0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
