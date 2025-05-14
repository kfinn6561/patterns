package org.example.factory;

public class GroundLogisticsHub extends LogisticsHub {
    // override the factory method to create a Truck
    @Override
    protected Transport createTransport(Location origin) {
        return new Truck(origin);
    }
}
