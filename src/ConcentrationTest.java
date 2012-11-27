import javax.swing.*;

public class ConcentrationTest {
	
	public static void main (String [] args) {

	JFrame frame = new JFrame ();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(new Concentration(5));

	frame.pack();
	frame.setVisible(true);
	frame.setSize(400, 400);
	
	}
}
