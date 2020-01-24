package business;

import framework.Command;

public class Stop extends Command {
	
	private Simulation sim;
	
	public Stop (Simulation m) {
		sim = m;
		
	}
	
	public void execute()
	{
		sim.stop();
	}

}
