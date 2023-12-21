package pl.put.poznan.BuildingInfo.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a room within a building.
 *
 * This class extends the abstract class Location and provides specific functionality
 * for managing properties and calculations related to a room.
 *
 * @author Paulina Guzior, Jakub Binkowski, Benedykt Huszcza, Jan Wybieralski
 * @version 1.0
 */
public class Room extends Location {

    /**
     * The area of the room in square meters.
     */
    private double area;

    /**
     * The volume (cube) of the room in cubic meters.
     */
    private double cube;

    /**
     * The heating level of the room.
     */
    private float heating;

    /**
     * The light intensity of the room.
     */
    private int light;

    /**
     * Constructs a new Room with the specified identifier, name, area, cube, heating, and light.
     *
     * @param id      The unique identifier of the room.
     * @param name    The name of the room.
     * @param area    The area of the room in square meters.
     * @param cube    The volume (cube) of the room in cubic meters.
     * @param heating The heating level of the room.
     * @param light   The light intensity of the room.
     */
    public Room(int id, String name, double area, double cube, float heating, int light) {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    /**
     * Unsupported operation: Cannot add a location to a room.
     *
     * @param location The location to be added.
     * @throws UnsupportedOperationException Always thrown, as adding a location to a room is not supported.
     */
    @Override
    public void add(Location location) {
        throw new UnsupportedOperationException("Cannot add location to Room");
    }

    /**
     * Unsupported operation: Cannot remove a location from a room.
     *
     * @param location The location to be removed.
     * @throws UnsupportedOperationException Always thrown, as removing a location from a room is not supported.
     */
    @Override
    public void remove(Location location) {
        throw new UnsupportedOperationException("Cannot remove location from Room");
    }

    /**
     * Displays information about the room, including its name, area, cube, heating, and light.
     */
    @Override
    public void display() {
        System.out.println("Room: " + name + ", Area: " + area + "m^2, Cube: " + cube + "m^3, Heating: " + heating + ", Light: " + light);
    }

    /**
     * Calculates the light power of the room.
     *
     * @return The light power of the room.
     */
    public double calculateLightPower() {
        return (double) this.light / this.cube;
    }

    /**
     * Calculates the energy consumption of the room.
     *
     * @return The energy consumption of the room.
     */
    public double calculateEnergyConsumption() {
        return (double) this.heating / this.cube;
    }



    /**
     * Calculates the annual energy cost for a room.
     *
     * @return The annual cost of energy for the room.
     */
    public double calculateEnergyCostYearly(double energyCost) { return this.calculateEnergyConsumption() * energyCost * 12; }
    /**
     * Calculates the monthly energy cost for a room.
     *
     * @return The monthly cost of energy for the room.
     */
    public double calculateEnergyCostMonthly(double energyCost) { return this.calculateEnergyConsumption() * energyCost; }
    /**
     * Calculates the weekly energy cost for a room.
     *
     * @return The weekly cost of energy for the room.
     */
    public double calculateEnergyCostWeekly(double energyCost) { return this.calculateEnergyConsumption() * energyCost / 4; }
    /**
     * Calculates the daily energy cost for a room.
     *
     * @return The daily cost of energy for the room.
     */
    public double calculateEnergyCostDaily(double energyCost) { return this.calculateEnergyConsumption() * energyCost / 31; }

    /**
     * Calculates the annual profit from the rent for a room.
     *
     * @return the annual profit from the rent for a room
     */
    public double calculateRentProfitYearly(double areaCost) { return this.getArea() * areaCost * 12; }
    /**
     * Calculates the monthly profit from the rent for a room.
     *
     * @return the monthly profit from the rent for a room
     */
    public double calculateRentProfitMonthly(double areaCost) { return this.getArea() * areaCost; }
    /**
     * Calculates the weekly profit from the rent for a room.
     *
     * @return the weekly profit from the rent for a room
     */
    public double calculateRentProfitWeekly(double areaCost) { return this.getArea() * areaCost / 4; }
    /**
     * Calculates the daily profit from the rent for a room.
     *
     * @return the daily profit from the rent for a room
     */
    public double calculateRentProfitDaily(double areaCost) { return this.getArea() * areaCost / 31; }

    /**
     * Gets the area of the room.
     *
     * @return The area of the room in square meters.
     */
    public double getArea() {
        return area;
    }

    /**
     * Gets the volume (cube) of the room.
     *
     * @return The volume (cube) of the room in cubic meters.
     */
    public double getCube() {
        return cube;
    }

    /**
     * Gets the name of the room.
     *
     * @return The name of the room.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the unique identifier of the room.
     *
     * @return The unique identifier of the room.
     */
    public int getId() {
        return this.id;
    }
}
