package StockMarket;


/**
 * Generated from IDL interface "StockServer".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 1:12:09 AM
 */

public abstract class StockServerPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, StockMarket.StockServerOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "getStockValue", Integer.valueOf(0));
		m_opsHash.put ( "getStockSymbols", Integer.valueOf(1));
	}
	private String[] ids = {"IDL:StockMarket/StockServer:1.0"};
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
			case 0: // getStockValue
			{
			try
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				_out.write_float(getStockValue(_arg0));
			}
			catch(StockMarket.UnknownSymbol _ex0)
			{
				_out = handler.createExceptionReply();
				StockMarket.UnknownSymbolHelper.write(_out, _ex0);
			}
				break;
			}
			case 1: // getStockSymbols
			{
				_out = handler.createReply();
				StockMarket.StockSymbolListHelper.write(_out,getStockSymbols());
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
