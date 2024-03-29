package StockMarket;


/**
 * Generated from IDL interface "StockServer".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 12:32:04 PM
 */

public interface StockServerOperations
{
	/* constants */
	/* operations  */
	float getStockValue(java.lang.String symbol) throws StockMarket.UnknownSymbol;
	java.lang.String[] getStockSymbols();
	StockMarket.StockInfo[] getStockInfoList();
}
