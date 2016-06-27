package StockMarket;


/**
 * Generated from IDL interface "StockExchange".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 12:32:04 PM
 */

public abstract class StockExchangePOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, StockMarket.StockExchangeOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "buyStock", Integer.valueOf(0));
		m_opsHash.put ( "connectPrinter", Integer.valueOf(1));
	}
	private String[] ids = {"IDL:StockMarket/StockExchange:1.0"};
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
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // buyStock
			{
			try
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				_out.write_boolean(buyStock(_arg0));
			}
			catch(StockMarket.UnknownSymbol _ex0)
			{
				_out = handler.createExceptionReply();
				StockMarket.UnknownSymbolHelper.write(_out, _ex0);
			}
				break;
			}
			case 1: // connectPrinter
			{
				StockMarket.ExchangePrinter _arg0=StockMarket.ExchangePrinterHelper.read(_input);
				_out = handler.createReply();
				_out.write_boolean(connectPrinter(_arg0));
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
