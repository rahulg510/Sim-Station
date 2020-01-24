package business;

import framework.*;

public  class Simulation extends Model implements Runnable{
	
	private static final long serialVersionUID = 1L;
	protected String name;
    protected long clock;
    protected SimState simState;
    private transient Thread thread;

    public Simulation(String name) {
    	simState = SimState.READY;
    	this.name = name;
    	clock = 0;
    }

	public void copy(Model other)
    {
    	super.copy(other);
    	if(other != null && other instanceof Simulation)
    	{
	    	Simulation m = (Simulation) other;
	    	//update instance variables here
	    	name = m.name;
	    	clock = m.clock;
	    	simState = m.simState;
	    	changed();
    	}
    }
	
	public long getClock()
	{
		return clock;
	}

	public synchronized void start()
	{
		thread = new Thread(this); 
		if(simState == SimState.READY) {
			simState = SimState.RUNNING;
			thread.start();
			}
	}
	
	public synchronized void stop()
	{
		if(simState == SimState.RUNNING || simState == SimState.SUSPENDED)
		{
			simState = SimState.STOPPED;
		}
		
	}

	public synchronized void suspend()
	{
		if(simState == SimState.RUNNING)
		{
			simState = SimState.SUSPENDED;
		}
	}
	
	public synchronized void resume()
	{
		if(simState ==  SimState.SUSPENDED)
		{
			simState = SimState.RUNNING;
			notify();			
		}
	}

	public void update() 
	{
		clock++;
		changed();
	}
	
	@Override
	public void run() {
		while(simState != SimState.STOPPED)
		{
			try 
			{	
				synchronized(this) 
				{
					while(simState == SimState.SUSPENDED)
					{
						wait();
					}
					update();
				}
			
				Thread.sleep(65);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
	}
	

}