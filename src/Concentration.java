import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Concentration extends JPanel implements ActionListener {
	
	int[] ordered = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54};
	int[] shuffled = shuffler(ordered);
	
	JButton replayBtn, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36, b37, b38, b39, b40, b41, b42, b43, b44, b45, b46, b47, b48, b49, b50, b51, b52, b53, b54;
	JButton[] button = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36, b37, b38, b39, b40, b41, b42, b43, b44, b45, b46, b47, b48, b49, b50, b51, b52, b53, b54};
	ImageIcon card, card2;
	Concentration other;
	
	public Concentration() {
		
		super();
		setLayout(new FlowLayout());
		init();
	}
	
	public void init () {
		
		int w = 60, h = 80;
		
		for (int j = 0; j <= 53; j++) {
			card = new ImageIcon (getClass().getResource("b2fv.png"));
			Image i = card.getImage();
			Image i2 = i.getScaledInstance(w, h, Image.SCALE_DEFAULT);
			card.setImage(i2);
			
			int v = shuffled[j];
			card2 = new ImageIcon(getClass().getResource(v + ".png"));
			i = card2.getImage();
			i2 = i.getScaledInstance(w, h, Image.SCALE_DEFAULT);
			card2.setImage(i2);
			
			button[j] = new JButton (card);
			button[j].addActionListener(this);
			
			add(button[j]);
		}
		
		replayBtn = new JButton("Restart");
		replayBtn.addActionListener(this);
		add(replayBtn);
	}
	/*
	private class ButtonHandler implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			for (int i = 0; i < 54; i++) {
				if (button[i].getIcon() == card2) {
					button[i].setIcon(card);
				} else
					button[i].setIcon(card2);
				other.flip();
			}
		}
	}
	*/
	public void flip() {
		
		for (int i = 1; i <= 54; i++) {
			if (button[i].getIcon() == card2)
				button[i].setIcon(card);
			else
				button[i].setIcon(card2);
		}
	}
	
	public static int[] shuffler (int[]a) { //method to shuffle a deck of cards
		Random generator = new Random();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				swapper(a, generator.nextInt(a.length-1), generator.nextInt(a.length-1));
			}
		} return a;
	}

	public static void swapper(int[] a, int b, int c){ //swapper method used in the shuffler method to shuffle a deck of cards
		int x = a[b];
		int y = a[c];
		a[b] = y;
		a[c] = x;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int counter = 0;
		if (e.getSource() == replayBtn) {
			//System.out.println("Hello World!");
			new Concentration();
		}
		
		for (int i = 0; i < button.length; i++) {
			if (button[i] == e.getSource()) {
				button[i].setIcon(card2);
				counter++;
			} else
				button[i].setIcon(card);
				
			//other.flip();
		}
	}
}

