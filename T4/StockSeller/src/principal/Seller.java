package principal;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.jacorb.poa.POA;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import servants.StockExchangeImpl;
import servants.StockServerImpl;

public class Seller {

	public static void main(String[] args) {
		try {
			//if (args.length < 1){
			//	System.out.println("Erro no numero de Parâmetros");
			//	System.exit(1);
			//}
			
			Properties orbProps = new Properties();
			orbProps.setProperty("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
			orbProps.setProperty("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");  

			ORB orb = ORB.init(args, orbProps);
		
			StockServerImpl stockServer = StockServerImpl.getInstance();
			StockExchangeImpl stockExchange = StockExchangeImpl.getInstance();
		
			POA poa = (POA) POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
			org.omg.CORBA.Object objStockServer = poa.servant_to_reference(stockServer);
			org.omg.CORBA.Object objStockExchange = poa.servant_to_reference(stockExchange);
			
			
			BufferedWriter writerStockServer = 
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream("IOR_STOCK_SERVER.txt")));
			String iorStockServer = orb.object_to_string(objStockServer);
			writerStockServer.write(iorStockServer);
			writerStockServer.close();
			
			BufferedWriter writerStockExchange = 
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream("IOR_STOCK_EXCHANGE.txt")));
			String iorStockExchange = orb.object_to_string(objStockExchange);
			writerStockExchange.write(iorStockExchange);
			writerStockExchange.close();
			
			while (true){
				orb.run();
			}
		   
		} catch (InvalidName e) {
			e.getCause().printStackTrace();
		} catch (AdapterInactive e) {
			e.getCause().printStackTrace();
		} catch (ServantNotActive e) {
			e.getCause().printStackTrace();
		} catch (WrongPolicy e) {
			e.getCause().printStackTrace();
		} catch (IOException e) {
			e.getCause().printStackTrace();
		}
	}

}
