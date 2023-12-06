package pl.put.poznan.BuildingInfo.logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room extends Location {
    private double area;
    private double cube;
    private double heating;
    private int light;

    @JsonCreator
    public Room(@JsonProperty("id") int id,
                @JsonProperty("name") String name,
                @JsonProperty("area") double area,
                @JsonProperty("cube") double cube,
                @JsonProperty("heating") double heating,
                @JsonProperty("light") int light
                ) {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    @Override
    public void add(Location location) {
        throw new UnsupportedOperationException("Cannot add location to Room");
    }

    @Override
    public void remove(Location location) {
        throw new UnsupportedOperationException("Cannot remove location from Room");
    }

    @Override
    public void display() {
        System.out.println("Room: " + name + ", Area: " + area + "m^2, Cube: " + cube + "m^3, Heating: " + heating + ", Light: " + light);
    }

    public double getArea() {
        return area;
    }

    public double getEnergyConsumption() { return heating/cube; }
}

