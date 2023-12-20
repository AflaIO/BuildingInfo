package pl.put.poznan.BuildingInfo.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private Room testRoom;

    @BeforeEach
    void setUp() {
        // Inicjalizacja testowej instancji pokoju przed każdym testem
        testRoom = new Room(1, "Test Room", 25.0, 50.0, 20.0f, 80);
    }

    @Test
    void calculateLightPowerTest() {
        double expectedLightPower = 80.0 / 50.0;
        assertEquals(expectedLightPower, testRoom.calculateLightPower());
    }

    @Test
    void calculateEnergyConsumptionTest() {
        double expectedEnergyConsumption = 20.0 / 50.0;
        assertEquals(expectedEnergyConsumption, testRoom.calculateEnergyConsumption());
    }

    @Test
    void calculateEnergyCostMonthlyTest() {
        double energyCost = 0.1; // Przykładowy koszt energii
        double expectedEnergyConsumption = 20.0 / 50.0;
        double expectedMonthlyCost = expectedEnergyConsumption * energyCost;
        assertEquals(expectedMonthlyCost, testRoom.calculateEnergyCostMonthly(energyCost));
    }

    @Test
    void calculateEnergyCostWeeklyTest() {
        double energyCost = 0.1; // Przykładowy koszt energii
        double expectedEnergyConsumption = 20.0 / 50.0;
        double expectedWeeklyCost = expectedEnergyConsumption * energyCost / 4;
        assertEquals(expectedWeeklyCost, testRoom.calculateEnergyCostWeekly(energyCost));
    }

    @Test
    void calculateEnergyCostDailyTest() {
        double energyCost = 0.1; // Przykładowy koszt energii
        double expectedEnergyConsumption = 20.0 / 50.0;
        double expectedDailyCost = expectedEnergyConsumption * energyCost / 31;
        assertEquals(expectedDailyCost, testRoom.calculateEnergyCostDaily(energyCost));
    }

    @Test
    void calculateRentProfitYearlyTest() {
        double areaCost = 10.0; // Przykładowy koszt za metr kwadratowy
        double expectedYearlyProfit = 25.0 * areaCost * 12;
        assertEquals(expectedYearlyProfit, testRoom.calculateRentProfitYearly(areaCost));
    }

    @Test
    void calculateRentProfitMonthlyTest() {
        double areaCost = 10.0; // Przykładowy koszt za metr kwadratowy
        double expectedMonthlyProfit = 25.0 * areaCost;
        assertEquals(expectedMonthlyProfit, testRoom.calculateRentProfitMonthly(areaCost));
    }

    @Test
    void calculateRentProfitDailyTest() {
        double areaCost = 10.0; // Przykładowy koszt za metr kwadratowy
        double expectedDailyProfit = 25.0 * areaCost / 31;
        assertEquals(expectedDailyProfit, testRoom.calculateRentProfitDaily(areaCost));
    }
}