

class Vehicle {
    void run() {
        System.out.println("Vehicle");
    }
}


class Bike extends Vehicle {
    void run() {
        System.out.println("Bike");
    }
}


public class TestPolmorphism {
    public static void main(String[] args) {
        Vehicle v;

        v = new Vehicle();
        v.run();

        v = new Bike();
        v.run(); 
    }
}
