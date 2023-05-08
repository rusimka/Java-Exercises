package interfaces;

public interface AbstractInterface1 {
  default void doSomething() {
    System.out.println("Hello");
  }

  // default keyword in interface can provide implementation in the function within the interface
}
