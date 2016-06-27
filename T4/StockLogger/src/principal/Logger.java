package principal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.jacorb.poa.POA;
import org.omg.CORBA.COMM_FAILURE;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TRANSIENT;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import StockMarket.ExchangePrinter;
import StockMarket.ExchangePrinterHelper;
import StockMarket.StockExchange;
import StockMarket.StockExchangeHelper;
import servants.DisplayExchangePrinterImpl;
import servants.FileExchangePrinterImpl;

public class Logger {
	public static void main(String[] args) {
		try {
			if (args.length != 1){
				System.out.println("Erro no numero de Parâmetros");
				System.exit(1);
			}
			
			String ARQUIVO_IOR_STOCK_EXCHANGE = args[0];
			
			// As propriedades que informam o uso do JacORB como ORB.
			Properties orbProps = new Properties();
			orbProps.setProperty("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
			orbProps.setProperty("org.omg.CORBA.ORBSingletonClass","org.jacorb.orb.ORBSingleton");
						
			// Inicializa o ORB.
			ORB orb = ORB.init(args, orbProps);
						
			// Lê o IOR do arquivo
			BufferedReader reader = new BufferedReader(
								new InputStreamReader(new FileInputStream(ARQUIVO_IOR_STOCK_EXCHANGE)));
			String ior = reader.readLine();			
			reader.close();
						
			// Obtém a referência para o objeto CORBA
			org.omg.CORBA.Object obj = orb.string_to_object(ior);
			StockExchange socketExchange = StockExchangeHelper.narrow(obj);
			
			DisplayExchangePrinterImpl displayExchangePrinter = new DisplayExchangePrinterImpl();
			FileExchangePrinterImpl fileExchangePrinter = new FileExchangePrinterImpl();
			
			POA poa = (POA) POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
			org.omg.CORBA.Object objDisplayPrinter = poa.servant_to_reference(displayExchangePrinter);
			org.omg.CORBA.Object objFilePrinter = poa.servant_to_reference(fileExchangePrinter);
		
			ExchangePrinter displayPrinter = ExchangePrinterHelper.narrow(objDisplayPrinter);
			ExchangePrinter filePrinter = ExchangePrinterHelper.narrow(objFilePrinter);
			if (socketExchange.connectPrinter(displayPrinter)){
				System.out.println("Impressora por Display conectada!");
			}
			if (socketExchange.connectPrinter(filePrinter)){
				System.out.println("Impressora por Arquivo conectada!");
			}
			
			
			while (true){
				orb.run();
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
		} catch (InvalidName e) {
			e.getCause().printStackTrace();
		} catch (AdapterInactive e) {
			e.getCause().printStackTrace();
		} catch (ServantNotActive e) {
			e.getCause().printStackTrace();
		} catch (WrongPolicy e) {
			e.getCause().printStackTrace();
		}

	}
}
