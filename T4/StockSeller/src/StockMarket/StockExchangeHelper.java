package StockMarket;


/**
 * Generated from IDL interface "StockExchange".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 12:32:04 PM
 */

public final class StockExchangeHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(StockExchangeHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:StockMarket/StockExchange:1.0", "StockExchange");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final StockMarket.StockExchange s)
	{
			any.insert_Object(s);
	}
	public static StockMarket.StockExchange extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:StockMarket/StockExchange:1.0";
	}
	public static StockExchange read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(StockMarket._StockExchangeStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final StockMarket.StockExchange s)
	{
		_out.write_Object(s);
	}
	public static StockMarket.StockExchange narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof StockMarket.StockExchange)
		{
			return (StockMarket.StockExchange)obj;
		}
		else if (obj._is_a("IDL:StockMarket/StockExchange:1.0"))
		{
			StockMarket._StockExchangeStub stub;
			stub = new StockMarket._StockExchangeStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static StockMarket.StockExchange unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof StockMarket.StockExchange)
		{
			return (StockMarket.StockExchange)obj;
		}
		else
		{
			StockMarket._StockExchangeStub stub;
			stub = new StockMarket._StockExchangeStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
