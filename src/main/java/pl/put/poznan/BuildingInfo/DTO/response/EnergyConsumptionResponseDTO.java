package pl.put.poznan.BuildingInfo.DTO.response;

public class EnergyConsumptionResponseDTO {
    private int id;

    private String name;
    private double energyConsumption;

    public EnergyConsumptionResponseDTO(int id, String name, double energyConsumption) {
        this.id = id;
        this.name = name;
        this.energyConsumption = energyConsumption;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }
}
