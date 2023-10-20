package org.example.builder;

import static java.lang.Double.max;

public class Car {
  private final String name;
  private final FuelType fuelType;
  private final double engineSize;
  private final int numberOfDoors;
  private final double tankSize;
  private final double fuelConsumption;
  private double currentSpeed;
  private double currentPosition;
  private double currentFuel;

  public Car(
      String name, FuelType fuelType, double engineSize, int numberOfDoors, double tankSize) {
    this.name = name;
    this.fuelType = fuelType;
    this.engineSize = engineSize;
    this.numberOfDoors = numberOfDoors;
    this.tankSize = tankSize;
    this.fuelConsumption =
        CarUtils.calculateFuelConsumption(this.fuelType, this.engineSize, this.numberOfDoors);
    this.currentFuel = 0;
    this.currentSpeed = 0;
    this.currentPosition = 0;
  }

  public double fillTank() {
    double fuelBought = max(tankSize - this.currentFuel, 0);
    this.currentFuel = tankSize;
    return CarUtils.CalculateFuelPrice(this.fuelType, fuelBought);
  }

  public double getCurrentSpeed() {
    return currentSpeed;
  }

  public double getCurrentPosition() {
    return currentPosition;
  }

  public double getCurrentFuel() {
    return currentFuel;
  }

  public boolean DriveStep(double dt) {
    double fuelUsed = dt * this.fuelConsumption;

    if (fuelUsed > currentFuel) {
      return false;
    }

    this.currentFuel -= fuelUsed;

    double acceleration = CarUtils.calculateAcceleration(fuelType, engineSize, currentSpeed);

    this.currentPosition += currentSpeed * dt;

    this.currentSpeed += acceleration * dt;

    return true;
  }

  public String Description() {
    return String.format(
        "%d door, %.2f litre %s %s with a %.2fL tank. Currently doing %.1f miles per hour, %.1f miles from home",
        this.numberOfDoors,
        this.engineSize,
        this.fuelType,
        this.name,
        this.tankSize,
        this.currentSpeed,
        this.currentPosition);
  }
}
