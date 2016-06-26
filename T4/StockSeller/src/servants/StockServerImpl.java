package servants;

import java.util.HashMap;
import java.util.Map;

import StockMarket.StockServerPOA;
import StockMarket.UnknownSymbol;

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

     public synchronized float getStockValue(String symbol) throws UnknownSymbol {
    	 if (myStock.containsKey(symbol)) {
    		 return myStock.get(symbol);
    	 } else {
    		 throw new UnknownSymbol("Simbolo Não Encontrado!", symbol);
    	 }
     }

     public synchronized String[] getStockSymbols() {
    	 return myStock.keySet().toArray(new String[0]);
     }
}
