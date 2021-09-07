
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Inventory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONParser j =new JSONParser();
		JSONParser j1 = new JSONParser();
		HashMap<String,Double> map = new HashMap<String,Double>();
		try {
			Reader reader = new FileReader("/Users/panchamishenoy/Desktop/assignment/Day014/data/inventory.json");
			JSONObject jsonObject = (JSONObject) j.parse(reader);
			//System.out.println(jsonObject);
			JSONArray array = (JSONArray) jsonObject.get("inventory");
			System.out.println(array);
			Iterator<JSONObject> iterator = array.iterator();
			while(iterator.hasNext())
			{
				JSONObject jsonObject2 = iterator.next();
				String name= (String) jsonObject2.get("name");
				
				double price= (double) jsonObject2.get("pricePerKg");
				double weight= (double) jsonObject2.get("weight");
				map.put(name,(price*weight));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
		}
		write(map);
	}
	private static void write(HashMap<String, Double> map) {
		JSONArray array = new JSONArray ();
		
		for (Entry<String, Double> entry :map.entrySet()) {
			JSONObject obj = new JSONObject();
			obj.put("name",entry.getKey());
			obj.put("totalprice",entry.getValue());
			array.add(obj);
		}
		
		JSONObject obj = new JSONObject();
		obj.put("results", array);
		
		try {
			FileWriter writer = new FileWriter("/Users/panchamishenoy/Desktop/assignment/Day014/data/result.json");
			writer.write(obj.toJSONString());
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
