package StockMarket;

/**
 * Generated from IDL exception "UnknownSymbol".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at Jun 26, 2016 2:44:26 AM
 */

public final class UnknownSymbol
	extends org.omg.CORBA.UserException
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	public UnknownSymbol()
	{
		super(StockMarket.UnknownSymbolHelper.id());
	}

	public java.lang.String symbol = "";
	public UnknownSymbol(java.lang.String _reason,java.lang.String symbol)
	{
		super(_reason);
		this.symbol = symbol;
	}
	public UnknownSymbol(java.lang.String symbol)
	{
		super(StockMarket.UnknownSymbolHelper.id());
		this.symbol = symbol;
	}
}
