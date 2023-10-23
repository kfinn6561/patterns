package org.example.builder;

import org.junit.jupiter.api.Test;

public class BuilderTest {

  @Test
  public void TestExampleUsage() {
    BuilderExampleUsage.ExampleUsage("mercedes");
    BuilderExampleUsage.ExampleUsage("tesla");
    BuilderExampleUsage.ExampleUsage("prius");
    BuilderExampleUsage.ExampleUsage("transit");
  }
}
