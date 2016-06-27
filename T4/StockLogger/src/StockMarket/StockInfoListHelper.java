package StockMarket;

/**
 * Generated from IDL alias "StockInfoList".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 12:32:04 PM
 */

public final class StockInfoListHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;

	public static void insert (org.omg.CORBA.Any any, StockMarket.StockInfo[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static StockMarket.StockInfo[] extract (final org.omg.CORBA.Any any)
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
			synchronized(StockInfoListHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_alias_tc(StockMarket.StockInfoListHelper.id(), "StockInfoList",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init().create_value_tc ("IDL:StockMarket/StockInfo:1.0", "StockInfo", (short)0, null, new org.omg.CORBA.ValueMember[] {new org.omg.CORBA.ValueMember ("name", "IDL:StockMarket/StockSymbol:1.0", "StockInfo", "1.0", org.omg.CORBA.ORB.init().create_alias_tc(StockMarket.StockSymbolHelper.id(), "StockSymbol",org.omg.CORBA.ORB.init().create_string_tc(0)), null, (short)1), new org.omg.CORBA.ValueMember ("value", "IDL:*primitive*:1.0", "StockInfo", "1.0", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(6)), null, (short)1)})));
				}
			}
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:StockMarket/StockInfoList:1.0";
	}
	public static StockMarket.StockInfo[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		StockMarket.StockInfo[] _result;
		int _l_result1 = _in.read_long();
		try
		{
			 int x = _in.available();
			 if ( x > 0 && _l_result1 > x )
				{
					throw new org.omg.CORBA.MARSHAL("Sequence length too large. Only " + x + " available and trying to assign " + _l_result1);
				}
		}
		catch (java.io.IOException e)
		{
		}
		_result = new StockMarket.StockInfo[_l_result1];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=(StockMarket.StockInfo)((org.omg.CORBA_2_3.portable.InputStream)_in).read_value ("IDL:StockMarket/StockInfo:1.0");
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, StockMarket.StockInfo[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			((org.omg.CORBA_2_3.portable.OutputStream)_out).write_value (_s[i], (String)null);
		}

	}
}
