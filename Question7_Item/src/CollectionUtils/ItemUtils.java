package CollectionUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static  CollectionUtils.IOutils.*;
import ItemCore.Item;

public class ItemUtils implements Comparable<Item>{
	static Scanner scan = new Scanner(System.in);

	//case 1
	public static ArrayList<Item> populateList(){
		ArrayList<Item> arr = new ArrayList<>();
		
		arr.add(new Item("12345","Cargo is on its way",40560.98,LocalDate.parse("2024-03-12")));
		arr.add(new Item("67890","Weapons is on its way",51000.00,LocalDate.parse("2023-01-13")));
		arr.add(new Item("24680","Black Ops ",31565.80,LocalDate.parse("2012-06-29")));
		arr.add(new Item("13579","World At War ",8900.45,LocalDate.parse("2022-12-12")));

		return arr;


	}
	
	//case 2
	public static void displayItem(ArrayList<Item> arr) {
		for(Item i : arr) {
			System.out.println(i);
		}
	}
	
	//case 3
	
	public static void sortByItemCode(List<Item> arr) throws FileNotFoundException, IOException {
	
		 Collections.sort(arr ,new CompartorItemCode());
		for(Item it : arr) {
			System.out.println(it);
		}
		
		System.out.println("Enter the File name ");
		String filename = scan.next();
		saveInFileByItemCode(filename,arr);
		
		System.out.println("Data Stored in the File named item_code.ser");
		
		Collections.sort(arr,new CompartorItemPrice());
		for(Item iti : arr) {
			System.out.println(iti);
		}
		System.out.println("Enter the File name ");
		String file = scan.next();
		saveFileByItemPrice(file,arr);
		
		System.out.println("Data Stored in the File Named item_price.ser ");
	}

	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public int compareTo(Item o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}