package StockMarket;

/**
 * Generated from IDL valuetype "StockInfo".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 11:43:31 AM
 */

public abstract class StockInfo
	implements org.omg.CORBA.portable.StreamableValue
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	private String[] _truncatable_ids = {"IDL:StockMarket/StockInfo:1.0"};
	public java.lang.String name;
	public float value;
	public abstract java.lang.String _toString();

	public void _write (org.omg.CORBA.portable.OutputStream os)
	{
		java.lang.String tmpResult3 = name;
os.write_string( tmpResult3 );
		os.write_float(value);
	}

	public void _read (final org.omg.CORBA.portable.InputStream os)
	{
		name=os.read_string();
		value=os.read_float();
	}

	public String[] _truncatable_ids()
	{
		return _truncatable_ids;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return StockMarket.StockInfoHelper.type();
	}
}
