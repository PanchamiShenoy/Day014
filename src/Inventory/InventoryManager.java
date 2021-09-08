package Inventory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;

public class InventoryManager {
	static Map<String, Double> map = new HashMap<>();

	/*
	 * method to iterate through list and add it to HashMap
	 */
	public static void manager() {
		ArrayList<JSONObject> list = inventoryFactory();

		for (JSONObject obj : list) {
			String type = (String) obj.get("type");
			String name = (String) obj.get("name");
			double weight = (double) obj.get("weight");
			double pricePerWeight = (double) obj.get("pricePerKg");
			double totalPrice = pricePerWeight * weight;
			map.put(name, totalPrice);
		}

		display();

	}

	/*
	 * method to display json object
	 */
	private static void display() {
		JSONArray array = new JSONArray();
		for (Entry<String, Double> entry : map.entrySet()) {
			JSONObject obj = new JSONObject();
			obj.put("name", entry.getKey());
			obj.put("totalprice", entry.getValue());
			array.add(obj);
		}

		JSONObject obj = new JSONObject();
		obj.put("results", array);
		System.out.println(obj.toJSONString());

	}

	/*
	 * method returns ArrayList to InventoryManager
	 */
	private static ArrayList<JSONObject> inventoryFactory() {

		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONParser parser = new JSONParser();
		try {
			Reader reader = new FileReader("/Users/panchamishenoy/Desktop/assignment/Day014/data/inventory.json");
			JSONObject inventory = (JSONObject) parser.parse(reader);
			JSONArray array = (JSONArray) inventory.get("inventory");
			Iterator<JSONObject> iterator = array.iterator();
			while (iterator.hasNext()) {
				JSONObject object2 = iterator.next();
				list.add(object2);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String args[]) {
		InventoryManager.manager();
	}

}