package StockMarket;

/**
 * Generated from IDL interface "StockServer".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 11:43:31 AM
 */

public final class StockServerHolder	implements org.omg.CORBA.portable.Streamable{
	 public StockServer value;
	public StockServerHolder()
	{
	}
	public StockServerHolder (final StockServer initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return StockServerHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = StockServerHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		StockServerHelper.write (_out,value);
	}
}
