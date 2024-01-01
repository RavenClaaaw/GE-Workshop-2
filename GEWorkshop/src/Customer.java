public class Customer {
    String name;
    String contact;

    Customer(String name, String contact){
        this.name = name;
        this.contact = contact;
    }

    public void display(){
        System.out.println("NAME:- " + this.name);
        System.out.println("CONTACT:- " + this.contact);
    }
}
