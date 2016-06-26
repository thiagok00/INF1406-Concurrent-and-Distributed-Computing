package StockMarket;

/**
 * Generated from IDL interface "ExchangePrinter".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 12:32:04 PM
 */

public final class ExchangePrinterHolder	implements org.omg.CORBA.portable.Streamable{
	 public ExchangePrinter value;
	public ExchangePrinterHolder()
	{
	}
	public ExchangePrinterHolder (final ExchangePrinter initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return ExchangePrinterHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = ExchangePrinterHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		ExchangePrinterHelper.write (_out,value);
	}
}
