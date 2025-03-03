import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Scanner;

public class Client {
    public static void main(String [] args){
        try{
            RevenueManagement hello = (RevenueManagement) Naming.lookup("rmi://localhost:3500/toto");
            Scanner scanner = new Scanner(System.in);
            float montant;
            float moyenne ;
            float revenuetotal;
            while(true){
                System.out.println("choisir une option :");
                System.out.println("1.AddInvoice");
                System.out.println("2.getAverage");
                System.out.println("3.getTotalRevenue");
                System.out.println("4.Terminer");
                String option = scanner.nextLine();
                switch(option){
                    case "1":
                        System.out.println("entrez votre montant :");
                        montant = Float.parseFloat(scanner.nextLine());
                        hello.AddInvoice(montant);
                        continue;
                    case "2":
                        moyenne = hello.getAverageInvoice();
                        System.out.println("votre average invoice est :"+moyenne);
                        continue;
                    case "3":
                        revenuetotal = hello.getTotalRevenue();
                        System.out.println("votre revenue total est :"+revenuetotal);
                        continue;
                    case "4":
                        break;
                }
            }
        }catch(IOException e ){
            System.out.println(e.getMessage());
        }catch(NotBoundException e){
            System.out.println(e.getMessage());
        }
    }
}
