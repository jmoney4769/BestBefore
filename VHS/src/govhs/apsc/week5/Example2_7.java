package govhs.apsc.week5;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example2_7 extends JPanel {

	public Example2_7() {
		super();
		setSize(300, 300);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 100, 100);
		g.fillRect(200, 0, 100, 100);
		g.fillRect(100, 100, 100, 100);
		g.fillRect(0, 200, 100, 100);
		g.fillRect(200, 200, 100, 100);
		
		g.setColor(Color.WHITE);
		g.fillRect(100, 0, 100, 100);
		g.fillRect(200, 100, 100, 100);
		g.fillRect(0, 100, 100, 100);
		g.fillRect(100, 200, 100, 100);
	}
	
	public static void main(String[] args) {
		
		Example2_7 panel = new Example2_7();
		JFrame frame = new JFrame("This");
		
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

