import java.util.HashMap;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private static HashMap<String,Option> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<>();
        validCommands.put("ir",Option.GO);
        validCommands.put("salir",Option.QUIT);
        validCommands.put("ayuda",Option.HELP);
        validCommands.put("mirar",Option.LOOK);
        validCommands.put("comer",Option.EAT);
        validCommands.put("atras",Option.BACK);
        validCommands.put("coger",Option.TAKE);
        validCommands.put("dejar",Option.DROP);
        validCommands.put("objetos",Option.ITEMS);
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        boolean booleanToReturn = validCommands.containsKey(aString);
        return booleanToReturn;
    }
    
    /**
     * Print all valid commands to System.out
     */
    public void showAll()
    {
        for (String key : validCommands.keySet()){
            System.out.print(key +", ");
        }
    }
    
    /**
     * Return the Option associated with a word.
     * @param commandWord The word to look up (as a string).
     * @return The Option correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public Option getCommandWord(String commandWord)
    {
        Option option = Option.UNKNOWN;
          
        if(isCommand(commandWord)){
            option = validCommands.get(commandWord);
        }

        return option;
    }
}
