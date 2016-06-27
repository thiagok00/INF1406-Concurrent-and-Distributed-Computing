package principal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Scanner;

import org.omg.CORBA.COMM_FAILURE;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TRANSIENT;

import StockMarket.StockExchange;
import StockMarket.StockExchangeHelper;
import StockMarket.StockInfo;
import StockMarket.StockInfoHelper;
import StockMarket.StockServer;
import StockMarket.StockServerHelper;
import StockMarket.UnknownSymbol;
import valuetypes.StockInfoFactory;

public class Client {

	public static void main(String[] args) {
		try {
			if (args.length != 2){
				System.out.println("Erro no numero de Parâmetros");
				System.exit(1);
			}
			
			String ARQUIVO_IOR_STOCK_SERVER = args[0];
			String ARQUIVO_IOR_STOCK_EXCHANGE = args[1];
			
			// As propriedades que informam o uso do JacORB como ORB.
			Properties orbProps = new Properties();
			orbProps.setProperty("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
			orbProps.setProperty("org.omg.CORBA.ORBSingletonClass","org.jacorb.orb.ORBSingleton");
			
			// Inicializa o ORB.
			org.omg.CORBA_2_3.ORB orb = (org.omg.CORBA_2_3.ORB) ORB.init(args, orbProps);
			orb.register_value_factory(StockInfoHelper.id(),new StockInfoFactory());
			
			// Lê o IOR do arquivo
			BufferedReader readerStockServer = new BufferedReader(
					new InputStreamReader(new FileInputStream(ARQUIVO_IOR_STOCK_SERVER)));
			String iorStockServer = readerStockServer.readLine();			
			readerStockServer.close();
			
			// Obtém a referência para o objeto CORBA
			org.omg.CORBA.Object objStockServer = orb.string_to_object(iorStockServer);
			StockServer stockServer = StockServerHelper.narrow(objStockServer);
			
			
			System.out.println("Ações de mercado obtidas do StockServer:");
			//Parte 1
			//imprimeSimbolos(stockServer);
		
			//Parte 2
			imprimeListaSimbolosValueType(stockServer);
			
			System.out.println();
			System.out.println("Digite o Simbolo da Acao que deseja:");
			Scanner teclado = new Scanner(System.in);
			String resp = teclado.nextLine();
			
			BufferedReader readerStockExchange = new BufferedReader(
					new InputStreamReader(new FileInputStream(ARQUIVO_IOR_STOCK_EXCHANGE)));
			String iorStockExchange = readerStockExchange.readLine();			
			readerStockExchange.close();
			org.omg.CORBA.Object objStockExchange = orb.string_to_object(iorStockExchange);
			StockExchange stockExchange = StockExchangeHelper.narrow(objStockExchange);
			
			do {
				tentarComprar(stockExchange,resp);
				System.out.println();
				imprimeSimbolos(stockServer);
				System.out.println();
				System.out.println("Digite o Simbolo da Acao que deseja:");
				resp = teclado.nextLine();
			} while (true);
			
		
		} catch (TRANSIENT e) {
			System.err.println("O serviço encontra-se indisponível.");
			e.getCause().printStackTrace();
		} catch (COMM_FAILURE e) {
		   	System.err.println("Falha de comunicação com o serviço.");
		   	e.getCause().printStackTrace();
		} catch (IOException e) {
			System.err.println("Erro na leitura do arquivo IOR.");
			e.getCause().printStackTrace();
		}

	}
	
	private static void imprimeSimbolos(StockServer stockServer) {
		String[] stockSymbols = stockServer.getStockSymbols();
		for (int i = 0; i < stockSymbols.length; i++) {
	    	try {
				System.out.println(stockSymbols[i] + " "+ stockServer.getStockValue(stockSymbols[i]));
			} catch (UnknownSymbol eu) {
				System.out.println(eu.symbol + " - Nao Encontrado!");
			}
	    }
	}

	private static void imprimeListaSimbolosValueType(StockServer stockServer) {
		StockInfo[] stockInfoList = stockServer.getStockInfoList();
		for(StockInfo stockInfo : stockInfoList){
			System.out.println(stockInfo._toString());
		}
	}

	private static void tentarComprar(StockExchange stockExchange,String symbol){
		try {
			System.out.println("Tentativa de Comprar: "+ symbol);
			if (stockExchange.buyStock(symbol))
				System.out.println(symbol + " Comprada!");
			else
				System.out.println(symbol + "Não Comprada");
			System.out.println();
		}  catch (UnknownSymbol e) {
			System.out.println(e.symbol +  " Não Encontrada");
		}
	}

}
