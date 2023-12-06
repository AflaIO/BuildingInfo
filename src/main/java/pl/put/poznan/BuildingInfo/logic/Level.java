package pl.put.poznan.BuildingInfo.logic;

import java.util.ArrayList;
import java.util.List;
public class Level extends Location {
    private List<Location> rooms;

    public Level(int id, String name) {
        super(id, name);
        this.rooms = new ArrayList<>();
    }

    @Override
    public void add(Location location) {
        rooms.add(location);
    }

    @Override
    public void remove(Location location) {
        rooms.remove(location);
    }

    @Override
    public void display() {
        System.out.println("Level: " + name);
        for (Location room : rooms) {
            room.display();
        }
    }
}
