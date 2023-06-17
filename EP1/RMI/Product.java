import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Product{
    Integer server;
    Integer ID;
    String name;
    String description;
    Integer quantidade;
    ArrayList<String> subcomponents;

    protected Product(Integer newPc, Integer newID, String newName, String newDescription, Integer newQtd, ArrayList<String> newSubcomponents) throws Exception {
        this.server = newPc;
        this.ID = newID;
        this.name = newName;
        this.description = newDescription;
        this.quantidade = newQtd;
        this.subcomponents = newSubcomponents;

    }

    public Integer getID() throws RemoteException{
        return this.ID;
    }

    public String getname() throws RemoteException{
        return this.name;
    }

    public String getdescription() throws RemoteException{
        return this.description;
    }

    public Integer getQuantidade() throws RemoteException{
        return this.quantidade;
    }

    public ArrayList<String> getsubcomponents() throws RemoteException{
        return this.subcomponents;
    }

       

    
}
