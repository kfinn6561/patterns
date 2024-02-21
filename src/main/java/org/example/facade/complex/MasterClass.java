package org.example.facade.complex;

public class MasterClass {
  private SubClass subClass;

  public MasterClass(SubClass subClass) {
    this.subClass = subClass;
  }

  public void processSubclass(SubClass subClass) {
    this.subClass.processString(subClass.getName());
  }

  public SubClass getSubClass() {
    return subClass;
  }
}
