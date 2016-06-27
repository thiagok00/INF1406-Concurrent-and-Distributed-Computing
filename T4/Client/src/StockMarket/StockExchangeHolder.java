package StockMarket;

/**
 * Generated from IDL interface "StockExchange".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 12:32:04 PM
 */

public final class StockExchangeHolder	implements org.omg.CORBA.portable.Streamable{
	 public StockExchange value;
	public StockExchangeHolder()
	{
	}
	public StockExchangeHolder (final StockExchange initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return StockExchangeHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = StockExchangeHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		StockExchangeHelper.write (_out,value);
	}
}
