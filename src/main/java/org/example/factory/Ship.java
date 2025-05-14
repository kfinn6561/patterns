package org.example.factory;

public class Ship implements Transport{
    private Location currentLocation;
    private boolean busy;

    private static final float SHIP_SPEED = 30.0f; // Speed in km/h

    public Ship(Location currentLocation) {
        this.currentLocation = currentLocation;
        this.busy = false;
    }

    @Override
    public void deliver(Location origin, Location destination) {
        // Simulate delivery process
        System.out.println("Ship delivering from " + origin.name() + " to " + destination.name());
        this.currentLocation = destination;
        this.busy = true; // Mark as busy during delivery
        // Simulate delivery in a separate thread
        new Thread(() -> {
            try {
                System.out.println("Splish splosh!");
                // Simulate time passing (e.g., 5 seconds)
                Thread.sleep((int)(SHIP_SPEED*origin.distanceTo(destination) * 1000 / 60)); // Convert speed to time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            } finally {
                this.busy = false; // Mark as not busy after delivery
            }
        }).start();
    }

    @Override
    public boolean isBusy() {
        return busy;
    }

    @Override
    public Location getCurrentLocation() {
        return currentLocation;
    }
}
