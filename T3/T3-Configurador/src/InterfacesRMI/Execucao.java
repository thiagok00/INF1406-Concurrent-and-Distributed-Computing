package InterfacesRMI;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Execucao extends Remote {
	void execute (Runnable task) throws RemoteException;
}