package pl.put.poznan.BuildingInfo.DTO.response;

public class EnergyCostResponseDTO {
    private int id;

    private String name;
    private double energyCost;

    public EnergyCostResponseDTO(int id, String name, double energyCost) {
        this.id = id;
        this.name = name;
        this.energyCost = energyCost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getEnergyCost() {
        return energyCost;
    }
}
