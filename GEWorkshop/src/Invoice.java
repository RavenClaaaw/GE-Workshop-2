import java.time.Duration;
import java.time.LocalDate;

public class Invoice {
    public Car car;
    public LocalDate rentalDate;
    public LocalDate returnDate;
    public Long duration;

    Invoice(Car car, LocalDate rentalDate, LocalDate returnDate){
        this.car = car;
        this.rentalDate = rentalDate;
        this.returnDate = null;
        this.duration = null;
    }

    public void display(){
        System.out.println("- CAR");
        this.car.display();

        System.out.println("Rental Date:- " + this.rentalDate);
        System.out.println("Return Date:- " + this.returnDate);
        System.out.println("Duration:- " + this.duration);
    }

    public void returnCar(){
        this.returnDate = LocalDate.now();
        duration = (long) 0;
    }
}
