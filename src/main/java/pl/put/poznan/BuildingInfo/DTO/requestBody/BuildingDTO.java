package pl.put.poznan.BuildingInfo.DTO.requestBody;


import java.util.List;

public class BuildingDTO {
    private int id;
    private String name;
    private List<LevelDTO> levels;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<LevelDTO> getLevels() {
        return levels;
    }
}
