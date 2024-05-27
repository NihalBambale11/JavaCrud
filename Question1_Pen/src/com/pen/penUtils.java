package com.pen;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class penUtils {

	
	public static Map<Integer, Pen> Input()
	{
		Map<Integer,Pen> map=new HashMap<Integer, Pen>();
				
		map.put(Pen.getCount(),new Pen(Brand.CELLO, "Red","Blue", Material.METAL, 100,LocalDate.parse("2021-12-06"), LocalDate.now(),10, 10));
		map.put(Pen.getCount(),new Pen(Brand.PARKER, "Black","Pink", Material.PLASTIC, 100,LocalDate.parse("2023-12-02"), LocalDate.now(),20, 10));
		map.put(Pen.getCount(),new Pen(Brand.REYNOLDS, "Pink","Blue", Material.ALLOY, 100,LocalDate.parse("2023-09-12"), LocalDate.now(),15, 5));
		map.put(Pen.getCount(),new Pen(Brand.CELLO, "Blue","Blue", Material.METAL, 100,LocalDate.parse("2021-12-23"), LocalDate.now(),10, 10));
		
		return map;
	}
}
