package Controlador;

import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executar extends RemoteObject {

	private final ExecutorService executor;

	public Executar(int numTheads){
		executor = Executors.newFixedThreadPool(numTheads);
	}
	
	public void execute (Runnable task) throws RemoteException{
		executor.execute(task);
	}
}
