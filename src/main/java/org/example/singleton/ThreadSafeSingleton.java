package org.example.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeSingleton {
  private static ThreadSafeSingleton instance;
  private static final Lock instanceLock = new ReentrantLock();
  private final double id;

  private ThreadSafeSingleton() {
    try {
      Thread.sleep(100); // artificial sleep to righlight race conditions
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    this.id = Math.random();
  }

  public static ThreadSafeSingleton getInstance() {
    if (instance != null) {
      return instance;
    }

    instanceLock.lock();
    try {
      if (instance == null) {
        instance = new ThreadSafeSingleton();
      }
    } finally {
      instanceLock.unlock();
    }
    return instance;
  }

  public double getId() {
    return id;
  }
}
