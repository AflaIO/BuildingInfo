package pl.put.poznan.BuildingInfo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import pl.put.poznan.BuildingInfo.DTO.requestBody.BuildingDTO;
import pl.put.poznan.BuildingInfo.DTO.requestBody.LevelDTO;
import pl.put.poznan.BuildingInfo.DTO.requestBody.RoomDTO;
import pl.put.poznan.BuildingInfo.DTO.response.*;

import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(RoomController.class)
class MockedRoomControllerTest {
    @Configuration
    static class TestConfig {}
    List<BuildingDTO> buildingDTOList = List.of(new BuildingDTO(
            4,
            "building-name",
            List.of(new LevelDTO(
                    4,
                    "level-name",
                    List.of(new RoomDTO(
                            4,
                            "name",
                            25.0,
                            10.0,
                            20.0F,
                            12
                    ))
            ))
    ));
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RoomController roomController;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void testGetArea() throws Exception {
        AreaResponseDTO areaResponseDTO = new AreaResponseDTO(
                4,
                "room-name",
                20.0
        );

        ResponseEntity<?> mockedResponseEntity = ResponseEntity.ok(areaResponseDTO);
        doReturn(mockedResponseEntity).when(roomController).getArea(any(Integer.class), any(List.class));

        mockMvc.perform(get("/api/rooms/area")
                        .param("roomId", "4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildingDTOList)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(areaResponseDTO.getId()))
                .andExpect(jsonPath("$.area").value(areaResponseDTO.getArea()));


    }
    @Test
    void testGetCube() throws Exception {
        CubeResponseDTO response = new CubeResponseDTO(
                4,
                "room-name",
                20.0
        );

        ResponseEntity<?> mockedResponseEntity = ResponseEntity.ok(response);
        doReturn(mockedResponseEntity).when(roomController).getCube(any(Integer.class), any(List.class));

        mockMvc.perform(get("/api/rooms/cube")
                        .param("roomId", "4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildingDTOList)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(response.getId()))
                .andExpect(jsonPath("$.cube").value(response.getCube()));


    }
    @Test
    void testGetAveragePower() throws Exception {
        AverageLightPowerResponseDTO response = new AverageLightPowerResponseDTO(
                4,
                "room-name",
                20.0
        );

        ResponseEntity<?> mockedResponseEntity = ResponseEntity.ok(response);
        doReturn(mockedResponseEntity).when(roomController).getAveragePower(any(Integer.class), any(List.class));

        mockMvc.perform(get("/api/rooms/light-power")
                        .param("roomId", "4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildingDTOList)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(response.getId()))
                .andExpect(jsonPath("$.averageLightPowerForRoom").value(response.getAverageLightPowerForRoom()));

    }
    @Test
    void testGetEnergyConsumption() throws Exception {
        EnergyConsumptionResponseDTO response = new EnergyConsumptionResponseDTO(
                4,
                "room-name",
                20.0
        );

        ResponseEntity<?> mockedResponseEntity = ResponseEntity.ok(response);
        doReturn(mockedResponseEntity).when(roomController).getEnergyConsumption(any(Integer.class), any(List.class));

        mockMvc.perform(get("/api/rooms/energy-consumption")
                        .param("roomId", "4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildingDTOList)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(response.getId()))
                .andExpect(jsonPath("$.energyConsumption").value(response.getEnergyConsumption()));

    }
    @Test
    void testGetEnergyCostYearly() throws Exception {
        EnergyCostResponseDTO response = new EnergyCostResponseDTO(
                4,
                "room-name",
                20.0
        );

        ResponseEntity<?> mockedResponseEntity = ResponseEntity.ok(response);
        doReturn(mockedResponseEntity).when(roomController).getEnergyCostYearly(any(Integer.class), any(Double.class), any(List.class));

        mockMvc.perform(get("/api/rooms/energy-cost/yearly")
                        .param("roomId", "4")
                        .param("energyCost", "25.0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildingDTOList)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(response.getId()))
                .andExpect(jsonPath("$.energyCost").value(response.getEnergyCost()));

    }
    @Test
    void testGetEnergyCostWeekly() throws Exception {
        EnergyCostResponseDTO response = new EnergyCostResponseDTO(
                4,
                "room-name",
                30.0
        );

        ResponseEntity<?> mockedResponseEntity = ResponseEntity.ok(response);
        doReturn(mockedResponseEntity).when(roomController).getEnergyCostWeekly(any(Integer.class), any(Double.class), any(List.class));

        mockMvc.perform(get("/api/rooms/energy-cost/weekly")
                        .param("roomId", "4")
                        .param("energyCost", "25.0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildingDTOList)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(response.getId()))
                .andExpect(jsonPath("$.energyCost").value(response.getEnergyCost()));

    }
    @Test
    void testGetEnergyCostDaily() throws Exception {
        EnergyCostResponseDTO response = new EnergyCostResponseDTO(
                4,
                "room-name",
                30.0
        );

        ResponseEntity<?> mockedResponseEntity = ResponseEntity.ok(response);
        doReturn(mockedResponseEntity).when(roomController).getEnergyCostDaily(any(Integer.class), any(Double.class), any(List.class));

        mockMvc.perform(get("/api/rooms/energy-cost/daily")
                        .param("roomId", "4")
                        .param("energyCost", "25.0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildingDTOList)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(response.getId()))
                .andExpect(jsonPath("$.energyCost").value(response.getEnergyCost()));

    }
    @Test
    void testGetRentProfitYearly() throws Exception {
        RentProfitResponseDTO response = new RentProfitResponseDTO(
                4,
                "room-name",
                30.0
        );

        ResponseEntity<?> mockedResponseEntity = ResponseEntity.ok(response);
        doReturn(mockedResponseEntity).when(roomController).getRentProfitYearly(any(Integer.class), any(Double.class), any(List.class));

        mockMvc.perform(get("/api/rooms/rent-profit/yearly")
                        .param("roomId", "4")
                        .param("areaCost", "25.0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildingDTOList)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(response.getId()))
                .andExpect(jsonPath("$.rentProfit").value(response.getRentProfit()));

    }
    @Test
    void testGetRentProfitWeekly() throws Exception {
        RentProfitResponseDTO response = new RentProfitResponseDTO(
                4,
                "room-name",
                30.0
        );

        ResponseEntity<?> mockedResponseEntity = ResponseEntity.ok(response);
        doReturn(mockedResponseEntity).when(roomController).getRentProfitWeekly(any(Integer.class), any(Double.class), any(List.class));

        mockMvc.perform(get("/api/rooms/rent-profit/weekly")
                        .param("roomId", "4")
                        .param("areaCost", "25.0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildingDTOList)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(response.getId()))
                .andExpect(jsonPath("$.rentProfit").value(response.getRentProfit()));

    }
    @Test
    void testGetRentProfitDaily() throws Exception {
        RentProfitResponseDTO response = new RentProfitResponseDTO(
                4,
                "room-name",
                30.0
        );

        ResponseEntity<?> mockedResponseEntity = ResponseEntity.ok(response);
        doReturn(mockedResponseEntity).when(roomController).getRentProfitDaily(any(Integer.class), any(Double.class), any(List.class));

        mockMvc.perform(get("/api/rooms/rent-profit/daily")
                        .param("roomId", "4")
                        .param("areaCost", "25.0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildingDTOList)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(response.getId()))
                .andExpect(jsonPath("$.rentProfit").value(response.getRentProfit()));

    }
}