import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class RentalHistory {
    public HashMap<String, ArrayList<Invoice>> invoiceMap;

    RentalHistory(){
        invoiceMap = new HashMap<>();
    }

    public void add(String customer, Invoice invoice){
        if(!invoiceMap.containsKey(customer)){
            invoiceMap.put(customer, new ArrayList<>());
        }

        invoiceMap.get(customer).add(invoice);
    }

    public void display(String customer){
        System.out.println(invoiceMap.keySet());
        if(!invoiceMap.containsKey(customer)){
            System.out.println("-- ERROR --");
            return;
        }

        int counter = 0;
        for(Invoice invoice : invoiceMap.get(customer)){
            System.out.println("-- Transaction -- " + counter + 1 + " --");
            invoice.display();
            counter += 1;
        }
    }
}
