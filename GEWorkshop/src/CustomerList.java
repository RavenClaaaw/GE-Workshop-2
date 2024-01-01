import java.util.ArrayList;
import java.util.Scanner;

public class CustomerList {
    public ArrayList<Customer> customers;

    CustomerList(){
        customers = new ArrayList<>();
    }

    public void add(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();

        customers.add(new Customer(name, contact));
    }

    public void display(){
        int counter = 0;
        for(Customer customer : customers){
            System.out.println("CUSTOMER - " + (counter+1));
            customer.display();
            counter += 1;
        }
    }

    public void remove(){
        int index = getIndex();

        customers.remove(index);
    }

    public Customer select(){
        int index = getIndex();

        return customers.get(index);
    }

    public void update(){
        Scanner scanner = new Scanner(System.in);

        int index = getIndex();

        System.out.println("ENTER NAME: ");
        String cName = scanner.nextLine();

        System.out.println("ENTER CONTACT:");
        String cContact = scanner.nextLine();

        this.customers.get(index).name = cName;
        this.customers.get(index).contact = cContact;

        return;
    }

    public int getIndex(){
        Scanner scanner = new Scanner(System.in);
        
        this.display();
        System.out.print("ENTER OPTION:- ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        return index;
    }
}
