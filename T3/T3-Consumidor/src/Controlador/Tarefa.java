package Controlador;

import java.rmi.RemoteException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import InterfacesRMI.Callback;

public class Tarefa implements Runnable {

	private int tamMatriz;
	private double[][]m1;
	private double[][]m2;
	private Callback resp;
	
	Tarefa(int tamMatriz,double[][] m1,double[][] m2, Callback c){
		this.tamMatriz = tamMatriz;
		resp = c;
		tamMatriz = m1.length;
	}

	@Override
	public void run() {
	
		double resultado[] = null;
		//TODO FAZER CALCULO DA MULTIPLICACAO
		try {
			resp.entregaResultado(resultado);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
