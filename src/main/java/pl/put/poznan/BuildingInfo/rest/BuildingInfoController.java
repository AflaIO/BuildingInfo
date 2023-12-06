package pl.put.poznan.BuildingInfo.rest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.BuildingInfo.logic.Building;
import pl.put.poznan.BuildingInfo.logic.JsonToBuilding;
import java.io.File;

@RestController
@RequestMapping("/building")
public class BuildingInfoController {
    private Building building;
    private final JsonToBuilding jsonToBuilding = new JsonToBuilding();

    @PostMapping("/transform")
    public void transformJsonToBuilding() {
        try {
            Resource resource = new ClassPathResource("building_structure.json");
            File file = resource.getFile();
            building = jsonToBuilding.transformJsonToBuilding(file.getPath());
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to transform JSON to Building object: " + e.getMessage());
        }
    }

    @GetMapping("/area")
    public double calculateBuildingArea() {

        if (building == null) {
            throw new IllegalStateException("Building object is not initialized. Transform JSON first.");
        }

        return building.calculateTotalArea();
    }

    @GetMapping("/consumption")
    public double calculateBuildingEnergyConsumption() {

        if (building == null) {
            throw new IllegalStateException("Building object is not initialized. Transform JSON first.");
        }

        return building.calculateTotalEnergyConsumption();
    }

    @GetMapping("/level/{levelId}/area")
    public double calculateLevelArea(@PathVariable int levelId) {

        if (building == null) {
            throw new IllegalStateException("Building object is not initialized. Transform JSON first.");
        }

        return building.getLevelById(levelId).calculateTotalArea();
    }

    @GetMapping("/level/{levelId}/consumption")
    public double calculateLevelEnergyConsumption(@PathVariable int levelId) {

        if (building == null) {
            throw new IllegalStateException("Building object is not initialized. Transform JSON first.");
        }

        return building.getLevelById(levelId).calculateTotalEnergyConsumption();
    }
    @GetMapping("/room/{roomId}/area")
    public double calculateRoomArea(@PathVariable int roomId) {

        if (building == null) {
            throw new IllegalStateException("Building object is not initialized. Transform JSON first.");
        }

        return building.getRoomById(roomId).getArea();
    }

    @GetMapping("/room/{roomId}/consumption")
    public double calculateRoomEnergyConsumption(@PathVariable int roomId) {

        if (building == null) {
            throw new IllegalStateException("Building object is not initialized. Transform JSON first.");
        }

        return building.getRoomById(roomId).getEnergyConsumption();
    }

}
