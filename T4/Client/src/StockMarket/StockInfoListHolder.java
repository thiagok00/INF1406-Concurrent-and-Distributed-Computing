package StockMarket;

/**
 * Generated from IDL alias "StockInfoList".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 11:43:31 AM
 */

public final class StockInfoListHolder
	implements org.omg.CORBA.portable.Streamable
{
	public StockMarket.StockInfo[] value;

	public StockInfoListHolder ()
	{
	}
	public StockInfoListHolder (final StockMarket.StockInfo[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return StockInfoListHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = StockInfoListHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		StockInfoListHelper.write (out,value);
	}
}
