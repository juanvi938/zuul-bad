import java.util.Stack;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    private Room currentRoom;
    private Stack<Room> visitedRooms;
    private ArrayList<Item> items;
    private float weight;
    private final static float maximunWeight = 7.5F;

    /**
     * Constructor of class Player. Initialize the atributes of class.
     */
    public Player()
    {
        visitedRooms = new Stack<>();
        items = new ArrayList<>();
        weight = 0F;
    }

    /**
     * Method that return the value of atribute weight.
     */
    public float getWeight()
    {
        return weight;
    }
    
    /**
     * Method to modify the atribute weight.
     */
    public void setWeight(float newWeight)
    {
        weight = newWeight;
    }

    /**
     * Method that return the value of atribute maximunWeight.
     */
    public float getMaximunWeight()
    {
        return maximunWeight;
    }

    /**
     * Method that return the information of objects Item from the ArrayList items.
     */
    public String getItemsInfo()
    {
        String itemsInfo = null;
        if(items == null)
        {
            itemsInfo = "The player haven't any item";
        }else{
            for(int i = 0; i < items.size(); i++)
            {
                itemsInfo = items.get(i).getDescription();
            }
        }
        return itemsInfo;
    }

    /**
     * Method getter that returns the value of atribute currentRoom.
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    /**
     * Method that modify the currentRoom.
     */
    public void setCurrentRoom(Room newCurrentRoom)
    {
        currentRoom = newCurrentRoom;
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    public void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;

        nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            visitedRooms.push(currentRoom);
            currentRoom = nextRoom;

            printLocationInfo();

            System.out.println();
        }
    }

    /**
     * Print the location information of the current room.
     */
    public void printLocationInfo()
    {
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Print the description of the currentRoom.
     */
    public void look()
    {
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Return to the previous location.
     */
    public void back()
    {
        currentRoom = visitedRooms.pop();
        printLocationInfo();
    }

    /**
     * Print a message.
     */
    public void eat()
    {
        System.out.println("You have eaten now and you are not hungry any more");
    }
    
    /**
     * Method to add an Item object in ArrayList.
     */
    public boolean addItem(Item item)
    {
        boolean booleanToReturn = false;
        if((weight + item.getItemWeight()) > maximunWeight)
        {
            System.out.println("The weight of the object is greater than the weight that the player can have");
        }else{
            items.add(item);
            setWeight(item.getItemWeight());
            booleanToReturn = true;
        }
        return booleanToReturn;
    }
    
    /**
     * Method to remove an Item object in ArrayList.
     */
    public void removeItem(String itemDescription)
    {
        Iterator<Item> it = items.iterator();
        while(it.hasNext())
        {
            Item item = it.next();
            if(item.getDescription().contains(itemDescription))
            {
                it.remove();
            }
        }
    }
    
    /**
     * Method to search an object Item from ArrayList items.
     */
    public Item searchItem(String itemDescription)
    {
        Item itemToReturn = null;
        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getDescription().contains(itemDescription))
            {
                itemToReturn = items.get(i);
            }
        }
        return itemToReturn;
    }
            
    /**
     * Try to take the Item of the Room. If it exceeds the maximunWeight supported by the player or if you can not add the item shows an error message.
     */
    public void take(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("What object you want to take?");
            return;
        }

        String itemString = command.getSecondWord();

        if(currentRoom.emptyItems() == true)
        {
            System.out.println("No items in this room");
        }else{
            Item item = currentRoom.searchItem(itemString);
            if(item == null)
            {
                System.out.println("No item matches with that description.");
            }else{
                boolean added = addItem(item);
                if(added == true)
                {
                    currentRoom.removeItem(itemString);
                }else{
                    System.out.println("Could not add the object");
                }
            }
        }
    }
}

