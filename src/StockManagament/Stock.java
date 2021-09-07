package StockManagament;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.Scanner;

public class Stock {
	public static Scanner sc = new Scanner(System.in);
	public static JSONArray arr = new JSONArray();

	public static void main(String[] args) {
		getInputFromUser();
	}

	/*
	 * method to take user choice
	 */
	private static void getInputFromUser() {
		System.out.println("Which operation do you want to perform ?\n1.Add Stock \n2.Print stock report \n3.Exit");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			addStock();
			break;
		case 2:
			printStock();
			break;
		case 3:
			System.exit(1);
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}

	/*
	 * method to display stocks
	 */
	public static void printStock() {
		JSONParser j = new JSONParser();
		try {
			Reader reader = new FileReader("/Users/panchamishenoy/Desktop/assignment/Day014/data/stock.json");
			JSONObject jsonObject = (JSONObject) j.parse(reader);
			JSONArray array = (JSONArray) jsonObject.get("Stocks");
			System.out.println(array);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getInputFromUser();
	}

	/*
	 * method to add stocks to json file
	 */
	public static void addStock() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Stock Name : ");
		String stockName = sc.nextLine();
		System.out.println("Enter number of shares: ");
		int noOfShares = sc.nextInt();
		System.out.println("Enter share price: ");
		double sharePrice = sc.nextDouble();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", stockName);
		jsonObject.put("no_of_shares", noOfShares);
		jsonObject.put("price", sharePrice);
		arr.add(jsonObject);
		JSONObject obj = new JSONObject();
		obj.put("Stocks", arr);
		try {
			FileWriter writer = new FileWriter("/Users/panchamishenoy/Desktop/assignment/Day014/data/stock.json");
			writer.write(obj.toJSONString());
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getInputFromUser();
	}
}