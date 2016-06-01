package Controlador;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import InterfacesRMI.Execucao;

public class Executor {

	private static Executar executar;
	public static void inicializar (Integer numThreads) throws RemoteException
	{
		executar = new Executar(numThreads);
		
		try {
			System.setProperty("java.security.policy", "file:./T3-Produtor.policy");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		Registry registry = LocateRegistry.createRegistry(22003);
		Execucao executionServant = (Execucao) UnicastRemoteObject.exportObject(executar, 0);
		try {
			registry.bind("Execucao", executionServant);
		} catch (AlreadyBoundException e) {
			registry.rebind("Execucao", executionServant);
		}
	}
	
	public static void executar() {
		//TODO RECEBER TASK E JOGAR PARA EXECUTAR
		
	}
	
	
}
