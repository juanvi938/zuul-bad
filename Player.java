import java.util.Stack;
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
   
   /**
    * Constructor of class Player. Initialize the atributes of class.
    */
   public Player()
   {
       visitedRooms = new Stack<>();
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
}
