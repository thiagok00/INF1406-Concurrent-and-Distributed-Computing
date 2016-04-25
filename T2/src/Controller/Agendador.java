package Controller;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import Model.Parametros;

public class Agendador {

	private final ExecutorService executor;
	private final Parametros p = Parametros.getIstance();

	Agendador() {		
		
		executor = Executors.newFixedThreadPool(p.getQtdThreads());
	}
	
	public void multiplicaMatrizes() {
		int qtdMatrizes = p.getQtdMatrizes();
		int m = qtdMatrizes%2;
		@SuppressWarnings("unchecked")
		Future<Double>[][][] resultados = new Future[m][][];
		
		
		for (int i = 0; i < m; i++) {	
			double m1[][] = p.getMatriz(i*2);
			double m2[][] = p.getMatriz(i*2+1);
			Multiplicador mult = new Multiplicador(executor,m1,m2);
			resultados[i] = mult.multiplicaDuasMatrizes();
		}
		
		
		
		
	}
	
	

	

} //End of Class
