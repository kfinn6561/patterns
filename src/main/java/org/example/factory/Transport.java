package org.example.factory;

public interface Transport {
    void deliver(Location origin, Location destination);
    boolean isBusy();
    Location getCurrentLocation();
}
