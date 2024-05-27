package ItemValidation;

import java.util.ArrayList;

import ItemCore.Item;
import ItemException.DuplicateValueNotAllowedException;

public class ItemValidationRules {


	public static Item validateCode(String itemCode,ArrayList<Item> arr) throws DuplicateValueNotAllowedException {
		Item it = new Item(itemCode);
		int index = arr.indexOf(it);
		if(index ==-1) {
			throw new DuplicateValueNotAllowedException("Enter Another code ");
		}
		Item i = arr.get(index);
		if(!i.getItemCode().equals(it)) {
			return i;
		}
		throw new DuplicateValueNotAllowedException("Enterrr Another code ");

	}
}
