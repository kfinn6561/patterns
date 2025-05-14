package org.example.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeaLogisticsHubTest {
    private SeaLogisticsHub seaLogisticsHub;
    @BeforeEach
    void setUp() {
        seaLogisticsHub = new SeaLogisticsHub();
    }

    @Test
    void testDeliverPackage() {
        Location origin = new Location("Origin", 0, 0);
        Location destination = new Location("Destination", 10, 10);

        seaLogisticsHub.deliverPackage(origin, destination);

        List<Transport> transportPool = seaLogisticsHub.getTransportPool();
        assertEquals(1, transportPool.size());
        assertInstanceOf(Ship.class, transportPool.get(0));
    }

    @Test
    void testDeliverTwoPackagesQuickly(){
        Location origin = new Location("Origin", 0, 0);
        Location destination1 = new Location("Destination1", 10, 10);
        Location destination2 = new Location("Destination2", 20, 20);

        seaLogisticsHub.deliverPackage(origin, destination1);
        seaLogisticsHub.deliverPackage(origin, destination2);

        List<Transport> transportPool = seaLogisticsHub.getTransportPool();
        assertEquals(2, transportPool.size());
        assertInstanceOf(Ship.class, transportPool.get(0));
        assertInstanceOf(Ship.class, transportPool.get(1));
    }

    @Test
    void testDeliverTwoPackagesSlowly(){
        Location origin = new Location("Origin", 0, 0);
        Location destination1 = new Location("Destination1", 10, 10);
        Location destination2 = new Location("Destination2", 20, 20);

        seaLogisticsHub.deliverPackage(origin, destination1);

        // Simulate some delay
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        seaLogisticsHub.deliverPackage(origin, destination2);

        List<Transport> transportPool = seaLogisticsHub.getTransportPool();
        assertEquals(1, transportPool.size());
        assertInstanceOf(Ship.class, transportPool.get(0));
    }

}