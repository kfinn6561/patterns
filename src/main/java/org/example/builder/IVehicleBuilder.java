package org.example.builder;

public interface IVehicleBuilder {
  public IVehicleBuilder setWindows(int windows);

  public IVehicleBuilder setDoors(int doors);

  public IVehicleBuilder setFuelType(FuelType fuelType);
  public IVehicleBuilder setTankSize(int tankSize);
}
