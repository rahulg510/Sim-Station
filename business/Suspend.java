package business;

import framework.Command;

public class Suspend extends Command {
	
	private Simulation sim;
	
	public Suspend (Simulation m) {
		sim = m;
		
	}
	
	public void execute()
	{
		sim.suspend();
	}

}
