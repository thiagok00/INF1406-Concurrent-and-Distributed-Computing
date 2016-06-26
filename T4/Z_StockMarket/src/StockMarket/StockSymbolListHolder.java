package StockMarket;

/**
 * Generated from IDL alias "StockSymbolList".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 1:12:09 AM
 */

public final class StockSymbolListHolder
	implements org.omg.CORBA.portable.Streamable
{
	public java.lang.String[] value;

	public StockSymbolListHolder ()
	{
	}
	public StockSymbolListHolder (final java.lang.String[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return StockSymbolListHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = StockSymbolListHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		StockSymbolListHelper.write (out,value);
	}
}
