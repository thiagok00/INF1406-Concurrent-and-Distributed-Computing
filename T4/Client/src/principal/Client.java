package principal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.omg.CORBA.COMM_FAILURE;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TRANSIENT;

import StockMarket.StockServer;
import StockMarket.StockServerHelper;
import StockMarket.UnknownSymbol;

public class Client {

	public static void main(String[] args) {
		try {
			// As propriedades que informam o uso do JacORB como ORB.
			Properties orbProps = new Properties();
			orbProps.setProperty("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
			orbProps.setProperty("org.omg.CORBA.ORBSingletonClass","org.jacorb.orb.ORBSingleton");
			// Inicializa o ORB.
			ORB orb = ORB.init(args, orbProps);
			
			// L� o IOR do arquivo cujo nome � passado como par�metro
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("../StockSeller/ior.txt")));
			
			String ior = reader.readLine();
			
			reader.close();
			
			// Obt�m a refer�ncia para o objeto CORBA
			org.omg.CORBA.Object obj = orb.string_to_object(ior);
			StockServer server = StockServerHelper.narrow(obj);
			
			System.out.println("A��es de mercado obtidas do StockServer:");
		      String[] stockSymbols = server.getStockSymbols();
		      for (int i = 0; i < stockSymbols.length; i++) {
		        try {
					System.out.println(stockSymbols[i] + " "+ server.getStockValue(stockSymbols[i]));
				} catch (UnknownSymbol e) {
					System.out.println(e.symbol + " - Nao Encontrado!");
				}
		      }
		    }
		catch (TRANSIENT e) {
			System.err.println("O servi�o encontra-se indispon�vel.");
			e.getCause().printStackTrace();
		}
		catch (COMM_FAILURE e) {
		   	System.err.println("Falha de comunica��o com o servi�o.");
		   	e.getCause().printStackTrace();
		} catch (IOException e) {
			System.err.println("Erro na leitura do arquivo IOR.");
			e.getCause().printStackTrace();
		}

	}

}
