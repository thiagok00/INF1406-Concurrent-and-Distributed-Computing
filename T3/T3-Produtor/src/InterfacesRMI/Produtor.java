package InterfacesRMI;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Produtor extends Remote{

	//ConjuntoMatrizes 
	double[][][] obtemMatrizes() throws RemoteException;
}