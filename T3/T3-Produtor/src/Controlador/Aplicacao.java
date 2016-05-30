package Controlador;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import InterfacesRMI.Configuracao;
import InterfacesRMI.Produtor;

public class Aplicacao  {

	ConfiguracaoServant cservant;
	ProdutorServant pservant;
	private Registry registryProxy;
	private Produtor esqueletoProdutor;
	private Configuracao esqueletoConfiguracao;
	
	
	void produzir(String path) {
	

		(new Thread(new LeitorArquivo(path,pservant.matrizes,cservant.delaySleep))).start();	
		this.configurarPropriedades();
		this.publicarObjRemoto();
	}
	
	private void publicarObjRemoto(){
		
		this.pservant = new ProdutorServant();
		this.cservant = new ConfiguracaoServant();
		
		try{
			this.esqueletoProdutor = (Produtor) UnicastRemoteObject.exportObject(this.pservant, 0);
			this.esqueletoConfiguracao = (Configuracao) UnicastRemoteObject.exportObject(this.cservant, 0);
		}
		catch (RemoteException e){
			System.out.println("Erro exportar obj remoto");
			e.printStackTrace();
		}
		
		try{
			this.registryProxy = LocateRegistry.createRegistry(22001);
		}
		catch (RemoteException e){
			try{
				this.registryProxy = LocateRegistry.getRegistry(22001);
			}
			catch (RemoteException e2){
				System.out.println("Falha pegar registro");
				e2.printStackTrace();
			}
		}
		try{
			this.registryProxy.rebind("Produtor", this.esqueletoProdutor);
			this.registryProxy.rebind("Configuracao", this.esqueletoConfiguracao);
		}
		catch(RemoteException e){
			System.out.println("Conexão de registro falhou");
			e.printStackTrace();
		}
	}
	private void configurarPropriedades(){

		try{
			System.setProperty("java.security.policy", "file:./T3-Produtor.policy");
			System.setProperty("java.rmi.server.useCodebaseOnly", "false");
			
			if (System.getSecurityManager() == null) {
			  System.setSecurityManager(new SecurityManager());
			}
		}
		catch(SecurityException e){
			System.out.println("Falha ao pegar propriedades do sistema.");
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("Argumentos Insuficientes");
			System.exit(1);
		}
			
		String pathInput = args[0];
		Aplicacao produtor = new Aplicacao();
		produtor.produzir(pathInput);
		
	}







}
