package StockManagament;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class StockMain {

	public static void main(String Args[]) {
		StockPortfolio portfolio = new StockPortfolio();

		try {
			FileReader reader = new FileReader("/Users/panchamishenoy/Desktop/assignment/Day014/data/stock.json");
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(reader);
			JSONArray stocks = (JSONArray) obj.get("Stocks");

			Iterator<JSONObject> itr = stocks.iterator();
			while (itr.hasNext()) {
				JSONObject stock = itr.next();
				String stockName = (String) stock.get("name");
				double numberOfShares = (double) stock.get("no_of_shares");
				double sharePrice = (double) stock.get("price");
				Stock newStock = new Stock(stockName, numberOfShares, sharePrice);
				portfolio.addStock(newStock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Stock Report");
		for (Stock stock : portfolio.getStocks()) {
			System.out.println("Stock Name: " + stock.getStockName());
			System.out.println("Stock Value: " + portfolio.valueOf(stock));
			System.out.println();
		}

		System.out.println("Total Value of Portfolio: " + portfolio.valueOfPortfolio());
	}
}
