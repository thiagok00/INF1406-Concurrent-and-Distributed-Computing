package Controller;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import Model.Parametros;

public class Multiplicador {

	private final ExecutorService executor;
	private final Parametros p = Parametros.getIstance();
	private final int tamMatriz;
	private double[][]m1;
	private double[][]m2;
	private final Future<Double>[][] resultado;

	@SuppressWarnings("unchecked")
	Multiplicador(ExecutorService executor, double[][]m1, double[][]m2) {		
		this.executor = executor;
		this.m1 = m1;
		this.m2 = m2;
		this.tamMatriz = p.getTamMatriz();
		resultado = new Future[tamMatriz][tamMatriz];
	}
	
	public Future<Double>[][] multiplicaDuasMatrizes() {

		
		for (int i = 0; i < tamMatriz; i++){
			
			for (int j = 0; j < tamMatriz; j++) {
				calcula(i, j);
			}	
		}
		return resultado;
	}

	private void calcula(int i, int j) {
		
		Future<Double> submit = executor.submit(new Callable<Double>() {
	        public Double call() throws Exception {
	            Double sum = 0.0;
	            for (int z = 0; z < tamMatriz; z ++){
	            	sum += m1[i][z]*m2[z][j];
	  
	            }
	            return sum;
	        } });
			resultado[i][j] = submit ;
	}
}
