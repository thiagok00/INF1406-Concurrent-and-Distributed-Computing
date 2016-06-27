package StockMarket;


/**
 * Generated from IDL interface "StockExchange".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 12:32:04 PM
 */

public interface StockExchangeOperations
{
	/* constants */
	/* operations  */
	boolean buyStock(java.lang.String symbol) throws StockMarket.UnknownSymbol;
	boolean connectPrinter(StockMarket.ExchangePrinter printer);
}
