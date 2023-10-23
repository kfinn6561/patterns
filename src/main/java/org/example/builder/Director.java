package org.example.builder;

publc class Director{
    publc IVehicleBuilder buildMercedes(IVehicleBuilder builder){
        builder.reset();
        return builder
        .setName("Mercedes")
        .setDoors(5)
        .setFuelType(FuelType.PETROL)
        .setTankSize(100.0)
        .setEngineSize(10.0)
    }

publc IVehicleBuilder buildTesla(IVehicleBuilder builder){
    builder.reset();
        return builder
        .setName("Tesla")
        .setDoors(5)
        .setFuelType(FuelType.ELECTRIC)
        .setTankSize(0.0)
        .setEngineSize(30.0)
    }
    publc IVehicleBuilder buildPrius(IVehicleBuilder builder){
        builder.reset();
        return builder
        .setName("Toyota Prius")
        .setDoors(3)
        .setFuelType(FuelType.HYBRID)
        .setTankSize(30.0)
        .setEngineSize(5.0)
    }
    publc IVehicleBuilder buildTransit(IVehicleBuilder builder){
        builder.reset();
        return builder
        .setName("Ford Transit van")
        .setDoors(7)
        .setFuelType(FuelType.DIESEL)
        .setTankSize(200.0)
        .setEngineSize(15.0)
    }
}