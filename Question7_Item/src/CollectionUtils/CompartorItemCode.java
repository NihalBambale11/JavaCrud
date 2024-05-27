package CollectionUtils;

import java.util.Comparator;

import ItemCore.Item;

public class CompartorItemCode implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		
		return  o1.getItemCode().compareTo(o2.getItemCode());
		
		//return 0;
	}

}
