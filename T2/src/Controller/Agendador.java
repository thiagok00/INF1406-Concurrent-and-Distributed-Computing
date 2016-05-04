package Controller;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Model.Parametros;

public class Agendador {

	private final ExecutorService executor;
	private final Parametros p = Parametros.getIstance();

	Agendador() {		
		
		executor = Executors.newFixedThreadPool(p.getQtdThreads());
	}
	
	public void multiplicaMatrizes() {

		long tempoInicio = System.currentTimeMillis();	
		int qtdMatrizes = p.getQtdMatrizes();
		double[][]m1 = p.getMatriz(0);
		for(int i = 1; i < qtdMatrizes; i++) {
			
			double[][]m2 = p.getMatriz(i);
			Multiplicador ag = new Multiplicador(executor,m1,m2);
			m1 = ag.multiplicaDuasMatrizes();
		}
	
		p.setMatrizResultado(m1);
		System.out.println("Tempo gasto em multiplicação: "+(System.currentTimeMillis()-tempoInicio)+" ms");
	}
	
	

	

} //End of Class
