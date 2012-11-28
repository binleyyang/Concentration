import javax.swing.*;

public class ConcentrationTest {
	
	public static void main (String [] args) {

	JFrame frame = new JFrame ();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(new Concentration());
	
	frame.pack();
	frame.setVisible(true);
	frame.setSize(800, 650);
	
	}
}
