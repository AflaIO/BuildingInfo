package pl.put.poznan.BuildingInfo.logic;

import java.util.ArrayList;
import java.util.List;

public class Building extends Location {
    private List<Level> levels;

    public Building(int id, String name) {
        super(id, name);
        this.levels = new ArrayList<>();
    }

    @Override
    public void add(Location location) {
        if (location instanceof Level) {
            levels.add((Level) location);
        } else {
            throw new IllegalArgumentException("Only instances of Level can be added to Building.");
        }
    }

    @Override
    public void remove(Location location) {
        levels.remove(location);
    }

    @Override
    public void display() {
        System.out.println("Building: " + name);
        for (Level level : levels) {
            level.display();
        }
    }

    public double calculateTotalArea() {
        double totalArea = 0.0;
        for (Level level : levels) {
            totalArea += level.calculateTotalArea();
        }
        return totalArea;
    }

    public double calculateLightPower() {
        double lightPower = 0.0;
        for (Level level : levels) {
            lightPower += level.calculateLightPower();
        }
        return lightPower;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
