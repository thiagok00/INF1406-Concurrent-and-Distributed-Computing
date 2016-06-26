package servants;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import StockMarket.StockInfo;
import StockMarket.StockServerPOA;
import StockMarket.UnknownSymbol;
import valuetypes.StockInfoImpl;

public class StockServerImpl extends StockServerPOA {
     // As ações com seus respectivos valores
     private Map<String, Float> myStock;
     
     public StockServerImpl() {
    	 myStock = new HashMap<String,Float>();
    	 
    	 myStock.put("ABC", 1.43f);
    	 myStock.put("DEF", 2.221f);
    	 myStock.put("HIJ", 50.243f);
    	 myStock.put("LMN", 43.58f);
    	 myStock.put("OPQ", 8.65f);
    	 myStock.put("RST", 0.33f);
     }

     public float getStockValue(String symbol) throws UnknownSymbol {
    	 if (myStock.containsKey(symbol)) {
    		 return myStock.get(symbol);
    	 } else {
    		 throw new UnknownSymbol("Simbolo Não Encontrado!", symbol);
    	 }
     }

     public String[] getStockSymbols() {
    	 return myStock.keySet().toArray(new String[0]);
     }

	@Override
	public StockInfo[] getStockInfoList() {
		
		StockInfo[] stockList = new StockInfo[myStock.size()];
		
		Set<String> keys = myStock.keySet();
		int i = 0;
		for (String key : keys){
			//System.out.println(key);
			//System.out.println(myStock.get(key));
			StockInfo stock = new StockInfoImpl();
			stock.name=key;
			stock.value=myStock.get(key);
			stockList[i] = stock;
			
			i++;
		}
		
		return stockList;
	}
}
