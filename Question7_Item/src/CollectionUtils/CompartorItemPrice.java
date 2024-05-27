package CollectionUtils;

import java.util.Comparator;

import ItemCore.Item;

public class CompartorItemPrice implements Comparator<Item> {



	@Override
	public int compare(Item o1, Item o2) {
		if(o1.getPrice() > o2.getPrice()) {
			return 1;
		}
		if(o1.getPrice() == o2.getPrice()) {
			return 0;
		}
		return -1;
	}

}
