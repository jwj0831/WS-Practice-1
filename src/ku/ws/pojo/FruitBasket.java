package ku.ws.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitBasket {
	private List<Map<String, String>> Fruits = new ArrayList<Map<String, String>>();
	//private Map<String, Integer> Fruits = new HashMap<String, Integer>();
	
	public FruitBasket() {
		Map<String, String> fruit1 = new HashMap<String, String>();
		fruit1.put("name", "Apple");
		fruit1.put("price", "1500");
		Fruits.add( fruit1 );
		
		Map<String, String> fruit2 = new HashMap<String, String>();
		fruit2.put("name", "Orange");
		fruit2.put("price", "1000");
		Fruits.add( fruit2 );
		
		Map<String, String> fruit3 = new HashMap<String, String>();
		fruit3.put("name", "Banana");
		fruit3.put("price", "400");
		Fruits.add( fruit3 );
		
		Map<String, String> fruit4 = new HashMap<String, String>();
		fruit4.put("name", "Kiwi");
		fruit4.put("price", "800");
		Fruits.add( fruit4 );
	}

	public List<Map<String, String>> getFruits() {
		return Fruits;
	}

	public void setFruits(List<Map<String, String>> fruits) {
		Fruits = fruits;
	}
}
