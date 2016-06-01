package Controlador;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Aplicacao {
	public static void main (String [] args)
	{		
		if (args.length != 4) {
			System.exit(1);
		}
	
		String produtorIP = args[0];
		Integer produtorPorta = new Integer(args[1]);
		
		String servExecIP = args[2];
		Integer servExecPorta = new Integer(args[3]);
		
		try {
			Consumidor consumer = new Consumidor(produtorIP, produtorPorta, servExecIP, servExecPorta);
			consumer.consumir();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
