import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class CarRental {
    public HashMap<String, Boolean> canBook = new HashMap<>();
    CustomerList customers = new CustomerList();
    CarList cars = new CarList();
    RentalHistory customerRentalHistory = new RentalHistory();

    public Customer handleCustomer(){
        Scanner scanner = new Scanner(System.in);
        int option;

        while(true){
            // CUSTOMER SELECTION
            System.out.println("\n1. Add Customer");
            System.out.println("2. Delete Customer");
            System.out.println("3. Display Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Select Customer");
            
            System.out.print("SELECT OPTION: ");
            option = scanner.nextInt();
            scanner.nextLine();

            int breakoff = 0;
            switch (option) {
                case 1:
                    customers.add();
                    break;

                case 2:
                    customers.remove();
                    break;
        
                case 3:
                    customers.display();
                    break;

                case 4:
                    customers.update();

                case 5:
                    Customer selectedCustomer = customers.select();
                    return selectedCustomer;

                default:
                    System.out.println("ERROR");
                    break;
            }
        }
    }

    public Car handleCar(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            // CAR SELECTION 
            System.out.println("\n1. Add Car");
            System.out.println("2. Delete Car");
            System.out.println("3. Display Car");
            System.out.println("4. Update Car");
            System.out.println("5. Select Car");
            
            System.out.print("Enter Option:- ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    Car nCar = cars.add();
                    canBook.put(nCar.registration, true);
                    break;

                case 2:
                    cars.remove();
                    break;
        
                case 3:
                    cars.display();
                    break;

                case 4:
                    cars.update();

                case 5:
                    Car selectedCar = cars.select();
                    return selectedCar;

                default:
                    break;
            }
        }
    }

    public void rent(Customer customer, Car car){
        canBook.put(car.registration, false);
        
        System.out.println("OK");
        customerRentalHistory.add(customer.name, new Invoice(car, LocalDate.now(), null));
    }

    public void returnCar(Customer customer, Car car){
        // Set Available
        canBook.put(car.registration, true);

        for(Invoice invoice : customerRentalHistory.invoiceMap.get(customer.name)){
            if(invoice.car.equals(car)) invoice.returnCar();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CarRental carRent = new CarRental();

        System.out.println("-- WELCOME CAR RENTAL --");

        while(true){
            Customer selectedCustomer = carRent.handleCustomer();

            System.out.println("1. SHOW HISTORY");
            System.out.print("SELECT: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            
            if(option == 1) carRent.customerRentalHistory.display(selectedCustomer.name);

            Car selectedCar = carRent.handleCar();

            System.out.println(" -- BOOK -- ");
            System.out.println("1. RENT");
            System.out.println("2. RETURN");

            System.out.print("ENTER OPTION: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    if(carRent.canBook.get(selectedCar.registration)){
                        carRent.rent(selectedCustomer, selectedCar);
                    } else{
                        System.out.println("ERROR - NOT AVAILABLE");
                    }
                    
                    break;
            
                case 2:
                    carRent.returnCar(selectedCustomer, selectedCar);
                    break;
            }
        }
    }
}
