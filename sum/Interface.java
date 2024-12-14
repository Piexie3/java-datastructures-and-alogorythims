package sum;

public class Interface {
    public static void main(String[] args) {
        // Lambda expression implementing the interface
        Calculator add = (a, b) -> a + b;
        System.out.println("Addition: " + add.calculate(40,3));
    }

}
