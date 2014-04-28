import java.util.HashMap;
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
    private HashMap<String,Room> directions;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        directions = new HashMap<>();
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
    public void setExits(Room north, Room east, Room south, Room west, 
        Room southEast, Room northWest, Room southWest, Room northEast) 
    {
        if(north != null)
            directions.put("north",north);
        if(east != null)
            directions.put("east",east);
        if(south != null)
            directions.put("south",south);
        if(west != null)
            directions.put("west",west);
        if(southEast != null)
            directions.put("southEast",southEast);
        if(northWest != null)
            directions.put("northWest",northWest);
        if(southWest != null)
            directions.put("southWest",southWest);
        if(northEast != null)
            directions.put("northEast",northEast);
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

        returnRoom = directions.get(direction);

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
       String stringToReturn = "Exits: ";
       if(directions.containsKey("north")){
           stringToReturn += "north ";
       }
       if(directions.containsKey("east")){
           stringToReturn += "east ";
       }
       if(directions.containsKey("south")){
           stringToReturn += "south ";
       }
       if(directions.containsKey("west")){
           stringToReturn += "west ";
       }
       if(directions.containsKey("southEast")){
           stringToReturn += "southEast ";
       }
       if(directions.containsKey("northWest")){
           stringToReturn += "northWest ";
       }
       if(directions.containsKey("southWest")){
           stringToReturn += "southWest ";
       }
       if(directions.containsKey("northEast")){
           stringToReturn += "northEast ";
       }
       return stringToReturn;
    }
}
