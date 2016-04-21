package Controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Model.Parametros;

public class LeitorArquivo {


	
	public double[][][] inputMatrizes() {
		
		Parametros p = Parametros.getIstance();
		String path = p.getPathArqEntrada();
		int size = p.getTamMatriz();
		int numMatrizes = p.getQtdMatrizes();
		
		Scanner in = null; 
		try {
			in = new Scanner(new File(path));
		}
		catch(IOException e) {
			System.out.println(path+"/"+e.getMessage());
			System.exit(1);
		}
		
		/*	Criando array de matrizes */
		double[][][] vet = new double[numMatrizes][][];
		
		/* Lendo numero por numero */
		for (int x = 0; x < numMatrizes; x++) {
			double [][]matriz = new double[size][size];
			vet[x] = matriz;
			for	(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					vet[x][i][j] = in.nextDouble();		
				}
			}
		}
		return vet;		
	}

	
} //End of Class
