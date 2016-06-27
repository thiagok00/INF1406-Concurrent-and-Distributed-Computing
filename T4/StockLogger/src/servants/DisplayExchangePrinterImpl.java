package servants;

import StockMarket.ExchangePrinterPOA;

public class DisplayExchangePrinterImpl extends ExchangePrinterPOA{

	@Override
	public void print(String symbol) {
		System.out.println(symbol);
	}

}
