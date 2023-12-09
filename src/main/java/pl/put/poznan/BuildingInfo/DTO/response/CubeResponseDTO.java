package pl.put.poznan.BuildingInfo.DTO.response;

public class CubeResponseDTO {
    private int id;

    private String name;
    private double cube;

    public CubeResponseDTO(int id, String name, double totalCube) {
        this.id = id;
        this.name = name;
        this.cube = totalCube;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCube() {
        return cube;
    }
}
