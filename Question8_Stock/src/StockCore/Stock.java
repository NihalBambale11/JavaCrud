package StockCore;

import java.io.Serializable;
import java.time.LocalDate;

public class Stock implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5785159326183300167L;
	private String stockId;
	private String stockName;
	private String companyName;
	private double price;
	private LocalDate closingDate;
	private int quantity;
	
	
	public Stock(String stockId, String stockName, String companyName, double price, LocalDate closingDate,
			int quantity) {
		
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.companyName = companyName;
		this.price = price;
		this.closingDate = closingDate;
		this.quantity = quantity;
	}


	public String getStockId() {
		return stockId;
	}


	public void setStockId(String stockId) {
		this.stockId = stockId;
	}


	public String getStockName() {
		return stockName;
	}


	public void setStockName(String stockName) {
		this.stockName = stockName;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public LocalDate getClosingDate() {
		return closingDate;
	}


	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", companyName=" + companyName + ", price="
				+ price + ", closingDate=" + closingDate + ", quantity=" + quantity + "]";
	}
	
	
	public boolean equals(Object o) {
		if(o instanceof Stock) {
			Stock s = (Stock)o;
			return this.stockId == s.stockId; 
		}
		return false;
	}
	
	
	
}
