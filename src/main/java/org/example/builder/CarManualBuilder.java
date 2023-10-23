package org.example.builder;

public class CarManualBuilder implements IVehicleBuilder {
  private String name;
  private FuelType fuelType;
  private double engineSize;
  private int numberOfDoors;
  private double tankSize;
  
@Override
  public void reset(){
    this.name=null;
    this.fuelType=null;
    this.engineSize= 0.0;
    this.numberOfDoors= 0;
    this.tankSize= 0.0;
  }

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

  public CarManual build() {
    return new CarManual(name, fuelType, engineSize, numberOfDoors, tankSize);
  }
}
