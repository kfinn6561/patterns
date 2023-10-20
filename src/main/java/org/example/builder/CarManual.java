package org.example.builder;

public class CarManual {
  private final String name;
  private final FuelType fuelType;
  private final double engineSize;
  private final int numberOfDoors;
  private final double tankSize;
  private final double fuelConsumption;
  private final double maxSpeed;

  public CarManual(
      String name, FuelType fuelType, double engineSize, int numberOfDoors, double tankSize) {
    this.name = name;
    this.fuelType = fuelType;
    this.engineSize = engineSize;
    this.numberOfDoors = numberOfDoors;
    this.tankSize = tankSize;
    this.fuelConsumption =
        CarUtils.calculateFuelConsumption(this.fuelType, this.engineSize, this.numberOfDoors);
    this.maxSpeed = CarUtils.calculateMaxSpeed(this.engineSize);
  }

  public String getDescription() {
    return String.format(
        "The %d door %s %s has a %.2fL engine and a tank size of %.2f litres. Its fuel consumption is %.2f mpg and it has a top speed of %.2f mph.",
        numberOfDoors, fuelType, name, engineSize, tankSize, fuelConsumption, maxSpeed);
  }
}
