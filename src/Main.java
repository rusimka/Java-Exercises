import interfaces.Calculator;
import interfaces.impl.CalculatorImpl;
import interfaces.impl.SayInterfaceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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

    System.out.println("Consumer Interface 1 - Printing numbers: ");
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    Consumer<Integer> doubleNumber = number -> System.out.println(number *= 2);
    numbers.forEach(doubleNumber);
    /* Explanation about this example:
     * We have some array list with numbers
     * The Customer Interface will double all the numbers with two and it will print them out
     * forEach is used to iterate through the numbers array 'doubleNumber' consumer is applied to it to double the number. If we want
     * something else to be done with this list, we can create another consumer who will do something else
     * ex: double the number by three.
     * The Consumer Interface takes only one argument, does not return value as a result, but it's used to perform action on each element of a collection or stream
     *
     * IMPORTANT!! : the accept method takes only one argument. The accept method is called by the forEach method
     * and it passes the current element of the iteration as an argument (ONLY ONE ARGUMENT) to the 'doubleNumber' consumer
     *  */

    //    doubleNumber.accept(40);
    /*
    The consumer doubleNumber accepts only one argument, and that is integer 40, and it doubles that number */

    System.out.println("Consumer Interface 2 - Displaying number");
    Consumer<Integer> display = number -> System.out.println(number);
    display.accept(10);
    /* The difference between these two examples is that in the first example accept is called by foreach for every element
     * And here we are calling to accept with the argument that we want to call*/

    System.out.println("Consumer Interface 3 - Displaying all numbers in a list");
    Consumer<List<Integer>> displayList =
        list -> list.stream().forEach(number -> System.out.print(number + " "));
    displayList.accept(numbers);

    /* We are calling the accept method on a consumer that takes single list as an argument and consumer is streaming the list, and it
     * s printing all elements in the list
     * IMPORTANT : The difference between Example 1 and Example 3, is that in Example 1, is that that Consumer only works for
     * one number, we are iterating through the list, and each element of the list is passed as an argument to the consumer
     * 'doubleNumber' and the consumer doubles the number and prints it. forEach calls the 'accept' method for each element of the list.
     * IMPORTANT: In Example 3, 'displayList' Consumer, takes only one argument , list argument, iterates the list, and it print
     * each element of the list. The accept method takes the 'numbers' array as a parametar.
     *
     */

    System.out.println("Consumer Interface 4 : Example with 'andThen'");
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    Consumer<String> printName = name -> System.out.println(name);
    Consumer<String> uppercaseName = name -> System.out.println(name.toUpperCase());
    names.forEach(printName.andThen(uppercaseName));
    /*
    We have two consumer 'printName' to print out the original names, and 'uppercaseName' consumer the print out the names with upper case'
    f
     */

    System.out.println("Consumer Interface 5: ");
    Consumer<List<Integer>> modify =
        list -> {
          for (int i = 0; i < list.size(); i++) list.set(i, 2 * list.get(i));
        };

    // Consumer to display a list of integers
    Consumer<List<Integer>> dispList =
        list -> list.stream().forEach(a -> System.out.print(a + " "));

    List<Integer> list = new ArrayList<Integer>();
    list.add(2);
    list.add(1);
    list.add(3);

    // using addThen()
    modify.andThen(dispList).accept(list);
    ;
  }
}
