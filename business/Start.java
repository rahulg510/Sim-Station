package business;

import framework.Command;

public class Start extends Command {
	
	private Simulation sim;
	
	public Start (Simulation m) {
		sim = m;
		
	}
	
	public void execute()
	{
		sim.start();
	}

}
