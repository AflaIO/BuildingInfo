package pl.put.poznan.BuildingInfo.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {

    private Building testBuilding;

    @BeforeEach
    void setUp() {
        // Inicjalizacja testowej instancji budynku przed każdym testem
        testBuilding = new Building(1, "Test Building");
        Level level1 = new Level(1, "Level 1");
        level1.add(new Room(1, "Room 1", 25.0, 50.0, 20.0f, 80));
        level1.add(new Room(2, "Room 2", 30.0, 60.0, 25.0f, 100));

        Level level2 = new Level(2, "Level 2");
        level2.add(new Room(3, "Room 3", 20.0, 40.0, 15.0f, 70));
        level2.add(new Room(4, "Room 4", 35.0, 70.0, 30.0f, 120));

        testBuilding.add(level1);
        testBuilding.add(level2);
    }

    @Test
    void calculateTotalAreaTest() {
        double expectedTotalArea = (25.0 + 30.0) + (20.0 + 35.0);
        assertEquals(expectedTotalArea, testBuilding.calculateTotalArea());
    }

    @Test
    void calculateTotalCubeTest() {
        double expectedTotalCube = (50.0 + 60.0) + (40.0 + 70.0);
        assertEquals(expectedTotalCube, testBuilding.calculateTotalCube());
    }

    @Test
    void calculateLightPowerTest() {
        double expectedTotalLightPower = (80.0 / 50.0) + (100.0 / 60.0) + (70.0 / 40.0) + (120.0 / 70.0);
        assertEquals(expectedTotalLightPower, testBuilding.calculateLightPower());
    }

    @Test
    void calculateTotalEnergyConsumptionTest() {
        double expectedTotalEnergyConsumption = (20.0 / 50.0) + (25.0 / 60.0) + (15.0 / 40.0) + (30.0 / 70.0);
        assertEquals(expectedTotalEnergyConsumption, testBuilding.calculateTotalEnergyConsumption());
    }

    @Test
    void calculateEnergyCostYearlyTest() {
        double energyCost = 0.1; // Przykładowy koszt energii
        double expectedTotalEnergyConsumption = (20.0 / 50.0) + (25.0 / 60.0) + (15.0 / 40.0) + (30.0 / 70.0);
        double expectedYearlyCost = expectedTotalEnergyConsumption * energyCost * 12;
        assertEquals(expectedYearlyCost, testBuilding.calculateEnergyCostYearly(energyCost));
    }

    @Test
    void calculateRentProfitYearlyTest() {
        double areaCost = 10.0; // Przykładowy koszt za metr kwadratowy
        double expectedTotalArea = (25.0 + 30.0) + (20.0 + 35.0);
        double expectedYearlyProfit = expectedTotalArea * areaCost * 12;
        assertEquals(expectedYearlyProfit, testBuilding.calculateRentProfitYearly(areaCost));
    }

}
