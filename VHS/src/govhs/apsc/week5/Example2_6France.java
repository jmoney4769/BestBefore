package govhs.apsc.week5;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example2_6France extends JPanel{

	public Example2_6France() {
		super();
		setSize(300, 300);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.fillRect(0, 0, 100, 300);
		
		g.setColor(Color.WHITE);
		g.fillRect(100, 0, 100, 300);
		
		g.setColor(Color.BLUE);
		g.fillRect(200, 0, 100, 300);
	}
	
	public static void main(String[] args) {
		
		Example2_6France panel = new Example2_6France();
		JFrame frame = new JFrame("This");
		
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
