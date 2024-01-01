import java.util.ArrayList;
import java.util.Scanner;

public class CarList {
    public ArrayList<Car> cars;

    CarList(){
        cars = new ArrayList<>();
    }

    public Car add(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-- ADDING NEW CAR --");

        String company, model, registration;

        System.out.print("ENTER CAR COMPANY:- ");
        company = scanner.nextLine();
        System.out.print("ENTER CAR MODEL:- ");
        model = scanner.nextLine();
        System.out.print("ENTER REGISTRATION:- ");
        registration = scanner.nextLine();

        Car nCar = new Car(company, model, registration);
        cars.add(nCar);

        return nCar;
    }

    public void display(){
        int counter = 0;
        for(Car car : cars){
            System.out.println("CAR - " + (counter+1));
            car.display();
            counter += 1;
        }
    }

    public void remove(){
        Scanner scanner = new Scanner(System.in);

        this.display();
        System.out.println("ENTER OPTION TO DELETE:- ");
        int option = scanner.nextInt() - 1;
        scanner.nextLine();

        cars.remove(option);
    }

    public Car select(){
        Scanner scanner = new Scanner(System.in);

        this.display();
        System.out.print("ENTER OPTION:- ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        return cars.get(index);
    }

    public void update(){
        Scanner scanner = new Scanner(System.in);

        this.display();
        System.out.print("ENTER OPTION:- ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        String company, model, registration;

        System.out.print("ENTER CAR COMPANY:- ");
        company = scanner.nextLine();
        System.out.print("ENTER CAR MODEL:- ");
        model = scanner.nextLine();
        System.out.print("ENTER REGISTRATION:- ");
        registration = scanner.nextLine();

        cars.get(index).company = company;
        cars.get(index).model = model;
        return;
    }
}
