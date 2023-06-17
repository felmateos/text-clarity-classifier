import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) {
        //busca o objeto remoto no registro
        try {
            Part stub = (Part) Naming.lookup("rmi://localhost:6900/product");
            System.out.println(stub.aux());
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
    
}
