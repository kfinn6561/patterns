package org.example.facade.complex;

public class SubClass {
  private String name;

  public SubClass(String name) {
    this.name = name;
  }

  public void processString(String newString) {
    this.name = newString + name + newString;
  }

  public String getName() {
    return name;
  }
}
