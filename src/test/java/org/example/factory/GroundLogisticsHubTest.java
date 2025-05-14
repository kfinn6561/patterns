package org.example.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroundLogisticsHubTest {
    private GroundLogisticsHub groundLogisticsHub;
    @BeforeEach
    void setUp() {
        groundLogisticsHub = new GroundLogisticsHub();
    }

    @Test
    void testDeliverPackage() {
        Location origin = new Location("Origin", 0, 0);
        Location destination = new Location("Destination", 10, 10);

        groundLogisticsHub.deliverPackage(origin, destination);

        List<Transport> transportPool = groundLogisticsHub.getTransportPool();
        assertEquals(1, transportPool.size());
        assertInstanceOf(Truck.class, transportPool.get(0));
    }

    @Test
    void testDeliverTwoPackagesQuickly(){
        Location origin = new Location("Origin", 0, 0);
        Location destination1 = new Location("Destination1", 10, 10);
        Location destination2 = new Location("Destination2", 20, 20);

        groundLogisticsHub.deliverPackage(origin, destination1);
        groundLogisticsHub.deliverPackage(origin, destination2);

        List<Transport> transportPool = groundLogisticsHub.getTransportPool();
        assertEquals(2, transportPool.size());
        assertInstanceOf(Truck.class, transportPool.get(0));
        assertInstanceOf(Truck.class, transportPool.get(1));
    }

    @Test
    void testDeliverTwoPackagesSlowly(){
        Location origin = new Location("Origin", 0, 0);
        Location destination1 = new Location("Destination1", 10, 10);
        Location destination2 = new Location("Destination2", 20, 20);

        groundLogisticsHub.deliverPackage(origin, destination1);

        // Simulate some delay
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        groundLogisticsHub.deliverPackage(origin, destination2);

        List<Transport> transportPool = groundLogisticsHub.getTransportPool();
        assertEquals(1, transportPool.size());
        assertInstanceOf(Truck.class, transportPool.get(0));
    }
}