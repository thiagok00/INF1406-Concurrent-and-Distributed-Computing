package Controller;

import Model.LeitorArquivo;
import Model.Parametros;

public class Principal {

	public static void main(String[] args) {
	
		String path;
		
		
		if (args.length != 4) {
			System.out.println("Argumentos Insuficientes");
			System.exit(1);
		}
		
		Parametros p = Parametros.getIstance();
		try {
			int tamMatriz,qtdThreads,qtdMatrizes;
			path = args[0];
			tamMatriz = Integer.parseInt(args[1]);
			qtdThreads = Integer.parseInt(args[2]);
			qtdMatrizes = Integer.parseInt(args[3]);
			
			
			p.setPathArqEntrada(path);
			p.setQtdMatrizes(qtdMatrizes);
			p.setTamMatriz(tamMatriz);
			p.setQtdThreads(qtdThreads);
			
		}
		catch(NumberFormatException n) {
			System.out.println("Erro Formato Argumentos");
			System.exit(1);
		}
		
		p.printParametros();
	
		LeitorArquivo input = new LeitorArquivo();
		input.inputMatrizes();
		
		
	}

	
}
