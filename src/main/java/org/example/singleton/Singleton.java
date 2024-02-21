package org.example.singleton;

public class Singleton {
  private static Singleton instance;
  private final double id;

  private Singleton() {
    try {
      Thread.sleep(100); //artificial sleep to righlight race conditions
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    this.id = Math.random();
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }

  public double getId() {
    return id;
  }
}
