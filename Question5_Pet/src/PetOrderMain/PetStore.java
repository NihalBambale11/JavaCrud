package PetOrderMain;

import static PetOrderValidations.PetOrderValidationsRules.OrderPet;
import static PetOrderValidations.PetOrderValidationsRules.displayPetDetails;
import static PetOrderValidations.PetOrderValidationsRules.updatePet;
import static PetOrderValidations.PetOrderValidationsRules.validateCredentailsAdmin;
import static PetOrderValidations.PetOrderValidationsRules.validateCredentailsCustomer;
import static PetOrderValidations.PetOrderValidationsRules.validateInputs;
import static PetOrderValidations.PetOrderValidationsRules.getPet;
import static PetOrderValidations.PetOrderValidationsRules.checkOrderStatus;
import static PetOrderValidations.PetOrderValidationsRules.updatePet;
import static PetOrderValidations.PetOrderValidationsRules.*;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static PetOrderValidations.PetOrderValidationsRules.populatePet;
import CustomerException.OutofStockException;
import PetOrderCore.Order;
import PetOrderCore.Pet;

public class PetStore {
	public static void main(String[] args) {
		int choice;
		int petId;
		String name;
		String cate;
		int unitPrice;
		int stocks;
		Map<Integer, Pet> PetMap = populatePet();
		Map<Integer, Order> OrderMap = new HashMap<>();
		try (Scanner scan = new Scanner(System.in)) {
			do {
				System.out
						.println("1. Login\n" + "2. Add New Pet (Admin Only)\n" + "3. Update Pet Details (Admin Only)\n"
								+ "4. Display All Pets\n" + "5. Order a Pet\n" + "6. Check Order Status by Order Id\n"
								+ "7. Update Order Status (Admin Only)\n" + "8. Display All Orders\n" + "9. Exit");
				System.out.print("Enter your choice : ");
				choice = scan.nextInt();
				switch (choice) {

				case 1:
					System.out.println("who you want to login -> As 1.Admin or 2.Customer ");
					int ch = scan.nextInt();
					if (ch == 1) {
						System.out.println("Enter loginID and Password for Admin");
						String login = scan.next();
						String pass = scan.next();
						boolean isvalidA = validateCredentailsAdmin(login, pass);
						if (isvalidA) {
							System.out.println("Admin Logged IN Successfully ");
						}
					} else if (ch == 2) {
						System.out.println("Enter loginID and Password for Customer");
						String clogin = scan.next();
						String cpass = scan.next();
						boolean isvalidC = validateCredentailsCustomer(clogin, cpass);
						if (isvalidC) {
							System.out.println("Customer Logged IN Successfully");
						}

					} else {
						System.out.println("Please Choose Between admin login or Customer login");
					}
					break;

				case 2:
					System.out.println("Enter loginID and Password for Admin");
					String login = scan.next();
					String pass = scan.next();
					boolean isvalidA = validateCredentailsAdmin(login, pass);
					if (isvalidA) {
						System.out.println("Admin Logged IN Successfully ");
					}
					System.out.println("Enter the pet ID ");
					petId = scan.nextInt();
					System.out.println("Enter the Pet Name");
					name = scan.next();
					System.out.println("Enter the Pet Catergory");
					cate = scan.next();
					System.out.println("Enter the pet price ");
					unitPrice = scan.nextInt();
					System.out.println("Enter the Stock for the Pet");
					stocks = scan.nextInt();

					Pet pet = validateInputs(petId, name, cate, unitPrice, stocks);
					//validateStocks(stocks, PetMap);
					PetMap.put(petId, pet);
					System.out.println("NEW Pet ADDED");
					break;

				case 3:
					System.out.println("Enter loginID and Password for Admin");
					login = scan.next();
					pass = scan.next();
					boolean isvalid = validateCredentailsAdmin(login, pass);
					if (isvalid) {
						System.out.println("Admin Logged IN Successfully ");
					}
					System.out.println("Enter the pet ID for Updations");
					petId = scan.nextInt();
					updatePet(PetMap, petId);
					System.out.println("Updated Pet Details Successfully ");
					break;

				case 4:
					displayPetDetails(PetMap);
					break;
				
				case 5:
					System.out.println("who you want to login -> As 1.Admin or 2.Customer ");
					int cho = scan.nextInt();
					if (cho == 1) {
						System.out.println("Enter loginID and Password for Admin");
						 login = scan.next();
						 pass = scan.next();
						boolean valid = validateCredentailsAdmin(login, pass);
						if (valid) {
							System.out.println("Admin Logged IN Successfully ");
						}
					} else if (cho == 2) {
						System.out.println("Enter loginID and Password for Customer");
						String clogin = scan.next();
						String cpass = scan.next();
						boolean isvalidC = validateCredentailsCustomer(clogin, cpass);
						if (isvalidC) {
							System.out.println("Customer Logged IN Successfully");
						}

					} else {
						System.out.println("Please Choose Between admin login or Customer login");
					}
					System.out.println("Enter PetID to Give Order ");
					int o =scan.nextInt();
					Pet p = getPet(o,PetMap);
					if(p.getPetId() !=0) {
						System.out.println("Enter the Quantity for Pet ");
						int qu = scan.nextInt();
						
						if(p.getStocks() < qu) {
							throw new OutofStockException("Not Stock Available");
							
						}
						Order o1 = new Order(p.getPetId(),qu);
						OrderMap.put(o, o1);
						
						p.setStocks(p.getStocks() - qu);
						System.out.println("Ordered Placed ");
					}
					break;
					
				case 6:
					System.out.println("Enter PetID to Check Order Status ");
					int oid =scan.nextInt();
					checkOrderStatus(oid,OrderMap);
					break;
				
				case 7:
					System.out.println("Enter id to Update Status");
					int oiid = scan.nextInt();
					updateOrderStatus(oiid,OrderMap);
					break;
				case 8:
					System.out.println("Display All order");
					for(Order oo : OrderMap.values()) {
						System.out.println(oo);
					}

				case 0:
					System.out.println("EXITING ....");
					break;
				}

			} while (choice != 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
