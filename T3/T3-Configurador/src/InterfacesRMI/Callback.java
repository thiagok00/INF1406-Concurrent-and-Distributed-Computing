package InterfacesRMI;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Callback extends Remote
{
	void entregaResultado (double[] resultado) throws RemoteException;
}