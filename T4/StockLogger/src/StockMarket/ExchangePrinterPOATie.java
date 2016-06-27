package StockMarket;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "ExchangePrinter".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 12:32:04 PM
 */

public class ExchangePrinterPOATie
	extends ExchangePrinterPOA
{
	private ExchangePrinterOperations _delegate;

	private POA _poa;
	public ExchangePrinterPOATie(ExchangePrinterOperations delegate)
	{
		_delegate = delegate;
	}
	public ExchangePrinterPOATie(ExchangePrinterOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public StockMarket.ExchangePrinter _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		StockMarket.ExchangePrinter __r = StockMarket.ExchangePrinterHelper.narrow(__o);
		if (__o != null && __o != __r)
		{
			((org.omg.CORBA.portable.ObjectImpl)__o)._set_delegate(null);

		}
		return __r;
	}
	public StockMarket.ExchangePrinter _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		StockMarket.ExchangePrinter __r = StockMarket.ExchangePrinterHelper.narrow(__o);
		if (__o != null && __o != __r)
		{
			((org.omg.CORBA.portable.ObjectImpl)__o)._set_delegate(null);

		}
		return __r;
	}
	public ExchangePrinterOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(ExchangePrinterOperations delegate)
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
	public void print(java.lang.String symbol)
	{
_delegate.print(symbol);
	}

}
