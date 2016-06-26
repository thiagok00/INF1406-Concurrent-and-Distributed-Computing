package StockMarket;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "StockServer".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 11:43:31 AM
 */

public class StockServerPOATie
	extends StockServerPOA
{
	private StockServerOperations _delegate;

	private POA _poa;
	public StockServerPOATie(StockServerOperations delegate)
	{
		_delegate = delegate;
	}
	public StockServerPOATie(StockServerOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public StockMarket.StockServer _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		StockMarket.StockServer __r = StockMarket.StockServerHelper.narrow(__o);
		if (__o != null && __o != __r)
		{
			((org.omg.CORBA.portable.ObjectImpl)__o)._set_delegate(null);

		}
		return __r;
	}
	public StockMarket.StockServer _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		StockMarket.StockServer __r = StockMarket.StockServerHelper.narrow(__o);
		if (__o != null && __o != __r)
		{
			((org.omg.CORBA.portable.ObjectImpl)__o)._set_delegate(null);

		}
		return __r;
	}
	public StockServerOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(StockServerOperations delegate)
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
	public float getStockValue(java.lang.String symbol) throws StockMarket.UnknownSymbol
	{
		return _delegate.getStockValue(symbol);
	}

	public StockMarket.StockInfo[] getStockInfoList()
	{
		return _delegate.getStockInfoList();
	}

	public java.lang.String[] getStockSymbols()
	{
		return _delegate.getStockSymbols();
	}

}
