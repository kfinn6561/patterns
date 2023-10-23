package org.example.builder;

public class BuilderExampleUsage {
  public static void ExampleUsage(String carType) {
    Director director = new Director();
    CarBuilder carBuilder = new CarBuilder();
    CarManualBuilder manualBuilder = new CarManualBuilder();

    director.build(carType, carBuilder);
    Car car = carBuilder.build();

    director.build(carType, manualBuilder);
    CarManual manual = manualBuilder.build();

    System.out.println(manual.getDescription());

    double costOfFuel = car.fillTank();

    int i = 0;
    System.out.printf("filling the tank cost £%.2f%n", costOfFuel);
    while (car.DriveStep(0.1)) {
      System.out.println(car.Description());
      i++;
      if (i > 150) {
        break;
      }
    }
    System.out.printf(
        "%s traveled a total distance of %.2f miles on a full tank, reaching a final speed of %.2f mph.%n",
        car.getName(), car.getCurrentPosition(), car.getCurrentSpeed());
  }
}
