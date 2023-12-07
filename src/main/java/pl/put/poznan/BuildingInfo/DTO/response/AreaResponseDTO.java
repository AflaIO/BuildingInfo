package pl.put.poznan.BuildingInfo.DTO.response;

public class AreaResponseDTO {
    private int id;

    private String name;
    private double area;

    public AreaResponseDTO(int id, String name, double totalArea) {
        this.id = id;
        this.name = name;
        this.area = totalArea;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }
}
