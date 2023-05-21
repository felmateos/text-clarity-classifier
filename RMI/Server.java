import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    //inicializa a main, a JVM vai procurara-la no momento de inicializacao da classe
    public static void main(String[] args) {
        //PartRepository aux = new PartRepository();  //(1, "item", "inicia lista", null);
        try{
            //cria registro para comunicar-se com o servidor da JVM e acesar os metodos
            Registry registry = LocateRegistry.createRegistry(6900);
            //usa-se rebind caso exista um outro registro igual possa sobrescrever
            Naming.rebind("rmi://localhost:6900/product", new PartRepository(null, null, null, null)); 
            System.out.println("Syst on!");
        } catch(RemoteException | MalformedURLException e){
            e.printStackTrace();
        }
    }
}
