import java.awt.Color;

public class Square
{
	int x;
	int y;
	final int WIDTH = 20;
	final int HEIGHT = 20;
	
	public Square()
	{
		x = 0;
		y = 0;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return WIDTH;
	}
	
	public int getHeight()
	{
		return HEIGHT;
	}
	
	public void setX(int newX)
	{
		x = newX;
	}
	
	public void setY(int newY)
	{
		y = newY;
	}
}
