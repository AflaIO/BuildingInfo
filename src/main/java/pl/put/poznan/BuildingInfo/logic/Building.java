package pl.put.poznan.BuildingInfo.logic;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents a building, consisting of multiple levels.
 *
 * This class extends the abstract class Location and provides specific functionality
 * for managing levels within a building.
 *
 * @author Paulina Guzior, Jakub Binkowski, Benedykt Huszcza, Jan Wybieralski
 * @version 1.0
 */
public class Building extends Location {

    /**
     * List of levels in the building.
     */
    private List<Level> levels;

    /**
     * Constructs a new Building with the specified identifier and name.
     *
     * @param id   The unique identifier of the building.
     * @param name The name of the building.
     */
    public Building(int id, String name) {
        super(id, name);
        this.levels = new ArrayList<>();
    }

    /**
     * Adds a level to the building.
     *
     * Only instances of Level can be added to the building.
     *
     * @param location The level to be added to the building.
     * @throws IllegalArgumentException If the provided location is not an instance of Level.
     */
    @Override
    public void add(Location location) {
        if (location instanceof Level) {
            levels.add((Level) location);
        } else {
            throw new IllegalArgumentException("Only instances of Level can be added to Building.");
        }
    }

    /**
     * Removes a level from the building.
     *
     * @param location The level to be removed from the building.
     */
    @Override
    public void remove(Location location) {
        levels.remove(location);
    }

    /**
     * Displays information about the building and its levels.
     */
    @Override
    public void display() {
        System.out.println("Building: " + name);
        for (Level level : levels) {
            level.display();
        }
    }

    /**
     * Calculates the total area of all levels in the building.
     *
     * @return The total area of all levels in the building.
     */
    public double calculateTotalArea() {
        double totalArea = 0.0;
        for (Level level : levels) {
            totalArea += level.calculateTotalArea();
        }
        return totalArea;
    }

    /**
     * Calculates the total volume (cube) of all levels in the building.
     *
     * @return The total volume (cube) of all levels in the building.
     */
    public double calculateTotalCube() {
        double totalCube = 0.0;
        for (Level level : levels) {
            totalCube += level.calculateTotalCube();

        }
        return totalCube;
    }

    /**
     * Calculates the total light power of all levels in the building.
     *
     * @return The total light power of all levels in the building.
     */
    public double calculateLightPower() {
        double lightPower = 0.0;
        for (Level level : levels) {
            lightPower += level.calculateLightPower();
        }
        return lightPower;
    }

    /**
     * Calculates the total energy consumption of all levels in the building.
     *
     * @return The total energy consumption of all levels in the building.
     */
    public double calculateTotalEnergyConsumption() {
        double totalEnergyConsumption = 0.0;
        for (Level level : levels) {
            totalEnergyConsumption += level.calculateTotalEnergyConsumption();
        }
        return totalEnergyConsumption;
    }
    /**
     * Calculates the annual energy cost for a building.
     *
     * @return The annual cost of energy for the building.
     */
    public double calculateEnergyCostYearly(double energyCost) { return this.calculateTotalEnergyConsumption() * energyCost * 12; }
    /**
     * Calculates the monthly energy cost for a building.
     *
     * @return The monthly cost of energy for the building.
     */
    public double calculateEnergyCostMonthly(double energyCost) { return this.calculateTotalEnergyConsumption() * energyCost; }
    /**
     * Calculates the weekly energy cost for a building.
     *
     * @return The weekly cost of energy for the building.
     */
    public double calculateEnergyCostWeekly(double energyCost) { return this.calculateTotalEnergyConsumption() * energyCost / 4; }
    /**
     * Calculates the daily energy cost for a building.
     *
     * @return The daily cost of energy for the building.
     */
    public double calculateEnergyCostDaily(double energyCost) { return this.calculateTotalEnergyConsumption() * energyCost / 31; }
    /**
     * Calculates the annual profit from the rent for a building.
     *
     * @return the annual profit from the rent for a building
     */
    public double calculateRentProfitYearly(double areaCost) { return this.calculateTotalArea() * areaCost * 12; }
    /**
     * Calculates the monthly profit from the rent for a building.
     *
     * @return the monthly profit from the rent for a building
     */
    public double calculateRentProfitMonthly(double areaCost) { return this.calculateTotalArea() * areaCost; }
    /**
     * Calculates the weekly profit from the rent for a building.
     *
     * @return the weekly profit from the rent for a building
     */
    public double calculateRentProfitWeekly(double areaCost) { return this.calculateTotalArea() * areaCost / 4; }
    /**
     * Calculates the daily profit from the rent for a building.
     *
     * @return the daily profit from the rent for a building
     */
    public double calculateRentProfitDaily(double areaCost) { return this.calculateTotalArea() * areaCost / 31; }

    /**
     * Gets the unique identifier of the building.
     *
     * @return The unique identifier of the building.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the name of the building.
     *
     * @return The name of the building.
     */
    public String getName() {
        return this.name;
    }
}
