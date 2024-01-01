public class Car {
    public String company;
    public String model;
    public String registration;

    Car(String company, String model, String registration){
        this.company = company;
        this.model = model;
        this.registration = registration;
    }

    public void display(){
        System.out.println("Company: " + this.company + "\nModel: " + this.model + "\nRegistration: " + this.registration);
    }
}
