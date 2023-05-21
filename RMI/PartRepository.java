import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;

public class PartRepository extends UnicastRemoteObject implements Part {

    public static LinkedList<Product> BancoDados;
    String aux;
    
    //Product (Integer newID, String newName, String newDescription, ArrayList newSubcomponents) throws RemoteException {

    //}

    //construtor com exception obrigatorio
    protected PartRepository(LinkedList<Product> newLinkedList) throws RemoteException{
        this.BancoDados = newLinkedList;    
    }
    
    //inicia a serializacao para contornar o armazenamento por bit de maior representatividade
    //passivel de serializacao, array de bytes
    private static final long serialVersionUID = 1L;

    //Metodos
    public LinkedList<Product> novaPart(Integer pc, Integer ID, String Name, String Description, ArrayList Subcomponents) throws Exception{
        Product aux = new Product(pc, ID, Name, Description, Subcomponents);
        BancoDados.add(aux);
        return BancoDados;
    }

    public static Product busca(Integer ID){
        Product resp;
        for(int i = 0; i < BancoDados.size(); i++){
            Product alvo = BancoDados.get(i);
            if (alvo.ID.equals(ID)){
                return resp = alvo;
            } else {
                System.out.println("Item não encontrado!");
                return resp;
            }
        }
    }

    //busca a Part pelo id
    public static Product getPart(Integer ID) throws RemoteException{
        return busca(ID);
    }

    public String getname() throws RemoteException{
        return this.name;
    }

    public String getdescription() throws RemoteException{
        return this.description;
    }

    public ArrayList getsubcomponents() throws RemoteException{
        return this.subcomponents;
   

    public String aux() throws RemoteException{
        return "foi aqui";
    }

}
