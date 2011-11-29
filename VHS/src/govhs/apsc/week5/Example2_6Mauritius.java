package govhs.apsc.week5;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example2_6Mauritius extends JPanel{

	public Example2_6Mauritius() {
		super();
		setSize(300, 300);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.fillRect(0, 0, 300, 100);
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 100, 300, 100);
		
		g.setColor(Color.YELLOW);
		g.fillRect(0, 200, 300, 100);
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 300, 300, 100);
	}
	
	public static void main(String[] args) {
		
		Example2_6Mauritius panel = new Example2_6Mauritius();
		JFrame frame = new JFrame("This");
		
		frame.add(panel);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}