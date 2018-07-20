public class Type
{
	Coordinate coords[] = new Coordinate[4];
	
	public Type(int type)
	{
		switch(type)
		{
		case 0:
			// T
			coords[0] = new Coordinate(1, 0);
			coords[1] = new Coordinate(2, 0);
			coords[2] = new Coordinate(2, 1);
			coords[3] = new Coordinate(3, 0);
			break;
		case 1:
			// S
			coords[0] = new Coordinate(1, 1);
			coords[1] = new Coordinate(2, 1);
			coords[2] = new Coordinate(2, 0);
			coords[3] = new Coordinate(3, 0);
			break;
		case 2:
			// Reverse S
			coords[0] = new Coordinate(1, 0);
			coords[1] = new Coordinate(2, 0);
			coords[2] = new Coordinate(2, 1);
			coords[3] = new Coordinate(3, 1);
			break;
		case 3:
			// L
			coords[0] = new Coordinate(1, 0);
			coords[1] = new Coordinate(1, 1);
			coords[2] = new Coordinate(2, 0);
			coords[3] = new Coordinate(3, 0);
			break;
		case 4:
			// Reverse L
			coords[0] = new Coordinate(1, 0);
			coords[1] = new Coordinate(2, 0);
			coords[2] = new Coordinate(3, 0);
			coords[3] = new Coordinate(3, 1);
			break;
		case 5:
			// Square
			coords[0] = new Coordinate(1, 0);
			coords[1] = new Coordinate(1, 1);
			coords[2] = new Coordinate(2, 0);
			coords[3] = new Coordinate(2, 1);
			break;
		case 6:
			// Line
			coords[0] = new Coordinate(0, 0);
			coords[1] = new Coordinate(1, 0);
			coords[2] = new Coordinate(2, 0);
			coords[3] = new Coordinate(3, 0);
			break;
		}
	}
	
	public Coordinate[] getCoords()
	{
		return coords;
	}
}
