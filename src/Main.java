import interfaces.Calculator;
import interfaces.impl.CalculatorImpl;
import interfaces.impl.SayInterfaceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
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

    System.out.println("Function 1");
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    Function<String,Integer> nameLength = name -> name.length();
    List<Integer> nameLengths = names.stream().map(nameLength).collect(Collectors.toList());
    System.out.println(nameLengths);
    /*
    Function is an interface that takes Stirng as argument, and returns Integer as result
    map() function transorms the element of a stream into another type of element based on a given function. In this example  we use to map function, and for each element of the array we are applying it to
    the nameLength function, and that nameLength function will return us  a new list of integers with the lengths of each name.
     */

    System.out.println("Map functions 1: " );
    List<Integer> numbers = Arrays.asList(1,2,3,4,5);
    List<Integer> squaredNumbers = numbers.stream().map(number -> number * number).collect(Collectors.toList());
    System.out.println(squaredNumbers);
    /*
    The map() functions, takes each element from the numbers array and it squares the number, and the result is in squaredNumbers array
     */

    System.out.println("Function 2 Example");
    Function<String,String> addPrefix = name -> "Mr. " + name;
    String nameWithPrefix = addPrefix.apply("John");
    System.out.println(nameWithPrefix);
    /*
    addPrefix is our function interface, which takes  string input , and output string
    We use the apply method to apply the name to this function
     */
  }
}
