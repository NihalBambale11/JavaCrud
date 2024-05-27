package StockValidation;

import java.time.LocalDate;
import java.util.Map;

import StockCore.Stock;
import StockException.DuplicateStockIdException;
import StockException.InvalidStockDateException;

public class StockValidationRules {
	public static Stock validateInputs(String stockId,String stockName,String companyName,double price,String closingDate ,int quantity) throws InvalidStockDateException, DuplicateStockIdException {
		
		//String id = validateId(stockId);
		validateDate(closingDate);
		
		return new Stock(stockId,stockName,companyName,price,LocalDate.parse(closingDate),quantity);
	}

	public static String validateId(String stockId,Map<String,Stock> maplist) throws DuplicateStockIdException {
		if(!maplist.containsKey(stockId)) {
			return stockId;
		}
		throw new DuplicateStockIdException("Stock Id cannot be same ");

	}

	public static void validateDate(String closingDate) throws InvalidStockDateException {
		LocalDate ld = LocalDate.parse(closingDate);
		if(!ld.isAfter(LocalDate.now())) {
			throw new InvalidStockDateException("closing date of Stock should be Future Date ");

		}
	}
}
