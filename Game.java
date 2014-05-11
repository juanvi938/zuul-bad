import java.util.Stack;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Player player;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
        player = new Player();
        createRooms();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room entrance, offices, management, it, dining, kitchen, itLab;
      
        // create the rooms
        entrance = new Room("at the entrance of the building");
        entrance.addItem("box",1F);
        offices = new Room("in work offices");
        offices.addItem("table", 7F);
        management = new Room(" management");
        management.addItem("books", 2.5F);
        it = new Room("in the IT department");
        it.addItem("rack", 25F);
        dining = new Room("in the dining room");
        dining.addItem("food", 10F);
        kitchen = new Room("in the kitchen");
        kitchen.addItem("dish", 0.1F);
        itLab = new Room("in the IT lab");
        itLab.addItem("computer", 2.5F);
        
        // initialise room exits
        entrance.setExit("west", dining);
        entrance.setExit("south", it);
        entrance.setExit("east",offices);
        entrance.setExit("southWest", kitchen);
        
        offices.setExit("west",entrance);
        offices.setExit("southWest",it);
        offices.setExit("south",management);
        
        management.setExit("north",offices);
        
        it.setExit("north",entrance);
        it.setExit("northEast",offices);
        it.setExit("southEast",itLab);
        
        dining.setExit("east",entrance);
        dining.setExit("southEast",kitchen);
        
        kitchen.setExit("northWest",dining);
        kitchen.setExit("northEast",entrance);
        
        itLab.setExit("northWest",it);

        player.setCurrentRoom(entrance);  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();

        player.printLocationInfo();
        
        System.out.println();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            player.goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }else if(commandWord.equals("look")) {
            player.look();
        }else if(commandWord.equals("eat")) {
            player.eat();
        }else if(commandWord.equals("back")) {
<<<<<<< HEAD
            if(visitedRooms != null)
            {
                currentRoom = visitedRooms.pop();
            }
            printLocationInfo();
=======
            player.back();
        }else if(commandWord.equals("take")) {
            player.take(command);
        }else if(commandWord.equals("drop")) {
            player.drop(command);
        }else if(commandWord.equals("items")) {
            System.out.println(player.getItemsInfo());
>>>>>>> player
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.printCommandWord();
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
