/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
    private Room southEastExit;
    private Room northWestExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     * @param southEast The south-east exit.
     * @param northWest The north-west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west, Room southEast, Room northWest) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
        if(southEast != null)
            southEastExit = southEast;
        if(northWest != null)
            northWestExit = northWest;
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Return the Room object if the parameter direction matches one of the locations. If not match return null.
     * @param direction The direction tho follow.
     */
    public Room getExit(String direction)
    {
        Room returnRoom = null;
        if(direction.equals("north")){
            returnRoom = northExit;
        }else if(direction.equals("east")){
            returnRoom = eastExit;
        }else if(direction.equals("south")){
            returnRoom = southExit;
        }else if(direction.equals("west")){
            returnRoom = westExit;
        }else if(direction.equals("southEast")){
            returnRoom = southEastExit;
        }else if(direction.equals("northWest")){
            returnRoom = northWestExit;
        }
        return returnRoom;
    }
    
    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     *
     * @ return A description of the available exits.
     */
    public String getExitString()
    {
       String stringToReturn = null;
       System.out.print("Exits: ");
       if(northExit != null){
           stringToReturn = "north";
       }
       if(eastExit != null){
           stringToReturn = "east";
       }
       if(southExit != null){
           stringToReturn = "south";
       }
       if(westExit != null){
           stringToReturn = "west";
       }
       if(southEastExit != null){
           stringToReturn = "southEast";
       }
       if(northWestExit != null){
           stringToReturn = "northWest";
       }
       return stringToReturn;
    }
}
