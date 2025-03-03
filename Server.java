import java.io.IOException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
public class Server {
    public static void main(String [] args){
        try{
            LocateRegistry.createRegistry(3500);
            RevenueManagement localobject = new RevenueManagement(0);
            Naming.rebind("rmi://localhost:3500/toto", localobject);
            System.out.println("object published ...");
        }catch(RemoteException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
