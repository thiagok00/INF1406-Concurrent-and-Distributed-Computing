package valuetypes;

import StockMarket.StockInfo;

public class StockInfoImpl extends StockInfo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StockInfoImpl(){
	}

	
	@Override
	public String _toString() {
		return "A ação " + this.name + " tem o valor de: " + this.value;
	}

}
