package CricketValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CricketCore.Cricketer;

public class CricketValidationRules {
	public static Cricketer validateInputs(String name, int age, String email, String Phone, int rating) {

		return new Cricketer(name, age, email, Phone, rating);
	}

	public static Map<String, Cricketer> populateMap() {
		Map<String, Cricketer> maplist = new HashMap<String, Cricketer>();
		maplist.put("nihal@gmail.com", new Cricketer("Nihal", 23, "nihal@gmail.com", "9404771090", 7));
		maplist.put("kass@gmail.com", new Cricketer("Kassandra", 2000, "kass@gmail.com", "9404452390", 10));
		maplist.put("edward@gmail.com", new Cricketer("Edward", 30, "edward@gmail.com", "9402010450", 9));
		maplist.put("jacob@gmail.com", new Cricketer("Jacob", 26, "jacob@gmail.com", "9200200106", 5));
		maplist.put("adewale@gmail.com", new Cricketer("Adewale", 40, "adewale@gmail.com", "8976509876", 3));

		return maplist;
	}

	public static void modifyRating(String email, int r, Map<String, Cricketer> mp) {
		for (Cricketer c : mp.values()) {
			if (c.getEmail().equals(email)) {
				c.setRating(r);
			}
		}
	}

	public static void searchByName(String en, String nm, Map<String, Cricketer> maplist) {
		for (Cricketer c : maplist.values()) {
			if (c.getName().equals(nm)) {
				System.out.println(c);
			}
		}
	}

	public static void displayCricketer(Map<String, Cricketer> maplist) {
		for (Cricketer c1 : maplist.values()) {
			System.out.println(c1);
		}
	}

	public static void SortByRating(Map<String,Cricketer>ml) {
		List<Cricketer> list = new ArrayList<>(ml.values());
		Collections.sort(list,new CompareRating());
		for(Cricketer c4 : list) {
			System.out.println(c4);
		}
	}

}
