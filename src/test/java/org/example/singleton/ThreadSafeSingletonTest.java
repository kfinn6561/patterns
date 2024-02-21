package org.example.singleton;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadSafeSingletonTest {
  @Test
  public void manyConcurrentSingletons() throws ExecutionException, InterruptedException {
    // given
    int numberOfSingletons = 100;

    // when
    List<CompletableFuture< ThreadSafeSingleton>> singletonList = new ArrayList<>(numberOfSingletons);
    for (int i = 0; i < numberOfSingletons; i++) {
      singletonList.add(CompletableFuture.supplyAsync(ThreadSafeSingleton::getInstance));
    }

    // then
    for (int i = 1; i < numberOfSingletons; i++) {
      assertEquals(singletonList.get(0).get().getId(), singletonList.get(i).get().getId());
    }
  }
}
