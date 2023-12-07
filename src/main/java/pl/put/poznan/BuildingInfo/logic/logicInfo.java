/**
 * The "logic" package contains classes that model and manage information related to buildings,
 * levels, and rooms. It provides a logical representation of a building structure and
 * includes functionality for calculating various metrics such as total area, total cube,
 * light power, and total energy consumption.
 *
 * The package includes the following classes:
 * - {@link pl.put.poznan.BuildingInfo.logic.Location}: An abstract class representing a location
 *   with common properties and methods for adding, removing, and displaying locations.
 * - {@link pl.put.poznan.BuildingInfo.logic.Level}: A class representing a level within a building
 *   and containing a list of rooms on that level. It extends the Location class.
 * - {@link pl.put.poznan.BuildingInfo.logic.Building}: A class representing a building, consisting
 *   of multiple levels. It extends the Location class.
 * - {@link pl.put.poznan.BuildingInfo.logic.Room}: A class representing a room within a building
 *   with properties such as area, cube, heating, and light intensity. It extends the Location class.
 *
 * The package follows a hierarchical structure, with Building containing Levels,
 * and Levels containing Rooms. Each class provides specific functionality related to its type.
 *
 * @author Jakub Binkowski
 * @version 1.0
 */
package pl.put.poznan.BuildingInfo.logic;
