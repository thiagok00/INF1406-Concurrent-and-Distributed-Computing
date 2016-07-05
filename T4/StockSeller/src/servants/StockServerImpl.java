package servants;

import java.util.HashMap;
import java.util.Set;

import StockMarket.StockInfo;
import StockMarket.StockServerPOA;
import StockMarket.UnknownSymbol;
import valuetypes.StockInfoImpl;

public class StockServerImpl extends StockServerPOA {
     // As ações com seus respectivos valores
     private static HashMap<String, Float> myStock;
     private static StockServerImpl stockServerImpl = null;
     
     private StockServerImpl() {
    	 myStock = new HashMap<String,Float>();
    	 myStock.put("ABC", 1.43f);
    	 myStock.put("DEF", 2.221f);
    	 myStock.put("HIJ", 50.243f);
    	 myStock.put("LMN", 43.58f);
    	 myStock.put("OPQ", 8.65f);
    	 myStock.put("RST", 0.33f);
     }
     
     public static StockServerImpl getInstance(){
    	 if (stockServerImpl == null){
    		 stockServerImpl = new StockServerImpl();
    		 return stockServerImpl;
    	 }
    	 return stockServerImpl;
     }

     public synchronized float getStockValue(String symbol) throws UnknownSymbol{
    	 if (myStock.containsKey(symbol)) {
    		 return myStock.get(symbol);
    	 } else {
    		 throw new UnknownSymbol("Simbolo Não Encontrado!", symbol);
    	 }
     }

     public synchronized String[] getStockSymbols() {
    	 return myStock.keySet().toArray(new String[0]);
     }

	@Override
	public synchronized StockInfo[] getStockInfoList() {
		
		StockInfo[] stockList = new StockInfo[myStock.size()];
		
		Set<String> keys = myStock.keySet();
		int i = 0;
		for (String key : keys){
			StockInfo stock = new StockInfoImpl();
			stock.name=key;
			stock.value=myStock.get(key);
			stockList[i] = stock;
			
			i++;
		}
		
		return stockList;
	}

	public synchronized void aumenta10(String symbol) {
		if (myStock.containsKey(symbol)) {
   		 	Float value = myStock.remove(symbol);
   		 	value = (float) (value * 1.1);
   		 	myStock.put(symbol,value);
		}
   	 
	}
}
