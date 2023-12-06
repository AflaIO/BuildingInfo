package pl.put.poznan.BuildingInfo.logic;

public class Room extends Location {
    private double area;
    private double cube;
    private float heating;
    private int light;

    public Room(int id, String name, double area, double cube, float heating, int light) {
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

    public double getCube(){return cube;}
}

