import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;

//interface que define os metodos remotos
public interface Part extends Remote{
    LinkedList<Product> novaPart() throws RemoteException;
    void listp() throws RemoteException;
    void listsubp() throws RemoteException;
    Product getPart() throws RemoteException;
    Product addSubpart() throws RemoteException;
    String aux() throws RemoteException;
}