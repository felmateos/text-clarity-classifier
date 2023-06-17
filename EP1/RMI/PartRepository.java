import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;

public class PartRepository extends UnicastRemoteObject implements Part {

    public static LinkedList<Product> BancoDados;
    String aux;
    
    //construtor com exception obrigatorio
    protected PartRepository(LinkedList<Product> newLinkedList) throws RemoteException{
        this.BancoDados = newLinkedList;    
    }
    
    //inicia a serializacao para contornar o armazenamento por bit de maior representatividade
    //passivel de serializacao, array de bytes
    private static final long serialVersionUID = 1L;

    //Metodos
    public LinkedList<Product> novaPart(Integer pc, Integer ID, String Name, String Description, Integer Qtd, ArrayList Subcomponents) throws Exception{
        Product aux = new Product(pc, ID, Name, Description, Qtd, Subcomponents);
        BancoDados.add(aux);
        return BancoDados;
    }

    //Busca produto pelo ID
    public static Product busca(Integer ID) throws Exception{
        Product resp = new Product(-1, -1, "-1", "-1", -1, null);
        for(int i = 0; i < BancoDados.size(); i++){
            Product alvo = BancoDados.get(i);
            if (alvo.ID.equals(ID)){
                return resp = alvo;
            } else {
                System.out.println("Item não encontrado!");
            }
        }

        return resp;
    }

    //Imprimi a lista de parts de um servidor
    public static void listp(Integer servidor) throws RemoteException{
        
        for (int i = 0; i < BancoDados.size(); i++) {

            if(BancoDados.get(i).server == servidor){
                System.out.println("name: " + BancoDados.get(i).getname() + "| id: " + BancoDados.get(i).getID() + "| id: " + BancoDados.get(i).getQuantidade());
            }
        }
    }
    
    //Imprimi a lista de subparts de uma part
    public static void listsubp(){
        //pensar
    }

    //Retorna a Part pelo id
    public static Product getPart(Integer ID) throws RemoteException{
        return busca(ID);
    }

    //Adiciona nova subpart
    public Product addSubpart(Integer ID, String newPart) throws RemoteException{
        Product aux = busca(ID);
        aux.subcomponents.add(newPart);
        return aux;
    }

    public String aux() throws RemoteException{
        return "foi aqui";
    }

}
