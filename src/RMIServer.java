import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class RMIServer {
    public static void main(String[] args)  {
        try{
            MyRemoteService service=new MyRemoteServiceImpl();
            Registry registry=LocateRegistry.createRegistry(1098);
            registry.rebind("MyRemoteService",service);
            System.out.println("RMI Server is ready.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
