package Controlador;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import InterfacesRMI.Configuracao;

public class Configurador {
	
	private String produtorIP;
	private String consumidorIP;
	
	private Integer produtorPorta;
	private Integer consumidorPorta;
	
	public Configurador (String producerIP, Integer producerPort, String consumerIP, Integer consumerPort) {			
		produtorIP = producerIP;
		produtorPorta = producerPort;
		consumidorIP = consumerIP;
		consumidorPorta = consumerPort;
		
		try {
			System.setProperty("java.security.policy", "file:./T3-Produtor.policy");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public void configurar () throws RemoteException, NotBoundException {		
		Scanner scanner = new Scanner(System.in);
		Registry registry;
		Configuracao proxy;
		int input;
		
		while (true) {	
			registry = null;
			proxy = null;
			
			System.out.println("Escreva:\n0: Produtor /n1: Consumidor /n2: Fechar");
			
			if (scanner.hasNext()) {
				input = scanner.nextInt();
				if (input == 0) {
					registry = LocateRegistry.getRegistry(produtorIP, produtorPorta);
				} else if (input == 1) {
					registry = LocateRegistry.getRegistry(consumidorIP, consumidorPorta);
				}
				else if (input == 2)
					break;
				else {
					continue;
				}
				
				proxy = (Configuracao) registry.lookup("Configuracao");
				System.out.println("Intervalo?");
				if (scanner.hasNext()) {
					proxy.aplicaIntervalo(scanner.nextInt());
				}
			}
		}
		scanner.close();
	}
	
}
