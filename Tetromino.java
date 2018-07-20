import java.awt.Color;
import java.util.Random;

public class Tetromino
{
	int x;
	int y;
	Type type;
	Square squares[] = {new Square(), new Square(), new Square(), new Square()};
	Color color;
	
	public Tetromino()
	{
		x = 3;
		y = 0;
		Random randomNumberGenerator = new Random();
		type = new Type(randomNumberGenerator.nextInt(7));
		int randomColor = randomNumberGenerator.nextInt(7);
		switch(randomColor)
		{
		case 0:
			color = Color.BLUE;
			break;
		case 1:
			color = Color.ORANGE;
			break;
		case 2:
			color = Color.GREEN;
			break;
		case 3:
			color = Color.MAGENTA;
			break;
		case 4:
			color = Color.CYAN;
			break;
		case 5:
			color = Color.YELLOW;
			break;
		case 6:
			color = Color.RED;
			break;
		}
		for(int i = 0;i < squares.length;i++)
		{
			squares[i].setX(type.getCoords()[i].getX() + x);
			squares[i].setY(type.getCoords()[i].getY() + y);
		}
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int newX)
	{
		x = newX;
		for(int i = 0;i < squares.length;i++)
		{
			squares[i].setX(type.getCoords()[i].getX() + x);
		}
	}
	
	public void setY(int newY)
	{
		y = newY;
		for(int i = 0;i < squares.length;i++)
		{
			squares[i].setY(type.getCoords()[i].getY() + y);
		}
	}
	
	public Square[] getSquares()
	{
		return squares;
	}
	
	public Type getType()
	{
		return type;
	}
}
