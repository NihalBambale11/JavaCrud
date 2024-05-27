package Tester;

import static CollectionUtils.MapUtils.*;
import static StockValidation.StockValidationRules.*;
import java.util.Map;
import java.util.Scanner;

import StockCore.Stock;

public class StockTester {
	public static void main(String[] args) {
		int choice;
		String stockId;
		String stockName;
		String companyName;
		double price;
		String closingDate;
		int quantity;
		Map<String, Stock> StockList = populateMap();

		try (Scanner scan = new Scanner(System.in)) {
			do {
				
				System.out.println("1. Sample Stock \n2. ADD NEW STOCK  \n3. VIEW STOCK \n4. PURCHASE STOCKS "
						+ "\n5. SELL STOCKS \n6. STOCK LIST  IN BINARY FILE (EXIT) \n7. DISPLAY" );
				
				System.out.println("Enter the choice ");
				choice = scan.nextInt();
				System.out.println();
				try {
					switch (choice) {
					case 1:
						System.out.println("Populate Map with Default Stocks ");
						//Map<String, Stock> StockList = populateMap();

						for (Stock s : StockList.values()) {
							System.out.println(s);
						}
						break;

					case 2:
						System.out.println("Enter the Stock Id");
						stockId = scan.next();
						System.out.println("Enter the Stock Name ");
						stockName = scan.next();
						System.out.println("Enter the Company Name");
						companyName = scan.next();
						System.out.println("Enter the price of Stock ");
						price = scan.nextDouble();
						System.out.println("Enter Closing Date of Stock");
						closingDate = scan.next();
						System.out.println("Enter the quantity of Stock you want to Purchase ");
						quantity = scan.nextInt();

						Stock stock = validateInputs(stockId, stockName, companyName, price, closingDate, quantity);
						String id = validateId(stockId,StockList);

						StockList.put(stockId,stock);
						break;
					case 3:
						System.out.println("Enter the Company Name ");
						String com = scan.next();
						
						viewAvailableStock(com,StockList);
						break;
					
					case 4:
						System.out.println("Enter the ID ");
						id = scan.next();
						System.out.println("Enter the Quantity for the Stock ");
						int q = scan.nextInt();
						purchaseStocks(id,q,StockList);
						System.out.println("Stock Purchased");
						break;
					
					case 5:
						System.out.println("Enter the ID ");
						id = scan.next();
						System.out.println("Enter the Quantity for the Stock ");
						q = scan.nextInt();
						
						sellStocks(id,q,StockList);
						System.out.println("Stock Sold");
						break;
					case 6:
						System.out.println("Enter the file name ");
						String file =scan.next();
						
						saveInFile(file,StockList);
						System.out.println("Stock List Added to the File ");
						System.out.println("NOW Exiting....   ");
						break;
						
						
						
					case 7:
						System.out.println("Displaying the Stock Lists ");
						displayStockList(StockList);
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} while (choice != 6);
		}
	}
}
