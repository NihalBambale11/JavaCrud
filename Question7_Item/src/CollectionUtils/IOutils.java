package CollectionUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import ItemCore.Item;

public class IOutils {
	public static void saveInFileByItemCode(String fileName,List<Item> arr ) throws FileNotFoundException, IOException {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
			out.writeObject(arr);
		}
	}
	
	public static void saveFileByItemPrice(String file,List<Item> arr) throws FileNotFoundException, IOException {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
			out.writeObject(arr);
		}
	}
}
