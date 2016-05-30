package Controlador;

import java.rmi.RemoteException;
import java.util.concurrent.atomic.AtomicInteger;

import InterfacesRMI.Configuracao;

public class ConfiguracaoServant implements Configuracao {

	AtomicInteger delaySleep = new AtomicInteger(60000);
	
	
	@Override
	public void aplicaIntervalo(int intervalo) throws RemoteException {
		this.delaySleep.set(intervalo);
	}


}
