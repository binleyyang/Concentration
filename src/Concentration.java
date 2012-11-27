 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Concentration extends JPanel {
	
	JButton b;
	ImageIcon card, card2;
		Concentration other;
	
	public Concentration(int num) {
		
		super();
		
		int w = 50, h = 75;
		card = new ImageIcon (getClass().getResource("b2fv.png"));
		Image i = card.getImage();
		Image i2 = i.getScaledInstance(w, h, Image.SCALE_DEFAULT);
		card.setImage(i2);
		card2 = new ImageIcon(getClass().getResource(num + ".png"));
		i = card2.getImage();
		i2 = i.getScaledInstance(w, h, Image.SCALE_DEFAULT);
		card2.setImage(i2);
		
		b = new JButton (card2);
		b.addActionListener(new ButtonHandler());
		add(b);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			if (b.getIcon() == card2) {
				b.setIcon(card);
			} else
				b.setIcon(card2);
			other.flip();
		}
	}
	
	public void flip() {
		
		if (b.getIcon() == card2)
			b.setIcon(card);
		else
		b.setIcon(card2);
	}
}
