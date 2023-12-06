package pl.put.poznan.BuildingInfo.logic;

import java.util.ArrayList;
import java.util.List;

public class Building extends Location {
    private List<Location> levels;

    public Building(int id, String name) {
        super(id, name);
        this.levels = new ArrayList<>();
    }

    @Override
    public void add(Location location) {
        levels.add(location);
    }

    @Override
    public void remove(Location location) {
        levels.remove(location);
    }

    @Override
    public void display() {
        System.out.println("Building: " + name);
        for (Location level : levels) {
            level.display();
        }
    }
}

