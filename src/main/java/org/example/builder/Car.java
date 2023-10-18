package org.example.builder;

public class Car {
    private final FuelType fuelType;
    private final int numberOfWindows;
    private final int numberOfDoors;
    private final int tankSize;
    private int currentSpeed;
    private int currentPosition;
    private int currentFuel;

    public Car(FuelType fuelType, int numberOfWindows, int numberOfDoors, int tankSize) {
        this.fuelType = fuelType;
        this.numberOfWindows = numberOfWindows;
        this.numberOfDoors = numberOfDoors;
        this.tankSize = tankSize;
        this.currentSpeed=0;
        this.currentPosition=0;
    }

    public void fillTank(){
        this.currentFuel=tankSize;
    }
}
