//Binley Yang
//CSC 171
//Project 3: Concentration

import javax.swing.*;

public class ConcentrationTest {
	
	public static void main (String [] args) {

	JFrame frame = new JFrame("Concentration Game");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(new Concentration());
	
	frame.pack();
	frame.setVisible(true);
	frame.setSize(800, 700);
	
	}
}
