import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.Timer;
import java.util.Collection;

public class Concentration extends JPanel implements ActionListener {
	
	int[] ordered = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54};
	int[] shuffled = shuffler(ordered);
	
	JButton replayBtn, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36, b37, b38, b39, b40, b41, b42, b43, b44, b45, b46, b47, b48, b49, b50, b51, b52, b53, b54;
	JButton[] button = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36, b37, b38, b39, b40, b41, b42, b43, b44, b45, b46, b47, b48, b49, b50, b51, b52, b53, b54};
	JButton[][] compare = {{b1,b2,b3,b4}, {b5,b6,b7,b8}, {b9,b10,b11,b12}, {b13,b14,b15,b16}, {b17,b18,b19,b20}, {b21,b22,b23,b24}, {b25,b26,b27,b28}, {b29,b30,b31,b32}, {b33,b34,b35,b36}, {b37,b38,b39,b40}, {b41,b42,b43,b44}, {b45,b46,b47,b48}, {b49,b50,b51,b52}, {b53,b54, null, null}};
	ImageIcon card, card2, back, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19, card20, card21, card22, card23, card24, card25, card26, card27, card28, card29, card30, card31, card32, card33, card34, card35, card36, card37, card38, card39, card40, card41, card42, card43, card44, card45, card46, card47, card48, card49, card50, card51, card52, card53, card54, card55, card56 ;
	ImageIcon[] cards = {card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19, card20, card21, card22, card23, card24, card25, card26, card27, card28, card29, card30, card31, card32, card33, card34, card35, card36, card37, card38, card39, card40, card41, card42, card43, card44, card45, card46, card47, card48, card49, card50, card51, card52, card53, card54, card55, card56};
	
	private int visibleButtons, counter;
	
	public Concentration() {
		
		super();
		setLayout(new FlowLayout());
		init();
	}
	
	public void init () {
		/*
		final TextField tries = new TextField(15);
		
		JLabel label = new JLabel();
		label.setToolTipText("Attempts");
		*/
		int w = 60, h = 80;
		
		for (int j = 0; j < 54; j++) {
			card = new ImageIcon (getClass().getResource("b2fv.png"));
			Image i = card.getImage();
			Image i2 = i.getScaledInstance(w, h, Image.SCALE_DEFAULT);
			card.setImage(i2);
			
			int v = shuffled[j];
			cards[j] = new ImageIcon(getClass().getResource(v + ".png"));
			i = cards[j].getImage();
			i2 = i.getScaledInstance(w, h, Image.SCALE_DEFAULT);
			cards[j].setImage(i2);
			
			button[j] = new JButton (card);
			button[j].addActionListener(this);
			
			add(button[j]);
		}
		
		replayBtn = new JButton("Restart");
		replayBtn.addActionListener(this);
		add(replayBtn);
	}
	
	public static int[] shuffler (int[]a) { //method to shuffle a deck of cards
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				for (int k = 0; k < a.length; k++) {
				Random generator = new Random();
				swapper(a, generator.nextInt(a.length), generator.nextInt(a.length));
				}
			}
		} return a;
	}

	public static void swapper(int[] a, int b, int c){ //swapper method used in the shuffler method to shuffle a deck of cards
		int x = a[b];
		int y = a[c];
		a[b] = y;
		a[c] = x;
	}
	
	private boolean gameChecker() {
		for (int i = 0; i < button.length; i++) {
			if (button[i].isEnabled() == true)
				return false;
		}
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				for (int i = 0; i < button.length; i++) {
					button[i].setIcon(card);
				}
			}
		});
		
		int a = 0;
		
		if (e.getSource() == replayBtn) {
			init();
		} 
		
		if (!gameChecker()) {
			for (int i = 0; i < button.length; i++) {
				if (e.getSource() == button[i]) {
					timer.start();
					a = i;
					button[a].setIcon(cards[a]);
					counter++;
					//System.out.println(counter);
					for (int j = 0; j < button.length; j++) {
						if (e.getSource() == button[j] && i!=j) {
							button[i].setEnabled(false);
							button[j].setEnabled(false);
						}
					}
				}
			}
			
			if (counter == 2) 
				counter = 0;			
			
		}
	}	
	
	public boolean comparison (JButton a, JButton b) {
		
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 4; j++) {
				if (a == compare[i][j] && b == compare[i][j])
					return true;
				else
					return false;
			}
		}
		return false;
	}
}

	
	
