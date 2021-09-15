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
	private String stockName;
	private String stockSymbol;
	private double numberOfShares;
	private double sharePrice;

	Stock(String stockName, double numberOfShares, double sharePrice) {
		this.stockName = stockName;
		this.stockSymbol = stockSymbol;
		this.numberOfShares = numberOfShares;
		this.sharePrice = sharePrice;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(double numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	@Override
	public String toString() {
		return "Stock\n numberOfShares=" + numberOfShares + " \n sharePrice=" + sharePrice + "\n stockName=" + stockName
				+ "\n stockSymbol=" + stockSymbol;
	}
}