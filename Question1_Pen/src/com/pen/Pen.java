package com.pen;

import java.time.LocalDate;

public class Pen {
	
	private static int count=1;
	private int ID; 
	private Brand b1;
	private String Color; 
	private String InkColor; 
	private Material m1;
	private int Stock;
	private LocalDate stockupdateDate;
	private LocalDate ListingDate;
	private double Price;
	private double Discounts;
	
	
	public Pen(Brand b1, String color, String inkColor, Material m1, int stock,
			LocalDate listingDate,LocalDate stockupdateDate, double price, double discounts) {
		super();
		ID = count++ ;
		this.b1 = b1;
		Color = color;
		InkColor = inkColor;
		this.m1 = m1;
		Stock = stock;
		ListingDate = listingDate;
		this.stockupdateDate = stockupdateDate;
		Price = price;
		Discounts = discounts;
	}

	 

	@Override
	public String toString() {
		return "Pen [ID=" + ID + ", b1=" + b1 + ", Color=" + Color + ", InkColor=" + InkColor + ", m1=" + m1
				+ ", Stock=" + Stock + ", ListingDate=" + ListingDate
				+", stockupdateDate=" + stockupdateDate + ", Price=" + Price + ", Discounts=" + Discounts + "]";
	}


	public static int getCount() {
		return count;
	}


	public static void setCount(int count) {
		Pen.count = count;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public Brand getB1() {
		return b1;
	}


	public void setB1(Brand b1) {
		this.b1 = b1;
	}


	public String getColor() {
		return Color;
	}


	public void setColor(String color) {
		Color = color;
	}


	public String getInkColor() {
		return InkColor;
	}


	public void setInkColor(String inkColor) {
		InkColor = inkColor;
	}


	public Material getM1() {
		return m1;
	}


	public void setM1(Material m1) {
		this.m1 = m1;
	}


	public int getStock() {
		return Stock;
	}


	public void setStock(int stock) {
		Stock = stock;
	}


	public LocalDate getStockupdateDate() {
		return stockupdateDate;
	}


	public void setStockupdateDate(LocalDate stockupdateDate) {
		this.stockupdateDate = stockupdateDate;
	}


	public LocalDate getListingDate() {
		return ListingDate;
	}


	public void setListingDate(LocalDate listingDate) {
		ListingDate = listingDate;
	}


	public double getPrice() {
		return Price;
	}


	public void setPrice(double price) {
		Price = price;
	}


	public double getDiscounts() {
		return Discounts;
	}


	public void setDiscounts(double discounts) {
		Discounts = discounts;
	}
	
	
	
	
	

}
