import java.rmi.RemoteException;

public interface Revenue {
    public void AddInvoice(float amount) throws RemoteException;
    public float getAverageInvoice() throws RemoteException;
    public float getTotalRevenue() throws RemoteException;
}
