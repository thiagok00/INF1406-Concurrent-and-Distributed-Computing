package StockMarket;

/**
 * Generated from IDL valuetype "StockInfo".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 11:43:31 AM
 */

public abstract class StockInfoHelper
{
	private volatile static org.omg.CORBA.TypeCode _type = null;
	public static void insert (org.omg.CORBA.Any a, StockMarket.StockInfo v)
	{
		a.insert_Value (v, v._type());
	}
	public static StockMarket.StockInfo extract (org.omg.CORBA.Any a)
	{
		return (StockMarket.StockInfo)a.extract_Value();
	}
	public static org.omg.CORBA.TypeCode type()
	{
		if (_type == null)
		{
			synchronized(StockInfoHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_value_tc ("IDL:StockMarket/StockInfo:1.0", "StockInfo", (short)0, null, new org.omg.CORBA.ValueMember[] {new org.omg.CORBA.ValueMember ("name", "IDL:StockMarket/StockSymbol:1.0", "StockInfo", "1.0", org.omg.CORBA.ORB.init().create_alias_tc(StockMarket.StockSymbolHelper.id(), "StockSymbol",org.omg.CORBA.ORB.init().create_string_tc(0)), null, (short)1), new org.omg.CORBA.ValueMember ("value", "IDL:*primitive*:1.0", "StockInfo", "1.0", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(6)), null, (short)1)});
				}
			}
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:StockMarket/StockInfo:1.0";
	}
	public static StockMarket.StockInfo read (org.omg.CORBA.portable.InputStream is)
	{
		return (StockMarket.StockInfo)((org.omg.CORBA_2_3.portable.InputStream)is).read_value ("IDL:StockMarket/StockInfo:1.0");
	}
	public static void write (org.omg.CORBA.portable.OutputStream os, StockMarket.StockInfo val)
	{
		((org.omg.CORBA_2_3.portable.OutputStream)os).write_value (val, "IDL:StockMarket/StockInfo:1.0");
	}
}
