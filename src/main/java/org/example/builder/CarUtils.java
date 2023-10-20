package org.example.builder;

public class CarUtils {
  public static double MAX_SPEED = 100.0;

  public static double CalculateFuelPrice(FuelType fuelType, double amount) {
    double costPerUnit =
        switch (fuelType) {
          case PETROL, HYBRID -> 1.56;
          case DIESEL -> 1.98;
          case ELECTRIC -> 0.0;
        };

    return amount * costPerUnit;
  }

  public static double calculateFuelConsumption(
      FuelType fuelType, double engineSize, int numberOfDoors) {
    double fuelConsumptionAdjuster =
        switch (fuelType) {
          case PETROL -> 1.0;
          case DIESEL -> 0.8;
          case HYBRID -> 0.5;
          case ELECTRIC -> 0.;
        };
    double sizeAdjuster =
        switch (numberOfDoors) {
          case 2 -> 0.8;
          case 3 -> 1;
          case 5 -> 1.3;
          default -> Math.sqrt(numberOfDoors);
        };

    return fuelConsumptionAdjuster * engineSize * sizeAdjuster;
  }

  public static double calculateMaxSpeed(double engineSize) {
      return MAX_SPEED * engineSize;
  }

  public static double calculateAcceleration(
      FuelType fuelType, double engineSize, double currentSpeed) {
    double accelerationAdjuster =
        switch (fuelType) {
          case PETROL -> 1.0;
          case DIESEL -> 0.8;
          case HYBRID -> 1.5;
          case ELECTRIC -> 2.0;
        };

    double terminalVelocity = calculateMaxSpeed(engineSize);

    return (terminalVelocity - currentSpeed) * accelerationAdjuster;
  }
}
