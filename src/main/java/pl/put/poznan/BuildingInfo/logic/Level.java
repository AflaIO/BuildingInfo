package pl.put.poznan.BuildingInfo.logic;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Level extends Location {
    private List<Room> rooms;

    @JsonCreator
    public Level(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("rooms") List<Room> rooms) {
        super(id, name);
        this.rooms = rooms;
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

    public List<Room> getRooms(){ return rooms;}

    public double calculateTotalArea() {
        double totalArea = 0.0;
        for (Room room : rooms) {
            totalArea += room.getArea();
        }
        return totalArea;
    }

    public double calculateTotalEnergyConsumption() {
        double totalEnergyConsumption = 0.0;
        for (Room room : rooms) {
            totalEnergyConsumption += room.getEnergyConsumption();
        }
        totalEnergyConsumption /= rooms.size();
        return totalEnergyConsumption;
    }
}
