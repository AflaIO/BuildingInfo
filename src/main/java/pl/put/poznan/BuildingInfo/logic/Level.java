package pl.put.poznan.BuildingInfo.logic;
import java.util.ArrayList;
import java.util.List;

public class Level extends Location {
    private List<Room> rooms;

    public Level(int id, String name) {
        super(id, name);
        this.rooms = new ArrayList<>();
    }


    @Override
    public void add(Location location) {
        if (location instanceof Room) {
            rooms.add((Room) location);
        } else {
            throw new IllegalArgumentException("Only instances of Room can be added to Level.");
        }
    }

    @Override
    public void remove(Location location) {
        rooms.remove(location);
    }

    @Override
    public void display() {
        System.out.println("Level: " + name);
        for (Room room : rooms) {
            room.display();
        }
    }

    public double calculateTotalArea() {
        double totalArea = 0.0;
        for (Room room : rooms) {
            totalArea += room.getArea();
        }
        return totalArea;
    }
    public double calculateTotalCube(){
        double totalCube = 0.0;
        for(Room room : rooms){
            totalCube += room.getCube();
        }
        return totalCube;
    }

    public double calculateLightPower() {
        double lightPower = 0.0;
        for (Room room : rooms) {
            lightPower += room.calculateLightPower();
        }
        return lightPower;
    }

    public double calculateTotalEnergyConsumption() {
        double totalEnergyConsumption = 0.0;
        for (Room room : rooms) {
            totalEnergyConsumption += room.calculateEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
}
