package Controlador;

import java.rmi.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;

import InterfacesRMI.Produtor;

public class ProdutorServant implements Produtor {
	
	
	LinkedBlockingQueue<double[][][]> matrizes = new LinkedBlockingQueue<double[][][]>();

	@Override
	public double[][][] obtemMatrizes() throws RemoteException {
		try {
			return matrizes.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
