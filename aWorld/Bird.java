package aWorld;

public class Bird extends Agent{

	public Bird(World world)
	{
		super(world);
		steps = rand.nextInt(5)+2;
	
	}

	@Override
	public void update() {
		Agent neighbor = world.findNeighbor(this, 50);
		if(neighbor != null)
		{
			this.steps = neighbor.steps;
			changeHeading(neighbor.heading);
		}
		move();
	}

}
