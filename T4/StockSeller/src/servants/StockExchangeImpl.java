package servants;

import java.util.ArrayList;
import java.util.List;


import StockMarket.ExchangePrinter;
import StockMarket.StockExchangePOA;
import StockMarket.UnknownSymbol;

public class StockExchangeImpl  extends StockExchangePOA {

	private List<ExchangePrinter> listPrinter;
	private static StockExchangeImpl stockExchangeImpl = new StockExchangeImpl();
	
	private StockExchangeImpl(){
		listPrinter = new ArrayList<ExchangePrinter>();
	}
	
	public static StockExchangeImpl getInstance(){
		return stockExchangeImpl;
		
	}
	
	@Override
	public boolean buyStock(String symbol) throws UnknownSymbol {
		try {
			StockServerImpl stockServer = StockServerImpl.getInstance();
			
			Float valueAntes = stockServer.getStockValue(symbol);
			stockServer.aumenta10(symbol);
			Float valueDepois = stockServer.getStockValue(symbol);
			
			for(ExchangePrinter p : listPrinter){
				try {
					p.print("A ação " + symbol + " foi vendida por " + valueDepois 
							+ " (Valor Anterior: " + valueAntes + ")");
				} catch (Exception e) {
					System.out.println("Erro ao comunicar com a impressora");
				}
			}
		    return true;
		    
		} catch (UnknownSymbol ux){
			throw ux;
		} catch (Exception ex) {
			System.out.println("Problema com venda da ação!");
			return false;
		}    
	}

	@Override
	public boolean connectPrinter(ExchangePrinter printer) {
		try {
			listPrinter.add(printer);
			return true;
		} catch (Exception e){
			return false;
		}
	}

}
