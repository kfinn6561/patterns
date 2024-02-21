package org.example.singleton;

public class Singleton {
  private static Singleton instance;
  private final double id;

  private Singleton() {
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
