package interfaces.impl;

import interfaces.Say;

public class SayInterfaceImpl implements Say {
  @Override
  public void say(String message) {
    System.out.println(message);
  }
}
