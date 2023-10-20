package org.example.builder;

public class CarBuilder implements IVehicleBuilder {
  private String name;
  private FuelType fuelType;
  private double engineSize;
  private int numberOfDoors;
  private double tankSize;

  @Override
  public IVehicleBuilder setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public IVehicleBuilder setDoors(int doors) {
    this.numberOfDoors = doors;
    return this;
  }

  @Override
  public IVehicleBuilder setFuelType(FuelType fuelType) {
    this.fuelType = fuelType;
    return this;
  }

  @Override
  public IVehicleBuilder setTankSize(double tankSize) {
    this.tankSize = tankSize;
    return this;
  }

  @Override
  public IVehicleBuilder setEngineSize(double engineSize) {
    this.engineSize = engineSize;
    return this;
  }

  public Car build() {
    return new Car(name, fuelType, engineSize, numberOfDoors, tankSize);
  }
}
