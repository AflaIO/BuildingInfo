package pl.put.poznan.BuildingInfo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.BuildingInfo.DTO.requestBody.RoomDTO;
import pl.put.poznan.BuildingInfo.DTO.response.AverageLightPowerResponseDTO;
import pl.put.poznan.BuildingInfo.logic.Room;


@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @GetMapping("/light-power")
    public ResponseEntity<AverageLightPowerResponseDTO> getAveragePower(@RequestBody RoomDTO roomDTO) {
        Room room = new Room(
                roomDTO.getId(),
                roomDTO.getName(),
                roomDTO.getArea(),
                roomDTO.getCube(),
                roomDTO.getHeating(),
                roomDTO.getLight()
        );
        return  ResponseEntity.ok(
                new AverageLightPowerResponseDTO(
                        room.getId(),
                        room.getName(),
                        room.calculateLightPower()
                ));
    }
}
