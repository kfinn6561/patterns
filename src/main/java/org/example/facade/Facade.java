package org.example.facade;

import org.example.facade.complex.MasterClass;
import org.example.facade.complex.SubClass;

public class Facade {
  public String CombineTwoStrings(String stringA, String stringB) {
    SubClass classA = new SubClass(stringA);
    MasterClass classB = new MasterClass(new SubClass(stringB));

    classB.processSubclass(classA);

    return classB.getSubClass().getName();
  }
}
