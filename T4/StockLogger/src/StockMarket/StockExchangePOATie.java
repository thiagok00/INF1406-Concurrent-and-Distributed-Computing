package StockMarket;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "StockExchange".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 12:32:04 PM
 */

public class StockExchangePOATie
	extends StockExchangePOA
{
	private StockExchangeOperations _delegate;

	private POA _poa;
	public StockExchangePOATie(StockExchangeOperations delegate)
	{
		_delegate = delegate;
	}
	public StockExchangePOATie(StockExchangeOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public StockMarket.StockExchange _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		StockMarket.StockExchange __r = StockMarket.StockExchangeHelper.narrow(__o);
		if (__o != null && __o != __r)
		{
			((org.omg.CORBA.portable.ObjectImpl)__o)._set_delegate(null);

		}
		return __r;
	}
	public StockMarket.StockExchange _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		StockMarket.StockExchange __r = StockMarket.StockExchangeHelper.narrow(__o);
		if (__o != null && __o != __r)
		{
			((org.omg.CORBA.portable.ObjectImpl)__o)._set_delegate(null);

		}
		return __r;
	}
	public StockExchangeOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(StockExchangeOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public boolean buyStock(java.lang.String symbol) throws StockMarket.UnknownSymbol
	{
		return _delegate.buyStock(symbol);
	}

	public boolean connectPrinter(StockMarket.ExchangePrinter printer)
	{
		return _delegate.connectPrinter(printer);
	}

}
