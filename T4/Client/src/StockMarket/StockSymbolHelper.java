package StockMarket;

/**
 * Generated from IDL alias "StockSymbol".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 12:32:04 PM
 */

public final class StockSymbolHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;

	public static void insert (org.omg.CORBA.Any any, java.lang.String s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static java.lang.String extract (final org.omg.CORBA.Any any)
	{
		if ( any.type().kind() == org.omg.CORBA.TCKind.tk_null)
		{
			throw new org.omg.CORBA.BAD_OPERATION ("Can't extract from Any with null type.");
		}
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(StockSymbolHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_alias_tc(StockMarket.StockSymbolHelper.id(), "StockSymbol",org.omg.CORBA.ORB.init().create_string_tc(0));
				}
			}
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:StockMarket/StockSymbol:1.0";
	}
	public static java.lang.String read (final org.omg.CORBA.portable.InputStream _in)
	{
		java.lang.String _result;
		_result=_in.read_string();
		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, java.lang.String _s)
	{
		java.lang.String tmpResult1 = _s;
_out.write_string( tmpResult1 );
	}
}
