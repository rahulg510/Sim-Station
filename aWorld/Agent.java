package aWorld;

import java.io.Serializable;
import java.util.Observer;
import java.util.Random;

public abstract class Agent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int xCoor;
	protected int yCoor;
	protected Heading heading;
	protected Random rand;
	protected int steps;
	protected World world;
	
	public Agent(World world)
	{
		rand = new Random();
		xCoor = rand.nextInt(World.SIZE);
		yCoor = rand.nextInt(World.SIZE);
		heading = Heading.getHeading(rand.nextInt(4));
		this.world = world;
		
	}

	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int xCoor) 
	{
		if(this.xCoor + xCoor > World.SIZE)
		{
			this.xCoor = this.xCoor + xCoor - World.SIZE;
		}
		else if(this.xCoor + xCoor < 0)
		{
			this.xCoor = this.xCoor + xCoor+ World.SIZE;
		}
		else 
		{
			this.xCoor +=xCoor;
		}
		
	}

	public void changeHeading(Heading h)
	{
		this.heading = h;
	}

	public int getyCoor() {
		return yCoor;
	}



	public void setyCoor(int yCoor) 
	{
		if(this.yCoor + yCoor > World.SIZE) 
		{
			this.yCoor = this.yCoor + yCoor- World.SIZE;
		}
		else if(this.yCoor + yCoor < 0) 
		{
			this.yCoor = this.yCoor + yCoor + World.SIZE;
		}
		else 
		{	
			this.yCoor += yCoor;
		}
	}



	public void move()
	{
		if(heading == Heading.EAST) { setxCoor(steps); }
		else if(heading == Heading.WEST) {  setxCoor(-steps); }
		else if(heading == Heading.NORTH) { setyCoor(-steps); }
		else if(heading == Heading.SOUTH) {setyCoor(steps);}
		
		
	}
	
	public abstract void update();
}
