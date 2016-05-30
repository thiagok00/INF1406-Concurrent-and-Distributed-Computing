package Controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LeitorArquivo {


	
	double[][][] inputMatrizes(String path,int size, int numMatrizes) {
		
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
		in.close();
		return vet;
	}


	
} //End of Class

