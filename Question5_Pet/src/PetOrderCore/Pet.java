package PetOrderCore;

import PetOrderEnums.Categories;

public class Pet {
	private int petId;
	private String name;
	private Categories cate;
	private int unitPrice ;
	private int stocks;
	public Pet(int petId, String name, Categories c, int unitPrice, int stocks) {
		super();
		this.petId = petId;
		this.name = name;
		this.cate = c;
		this.unitPrice = unitPrice;
		this.stocks = stocks;
	}
	


	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Categories getCate() {
		return cate;
	}
	public void setCate(Categories cate) {
		this.cate = cate;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getStocks() {
		return stocks;
	}
	public void setStocks(int stocks) {
		this.stocks = stocks;
	}
	
	
	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", cate=" + cate + ", unitPrice=" + unitPrice + ", stocks="
				+ stocks + "]";
	}
	
//	public boolean equals(Object o) {
//		if(o instanceof Pet) {
//			Pet p = (Pet)o;
//			return this.petId == (p.petId);
//		}
//		return false;
//	}
	
	
	
}
