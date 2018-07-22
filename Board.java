import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener
{
	final int WIDTH = 10;
	int HEIGHT = 22;
	JLabel score;
	ArrayList<Tetromino> tetrominos;
	Tetromino currentTetromino;
	int currentTetrominoIdx;
	Timer timer;
	boolean occupied[][];
	
	public Board(Tetris frame)
	{
		occupied= new boolean[22][10];
		setFocusable(true);
		score = frame.getScore();
		tetrominos = new ArrayList<Tetromino>(0);
		currentTetrominoIdx = -1;
		timer = new Timer(500, this);
		addKeyListener(new TetrisKeyListener());
	}

	public void actionPerformed(ActionEvent event){
		drop();
		updateBoard();
		repaint();
	}
	
	public void start()
	{
		timer.start();
		newTetromino();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		for(int i = 0;i < tetrominos.size();i++)
		{
			Square currentSquares[] = tetrominos.get(i).getSquares();
			
			for(int j = 0;j < currentSquares.length;j++)
			{
				g.setColor(tetrominos.get(i).color);
				g.fill3DRect(currentSquares[j].getX() * 20, currentSquares[j].getY() * 20, currentSquares[j].getWidth(), currentSquares[j].getHeight(), true);
			}
		}
	}
	
	public void drop()
	{
		//if(getMaxY() + 1 <= 21)
		//{
			currentTetromino.setY(currentTetromino.getY() + 1);
			if(getMaxY() == 21 || detectCollisions(1, 1))
				newTetromino();
		//}
	}
	
	public void newTetromino()
	{
		tetrominos.add(new Tetromino());
		currentTetrominoIdx++;
		currentTetromino = tetrominos.get(currentTetrominoIdx);
		updateBoard();
	}
	
	public void updateBoard()
	{
		clearBoard();
		for(int i = 0;i < tetrominos.size();i++)
		{
			Square currentSquares[] = tetrominos.get(i).getSquares();
			
			for(int j = 0;j < currentSquares.length;j++)
			{
				occupied[currentSquares[j].getY()][currentSquares[j].getX()] = true;
			}
		}
	}
	
	public void clearBoard()
	{
		for(int i = 0;i < occupied.length;i++)
		{
			for(int j = 0;j < occupied[i].length;j++)
			{
				occupied[i][j] = false;
			}
		}
	}
	
	public int getMaxY()
	{
		Square[] currentSquares = currentTetromino.getSquares();
		int max = 0;
		
		for(int i = 0;i < currentSquares.length;i++)
		{
			if(currentSquares[i].getY() > max)
				max = currentSquares[i].getY();
		}
		return max;
	}
	
	public boolean detectCollisions(int vector, int axis)
	{
		Square[] currentSquares = currentTetromino.getSquares();
		
		if(axis == 0) // x
		{
			for(int i = 0;i < currentSquares.length;i++)
			{
				if(occupied[currentSquares[i].getY()][currentSquares[i].getX() + vector] == true)
				{
					boolean shared = false;
					
					for(int j = 0;j < currentSquares.length;j++)
					{
						if(currentSquares[j].getY() == currentSquares[i].getY() && currentSquares[j].getX() == currentSquares[i].getX() + vector)
							shared = true;
					}
					if(!shared)
						return true;
				}
			}
		}
		else // y
		{
			for(int i = 0;i < currentSquares.length;i++)
			{
				if(occupied[currentSquares[i].getY() + vector][currentSquares[i].getX()] == true)
				{
					boolean shared = false;
					
					for(int j = 0;j < currentSquares.length;j++)
					{
						if(currentSquares[j].getY() == currentSquares[i].getY() + vector && currentSquares[j].getX() == currentSquares[i].getX())
							shared = true;
					}
					if(!shared)
						return true;
				}
			}
		}
		return false;
	}
	
	class TetrisKeyListener extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode() == KeyEvent.VK_A)
			{
				if(!detectCollisions(-1, 0))
					currentTetromino.setX(currentTetromino.getX() - 1);
			}
			if(e.getKeyCode() == KeyEvent.VK_D)
			{
				if(!detectCollisions(1, 0))
					currentTetromino.setX(currentTetromino.getX() + 1);
			}
			updateBoard();
			repaint();
		}
	}
}
