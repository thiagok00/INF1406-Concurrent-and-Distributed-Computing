package Controlador;

import java.rmi.RemoteException;

public class Aplicacao {

	public static void main(String[] args)
	{
		
		if (args.length != 1) {
			System.exit(1);
		}
	
		int numThreads = Integer.parseInt(args[0]);
		
		try {
			Executor.inicializar(numThreads);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		Executor.executar();
	}
}
