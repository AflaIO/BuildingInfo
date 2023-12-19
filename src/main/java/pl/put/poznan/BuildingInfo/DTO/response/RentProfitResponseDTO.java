package pl.put.poznan.BuildingInfo.DTO.response;

public class RentProfitResponseDTO {
    private int id;

    private String name;
    private double rentProfit;

    public RentProfitResponseDTO(int id, String name, double rentProfit) {
        this.id = id;
        this.name = name;
        this.rentProfit = rentProfit;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRentProfit() {
        return rentProfit;
    }
}

