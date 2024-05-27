package CollectionUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import StockCore.Stock;
import StockException.CompanyNotFoundException;
import StockException.DuplicateStockIdException;
import StockException.InsufficentStockQuantityException;
import StockException.StockIdNotFoundException;

public class MapUtils {
	
	//case 1
	public static Map<String , Stock> populateMap(){
		Map<String,Stock> mp= new HashMap<String, Stock>();
		
		mp.put("T12345", new Stock("T12345","TCS","TATA",1200,LocalDate.parse("2024-09-18"),100));
		mp.put("I12345", new Stock("I12345","Info","Infosys",2000,LocalDate.parse("2025-01-09"),254));
		mp.put("TRI234", new Stock("TRI234","Trident","TridentCom",19,LocalDate.parse("2024-05-10"),10));
		mp.put("P09876", new Stock("P09876","Prakash","PrakashSteel",6.09,LocalDate.parse("2024-10-31"),809));
		mp.put("S24680", new Stock("S24680","Suzlon","SuzlonEnergy",45.23,LocalDate.parse("2026-09-11"),5000));
		mp.put("TA2345", new Stock("TA2345","TataPower","TATA",200,LocalDate.parse("2024-11-11"),700));


		return mp;
	}
	
	
	//case 3:
		public static void viewAvailableStock(String com , Map<String,Stock> mp) throws CompanyNotFoundException {
			for(Stock s1 : mp.values()) {
				if(s1.getCompanyName().equalsIgnoreCase(com)) {
					System.out.println(s1.getStockName());
					
				}
			}
			//throw new CompanyNotFoundException("Please Enter valid Company Name ");
		}
		
	//case 4:
		public static void purchaseStocks(String id , int qu , Map<String,Stock> stockMap) throws DuplicateStockIdException, InsufficentStockQuantityException, StockIdNotFoundException {
			 if (!stockMap.containsKey(id)) {
		            throw new StockIdNotFoundException(" stock ID not Found: " + id);
		        }
			 	//wrapping 
		        Stock stock = stockMap.get(id);
		        if (stock.getQuantity() < qu) {
		            throw new InsufficentStockQuantityException("Insufficient available quantity for stock ID " +id);
		        }
		        stock.setQuantity(stock.getQuantity() - qu);

			
		}
		
	//case 5:
		public static void sellStocks(String id,int qu,Map<String,Stock> mp) throws StockIdNotFoundException, InsufficentStockQuantityException {
			if(!mp.containsKey(id)) {
				throw new StockIdNotFoundException("Key not Found");
			}
			Stock stock = mp.get(id);
			stock.setQuantity(stock.getQuantity() + qu);
			
		}
		
	//case 6:
		public static void saveInFile(String file,Map<String,Stock> maplist) throws FileNotFoundException, IOException {
			try(ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(file))){
				out.writeObject(maplist);
			}
		}
	
	//case 7
	public static void displayStockList(Map<String,Stock>StockList) {
		for(Stock s : StockList.values()) {
			System.out.println(s);
		}
	}

}
