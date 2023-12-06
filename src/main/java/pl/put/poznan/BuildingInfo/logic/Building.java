package pl.put.poznan.BuildingInfo.logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Building extends Location {
    private List<Level> levels;

    @JsonCreator
    public Building(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("levels") List<Level> levels) {
        super(id, name);
        this.levels = levels;
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

    public Level getLevelById(int levelId) {
        for (Level level : levels) {
            if (level.id == levelId) {
                return level;
            }
        }
        return null;
    }
    public Room getRoomById(int roomId) {
        for (Level level : levels) {
            for (Room room : level.getRooms()) {
                if (room.id == roomId) {
                    return room;
                }
            }
        }
        return null;
    }

    public double calculateTotalArea() {
        double totalArea = 0.0;
        for (Level level : levels) {
            totalArea += level.calculateTotalArea();
        }
        return totalArea;
    }

    public double calculateTotalEnergyConsumption() {
        double totalEnergyConsumption = 0.0;
        for (Level level : levels) {
            totalEnergyConsumption += level.calculateTotalEnergyConsumption();
        }
        totalEnergyConsumption /= levels.size();
        return totalEnergyConsumption;
    }
}
