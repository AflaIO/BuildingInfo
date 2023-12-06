package pl.put.poznan.BuildingInfo.logic;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonToBuilding {
    private final ObjectMapper objectMapper;

    public JsonToBuilding() {
        this.objectMapper = new ObjectMapper();
    }

    public Building transformJsonToBuilding(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), Building.class);
    }
}