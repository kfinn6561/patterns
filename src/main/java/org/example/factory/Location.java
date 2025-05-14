package org.example.factory;

public record Location(String name, float latitude, float longitude) {
    public float distanceTo(Location other) {
        // Simple Euclidean distance for demonstration purposes
        return (float) Math.sqrt(Math.pow(this.latitude - other.latitude, 2) +
                Math.pow(this.longitude - other.longitude, 2));
    }
}
