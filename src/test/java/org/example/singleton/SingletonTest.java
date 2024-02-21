package org.example.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SingletonTest {
  @Test
  public void testCreateManySingletons() {
    Singleton singletonA = Singleton.getInstance();
    double expectedID = singletonA.getId();

    Singleton singletonB = Singleton.getInstance();
    assertEquals(expectedID, singletonB.getId());
  }
}
