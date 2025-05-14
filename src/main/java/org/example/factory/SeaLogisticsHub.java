package org.example.factory;

public class SeaLogisticsHub extends LogisticsHub {
    // override the factory method to create a Ship
    @Override
    protected Transport createTransport(Location origin) {
        return new Ship(origin);
    }
}
