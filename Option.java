
/**
 * Enumeration class Option - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Option
{
    GO("ir"), HELP("ayuda"), QUIT("salir"), TAKE("coger"), 
	DROP("dejar"), BACK("volver"), EAT("comer"), LOOK("mirar"), 
	ITEMS("objetos"), UNKNOWN("");
	
	private String optionString;

	Option(String optionString)
	{
		this.optionString = optionString;
	}

	/**
	 *
	 *@return 
	 */
	 public String getOptionString(){
		return this.optionString;
	 }
}
