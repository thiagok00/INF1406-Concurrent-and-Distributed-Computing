package Model;

public class Parametros {

	private static Parametros singleton = new Parametros();
	
	private double [][][]matrizes;
	private int tamanhoMatriz;
	private int quantidadeThreads;
	private int quantidadeMatrizes;
	private String pathArquivoEntrada;
	private double[][] resultado;
	
	public static Parametros getIstance() {
		
		return Parametros.singleton;		
	}
	
	public double [][] getMatriz(int x) {
		if (x >= this.quantidadeMatrizes)
			System.exit(1);	
		return matrizes[x];		
	}
	
	public void setMatrizes(double [][][] matrizes) {
		this.matrizes = matrizes;
	}


	public int getTamMatriz() {
		return tamanhoMatriz;
	}
	
	public void setTamMatriz(int tamanhoMatriz) {
		this.tamanhoMatriz = tamanhoMatriz;
	}


	public int getQtdThreads() {
		return quantidadeThreads;
	}
	
	public void setQtdThreads(int qtdThreads) {
		this.quantidadeThreads = qtdThreads;
	}


	public int getQtdMatrizes() {
		return quantidadeMatrizes;
	}


	public void setQtdMatrizes(int quantidadeMatrizes) {
		this.quantidadeMatrizes = quantidadeMatrizes;
	}

	public String getPathArqEntrada() {
		return pathArquivoEntrada;
	}

	public void setPathArqEntrada(String pathArquivoEntrada) {
		this.pathArquivoEntrada = pathArquivoEntrada;
	}
	
	public void printParametros() {
		
		System.out.println("Arquivo entrada: "+pathArquivoEntrada);
		System.out.println("Multiplicando "+quantidadeMatrizes+" matrizes com tamanho "
		+tamanhoMatriz+"x"+tamanhoMatriz+" em "+quantidadeThreads+" thread(s)");		
	}

	public double[][] getMatrizResultado() {
		return resultado;
	}

	public void setMatrizResultado(double[][] resultado) {
		this.resultado = resultado;
	}
	
	
	
	
}//End of Class
