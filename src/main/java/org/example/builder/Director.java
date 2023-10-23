package org.example.builder;

public class Director {
  public void build(String carName, IVehicleBuilder builder) {
    switch (carName) {
      case "mercedes" -> buildMercedes(builder);
      case "tesla" -> buildTesla(builder);
      case "prius" -> buildPrius(builder);
      case "transit" -> buildTransit(builder);
    }
  }

  public void buildMercedes(IVehicleBuilder builder) {
    builder.reset();
    builder
        .setName("Mercedes")
        .setDoors(5)
        .setFuelType(FuelType.PETROL)
        .setTankSize(100.0)
        .setEngineSize(10.0);
  }

  public void buildTesla(IVehicleBuilder builder) {
    builder.reset();
    builder
        .setName("Tesla")
        .setDoors(5)
        .setFuelType(FuelType.ELECTRIC)
        .setTankSize(0.0)
        .setEngineSize(30.0);
  }

  public void buildPrius(IVehicleBuilder builder) {
    builder.reset();
    builder
        .setName("Toyota Prius")
        .setDoors(3)
        .setFuelType(FuelType.HYBRID)
        .setTankSize(30.0)
        .setEngineSize(5.0);
  }

  public void buildTransit(IVehicleBuilder builder) {
    builder.reset();
    builder
        .setName("Ford Transit van")
        .setDoors(7)
        .setFuelType(FuelType.DIESEL)
        .setTankSize(200.0)
        .setEngineSize(15.0);
  }
}
