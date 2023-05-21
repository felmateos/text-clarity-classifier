import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

//interface que define os metodos remotos
public interface Part extends Remote{
    Integer getID() throws RemoteException;
    String getname() throws RemoteException;
    String getdescription() throws RemoteException;
    ArrayList<?> getsubcomponents() throws RemoteException;
    String aux() throws RemoteException;
}