package org.example.factory;

public class GroundLogisticsHub extends LogisticsHub {
    @Override
    protected Transport createTransport(Location origin) {
        return new Truck(origin);
    }
}
