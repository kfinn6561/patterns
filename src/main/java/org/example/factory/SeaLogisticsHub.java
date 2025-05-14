package org.example.factory;

public class SeaLogisticsHub extends LogisticsHub {
    @Override
    protected Transport createTransport(Location origin) {
        return new Ship(origin);
    }
}
