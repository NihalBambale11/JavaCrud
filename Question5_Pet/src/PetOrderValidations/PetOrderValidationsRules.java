package PetOrderValidations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import CustomerException.AuthenticationException;
import CustomerException.LoginCredentialException;
import PetOrderCore.Order;
import PetOrderCore.Pet;
import PetOrderEnums.Categories;
import PetOrderEnums.Status;

public class PetOrderValidationsRules {
	static Scanner scan = new Scanner(System.in);

	public static boolean validateCredentailsAdmin(String login, String pass) throws LoginCredentialException {
		if (login.equals("admin") && pass.equals("admin")) {
			return true;
		}
		throw new LoginCredentialException("Check userid and Password");

	}

	public static boolean validateCredentailsCustomer(String login, String pass) throws LoginCredentialException {
		if (login.equals("customer") && pass.equals("customer")) {
			return true;
		}
		throw new LoginCredentialException("Check userid and Password");

	}
	
	public static Map<Integer,Pet> populatePet(){
		Map<Integer,Pet> pets = new HashMap<Integer,Pet>();
		pets.put(101, new Pet(101, "Bull Dog", Categories.DOG, 1000, 50));
        pets.put(102, new Pet(102, "Siamese Cat", Categories.CAT, 800, 30));
        pets.put(103, new Pet(103, "Goldfish", Categories.FISH, 50, 100));
        return pets;
	}

	public static Pet validateInputs(int petId, String name, String cate, int unitPrice, int stocks)
			throws CategoryNotFoundException {
		Categories c = validateCategory(cate);
		// validateStocks(stocks);

		return new Pet(petId, name, c, unitPrice, stocks);

	}
	
	public static Pet getPet(int id, Map<Integer, Pet> mt) throws AuthenticationException {
		for (Pet p : mt.values()) {
			if (p.getPetId() == id) {
				return p;
			}
		}
		throw new AuthenticationException("Id not Found");
	}

//	public static void validateStocks(int stocks, Map<Integer, Pet> pm) throws OutofStockException {
//		Pet p = pm.get(stocks);
//		if (!(p.getStocks() > 1)) {
//			throw new OutofStockException("Not Stock Available");
//		}
//	}

	public static Categories validateCategory(String cate) throws CategoryNotFoundException {
		for (Categories c : Categories.values()) {
			if (c.name().equalsIgnoreCase(cate)) {
				return c;
			}
		}
		throw new CategoryNotFoundException("Please Choose Valid Category");

	}
	
	public static Status validateStatus(String cate) throws IllegalArgumentException{
		return Status.valueOf(cate.toUpperCase());
	}
	
	
	
	
	
	

	// case 3
	public static void updatePet(Map<Integer, Pet> pm, int petId) {
		System.out.println("Enter the price for updations");
		int up = scan.nextInt();
		System.out.println("Enter the Stock for Updations");
		int st = scan.nextInt();
		Pet p = pm.get(petId);
		if (pm.containsKey(p)) {
			p.setUnitPrice(up);
			p.setStocks(st);
		}
	}

	// case 4
	public static void displayPetDetails(Map<Integer, Pet> pm) {
		for (Pet p : pm.values()) {
			System.out.println(p);
		}
	}
	
	//case 5
		public static void OrderPet(Map<Integer,Order> mp,int petId) {
			
		}
		
	//case 6
		public static void checkOrderStatus(int oid , Map<Integer,Order> omap) throws AuthenticationException {
			for(Order o : omap.values()) {
				if(o.getOrderId() == oid) {
					System.out.println(o.getStatus());
				}
			}
			throw new AuthenticationException("Order Id not found");
		}
		
	//case 7
		public static void updateOrderStatus(int id , Map<Integer,Order>mo) {
			for(Order o : mo.values()) {
				if(o.getPetId()  ==  id) {
					System.out.println("Enter the Status ");
					String status = scan.next();
					o.setStatus(validateStatus(status));
					
				}
			}
		}

}
