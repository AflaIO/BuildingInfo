package pl.put.poznan.BuildingInfo.DTO.requestBody;


import java.util.List;

public class LevelDTO {
    private int id;
    private String name;
    private List<RoomDTO> rooms;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<RoomDTO> getRooms() {
        return rooms;
    }
}
