package Controlador;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class LeitorArquivo implements Runnable {

	private String pathInput;
	private LinkedBlockingQueue<double[][][]> filaMatrizes;
	private AtomicInteger delaySleep;
	
	LeitorArquivo(String arquivoEntrada, LinkedBlockingQueue<double[][][]> fila,AtomicInteger delaySleep) {
		this.pathInput = arquivoEntrada;
		this.filaMatrizes = fila;
		this.delaySleep = delaySleep;
		
	}
	
	
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

	@Override
	public void run() {
		
		Scanner scanner = null; 
		try {
			scanner = new Scanner(new File(pathInput));
		}
		catch(IOException e) {
			System.out.println(pathInput+"/"+e.getMessage());
			System.exit(1);
		}
		
		while(scanner.hasNextLine()){
			
			String path = scanner.next();
			int size = scanner.nextInt();
			int numMatrizes = scanner.nextInt();
			
			try {
				filaMatrizes.put(this.inputMatrizes(path, size, numMatrizes));
				Thread.sleep(delaySleep.get());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		
		}
		scanner.close();
		
		

		
	}


	
} //End of Class

