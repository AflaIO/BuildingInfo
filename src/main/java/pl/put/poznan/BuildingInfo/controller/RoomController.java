package pl.put.poznan.BuildingInfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.BuildingInfo.DTO.requestBody.BuildingDTO;
import pl.put.poznan.BuildingInfo.DTO.requestBody.RoomDTO;
import pl.put.poznan.BuildingInfo.DTO.response.*;
import pl.put.poznan.BuildingInfo.logic.Building;
import pl.put.poznan.BuildingInfo.logic.Level;
import pl.put.poznan.BuildingInfo.logic.Room;

import java.util.List;


@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
    @GetMapping("/area")
    public ResponseEntity<?> getArea(@RequestParam int roomId, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with roomId: {}", "getArea", roomId);
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
            logger.info("Room with ID: {} found", roomId);
            Room room = new Room(
                    roomDTO.getId(),
                    roomDTO.getName(),
                    roomDTO.getArea(),
                    roomDTO.getCube(),
                    roomDTO.getHeating(),
                    roomDTO.getLight()
            );

            return ResponseEntity.ok(
                    new AreaResponseDTO(
                            room.getId(),
                            room.getName(),
                            room.getArea()
                    ));
        } else {
            logger.warn("Room with ID: {} not found", roomId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }
    @GetMapping("/cube")
    public ResponseEntity<?> getCube(@RequestParam int roomId, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with roomId: {}", "getCube", roomId);
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
            logger.info("Room with ID: {} found", roomId);
            Room room = new Room(
                    roomDTO.getId(),
                    roomDTO.getName(),
                    roomDTO.getArea(),
                    roomDTO.getCube(),
                    roomDTO.getHeating(),
                    roomDTO.getLight()
            );

            return ResponseEntity.ok(
                    new CubeResponseDTO(
                            room.getId(),
                            room.getName(),
                            room.getCube()
                    ));
        } else {
            logger.warn("Room with ID: {} not found", roomId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }
    @GetMapping("/light-power")
    public ResponseEntity<?> getAveragePower(@RequestParam int roomId, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with roomId: {}", "getAveragePower", roomId);
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
            logger.info("Room with ID: {} found", roomId);
            Room room = new Room(
                    roomDTO.getId(),
                    roomDTO.getName(),
                    roomDTO.getArea(),
                    roomDTO.getCube(),
                    roomDTO.getHeating(),
                    roomDTO.getLight()
            );

            return ResponseEntity.ok(
                    new AverageLightPowerResponseDTO(
                            room.getId(),
                            room.getName(),
                            room.calculateLightPower()
                    ));
        } else {
            logger.warn("Room with ID: {} not found", roomId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }

    @GetMapping("/energy-consumption")
    public ResponseEntity<?> getEnergyConsumption(@RequestParam int roomId, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with roomId: {}", "getEnergyConsumption", roomId);
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
            logger.info("Room with ID: {} found", roomId);
            Room room = new Room(
                    roomDTO.getId(),
                    roomDTO.getName(),
                    roomDTO.getArea(),
                    roomDTO.getCube(),
                    roomDTO.getHeating(),
                    roomDTO.getLight()
            );

            return ResponseEntity.ok(
                    new EnergyConsumptionResponseDTO(
                            room.getId(),
                            room.getName(),
                            room.calculateEnergyConsumption()
                    ));
        } else {
            logger.warn("Room with ID: {} not found", roomId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }

    @GetMapping("/energy-cost/yearly")
    public ResponseEntity<?> getEnergyCostYearly(@RequestParam int roomId, @RequestParam double energyCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with roomId: {} and energyCost: {}", "getEnergyCostYearly", roomId, energyCost);
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
            logger.info("Room with ID: {} found", roomId);
            Room room = new Room(
                    roomDTO.getId(),
                    roomDTO.getName(),
                    roomDTO.getArea(),
                    roomDTO.getCube(),
                    roomDTO.getHeating(),
                    roomDTO.getLight()
            );

            return ResponseEntity.ok(
                    new EnergyCostResponseDTO(
                            room.getId(),
                            room.getName(),
                            room.calculateEnergyCostYearly(energyCost)
                    ));
        } else {
            logger.warn("Room with ID: {} not found", roomId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }

    @GetMapping("/energy-cost/monthly")
    public ResponseEntity<?> getEnergyCostMonthly(@RequestParam int roomId, @RequestParam double energyCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with roomId: {} and energyCost: {}", "getEnergyCostMonthly", roomId, energyCost);
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
            logger.info("Room with ID: {} found", roomId);
            Room room = new Room(
                    roomDTO.getId(),
                    roomDTO.getName(),
                    roomDTO.getArea(),
                    roomDTO.getCube(),
                    roomDTO.getHeating(),
                    roomDTO.getLight()
            );

            return ResponseEntity.ok(
                    new EnergyCostResponseDTO(
                            room.getId(),
                            room.getName(),
                            room.calculateEnergyCostMonthly(energyCost)
                    ));
        } else {
            logger.warn("Room with ID: {} not found", roomId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }

    @GetMapping("/energy-cost/weekly")
    public ResponseEntity<?> getEnergyCostWeekly(@RequestParam int roomId, @RequestParam double energyCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with roomId: {} and energyCost: {}", "getEnergyCostWeekly", roomId, energyCost);
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
            logger.info("Room with ID: {} found", roomId);
            Room room = new Room(
                    roomDTO.getId(),
                    roomDTO.getName(),
                    roomDTO.getArea(),
                    roomDTO.getCube(),
                    roomDTO.getHeating(),
                    roomDTO.getLight()
            );

            return ResponseEntity.ok(
                    new EnergyCostResponseDTO(
                            room.getId(),
                            room.getName(),
                            room.calculateEnergyCostWeekly(energyCost)
                    ));
        } else {
            logger.warn("Room with ID: {} not found", roomId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }

    @GetMapping("/energy-cost/daily")
    public ResponseEntity<?> getEnergyCostDaily(@RequestParam int roomId, @RequestParam double energyCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with roomId: {} and energyCost: {}", "getEnergyCostDaily", roomId, energyCost);
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
            logger.info("Room with ID: {} found", roomId);
            Room room = new Room(
                    roomDTO.getId(),
                    roomDTO.getName(),
                    roomDTO.getArea(),
                    roomDTO.getCube(),
                    roomDTO.getHeating(),
                    roomDTO.getLight()
            );

            return ResponseEntity.ok(
                    new EnergyCostResponseDTO(
                            room.getId(),
                            room.getName(),
                            room.calculateEnergyCostDaily(energyCost)
                    ));
        } else {
            logger.warn("Room with ID: {} not found", roomId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }

    @GetMapping("/rent-profit/yearly")
    public ResponseEntity<?> getRentProfitYearly(@RequestParam int roomId, @RequestParam double areaCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with roomId: {} and areaCost: {}", "getRentProfitYearly", roomId, areaCost);
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
            logger.info("Room with ID: {} found", roomId);
            Room room = new Room(
                    roomDTO.getId(),
                    roomDTO.getName(),
                    roomDTO.getArea(),
                    roomDTO.getCube(),
                    roomDTO.getHeating(),
                    roomDTO.getLight()
            );

            return ResponseEntity.ok(
                    new RentProfitResponseDTO(
                            room.getId(),
                            room.getName(),
                            room.calculateRentProfitYearly(areaCost)
                    ));
        } else {
            logger.warn("Room with ID: {} not found", roomId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }

    @GetMapping("/rent-profit/monthly")
    public ResponseEntity<?> getRentProfitMonthly(@RequestParam int roomId, @RequestParam double areaCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with roomId: {} and areaCost: {}", "getRentProfitMonthly", roomId, areaCost);
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
            logger.info("Room with ID: {} found", roomId);
            Room room = new Room(
                    roomDTO.getId(),
                    roomDTO.getName(),
                    roomDTO.getArea(),
                    roomDTO.getCube(),
                    roomDTO.getHeating(),
                    roomDTO.getLight()
            );

            return ResponseEntity.ok(
                    new RentProfitResponseDTO(
                            room.getId(),
                            room.getName(),
                            room.calculateRentProfitMonthly(areaCost)
                    ));
        } else {
            logger.warn("Room with ID: {} not found", roomId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }

    @GetMapping("/rent-profit/weekly")
    public ResponseEntity<?> getRentProfitWeekly(@RequestParam int roomId, @RequestParam double areaCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with roomId: {} and areaCost: {}", "getRentProfitWeekly", roomId, areaCost);
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
            logger.info("Room with ID: {} found", roomId);
            Room room = new Room(
                    roomDTO.getId(),
                    roomDTO.getName(),
                    roomDTO.getArea(),
                    roomDTO.getCube(),
                    roomDTO.getHeating(),
                    roomDTO.getLight()
            );

            return ResponseEntity.ok(
                    new RentProfitResponseDTO(
                            room.getId(),
                            room.getName(),
                            room.calculateRentProfitWeekly(areaCost)
                    ));
        } else {
            logger.warn("Room with ID: {} not found", roomId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }

    @GetMapping("/rent-profit/daily")
    public ResponseEntity<?> getRentProfitDaily(@RequestParam int roomId, @RequestParam double areaCost, @RequestBody List<BuildingDTO> buildingDTOs) {
        logger.info("Request received for method '{}' with roomId: {} and areaCost: {}", "getRentProfitDaily", roomId, areaCost);
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
            logger.info("Room with ID: {} found", roomId);
            Room room = new Room(
                    roomDTO.getId(),
                    roomDTO.getName(),
                    roomDTO.getArea(),
                    roomDTO.getCube(),
                    roomDTO.getHeating(),
                    roomDTO.getLight()
            );

            return ResponseEntity.ok(
                    new RentProfitResponseDTO(
                            room.getId(),
                            room.getName(),
                            room.calculateRentProfitDaily(areaCost)
                    ));
        } else {
            logger.warn("Room with ID: {} not found", roomId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }

    private RoomDTO findRoomById(List<BuildingDTO> buildingDTOs, int roomId) {
        return buildingDTOs.stream()
                .flatMap(buildingDTO -> buildingDTO.getLevels().stream())
                .flatMap(levelDTO -> levelDTO.getRooms().stream())
                .filter(roomDTO -> roomDTO.getId() == roomId)
                .findFirst()
                .orElse(null);
    }
}
