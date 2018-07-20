import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tetris extends JFrame
{
	JLabel score;
	
	public Tetris()
	{
		score = new JLabel("Score: 0");
		add(score, BorderLayout.SOUTH);
		Board board = new Board(this);
		add(board);
		setSize(400, 800);
		setTitle("Tetris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.start();
	}
	
	public static void main(String args[])
	{
		Tetris game = new Tetris();
		game.setLocationRelativeTo(null);
		game.setVisible(true);
	}
	
	public JLabel getScore()
	{
		return score;
	}
}
