package principal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.omg.CORBA.COMM_FAILURE;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TRANSIENT;

import StockMarket.StockInfo;
import StockMarket.StockInfoHelper;
import StockMarket.StockServer;
import StockMarket.StockServerHelper;
import StockMarket.UnknownSymbol;
import valuetypes.StockInfoFactory;

public class Client {

	public static void main(String[] args) {
		try {
			// As propriedades que informam o uso do JacORB como ORB.
			Properties orbProps = new Properties();
			orbProps.setProperty("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
			orbProps.setProperty("org.omg.CORBA.ORBSingletonClass","org.jacorb.orb.ORBSingleton");
			// Inicializa o ORB.
			org.omg.CORBA_2_3.ORB orb = (org.omg.CORBA_2_3.ORB) ORB.init(args, orbProps);
			orb.register_value_factory(StockInfoHelper.id(),new StockInfoFactory());
			
			// Lê o IOR do arquivo cujo nome é passado como parâmetro
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("../StockSeller/ior.txt")));
			
			String ior = reader.readLine();
			
			reader.close();
			
			// Obtém a referência para o objeto CORBA
			org.omg.CORBA.Object obj = orb.string_to_object(ior);
			StockServer server = StockServerHelper.narrow(obj);
			
			System.out.println("Ações de mercado obtidas do StockServer:");
			//Parte 1
			/*String[] stockSymbols = server.getStockSymbols();
			for (int i = 0; i < stockSymbols.length; i++) {
		    	try {
					System.out.println(stockSymbols[i] + " "+ server.getStockValue(stockSymbols[i]));
				} catch (UnknownSymbol e) {
					System.out.println(e.symbol + " - Nao Encontrado!");
				}
		    }*/
			
			//Parte 2
			StockInfo[] stockInfoList = server.getStockInfoList();
			for(StockInfo stockInfo : stockInfoList){
				System.out.println(stockInfo._toString());
			}
		    
		    
		} catch (TRANSIENT e) {
			System.err.println("O serviço encontra-se indisponível.");
			e.getCause().printStackTrace();
		} catch (COMM_FAILURE e) {
		   	System.err.println("Falha de comunicação com o serviço.");
		   	e.getCause().printStackTrace();
		} catch (IOException e) {
			System.err.println("Erro na leitura do arquivo IOR.");
			e.getCause().printStackTrace();
		}

	}

}
