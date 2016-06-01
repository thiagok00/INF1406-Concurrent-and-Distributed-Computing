package Controlador;

public class Aplicacao {
	public static void main (String[] args)
	{
		
		if (args.length != 4) {
			System.exit(1);
		}
	
		String produtorIP = args[0];
		Integer produtorPorta = new Integer(args[1]);
		
		String consumidorIP = args[2];
		Integer consumidorPorta = new Integer(args[3]);
		
		Configurador configurator = new Configurador(produtorIP, produtorPorta, consumidorIP, consumidorPorta);
		
		try {
			configurator.configurar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
