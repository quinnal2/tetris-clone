import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	public Board(Tetris frame)
	{
		setFocusable(true);
		score = frame.getScore();
		tetrominos = new ArrayList<Tetromino>(0);
		currentTetrominoIdx = -1;
		timer = new Timer(500, this);
	}

	public void actionPerformed(ActionEvent event){
		drop();
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
				g.draw3DRect(currentSquares[j].getX() * 20, currentSquares[j].getY() * 20, currentSquares[j].getWidth(), currentSquares[j].getHeight(), true);
			}
		}
	}
	
	public void drop()
	{
		if(currentTetromino.getY() + 1 <= 21)
		{
			currentTetromino.setY(currentTetromino.getY() + 1);
			if(currentTetromino.getY() == 21)
				newTetromino();
		}
	}
	
	public void newTetromino()
	{
		tetrominos.add(new Tetromino());
		currentTetrominoIdx++;
		currentTetromino = tetrominos.get(currentTetrominoIdx);
	}
}
