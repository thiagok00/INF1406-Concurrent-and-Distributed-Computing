package StockMarket;


/**
 * Generated from IDL exception "UnknownSymbol".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 2:44:26 AM
 */

public final class UnknownSymbolHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(UnknownSymbolHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_exception_tc(StockMarket.UnknownSymbolHelper.id(),"UnknownSymbol",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("symbol", org.omg.CORBA.ORB.init().create_string_tc(0), null)});
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final StockMarket.UnknownSymbol s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static StockMarket.UnknownSymbol extract (final org.omg.CORBA.Any any)
	{
		org.omg.CORBA.portable.InputStream in = any.create_input_stream();
		try
		{
			return read (in);
		}
		finally
		{
			try
			{
				in.close();
			}
			catch (java.io.IOException e)
			{
			throw new RuntimeException("Unexpected exception " + e.toString() );
			}
		}
	}

	public static String id()
	{
		return "IDL:StockMarket/UnknownSymbol:1.0";
	}
	public static StockMarket.UnknownSymbol read (final org.omg.CORBA.portable.InputStream in)
	{
		String id = in.read_string();
		if (!id.equals(id())) throw new org.omg.CORBA.MARSHAL("wrong id: " + id);
		java.lang.String x0;
		x0=in.read_string();
		final StockMarket.UnknownSymbol result = new StockMarket.UnknownSymbol(id, x0);
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final StockMarket.UnknownSymbol s)
	{
		out.write_string(id());
		java.lang.String tmpResult0 = s.symbol;
out.write_string( tmpResult0 );
	}
}
