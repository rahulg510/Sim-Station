package aWorld;

import framework.AppFrame;
import presentation.SimulationFactory;
import presentation.SimulationFrame;

public class AworldMain {
	
	public static void main(String args[]) {
		//Change type below to "Bird" for flocking and "Drunk" for random walks. Be sure to comment out the other.
		
		World.type = "Bird";
		//World.type = "Drunk";
		
		AppFrame app = new SimulationFrame(new SimulationFactory());
		app.display();
		
	}
	
	

}
