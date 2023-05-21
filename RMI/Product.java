import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Product{
    Integer pc;
    Integer ID;
    String name;
    String description;
    ArrayList<?> subcomponents;

    protected Product(Integer newPc, Integer newID, String newName, String newDescription, ArrayList newSubcomponents) throws Exception {
        this.pc = newPc;
        this.ID = newID;
        this.name = newName;
        this.description = newDescription;
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

    public ArrayList getsubcomponents() throws RemoteException{
        return this.subcomponents;
    }

       

    
}
