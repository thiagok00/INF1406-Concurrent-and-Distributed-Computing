package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GerenciadorArquivos {


	
	public void inputMatrizes() {
		
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
		p.setMatrizes(vet);
		in.close();
	}
	
	public void outputResultado() {
		Parametros p = Parametros.getIstance();
		int tam = p.getTamMatriz();
		double[][] resultado = p.getMatrizResultado();
		FileWriter out = null;
		try {
			out = new FileWriter("resultado.txt");
		}
		catch (Exception e) {
			System.out.println("Erro abrir arquivo resultado.txt");
			System.exit(1);
		}
		
		PrintWriter arq = new PrintWriter(out);

		for(int i = 0; i < tam; i++ ) {
			String linha = "";
			for(int j = 0; j < tam; j++) {
				linha =  linha + resultado[i][j] + " ";
			}
			System.out.println(linha);
			arq.println(linha);
		}
		
		arq.close();
	}

	
} //End of Class

