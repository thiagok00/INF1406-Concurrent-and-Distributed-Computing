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

import servants.StockServerImpl;

public class Principal {

	public static void main(String[] args) {
		try {
			Properties orbProps = new Properties();
			orbProps.setProperty("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
			orbProps.setProperty("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");  

			ORB orb = ORB.init(args, orbProps);
		
			StockServerImpl stockServer = new StockServerImpl();
		
			POA poa;
			poa = (POA) POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
			org.omg.CORBA.Object obj = poa.servant_to_reference(stockServer);
			
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ior.txt")));
			
			String ior = orb.object_to_string(obj);
			writer.write(ior);
			writer.close();
			
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
