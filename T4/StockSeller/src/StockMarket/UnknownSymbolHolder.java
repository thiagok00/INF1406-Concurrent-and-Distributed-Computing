package StockMarket;

/**
 * Generated from IDL exception "UnknownSymbol".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 11:43:31 AM
 */

public final class UnknownSymbolHolder
	implements org.omg.CORBA.portable.Streamable
{
	public StockMarket.UnknownSymbol value;

	public UnknownSymbolHolder ()
	{
	}
	public UnknownSymbolHolder(final StockMarket.UnknownSymbol initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return StockMarket.UnknownSymbolHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = StockMarket.UnknownSymbolHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		StockMarket.UnknownSymbolHelper.write(_out, value);
	}
}
