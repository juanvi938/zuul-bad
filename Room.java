import java.util.HashMap;
import java.util.ArrayList;
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
    private ArrayList<Item> items;

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
        items = new ArrayList<>();
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
       
       stringToReturn += directions.keySet();
       
       return stringToReturn;
    }
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor The room in the given direction.
     */
    public void setExit(String direction, Room neighbor)
    {
        directions.put(direction,neighbor);
    }
    
    /**
     * Return a long description of this room, of the form:
     *     You are in the 'name of room'
     *     Exits: north west southwest
     * @return A description of the room, including exits.
     */
    public String getLongDescription()
    {
        String longDescription = "You are in the " + getDescription() + "\n"  + getExitString();
        for(int i = 0; i < items.size(); i++)
        {
            longDescription += items.get(i).getDescription();
        }
        return longDescription;
    }
    
    /**
     * Add Iten objects to ArrayList items.
     */
    public void addItem(String itemDescription, float itemWeight)
    {
        items.add(new Item(itemDescription,itemWeight));
    }
    
    /**
     * Method that returns true if ArrayList items is empty. If else return fasle.
     */
    public boolean emptyItems()
    {
        boolean booleanToReturn = false;
        if(items.size() == 0)
        {
            booleanToReturn = true;
        }
        return booleanToReturn;
    }
    
    /**
     * Method that return a object Item that matches with the parameter.
     */
    public Item searchItem(String itemDescription)
    {
        Item itemToReturn = null;
        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getItemDescription().equals(itemDescription))
            {
                itemToReturn = items.get(i);
            }
        }
        return itemToReturn;
    }
}
