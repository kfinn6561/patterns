package org.example.facade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FacadeTest {

  @Test
  public void testFacade() {
    // given
    Facade facade = new Facade();

    // when
    String actual = facade.CombineTwoStrings("foo", "bar");

    // then
    assertEquals("foobarfoo", actual);
  }
}
