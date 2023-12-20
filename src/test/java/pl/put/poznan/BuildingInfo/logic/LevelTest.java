package pl.put.poznan.BuildingInfo.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LevelTest {

    private Level testLevel;

    @BeforeEach
    void setUp() {
        // Inicjalizacja testowej instancji poziomu przed każdym testem
        testLevel = new Level(1, "Test Level");
        testLevel.add(new Room(1, "Room 1", 25.0, 50.0, 20.0f, 80));
        testLevel.add(new Room(2, "Room 2", 30.0, 60.0, 25.0f, 100));
    }

    @Test
    void calculateTotalAreaTest() {
        double expectedTotalArea = 25.0 + 30.0;
        assertEquals(expectedTotalArea, testLevel.calculateTotalArea());
    }

    @Test
    void calculateTotalCubeTest() {
        double expectedTotalCube = 50.0 + 60.0;
        assertEquals(expectedTotalCube, testLevel.calculateTotalCube());
    }

    @Test
    void calculateLightPowerTest() {
        double expectedTotalLightPower = (80.0 / 50.0) + (100.0 / 60.0);
        assertEquals(expectedTotalLightPower, testLevel.calculateLightPower());
    }

    @Test
    void calculateTotalEnergyConsumptionTest() {
        double expectedTotalEnergyConsumption = (20.0 / 50.0) + (25.0 / 60.0);
        assertEquals(expectedTotalEnergyConsumption, testLevel.calculateTotalEnergyConsumption());
    }

    @Test
    void calculateEnergyCostWeeklyTest() {
        double energyCost = 0.1; // Przykładowy koszt energii
        double expectedTotalEnergyConsumption = (20.0 / 50.0) + (25.0 / 60.0);
        double expectedYearlyCost = expectedTotalEnergyConsumption * energyCost / 4;
        assertEquals(expectedYearlyCost, testLevel.calculateEnergyCostWeekly(energyCost));
    }

    @Test
    void calculateRentProfitWeeklyTest() {
        double areaCost = 10.0; // Przykładowy koszt za metr kwadratowy
        double expectedTotalArea = 25.0 + 30.0;
        double expectedYearlyProfit = expectedTotalArea * areaCost / 4;
        assertEquals(expectedYearlyProfit, testLevel.calculateRentProfitWeekly(areaCost));
    }
}
