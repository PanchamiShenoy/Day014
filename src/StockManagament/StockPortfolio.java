package StockManagament;

import java.util.*;

public class StockPortfolio {
	private List<Stock> stocks = new ArrayList<Stock>();

	StockPortfolio() {

	}

	StockPortfolio(List<Stock> stocks) {
		this.stocks = stocks;
	}

	/**
	 * add stock to list of stocks in portfolio
	 * 
	 * @param stock
	 */
	public void addStock(Stock stock) {
		stocks.add(stock);
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	/**
	 * get the total value of the stock
	 * 
	 * @param stock
	 * @return
	 */
	public double valueOf(Stock stock) {
		return (double) (stock.getSharePrice() * stock.getNumberOfShares());
	}

	/**
	 * get the total value of entire portfolio
	 * 
	 * @return
	 */
	public double valueOfPortfolio() {
		double value = 0;
		for (Stock stock : stocks) {
			value += valueOf(stock);
		}

		return value;
	}

}