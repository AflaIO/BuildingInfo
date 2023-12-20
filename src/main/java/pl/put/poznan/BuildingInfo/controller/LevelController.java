package pl.put.poznan.BuildingInfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.BuildingInfo.DTO.requestBody.BuildingDTO;
import pl.put.poznan.BuildingInfo.DTO.requestBody.LevelDTO;
import pl.put.poznan.BuildingInfo.DTO.response.*;
import pl.put.poznan.BuildingInfo.logic.Level;
import pl.put.poznan.BuildingInfo.logic.Room;

import java.util.List;


@RestController
@RequestMapping("/api/levels")
public class LevelController {
    private static final Logger logger = LoggerFactory.getLogger(LevelController.class);
    @GetMapping("/area")
    public ResponseEntity<?> getArea(@RequestParam int levelId, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with levelId: {}", "getArea", levelId);
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            logger.info("Level with ID: {} found", levelId);
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
            logger.warn("Level with ID: {} not found", levelId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }
    @GetMapping("/cube")
    public ResponseEntity<?> getCube(@RequestParam int levelId, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with levelId: {}", "getCube", levelId);
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            logger.info("Level with ID: {} found", levelId);
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
            logger.warn("Level with ID: {} not found", levelId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }
    @GetMapping("/light-power")
    public ResponseEntity<?> getAveragePower(@RequestParam int levelId, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with levelId: {}", "getAveragePower", levelId);
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            logger.info("Level with ID: {} found", levelId);
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
            logger.warn("Level with ID: {} not found", levelId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }

    @GetMapping("/energy-consumption")
    public ResponseEntity<?> getEnergyConsumption(@RequestParam int levelId, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with levelId: {}", "getEnergyConsumption", levelId);
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            logger.info("Level with ID: {} found", levelId);
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
            logger.warn("Level with ID: {} not found", levelId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }

    @GetMapping("/energy-cost/yearly")
    public ResponseEntity<?> getEnergyCostYearly(@RequestParam int levelId, @RequestParam double energyCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with levelId: {} and energyCost: {}", "getEnergyCostYearly", levelId, energyCost);
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            logger.info("Level with ID: {} found", levelId);
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
                    new EnergyCostResponseDTO(
                            level.getId(),
                            level.getName(),
                            level.calculateEnergyCostYearly(energyCost)
                    ));
        } else {
            logger.warn("Level with ID: {} not found", levelId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }

    @GetMapping("/energy-cost/monthly")
    public ResponseEntity<?> getEnergyCostMonthly(@RequestParam int levelId, @RequestParam double energyCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with levelId: {} and energyCost: {}", "getEnergyCostMonthly", levelId, energyCost);
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            logger.info("Level with ID: {} found", levelId);
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
                    new EnergyCostResponseDTO(
                            level.getId(),
                            level.getName(),
                            level.calculateEnergyCostMonthly(energyCost)
                    ));
        } else {
            logger.warn("Level with ID: {} not found", levelId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }

    @GetMapping("/energy-cost/weekly")
    public ResponseEntity<?> getEnergyCostWeekly(@RequestParam int levelId, @RequestParam double energyCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with levelId: {} and energyCost: {}", "getEnergyCostWeekly", levelId, energyCost);
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            logger.info("Level with ID: {} found", levelId);
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
                    new EnergyCostResponseDTO(
                            level.getId(),
                            level.getName(),
                            level.calculateEnergyCostWeekly(energyCost)
                    ));
        } else {
            logger.warn("Level with ID: {} not found", levelId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }

    @GetMapping("/energy-cost/daily")
    public ResponseEntity<?> getEnergyCostDaily(@RequestParam int levelId, @RequestParam double energyCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with levelId: {} and energyCost: {}", "getEnergyCostDaily", levelId, energyCost);
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            logger.info("Level with ID: {} found", levelId);
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
                    new EnergyCostResponseDTO(
                            level.getId(),
                            level.getName(),
                            level.calculateEnergyCostDaily(energyCost)
                    ));
        } else {
            logger.warn("Level with ID: {} not found", levelId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }

    @GetMapping("/rent-profit/yearly")
    public ResponseEntity<?> getRentProfitYearly(@RequestParam int levelId, @RequestParam double areaCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with levelId: {} and areaCost: {}", "getRentProfitYearly", levelId, areaCost);
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            logger.info("Level with ID: {} found", levelId);
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
                    new RentProfitResponseDTO(
                            level.getId(),
                            level.getName(),
                            level.calculateRentProfitYearly(areaCost)
                    ));
        } else {
            logger.warn("Level with ID: {} not found", levelId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }

    @GetMapping("/rent-profit/monthly")
    public ResponseEntity<?> getRentProfitMonthly(@RequestParam int levelId, @RequestParam double areaCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with levelId: {} and areaCost: {}", "getRentProfitMonthly", levelId, areaCost);
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            logger.info("Level with ID: {} found", levelId);
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
                    new RentProfitResponseDTO(
                            level.getId(),
                            level.getName(),
                            level.calculateRentProfitMonthly(areaCost)
                    ));
        } else {
            logger.warn("Level with ID: {} not found", levelId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }

    @GetMapping("/rent-profit/weekly")
    public ResponseEntity<?> getRentProfitWeekly(@RequestParam int levelId, @RequestParam double areaCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with levelId: {} and areaCost: {}", "getRentProfitWeekly", levelId, areaCost);
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            logger.info("Level with ID: {} found", levelId);
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
                    new RentProfitResponseDTO(
                            level.getId(),
                            level.getName(),
                            level.calculateRentProfitWeekly(areaCost)
                    ));
        } else {
            logger.warn("Level with ID: {} not found", levelId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level with ID: "+levelId+" not found");
        }
    }

    @GetMapping("/rent-profit/daily")
    public ResponseEntity<?> getRentProfitDaily(@RequestParam int levelId, @RequestParam double areaCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with levelId: {} and areaCost: {}", "getRentProfitDaily", levelId, areaCost);
        LevelDTO levelDTO = findLevelById(buildingDTOs, levelId);

        if (levelDTO != null) {
            logger.info("Level with ID: {} found", levelId);
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
                    new RentProfitResponseDTO(
                            level.getId(),
                            level.getName(),
                            level.calculateRentProfitDaily(areaCost)
                    ));
        } else {
            logger.warn("Level with ID: {} not found", levelId);
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
