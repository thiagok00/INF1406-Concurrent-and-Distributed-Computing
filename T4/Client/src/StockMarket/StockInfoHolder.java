package StockMarket;

/**
 * Generated from IDL valuetype "StockInfo".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 11:43:31 AM
 */

public final class StockInfoHolder
	implements org.omg.CORBA.portable.Streamable
{
	public StockMarket.StockInfo value;
	public StockInfoHolder () {}
	public StockInfoHolder (final StockMarket.StockInfo initial)
	{
		value = initial;
	}
	public void _read (final org.omg.CORBA.portable.InputStream is)
	{
		value = StockMarket.StockInfoHelper.read (is);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream os)
	{
		StockMarket.StockInfoHelper.write (os, value);
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return value._type ();
	}
}
