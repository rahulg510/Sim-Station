package aWorld;

import java.util.ArrayList;
import java.util.Random;

import business.SimState;
import business.Simulation;
import framework.AppFrame;
import framework.Model;
import presentation.SimulationFactory;
import presentation.SimulationFrame;

public class World extends Simulation{
	
	private static final long serialVersionUID = 1L;
	
	public static String type ="";
	public static int SIZE = 500;
	private int numberOfAgents = SIZE/6;
	private ArrayList<Agent> agents;
	
	
	public World(String name) {
		super(name);
		agents = new ArrayList<>();
		createAgents(type);
	}

	@Override
	public void copy(Model other)
    {
    	super.copy(other);
    	if(other != null && other instanceof Simulation)
    	{
	    	World m = (World) other;
	    	//update instance variables here
	    	this.agents = m.agents;
	    	changed();
    	}
    }

	public void createAgents(String type)
	{
		if(type.equalsIgnoreCase("Bird")) 
		{
			for(int i =0 ; i< numberOfAgents; i++)
			{
				Agent bird = new Bird(this);
				agents.add(bird);	
			}
		}
		else 
		{
			for(int i =0 ; i< numberOfAgents; i++)
			{
				Agent bird = new Drunk(this);
				agents.add(bird);	
			}
		}
		
	}
	
	@Override
	public void update()
	{
		super.update();
		for(Agent a: agents) {
			a.update();
		}
		changed();
	}
	
	public void setAgents(ArrayList<Agent> agents)
	{
		this.agents = agents;
	}

	public ArrayList<Agent> getAgents()
	{
		return agents;
	}

	public synchronized Agent findNeighbor(Agent seeker, double radius)
	{
		Random rand = new Random();
		int randInt = rand.nextInt(agents.size());
		boolean found = false;
		Agent neighbor = null;
		for(int i = randInt;i< agents.size() && found == false;i++ )
		{
			if(agents.get(i) != seeker) {
				Agent temp = agents.get(i);
				Double distance = Math.sqrt(Math.pow((temp.xCoor - seeker.xCoor),2) + Math.pow((temp.yCoor - seeker.yCoor),2));
				if(distance <= radius)
				{
					neighbor = temp;
					found = true;
				}
			}
		}
		return neighbor;
	}



}
