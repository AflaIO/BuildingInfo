package pl.put.poznan.BuildingInfo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.BuildingInfo.DTO.requestBody.BuildingDTO;
import pl.put.poznan.BuildingInfo.DTO.requestBody.RoomDTO;
import pl.put.poznan.BuildingInfo.DTO.response.AreaResponseDTO;
import pl.put.poznan.BuildingInfo.DTO.response.AverageLightPowerResponseDTO;
import pl.put.poznan.BuildingInfo.DTO.response.CubeResponseDTO;
import pl.put.poznan.BuildingInfo.DTO.response.EnergyConsumptionResponseDTO;
import pl.put.poznan.BuildingInfo.logic.Building;
import pl.put.poznan.BuildingInfo.logic.Level;
import pl.put.poznan.BuildingInfo.logic.Room;

import java.util.List;


@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @GetMapping("/area")
    public ResponseEntity<?> getArea(@RequestParam int roomId, @RequestBody List<BuildingDTO> buildingDTOs) {
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }
    @GetMapping("/cube")
    public ResponseEntity<?> getCube(@RequestParam int roomId, @RequestBody List<BuildingDTO> buildingDTOs) {
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }
    @GetMapping("/light-power")
    public ResponseEntity<?> getAveragePower(@RequestParam int roomId, @RequestBody List<BuildingDTO> buildingDTOs) {
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with ID: "+roomId+" not found");
        }
    }

    @GetMapping("/energy-consumption")
    public ResponseEntity<?> getEnergyConsumption(@RequestParam int roomId, @RequestBody List<BuildingDTO> buildingDTOs) {
        RoomDTO roomDTO = findRoomById(buildingDTOs, roomId);

        if (roomDTO != null) {
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
