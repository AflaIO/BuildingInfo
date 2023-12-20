package pl.put.poznan.BuildingInfo.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a level in a building, containing rooms.
 *
 * This class extends the abstract class Location and provides specific functionality
 * for managing rooms on a particular level in a building.
 *
 * @author Paulina Guzior, Jakub Binkowski, Benedykt Huszcza, Jan Wybieralski
 * @version 1.0
 */
public class Level extends Location {

    /**
     * List of rooms on the level.
     */
    private List<Room> rooms;

    /**
     * Constructs a new Level with the specified identifier and name.
     *
     * @param id   The unique identifier of the level.
     * @param name The name of the level.
     */
    public Level(int id, String name) {
        super(id, name);
        this.rooms = new ArrayList<>();
    }

    /**
     * Adds a room to the level.
     *
     * Only instances of Room can be added to the level.
     *
     * @param location The room to be added to the level.
     * @throws IllegalArgumentException If the provided location is not an instance of Room.
     */
    @Override
    public void add(Location location) {
        if (location instanceof Room) {
            rooms.add((Room) location);
        } else {
            throw new IllegalArgumentException("Only instances of Room can be added to Level.");
        }
    }

    /**
     * Removes a room from the level.
     *
     * @param location The room to be removed from the level.
     */
    @Override
    public void remove(Location location) {
        rooms.remove(location);
    }

    /**
     * Displays information about the level and its rooms.
     */
    @Override
    public void display() {
        System.out.println("Level: " + name);
        for (Room room : rooms) {
            room.display();
        }
    }

    /**
     * Calculates the total area of all rooms on the level.
     *
     * @return The total area of all rooms on the level.
     */
    public double calculateTotalArea() {
        double totalArea = 0.0;
        for (Room room : rooms) {
            totalArea += room.getArea();
        }
        return totalArea;
    }

    /**
     * Calculates the total volume (cube) of all rooms on the level.
     *
     * @return The total volume (cube) of all rooms on the level.
     */
    public double calculateTotalCube() {
        double totalCube = 0.0;
        for (Room room : rooms) {
            totalCube += room.getCube();
        }
        return totalCube;
    }


    /**
     * Calculates the total light power of all rooms on the level.
     *
     * @return The total light power of all rooms on the level.
     */
    public double calculateLightPower() {
        double lightPower = 0.0;
        for (Room room : rooms) {
            lightPower += room.calculateLightPower();
        }
        return lightPower;
    }

    /**
     * Calculates the total energy consumption of all rooms on the level.
     *
     * @return The total energy consumption of all rooms on the level.
     */
    public double calculateTotalEnergyConsumption() {
        double totalEnergyConsumption = 0.0;
        for (Room room : rooms) {
            totalEnergyConsumption += room.calculateEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public double calculateEnergyCostYearly(double energyCost) { return this.calculateTotalEnergyConsumption() * energyCost * 12; }

    public double calculateEnergyCostMonthly(double energyCost) { return this.calculateTotalEnergyConsumption() * energyCost; }

    public double calculateEnergyCostWeekly(double energyCost) { return this.calculateTotalEnergyConsumption() * energyCost / 4; }

    public double calculateEnergyCostDaily(double energyCost) { return this.calculateTotalEnergyConsumption() * energyCost / 31; }

    public double calculateRentProfitYearly(double areaCost) { return this.calculateTotalArea() * areaCost * 12; }

    public double calculateRentProfitMonthly(double areaCost) { return this.calculateTotalArea() * areaCost; }
    public double calculateRentProfitWeekly(double areaCost) { return this.calculateTotalArea() * areaCost / 4; }
    public double calculateRentProfitDaily(double areaCost) { return this.calculateTotalArea() * areaCost / 31; }

    /**
     * Gets the unique identifier of the level.
     *
     * @return The unique identifier of the level.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the name of the level.
     *
     * @return The name of the level.
     */
    public String getName() {
        return this.name;
    }
}
