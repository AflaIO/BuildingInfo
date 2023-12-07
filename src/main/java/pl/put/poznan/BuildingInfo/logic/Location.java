package pl.put.poznan.BuildingInfo.logic;

/**
 * The abstract base class representing a location in a building.
 *
 * This class provides a common interface for specific locations within a building.
 * Subclasses should implement the methods to manage and display specific types of locations.
 *
 * @author Paulina Guzior, Jakub Binkowski, Benedykt Huszcza, Jan Wybieralski
 * @version 1.0
 */
public abstract class Location {
    /**
     * The unique identifier of the location.
     */
    protected int id;

    /**
     * The name of the location.
     */
    protected String name;

    /**
     * Constructor for a new Location with the specified identifier and name.
     *
     * @param id   The unique identifier of the location.
     * @param name The name of the location.
     */
    public Location(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Adds a sub-location to the current location.
     *
     * Subclasses should implement this method to define the specific behavior of adding a sub-location.
     *
     * @param location The sub-location to be added.
     */
    public abstract void add(Location location);

    /**
     * Removes a sub-location from the current location.
     *
     * Subclasses should implement this method to define the specific behavior of removing a sub-location.
     *
     * @param location The sub-location to be removed.
     */
    public abstract void remove(Location location);

    /**
     * Displays information about the location.
     *
     * Subclasses should implement this method to define the specific way of displaying information about the location.
     */
    public abstract void display();
}

