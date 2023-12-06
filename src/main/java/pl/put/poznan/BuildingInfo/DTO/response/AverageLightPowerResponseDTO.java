package pl.put.poznan.BuildingInfo.DTO.response;

public class AverageLightPowerResponseDTO {

    private int id;

    private String name;
    private double averageLightPower;

    public AverageLightPowerResponseDTO(int id, String name, double averageLightPower) {
        this.id = id;
        this.name = name;
        this.averageLightPower = averageLightPower;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAverageLightPower() {
        return averageLightPower;
    }
}
