package CricketValidation;

import java.util.Comparator;

import CricketCore.Cricketer;

public class CompareRating implements Comparator<Cricketer> {



	public int compare(Cricketer o1, Cricketer o2) {
		if (o2.getRating() < o1.getRating()) {
			return -1;
		}
		if(o2.getRating() == o1.getRating()) {
			return 0;
		}
		return 1;
	}

}
