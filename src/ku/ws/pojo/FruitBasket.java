package ku.ws.pojo;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {
	private Map<String, Integer> Fruits = new HashMap<String, Integer>();
	
	public FruitBasket() {
		Fruits.put("Apple", 1500);
		Fruits.put("Orange",1000);
		Fruits.put("Banana", 400);
		Fruits.put("Kiwi", 800);
	}

	public Map<String, Integer> getFruits() {
		return Fruits;
	}

	public void setFruits(Map<String, Integer> fruits) {
		Fruits = fruits;
	}
}
