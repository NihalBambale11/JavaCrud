package ItemCore;

import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4642271981816424371L;
	private String itemCode;
	private String description;
	private double price;
	private LocalDate shipmentDate;

	public Item(String itemCode, String description, double price, LocalDate shipmentDate) {
		super();
		this.itemCode = itemCode;
		this.description = description;
		this.price = price;
		this.shipmentDate = shipmentDate;
	}

	public Item(String itemCode2) {
		// TODO Auto-generated constructor stub
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	@Override
	public String toString() {
		return "Item [itemCode=" + itemCode + ", description=" + description + ", Price=" + price + ", shipmentDate="
				+ shipmentDate + "]";
	}

	public boolean equals(Object o) {
		if(o instanceof Item) {
			Item i = (Item)o;
			return this.itemCode.equals(i.itemCode);
		}
		return false;
	}
	
	public int compareTo(Item i1) {
			return this.itemCode.compareTo(i1.itemCode);
		
	}

}
