package pl.put.poznan.BuildingInfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.BuildingInfo.DTO.requestBody.BuildingDTO;
import pl.put.poznan.BuildingInfo.DTO.requestBody.RoomDTO;
import pl.put.poznan.BuildingInfo.DTO.response.AreaResponseDTO;
import pl.put.poznan.BuildingInfo.DTO.response.AverageLightPowerResponseDTO;
import pl.put.poznan.BuildingInfo.DTO.response.CubeResponseDTO;
import pl.put.poznan.BuildingInfo.DTO.response.EnergyConsumptionResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.BuildingInfo.DTO.requestBody.BuildingDTO;
import pl.put.poznan.BuildingInfo.DTO.requestBody.RoomDTO;
import pl.put.poznan.BuildingInfo.DTO.response.AverageLightPowerResponseDTO;
import pl.put.poznan.BuildingInfo.logic.Building;
import pl.put.poznan.BuildingInfo.logic.Level;
import pl.put.poznan.BuildingInfo.logic.Room;

import java.util.List;


@RestController
@RequestMapping("/api/buildings")
public class BuildingController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingController.class);
    @GetMapping("/area")
    public ResponseEntity<?> getArea(@RequestParam int buildingId, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with buildingId: {}", "getArea", buildingId);
        BuildingDTO buildingDTO = findBuildingById(buildingDTOs, buildingId);

        if (buildingDTO != null) {
            logger.info("Building with ID: {} found", buildingId);
            Building building = new Building(buildingId, buildingDTO.getName());

            buildingDTO.getLevels().forEach(levelDTO -> {
                Level level = new Level(levelDTO.getId(), levelDTO.getName());
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
                building.add(level);
            });

            return ResponseEntity.ok(
                    new AreaResponseDTO(
                            building.getId(),
                            building.getName(),
                            building.calculateTotalArea()
                    ));
        } else {
            logger.warn("Building with ID: {} not found", buildingId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Building with ID: "+buildingId+" not found");
        }
    }
    @GetMapping("/cube")
    public ResponseEntity<?> getCube(@RequestParam int buildingId, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with buildingId: {}", "getCube", buildingId);
        BuildingDTO buildingDTO = findBuildingById(buildingDTOs, buildingId);

        if (buildingDTO != null) {
            logger.info("Building with ID: {} found", buildingId);
            Building building = new Building(buildingId, buildingDTO.getName());

            buildingDTO.getLevels().forEach(levelDTO -> {
                Level level = new Level(levelDTO.getId(), levelDTO.getName());
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
                building.add(level);
            });

            return ResponseEntity.ok(
                    new CubeResponseDTO(
                            building.getId(),
                            building.getName(),
                            building.calculateTotalCube()
                    ));
        } else {
            logger.warn("Building with ID: {} not found", buildingId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Building with ID: "+buildingId+" not found");
        }
    }
    @GetMapping("/light-power")
    public ResponseEntity<?> getAveragePower(@RequestParam int buildingId, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with buildingId: {}", "getAveragePower", buildingId);
        BuildingDTO buildingDTO = findBuildingById(buildingDTOs, buildingId);

        if (buildingDTO != null) {
            logger.info("Building with ID: {} found", buildingId);
            Building building = new Building(buildingId, buildingDTO.getName());

            buildingDTO.getLevels().forEach(levelDTO -> {
                Level level = new Level(levelDTO.getId(), levelDTO.getName());
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
                building.add(level);
            });

            return ResponseEntity.ok(
                    new AverageLightPowerResponseDTO(
                            building.getId(),
                            building.getName(),
                            building.calculateLightPower()
                    ));
        } else {
            logger.warn("Building with ID: {} not found", buildingId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Building with ID: "+buildingId+" not found");
        }
    }

    @GetMapping("/energy-consumption")
    public ResponseEntity<?> getEnergyConsumption(@RequestParam int buildingId, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with buildingId: {}", "getEnergyConsumption", buildingId);
        BuildingDTO buildingDTO = findBuildingById(buildingDTOs, buildingId);

        if (buildingDTO != null) {
            logger.info("Building with ID: {} found", buildingId);
            Building building = new Building(buildingId, buildingDTO.getName());

            buildingDTO.getLevels().forEach(levelDTO -> {
                Level level = new Level(levelDTO.getId(), levelDTO.getName());
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
                building.add(level);
            });

            return ResponseEntity.ok(
                    new EnergyConsumptionResponseDTO(
                            building.getId(),
                            building.getName(),
                            building.calculateTotalEnergyConsumption()
                    ));
        } else {
            logger.warn("Building with ID: {} not found", buildingId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Building with ID: "+buildingId+" not found");
        }
    }

    private BuildingDTO findBuildingById(List<BuildingDTO> buildingDTOs, int buildingId) {
        return buildingDTOs.stream()
                .filter(buildingDTO -> buildingDTO.getId() == buildingId)
                .findFirst()
                .orElse(null);
    }
}
