package org.example.builder;

public class BuilderExampleUsage{
    public static void ExampleUsage{
        Director director = new Director();
        CarBuilder carBuilder = new CarBuilder();
        CarManualBuilder manualBuilder = new CarManualBuilder();

Car mercedes = director.buildMercedes(carBuilder).build();
CarManual mercedesManual=director.buildMercedes(manualBuilder).build();

System.out.Println(mercedesManual.getDescription());

double costOfFuel = mercedes.fillTank();

System.out.Println(String.format("filling the tank cost £%.2f",costOfFuel));
while (mercedes.DriveStep(0.1)){
    System.out.Println(mercedes.Description());
}
System.out.Println(String.format("Mercedes traveled a total distance of %.2d miles on a full tank, reaching a final speed of %.2d mph.", mercedes.getCurrentPosition(),mercedes.getCurrentSpeed()))

    }
}