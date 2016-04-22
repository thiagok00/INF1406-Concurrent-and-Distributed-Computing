package Controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Model.Parametros;

public class Multiplicador implements Runnable {

	
	
	public void multiplica() {
		Parametros p = Parametros.getIstance();
		ExecutorService executor = Executors.newFixedThreadPool(p.getQtdThreads());		
		
		executor.execute(this);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}
