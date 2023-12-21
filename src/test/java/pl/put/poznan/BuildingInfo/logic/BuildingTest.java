package pl.put.poznan.BuildingInfo.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains JUnit tests for the {@link Building} class in the
 * {@link pl.put.poznan.BuildingInfo.logic} package. It tests various methods
 * related to building calculations such as total area, total cube, light power,
 * total energy consumption, energy cost, and rent profit.
 *
 * @author Paulina Guzior, Jan Wybieralski, Benedykt Huszcza, Jakub Binkowski
 * @version 1.0
 * @see Building
 * @see Level
 * @see Room
 */
public class BuildingTest {

    /**
     * The instance of the {@link Building} class used for testing.
     */
    private Building testBuilding;

    /**
     * Sets up the test environment by creating a test building with levels and rooms.
     */
    @BeforeEach
    public void setUp() {
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

    /**
     * Tests the calculation of the total area of the building.
     */
    @Test
    public void calculateTotalAreaTest() {
        double expectedTotalArea = (25.0 + 30.0) + (20.0 + 35.0);
        assertEquals(expectedTotalArea, testBuilding.calculateTotalArea());
    }

    /**
     * Tests the calculation of the total cube of the building.
     */
    @Test
    public void calculateTotalCubeTest() {
        double expectedTotalCube = (50.0 + 60.0) + (40.0 + 70.0);
        assertEquals(expectedTotalCube, testBuilding.calculateTotalCube());
    }

    /**
     * Tests the calculation of the total light power of the building.
     */
    @Test
    public void calculateLightPowerTest() {
        double expectedTotalLightPower = (80.0 / 50.0) + (100.0 / 60.0) + (70.0 / 40.0) + (120.0 / 70.0);
        assertEquals(expectedTotalLightPower, testBuilding.calculateLightPower());
    }

    /**
     * Tests the calculation of the total energy consumption of the building.
     */
    @Test
    public void calculateTotalEnergyConsumptionTest() {
        double expectedTotalEnergyConsumption = (20.0 / 50.0) + (25.0 / 60.0) + (15.0 / 40.0) + (30.0 / 70.0);
        assertEquals(expectedTotalEnergyConsumption, testBuilding.calculateTotalEnergyConsumption());
    }

    /**
     * Tests the calculation of the yearly energy cost for the building.
     */
    @Test
    public void calculateEnergyCostYearlyTest() {
        double energyCost = 0.1;
        double expectedTotalEnergyConsumption = (20.0 / 50.0) + (25.0 / 60.0) + (15.0 / 40.0) + (30.0 / 70.0);
        double expectedYearlyCost = expectedTotalEnergyConsumption * energyCost * 12;
        assertEquals(expectedYearlyCost, testBuilding.calculateEnergyCostYearly(energyCost));
    }

    /**
     * Tests the calculation of the yearly rent profit for the building.
     */
    @Test
    public void calculateRentProfitYearlyTest() {
        double areaCost = 10.0;
        double expectedTotalArea = (25.0 + 30.0) + (20.0 + 35.0);
        double expectedYearlyProfit = expectedTotalArea * areaCost * 12;
        assertEquals(expectedYearlyProfit, testBuilding.calculateRentProfitYearly(areaCost));
    }
}
