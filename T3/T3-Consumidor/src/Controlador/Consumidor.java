package Controlador;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import InterfacesRMI.Callback;
import InterfacesRMI.Execucao;
import InterfacesRMI.Produtor;

public class Consumidor implements Callback {
	
	private Produtor produtorStub;
	private Execucao execucaoStub;
	
	public Consumidor (String producerIP, Integer producerPort, String executionIP,
			Integer executionPort) throws RemoteException, NotBoundException
	{

		try {
			System.setProperty("java.security.policy", "file:./T3-Produtor.policy");
			
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		

		
		Registry registry = LocateRegistry.createRegistry(22002);		
		registry = LocateRegistry.getRegistry(producerIP, producerPort);
		produtorStub = (Produtor) registry.lookup("Produtor");
		
		registry = LocateRegistry.getRegistry(executionIP, executionPort);
		execucaoStub = (Execucao) registry.lookup("Execucao");
	}
	
	public void consumir() {
		int matrizLida=0;
		while(true) {
			
			double matrizes[][][] = null;
			
			try {
				matrizes = produtorStub.obtemMatrizes();
			} catch (RemoteException e) {
				e.printStackTrace();
				break;
			}
			
			//TODO CALCULO DE MATRIZES FEITO ERRADO, LINHA POR LINHA E SEM RECUPERAR RESULTADO
			for (int i = 1; i < matrizes[matrizLida].length; i++) {
				Tarefa t = new Tarefa(matrizes[0].length, matrizes[i-1], matrizes[i], this);
				try {
					execucaoStub.execute(t);	
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			
			}
			
		}
		
		
	}

	@Override
	public void entregaResultado(double[] resultado) throws RemoteException {
		//TODO Colocar na matriz resultado
	}
	
}
