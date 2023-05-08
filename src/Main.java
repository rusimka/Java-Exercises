import interfaces.Calculator;
import interfaces.impl.CalculatorImpl;
import interfaces.impl.SayInterfaceImpl;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
    SayInterfaceImpl sayInterface = new SayInterfaceImpl();
    sayInterface.say("Zdravo");
    sayInterface.doSomething();
    /*
    doSomething() ke mozhe da se povika poradi toa sto SayInterface go ekstendira AbstractInterface1, sto znaci deka se sto
    ima vo AbstractInterface1, go ima i vo SayInterface
     */


    Calculator add = ((x, y) -> x + y);
    Calculator subtract = ((x, y) -> x - y);
    int sum = add.calculate(5, 3);
    int difference = subtract.calculate(5, 3);

    System.out.println("Sum: " + sum);
    System.out.println("Difference: " + difference);
  }
}
