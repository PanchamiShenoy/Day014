package CommercialData;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
public class CommercialDataProcessing {


    private static StockAccount account = new StockAccount("/Users/panchamishenoy/Desktop/assignment/Day014/data/Output.json");

    public static void main(String Args[]) {
        account.initializeAccountFromFile();

        Scanner in = new Scanner(System.in);

       System.out.println("Welcome to the Stock broker program");
       System.out.println("Select an Option to proceed");
        while (true) {
        	  System.out.println("Main Menu");
        	  System.out.println("1. Buy Stocks\n2. Sell Stocks\n3. Print Stock Report\n4. Exit");
            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    buyStocksMenu();
                    break;
                case 2:
                    sellStocksMenu();
                    break;
                case 3:
                    account.printReport();
                    break;
                case 4:
                    return;
                default:
                	  System.out.println("Invalid Option");
                    break;
            }
        }
    }
    
    /**
     * Method used to provide Console UI to users for selling stocks
     */
    private static void sellStocksMenu() {
        PrintWriter out = new PrintWriter(System.out, true);
        Scanner in = new Scanner(System.in);
        
        out.println("Select the stock you want to Sell");
        int count = 1;
        for (CompanyShare companyShare : account.getCompanyShares()) {
        	  System.out.println(count + ":");
        	  System.out.println("Stock Symbol : " + companyShare.getStockSymbol());
            System.out.println("Number Of Shares : " + companyShare.getNumberOfShares());
            System.out.println();
            count++;
        }

        int stockChoice = in.nextInt();
        while (stockChoice >= count) {
            out.println("Invalid option");
            stockChoice = in.nextInt();
        }

        out.println("Enter the amount to sell");
        int countShares = in.nextInt();
        CompanyShare selectedStock = account.getCompanyShares().get(stockChoice - 1);
        while (countShares <(long) selectedStock.getNumberOfShares() || countShares<=0)
        {
            out.println("Enter a valid amount");
            countShares = in.nextInt();
        }

        account.sell(countShares, selectedStock.getStockSymbol());
        account.save("/Users/panchamishenoy/Desktop/assignment/Day014/data/Output.json");
    }

    /**
     * Method used to provide Console UI to users for buying stocks
     */
    private static void buyStocksMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println("Select the stock you want to buy");
        JSONArray stocks = readJSON();
        Iterator<JSONObject> itr = stocks.iterator();
        int count = 1;
        while (itr.hasNext()) {
        	  System.out.println(count + ":");
            JSONObject stock = itr.next();
            System.out.println("Stock Name: " + stock.get("stockName"));
            System.out.println("Stock Symbol: " + stock.get("stockSymbol"));
            System.out.println("Share price: " + stock.get("sharePrice"));
            System.out.println("Number Of Shares: " + stock.get("numberOfShares"));
            System.out.println();
            count++;
        }
        
        int stockChoice = in.nextInt();
        while (stockChoice >= count) {
        	  System.out.println("Invalid option");
            stockChoice = in.nextInt();
        }

        System.out.println("Enter the number of share to buy");
        int countShares = in.nextInt();
        JSONObject selectedStock = (JSONObject) stocks.get(stockChoice - 1);
        while (countShares > (double)selectedStock.get("numberOfShares") || countShares<=0)
        {
        	  System.out.println("Enter a valid number os sharet");
            countShares = in.nextInt();
        }
        System.out.println(selectedStock.get("stockSymbol")+""+countShares);
        account.buy(countShares,(String)selectedStock.get("stockSymbol"));
        account.save("/Users/panchamishenoy/Desktop/assignment/Day014/data/Output.json");
    }
    
    
    /** 
     * @return JSONArray
     * Method used to read JSON from stocks.json file
     * and return the JSONArray
     */
    private static JSONArray readJSON() {
        try {
        	//System.out.println("hello");
            FileReader reader = new FileReader("/Users/panchamishenoy/Desktop/assignment/Day014/data/stock2.json");
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(reader);
            JSONArray stocks = (JSONArray) obj.get("Stocks");
            //System.out.println(stocks);
            return stocks;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
