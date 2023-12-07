package pl.put.poznan.BuildingInfo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.BuildingInfo.DTO.requestBody.BuildingDTO;
import pl.put.poznan.BuildingInfo.DTO.requestBody.LevelDTO;
import pl.put.poznan.BuildingInfo.DTO.response.AreaResponseDTO;
import pl.put.poznan.BuildingInfo.DTO.response.AverageLightPowerResponseDTO;
import pl.put.poznan.BuildingInfo.DTO.response.CubeResponseDTO;
import pl.put.poznan.BuildingInfo.DTO.response.EnergyConsumptionResponseDTO;
import pl.put.poznan.BuildingInfo.logic.Level;
import pl.put.poznan.BuildingInfo.logic.Room;

import java.util.List;


@RestController
@RequestMapping("/api/levels")
public class LevelController {
    @GetMapping("/area")
    public ResponseEntity<?> getArea(@RequestParam int levelId, @RequestBody List<BuildingDTO> buildingDTOs) {
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            Level level = new Level(levelId, levelDTO.getName());

            levelDTO.getRooms().forEach(roomDTO ->
                    level.add(new Room(
                            roomDTO.getId(),
                            roomDTO.getName(),
                            roomDTO.getArea(),
                            roomDTO.getCube(),
                            roomDTO.getHeating(),
                            roomDTO.getLight()
                    ))
            );

            return ResponseEntity.ok(
                    new AreaResponseDTO(
                            level.getId(),
                            level.getName(),
                            level.calculateTotalArea()
                    ));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }
    @GetMapping("/cube")
    public ResponseEntity<?> getCube(@RequestParam int levelId, @RequestBody List<BuildingDTO> buildingDTOs) {
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            Level level = new Level(levelId, levelDTO.getName());

            levelDTO.getRooms().forEach(roomDTO ->
                    level.add(new Room(
                            roomDTO.getId(),
                            roomDTO.getName(),
                            roomDTO.getArea(),
                            roomDTO.getCube(),
                            roomDTO.getHeating(),
                            roomDTO.getLight()
                    ))
            );

            return ResponseEntity.ok(
                    new CubeResponseDTO(
                            level.getId(),
                            level.getName(),
                            level.calculateTotalCube()
                    ));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }
    @GetMapping("/light-power")
    public ResponseEntity<?> getAveragePower(@RequestParam int levelId, @RequestBody List<BuildingDTO> buildingDTOs) {
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            Level level = new Level(levelId, levelDTO.getName());

            levelDTO.getRooms().forEach(roomDTO ->
                    level.add(new Room(
                            roomDTO.getId(),
                            roomDTO.getName(),
                            roomDTO.getArea(),
                            roomDTO.getCube(),
                            roomDTO.getHeating(),
                            roomDTO.getLight()
                    ))
            );

            return ResponseEntity.ok(
                    new AverageLightPowerResponseDTO(
                            level.getId(),
                            level.getName(),
                            level.calculateLightPower()
                    ));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }

    @GetMapping("/energy-consumption")
    public ResponseEntity<?> getEnergyConsumption(@RequestParam int levelId, @RequestBody List<BuildingDTO> buildingDTOs) {
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            Level level = new Level(levelId, levelDTO.getName());

            levelDTO.getRooms().forEach(roomDTO ->
                    level.add(new Room(
                            roomDTO.getId(),
                            roomDTO.getName(),
                            roomDTO.getArea(),
                            roomDTO.getCube(),
                            roomDTO.getHeating(),
                            roomDTO.getLight()
                    ))
            );

            return ResponseEntity.ok(
                    new EnergyConsumptionResponseDTO(
                            level.getId(),
                            level.getName(),
                            level.calculateTotalEnergyConsumption()
                    ));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }

    private LevelDTO findLevelById(List<BuildingDTO> buildingDTOs, int levelId) {
        return buildingDTOs.stream()
                .flatMap(buildingDTO -> buildingDTO.getLevels().stream())
                .filter(levelDTO -> levelDTO.getId() == levelId)
                .findFirst()
                .orElse(null);
    }
}
