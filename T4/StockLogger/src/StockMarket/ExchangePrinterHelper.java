package StockMarket;


/**
 * Generated from IDL interface "ExchangePrinter".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 12:32:04 PM
 */

public final class ExchangePrinterHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(ExchangePrinterHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:StockMarket/ExchangePrinter:1.0", "ExchangePrinter");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final StockMarket.ExchangePrinter s)
	{
			any.insert_Object(s);
	}
	public static StockMarket.ExchangePrinter extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:StockMarket/ExchangePrinter:1.0";
	}
	public static ExchangePrinter read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(StockMarket._ExchangePrinterStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final StockMarket.ExchangePrinter s)
	{
		_out.write_Object(s);
	}
	public static StockMarket.ExchangePrinter narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof StockMarket.ExchangePrinter)
		{
			return (StockMarket.ExchangePrinter)obj;
		}
		else if (obj._is_a("IDL:StockMarket/ExchangePrinter:1.0"))
		{
			StockMarket._ExchangePrinterStub stub;
			stub = new StockMarket._ExchangePrinterStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static StockMarket.ExchangePrinter unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof StockMarket.ExchangePrinter)
		{
			return (StockMarket.ExchangePrinter)obj;
		}
		else
		{
			StockMarket._ExchangePrinterStub stub;
			stub = new StockMarket._ExchangePrinterStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
