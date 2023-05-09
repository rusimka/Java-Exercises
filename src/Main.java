import interfaces.Calculator;
import interfaces.impl.CalculatorImpl;
import interfaces.impl.SayInterfaceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
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

    /*
    Exercise 1: For given stream of integer values, take only the even numbers, multiple by 10, and the result should be in array
     */
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    Predicate<Integer> isEven = number -> number % 2 == 0;
    Function<Integer, Integer> multipleByTen = number -> number * 10;
    List<Integer> resultList =
        numbers.stream().filter(isEven).map(multipleByTen).collect(Collectors.toList());
    System.out.println("Result: " + resultList);

    /*
    Exercise 2: Function for given stream of numbers to return the smallest one
     */
    Function<List<Integer>, Integer> findSmallestNumber =
        list -> list.stream().min(Integer::compareTo).orElse(null);
    int smallestNumber = findSmallestNumber.apply(numbers);
    System.out.println(smallestNumber);

    /*
    Exercise 3: Function that will convert array list in stream and for each element if it's divisible by three, to print out that's divisible with three
     */
    ArrayList<Integer> numbers2 =
        new ArrayList<>(Arrays.asList(1, 3, 4, 9, 12, 15, 16, 18, 21, 25, 27, 30));
    Predicate<Integer> isDivisibleByThree = number -> number % 3 == 0;
    Consumer<ArrayList<Integer>> displayDivisibleNumbers =
        list -> list.stream().filter(isDivisibleByThree).forEach(System.out::println);
    displayDivisibleNumbers.accept(numbers2);
  }
}
