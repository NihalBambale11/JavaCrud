package com.pen;

import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoPeriod;
import java.util.Map;
import java.util.Scanner;
import static com.pen.penUtils.*;

public class Tester {

	public static void main(String[] args) {
	
		try(Scanner sc=new Scanner(System.in))
		{
			Map<Integer, Pen> map=Input();
			
			boolean flag=false;
			while(!flag)
			{
			try
			{	
				
				System.out.println("1.Add New Pen");
				System.out.println("2.Update stock of a Pen");
				System.out.println("3.Set discount of 20% for all the pens which are not at all sold in last 3 months");
				System.out.println("4.Remove Pens which are never sold once listed in 9 months");
				System.out.println("5.Display");
				System.out.println("0.Exit");
				
				System.out.println("Enter you choice");
				
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter pan Details Brand , color, inkColor, Material , stock,StockupdateDate,listingDate,price,discounts");
					map.put(Pen.getCount(), new Pen(Brand.valueOf(sc.next().toUpperCase()),sc.next(),sc.next(),Material.valueOf(sc.next().toUpperCase()),sc.nextInt(),
							LocalDate.parse(sc.next()),LocalDate.parse(sc.next()),sc.nextDouble(),sc.nextDouble()));
					break;
					
				case 2:
					System.out.println("Enter the Id of pen and stock");
					int i=sc.nextInt();
					int st=sc.nextInt();
					map.values().stream().forEach(p->{if(p.getID()==i)
														p.setStock(st);});
					break;
					
				
				case 3:
					
//					LocalDate now = LocalDate.now();
//					for(Pen p:map.values()) {
//						LocalDate listingDate = p.getStockupdateDate();
//						int months = Period.between(listingDate, now).getMonths();
//						if(months>3) {
//							p.setDiscounts(20);
//						}
//					}
					map.values().forEach(p-> {if(Period.between(p.getListingDate(),LocalDate.now()).getMonths()>3)
												p.setDiscounts(20);});
						
					break;
					
				case 4:
					
//					LocalDate now = LocalDate.now();
//					for(Pen p:map.values()) {
//						LocalDate listingDate = p.getListingDate();
//						int months = Period.between(listingDate, now).getMonths();
//						if(months>2) {
//							map.remove(p.getID());
//							System.out.println("sefjgdskv");
//						}
//							
//						}
					
					map.forEach((k,p)-> {if(Period.between(p.getListingDate(),LocalDate.now()).getYears()>1)
						map.remove(k);});
					break;
					
				case 5:
					System.out.println("Enter the Id of pen and stock");
					map.forEach((k,v)->System.out.println(v));
					break;

				case 0:
					System.out.println("Program Exits");
					flag=false;
					break;
					
					
				}
				
				
				
				
			}
			catch (Exception e) {
//				System.out.println(e.getMessage());
//				e.printStackTrace();
				sc.nextLine();
				System.out.println("Please try Again");
			}
			
			
			}
			
		}
	}

}
