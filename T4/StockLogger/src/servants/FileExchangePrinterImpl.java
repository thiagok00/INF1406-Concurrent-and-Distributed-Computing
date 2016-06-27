package servants;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import StockMarket.ExchangePrinterPOA;

public class FileExchangePrinterImpl extends ExchangePrinterPOA{

	private static boolean arquivoJaUtilizado = false;
	private static String caminho =""; 
	
	@Override
	public void print(String symbol) {
		try {
			FileWriter writerFileArq;
			PrintWriter gravarArq;
			if (caminho.equals(""))
				caminho = "impressoraArquivo_"+System.currentTimeMillis()+".txt";
			
			writerFileArq = new FileWriter(caminho,arquivoJaUtilizado);
			gravarArq = new PrintWriter(writerFileArq);
			arquivoJaUtilizado = true;
			
			gravarArq.println(symbol);
			
			gravarArq.close();
			writerFileArq.close();
		} catch (IOException e) {
			e.getCause().printStackTrace();
		}
		
	}

}
