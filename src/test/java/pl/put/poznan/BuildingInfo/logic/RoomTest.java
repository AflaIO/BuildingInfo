package pl.put.poznan.BuildingInfo.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains JUnit tests for the {@link Room} class in the
 * {@link pl.put.poznan.BuildingInfo.logic} package. It tests various methods
 * related to room calculations such as light power, energy consumption, energy cost,
 * and rent profit at different time intervals.
 *
 * @author Paulina Guzior, Benedykt Huszcza, Jakub Binkowski, Jan Wybieralski
 * @version 1.0
 * @see Room
 */
class RoomTest {

    /**
     * The instance of the {@link Room} class used for testing.
     */
    private Room testRoom;

    /**
     * Sets up the test environment by creating a test room.
     */
    @BeforeEach
    void setUp() {
        testRoom = new Room(1, "Test Room", 25.0, 50.0, 20.0f, 80);
    }

    /**
     * Tests the calculation of light power for the room.
     */
    @Test
    void calculateLightPowerTest() {
        double expectedLightPower = 80.0 / 50.0;
        assertEquals(expectedLightPower, testRoom.calculateLightPower());
    }

    /**
     * Tests the calculation of energy consumption for the room.
     */
    @Test
    void calculateEnergyConsumptionTest() {
        double expectedEnergyConsumption = 20.0 / 50.0;
        assertEquals(expectedEnergyConsumption, testRoom.calculateEnergyConsumption());
    }

    /**
     * Tests the calculation of monthly energy cost for the room.
     */
    @Test
    void calculateEnergyCostMonthlyTest() {
        double energyCost = 0.1;
        double expectedEnergyConsumption = 20.0 / 50.0;
        double expectedMonthlyCost = expectedEnergyConsumption * energyCost;
        assertEquals(expectedMonthlyCost, testRoom.calculateEnergyCostMonthly(energyCost));
    }

    /**
     * Tests the calculation of weekly energy cost for the room.
     */
    @Test
    void calculateEnergyCostWeeklyTest() {
        double energyCost = 0.1;
        double expectedEnergyConsumption = 20.0 / 50.0;
        double expectedWeeklyCost = expectedEnergyConsumption * energyCost / 4;
        assertEquals(expectedWeeklyCost, testRoom.calculateEnergyCostWeekly(energyCost));
    }

    /**
     * Tests the calculation of daily energy cost for the room.
     */
    @Test
    void calculateEnergyCostDailyTest() {
        double energyCost = 0.1;
        double expectedEnergyConsumption = 20.0 / 50.0;
        double expectedDailyCost = expectedEnergyConsumption * energyCost / 31;
        assertEquals(expectedDailyCost, testRoom.calculateEnergyCostDaily(energyCost));
    }

    /**
     * Tests the calculation of yearly rent profit for the room.
     */
    @Test
    void calculateRentProfitYearlyTest() {
        double areaCost = 10.0;
        double expectedYearlyProfit = 25.0 * areaCost * 12;
        assertEquals(expectedYearlyProfit, testRoom.calculateRentProfitYearly(areaCost));
    }

    /**
     * Tests the calculation of monthly rent profit for the room.
     */
    @Test
    void calculateRentProfitMonthlyTest() {
        double areaCost = 10.0;
        double expectedMonthlyProfit = 25.0 * areaCost;
        assertEquals(expectedMonthlyProfit, testRoom.calculateRentProfitMonthly(areaCost));
    }

    /**
     * Tests the calculation of daily rent profit for the room.
     */
    @Test
    void calculateRentProfitDailyTest() {
        double areaCost = 10.0;
        double expectedDailyProfit = 25.0 * areaCost / 31;
        assertEquals(expectedDailyProfit, testRoom.calculateRentProfitDaily(areaCost));
    }
}
