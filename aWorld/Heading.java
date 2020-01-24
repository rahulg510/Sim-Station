package aWorld;

public enum Heading {
	NORTH,SOUTH,EAST,WEST;
	
	public static Heading getHeading(int x)
	{
		if(x == 0 )
		{
			return NORTH;
		}
		else if(x ==1 )
		{
			return SOUTH;
		}
		else if (x==2)
		{
			return EAST;
		}
		else {
			return WEST;
		}
		
	}

}
