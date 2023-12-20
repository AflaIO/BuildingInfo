package pl.put.poznan.BuildingInfo.DTO.requestBody;



public class RoomDTO {
    private int id;
    private String name;
    private double area;
    private double cube;
    private float heating;
    private int light;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public double getCube() {
        return cube;
    }

    public float getHeating() {
        return heating;
    }

    public int getLight() {
        return light;
    }

    public RoomDTO(int id, String name, double area, double cube, float heating, int light) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }
}
