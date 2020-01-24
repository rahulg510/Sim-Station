package business;

import framework.Command;

public class Resume extends Command {
	
	private Simulation sim;
	
	public Resume (Simulation m) {
		sim = m;
		
	}
	
	public void execute()
	{
		sim.resume();
	}

}
