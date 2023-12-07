package pl.put.poznan.BuildingInfo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.BuildingInfo.DTO.requestBody.LevelDTO;
import pl.put.poznan.BuildingInfo.DTO.response.AverageLightPowerResponseDTO;
import pl.put.poznan.BuildingInfo.logic.Level;
import pl.put.poznan.BuildingInfo.logic.Room;


@RestController
@RequestMapping("/api/levels")
public class LevelController {

    @GetMapping("/light-power")
    public ResponseEntity<AverageLightPowerResponseDTO> getAveragePower(@RequestBody LevelDTO levelDTO) {

        Level level = new Level(
                levelDTO.getId(),
                levelDTO.getName()
        );

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
    }
}
