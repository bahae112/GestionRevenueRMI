import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RevenueManagement extends UnicastRemoteObject implements Revenue{
    float totalFactures;
    int NombreFactures = 0;
    RevenueManagement(float totalFactures) throws RemoteException{
        super();
        this.totalFactures = totalFactures;
    }
    @Override
    public void AddInvoice(float amount) throws RemoteException{
        totalFactures += amount;
        NombreFactures +=1;
        System.out.println("votre facture a ete ajoute..");
    }
    @Override
    public float getAverageInvoice() throws RemoteException{
        if(this.NombreFactures > 0){
            float moyenne = (totalFactures /NombreFactures);
            return moyenne;
        }else{
            return 0;
        }
    }
    @Override
    public float getTotalRevenue() throws RemoteException{
        return totalFactures;
    }
}