package pl.put.poznan.BuildingInfo.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains JUnit tests for the {@link Level} class in the
 * {@link pl.put.poznan.BuildingInfo.logic} package. It tests various methods
 * related to level calculations such as total area, total cube, light power,
 * total energy consumption, energy cost, and rent profit.
 *
 * @author Paulina Guzior, Benedykt Huszcza, Jakub Binkowski, Jan Wybieralski
 * @version 1.0
 * @see Level
 * @see Room
 */
class LevelTest {

    /**
     * The instance of the {@link Level} class used for testing.
     */
    private Level testLevel;

    /**
     * Sets up the test environment by creating a test level with rooms.
     */
    @BeforeEach
    void setUp() {
        testLevel = new Level(1, "Test Level");
        testLevel.add(new Room(1, "Room 1", 25.0, 50.0, 20.0f, 80));
        testLevel.add(new Room(2, "Room 2", 30.0, 60.0, 25.0f, 100));
    }

    /**
     * Tests the calculation of the total area of the level.
     */
    @Test
    void calculateTotalAreaTest() {
        double expectedTotalArea = 25.0 + 30.0;
        assertEquals(expectedTotalArea, testLevel.calculateTotalArea());
    }

    /**
     * Tests the calculation of the total cube of the level.
     */
    @Test
    void calculateTotalCubeTest() {
        double expectedTotalCube = 50.0 + 60.0;
        assertEquals(expectedTotalCube, testLevel.calculateTotalCube());
    }

    /**
     * Tests the calculation of the total light power of the level.
     */
    @Test
    void calculateLightPowerTest() {
        double expectedTotalLightPower = (80.0 / 50.0) + (100.0 / 60.0);
        assertEquals(expectedTotalLightPower, testLevel.calculateLightPower());
    }

    /**
     * Tests the calculation of the total energy consumption of the level.
     */
    @Test
    void calculateTotalEnergyConsumptionTest() {
        double expectedTotalEnergyConsumption = (20.0 / 50.0) + (25.0 / 60.0);
        assertEquals(expectedTotalEnergyConsumption, testLevel.calculateTotalEnergyConsumption());
    }

    /**
     * Tests the calculation of the weekly energy cost for the level.
     */
    @Test
    void calculateEnergyCostWeeklyTest() {
        double energyCost = 0.1;
        double expectedTotalEnergyConsumption = (20.0 / 50.0) + (25.0 / 60.0);
        double expectedWeeklyCost = expectedTotalEnergyConsumption * energyCost / 4;
        assertEquals(expectedWeeklyCost, testLevel.calculateEnergyCostWeekly(energyCost));
    }

    /**
     * Tests the calculation of the weekly rent profit for the level.
     */
    @Test
    void calculateRentProfitWeeklyTest() {
        double areaCost = 10.0;
        double expectedTotalArea = 25.0 + 30.0;
        double expectedWeeklyProfit = expectedTotalArea * areaCost / 4;
        assertEquals(expectedWeeklyProfit, testLevel.calculateRentProfitWeekly(areaCost));
    }
}
