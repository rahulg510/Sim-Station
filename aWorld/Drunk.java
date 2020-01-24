package aWorld;

public class Drunk extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Drunk(World world) {
		super(world);
		steps = rand.nextInt(10)+2;
	}

	@Override
	public void update() {
		this.changeHeading(Heading.getHeading(rand.nextInt(4)));
		this.steps = rand.nextInt(15)+2;
		move();
	}
}
