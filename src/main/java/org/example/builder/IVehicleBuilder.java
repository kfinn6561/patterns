package org.example.builder;

public interface IVehicleBuilder {
  void reset();

  IVehicleBuilder setName(String name);

  IVehicleBuilder setDoors(int doors);

  IVehicleBuilder setFuelType(FuelType fuelType);

  IVehicleBuilder setTankSize(double tankSize);

  IVehicleBuilder setEngineSize(double engineSize);
}
