package org.example.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SingletonTest {
  @Test
  public void testCreateManySingletons() {
    // given
    int numberOfSingletons = 100;

    // when
    List<Singleton> singletonList = new ArrayList<>(numberOfSingletons);
    for (int i = 0; i < numberOfSingletons; i++) {
      singletonList.add(Singleton.getInstance());
    }

    // then
    for (int i = 1; i < numberOfSingletons; i++) {
      assertEquals(singletonList.get(0).getId(), singletonList.get(i).getId());
    }
  }
}
