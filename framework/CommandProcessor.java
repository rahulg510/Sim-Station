package framework;

/**
 * Edit History
 * Code generated from class diagrams
 */
public class CommandProcessor {

	public static CommandProcessor theCommandProcessor =  new CommandProcessor();
    
	/**
     * Default constructor
     */
    public CommandProcessor() {
    }

    /**
     * @param cmmd
     */
    public static void execute(Command cmmd) {
        cmmd.execute();
    }

}