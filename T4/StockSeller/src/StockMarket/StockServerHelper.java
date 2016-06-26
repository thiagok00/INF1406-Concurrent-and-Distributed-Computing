package StockMarket;


/**
 * Generated from IDL interface "StockServer".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 2:44:26 AM
 */

public final class StockServerHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(StockServerHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:StockMarket/StockServer:1.0", "StockServer");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final StockMarket.StockServer s)
	{
			any.insert_Object(s);
	}
	public static StockMarket.StockServer extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:StockMarket/StockServer:1.0";
	}
	public static StockServer read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(StockMarket._StockServerStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final StockMarket.StockServer s)
	{
		_out.write_Object(s);
	}
	public static StockMarket.StockServer narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof StockMarket.StockServer)
		{
			return (StockMarket.StockServer)obj;
		}
		else if (obj._is_a("IDL:StockMarket/StockServer:1.0"))
		{
			StockMarket._StockServerStub stub;
			stub = new StockMarket._StockServerStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static StockMarket.StockServer unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof StockMarket.StockServer)
		{
			return (StockMarket.StockServer)obj;
		}
		else
		{
			StockMarket._StockServerStub stub;
			stub = new StockMarket._StockServerStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
