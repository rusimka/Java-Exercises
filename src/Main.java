import interfaces.Calculator;
import interfaces.impl.CalculatorImpl;
import interfaces.impl.SayInterfaceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    System.out.println("Example Predicate 1");
    List<Integer> numbers = Arrays.asList(1,2,3,4,5);
    Predicate<Integer> isEven = number -> number % 2 == 0;
    List<Integer> evenNumbers = numbers.stream().filter(isEven).collect(Collectors.toList());
    System.out.println(evenNumbers);
    /*
    Predicate Interface is an interface that accepts one argument (for example number or list), have some condition, return true or false
    and it's used for filtering the collection, based on some condition

    The test() function that is specific to predicate is called by filter() method internally,and the lambda expression defined in the predicate represent the behavioru
    of the test() method, what we are testing
    First we are creating Predicate isEven who has some lambda expression that returns true or false, if the integer input is even
    The filter method takes the predicate object as argument and returns a new stream that satisfy the condition
     */

    System.out.println("Predicate Example 2");
    Predicate<Integer> isGreaterThan18 = number -> number > 18;
    System.out.println(isGreaterThan18.test(10));
    System.out.println(isGreaterThan18.test(20));
    /*
    The test method of this predicate is called on some number , and the lambda expression checks if it's true
     */
  }
}
