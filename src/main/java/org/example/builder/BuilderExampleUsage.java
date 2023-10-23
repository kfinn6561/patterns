package org.example.builder;

public class BuilderExampleUsage {
  public static void ExampleUsage() {
    Director director = new Director();
    CarBuilder carBuilder = new CarBuilder();
    CarManualBuilder manualBuilder = new CarManualBuilder();

    director.buildMercedes(carBuilder);
    Car mercedes = carBuilder.build();

    director.buildMercedes(manualBuilder);
    CarManual mercedesManual = manualBuilder.build();

    System.out.println(mercedesManual.getDescription());

    double costOfFuel = mercedes.fillTank();

    System.out.printf("filling the tank cost £%.2f%n", costOfFuel);
    while (mercedes.DriveStep(0.1)) {
      System.out.println(mercedes.Description());
    }
    System.out.printf(
        "Mercedes traveled a total distance of %.2f miles on a full tank, reaching a final speed of %.2f mph.%n",
        mercedes.getCurrentPosition(), mercedes.getCurrentSpeed());
  }
}
