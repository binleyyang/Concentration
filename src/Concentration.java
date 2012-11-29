import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class Concentration extends JPanel implements ActionListener {
	
	static String twoPeople = new String("Two Players");
	static String onePerson = new String("One Player");
	static String noPeople = new String("Computer");
	
	int[] ordered = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54};
	int[] shuffled = shuffler(ordered);
	
	final JButton replayBtn = new JButton("Restart");
	static JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36, b37, b38, b39, b40, b41, b42, b43, b44, b45, b46, b47, b48, b49, b50, b51, b52, b53, b54, ba;
	JButton[] button = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36, b37, b38, b39, b40, b41, b42, b43, b44, b45, b46, b47, b48, b49, b50, b51, b52, b53, b54, ba};
	static String[][] compare = {{"b1","b2","b3","b4"}, {"b5","b6","b7","b8"}, {"b9","b10","b11","b12"}, {"b13","b14","b15","b16"}, {"b17","b18","b19","b20"}, {"b21","b22","b23","b24"}, {"b25","b26","b27","b28"}, {"b29","b30","b31","b32"}, {"b33","b34","b35","b36"}, {"b37","b38","b39","b40"}, {"b41","b42","b43","b44"}, {"b45","b46","b47","b48"}, {"b49","b50","b51","b52"}, {"b53","b54", "b55", "b56"}};
	String[] Sbutton = {"b1","b2","b3","b4","b5","b6","b7","b8","b9","b10","b11","b12","b13","b14","b15","b16","b17","b18","b19","b20","b21","b22","b23","b24","b25","b26","b27","b28","b29","b30","b31","b32","b33","b34","b35","b36","b37","b38","b39","b40","b41","b42","b43","b44","b45","b46","b47","b48","b49","b50","b51","b52","b53","b54", null, null};
	ImageIcon card, card2, back, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19, card20, card21, card22, card23, card24, card25, card26, card27, card28, card29, card30, card31, card32, card33, card34, card35, card36, card37, card38, card39, card40, card41, card42, card43, card44, card45, card46, card47, card48, card49, card50, card51, card52, card53, card54, card55, card56 ;
	ImageIcon[] cards = {card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19, card20, card21, card22, card23, card24, card25, card26, card27, card28, card29, card30, card31, card32, card33, card34, card35, card36, card37, card38, card39, card40, card41, card42, card43, card44, card45, card46, card47, card48, card49, card50, card51, card52, card53, card54, card55, card56};
	
	int game = 2;
	
	final JLabel player1 = new JLabel("Player 1: 0");
	final JLabel player2 = new JLabel("Player 2: 0");
	final JLabel move = new JLabel("Turn: Player 1");
	final JLabel log = new JLabel("");
	final JLabel numberOfMoves = new JLabel("Attempts: 0");
	
	JRadioButton onePlayer = new JRadioButton("One Player");
	JRadioButton twoPlayer = new JRadioButton("Two Players");
	JRadioButton noPlayer = new JRadioButton("Computer");
	
	ButtonGroup group;
	
	public Concentration() {
		
		super();
		setLayout(new FlowLayout());
		init();
	}
	
	public void init () {
		
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
			add(button[j]);
			button[j].addActionListener(this);
			
		}
		replayBtn.addActionListener(this);
		
		twoPlayer.setSelected(true);
		twoPlayer.setActionCommand(twoPeople);
		onePlayer.setActionCommand(onePerson);
		noPlayer.setActionCommand(noPeople);
		
		group = new ButtonGroup();
		group.add(onePlayer);
		group.add(twoPlayer);
		group.add(noPlayer);
		
		RadioListener listener = new RadioListener();
		twoPlayer.addActionListener(listener);
		twoPlayer.addItemListener(listener);
		twoPlayer.addChangeListener(listener);
		onePlayer.addActionListener(listener);
		onePlayer.addItemListener(listener);
		onePlayer.addChangeListener(listener);
		noPlayer.addActionListener(listener);
		noPlayer.addItemListener(listener);
		noPlayer.addChangeListener(listener);
		
		add(log);
		add(player1);
		add(player2);
		add(move);
		add(replayBtn);
		add(onePlayer);
		add(twoPlayer);
		add(noPlayer);
		add(numberOfMoves);
	}
	
	class RadioListener implements ActionListener, ChangeListener, ItemListener {  
		public void actionPerformed(ActionEvent e) {
			
			if (e.getActionCommand() == twoPeople) {
				game = 2;
				replay();
			} else if (e.getActionCommand() == onePerson) {
				game = 1;
				replay();
			}
			else {
				game = 0;
				replay();
				Click(); //have computer click buttons randomly automatical
				}
			}
			public void itemStateChanged(ItemEvent e) {}
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
			}
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

	
	int counter, score1, score2, pairCount;
	ArrayList<Integer> pairs = new ArrayList<Integer>();
	ArrayList<JButton> pairs2 = new ArrayList<JButton>();
	
 	@Override
	public void actionPerformed(ActionEvent e) {
 		
		Timer timer = new Timer(1500, new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				for (int i = 0; i < button.length; i++) {
					button[i].setIcon(card);
				}
			}
		});
		
		if (game == 2) { //two players
			
			int a = 0;
			
			if (e.getSource() == replayBtn) 
				replay();
			
			for (int i = 0; i < button.length; i++) {
				
				if (e.getSource() == button[i]) {	
					a = i;
					button[a].setIcon(cards[a]);
					button[a].removeActionListener(this);
					counter++;
					numberOfMoves.setText("Attempts:" + pairCount);
					pairs.add(i);
					pairs2.add(button[a]);
					
					if (b1 == button[i])
						System.out.println(true);
					
					if (counter == 2) {
						pairs2.get(0).addActionListener(this);
						pairs2.get(1).addActionListener(this);
						timer.start();
						timer.setRepeats(false);
						if (test(pairCount) == false)
							move.setText("Turn: Player 1");
						else 
							move.setText("Turn: Player 2");
						
						pairCount++;
						
						if (check(Sbutton[shuffled[pairs.get(0)]-1], Sbutton[shuffled[pairs.get(1)]-1]) == true) {
							log.setText("You got a match!");
							button[pairs.get(0)].setEnabled(false);
							button[pairs.get(1)].setEnabled(false);
						
							if (test(pairCount) == false) {
								score1++;
								player1.setText("Player 1: " + score1);
							} else if (test(pairCount) == true) {
								score2++;
								player2.setText("Player 2: " + score2);
							}
						} else 
							log.setText("Wrong! Try again!");
				
						counter = 0;
						pairs.clear();
						pairs2.clear();
					}
				}
			}
		}
		
		if (game == 1) { //one player vs. AI
			
			Random random = new Random();
			
			int a = 0;
			
			if (e.getSource() == replayBtn)
				replay();
		
			for (int i = 0; i < button.length; i++) {
				
				if (e.getSource() == button[i]) {	
					a = i;
					button[a].setIcon(cards[a]);
					button[a].removeActionListener(this);
					counter++;
					numberOfMoves.setText("Attempts:" + pairCount);
					pairs.add(i);
					pairs2.add(button[a]);
					
					if (b1 == button[i])
						System.out.println(true);
					
					if (counter == 2) {
						pairs2.get(0).addActionListener(this);
						pairs2.get(1).addActionListener(this);
						timer.start();
						timer.setRepeats(false);
						if (test(pairCount) == false)
							move.setText("Turn: Player 1");
						else {
							move.setText("Turn: Computer");
							ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
							randomNumbers.add(random.nextInt(55)-1);
							randomNumbers.add(random.nextInt(55)-1);
								
							button[randomNumbers.get(0)].doClick();
							button[randomNumbers.get(1)].doClick();
							
							pairs.clear();
							pairs.add(randomNumbers.get(0));
							pairs.add(randomNumbers.get(1));
							
							pairs2.get(0).addActionListener(this); 
							pairs2.get(1).addActionListener(this);
							
							timer.start();
							
							if (check(Sbutton[shuffled[pairs.get(0)]-1], Sbutton[shuffled[pairs.get(1)]-1]) == true) {
								log.setText("You got a match!");
								button[pairs.get(0)].setEnabled(false);
								button[pairs.get(1)].setEnabled(false);
							
								if (test(pairCount) == false) {
									score1++;
									player1.setText("Player 1: " + score1);
								} else if (test(pairCount) == true) {
									score2++;
									player2.setText("Computer: " + score2);
								}
							} else 
								log.setText("Wrong! Try again!");
					
							counter = 0;
							pairs.clear();
							pairs2.clear();
							pairCount++;
						}
						
						pairCount++;
						
						if (check(Sbutton[shuffled[pairs.get(0)]-1], Sbutton[shuffled[pairs.get(1)]-1]) == true) {
							log.setText("You got a match!");
							button[pairs.get(0)].setEnabled(false);
							button[pairs.get(1)].setEnabled(false);
						
							if (test(pairCount) == false) {
								score1++;
								player1.setText("Player 1: " + score1);
							} else if (test(pairCount) == true) {
								score2++;
								player2.setText("Computer: " + score2);
							}
						} else 
							log.setText("Wrong! Try again!");
				
						counter = 0;
						pairs.clear();
						pairs2.clear();
					}
				}
			}
		}
		
		if (game == 0) { //AI solves the game
			
			int a = 0;
			if (e.getSource() == replayBtn) {
				replay();
			}
			for (int i = 0; i < button.length; i++) {
				
				if (e.getSource() == button[i]) {	
					a = i;
					button[a].setIcon(cards[a]);
					button[a].removeActionListener(this);
					counter++;
					numberOfMoves.setText("Attempts:" + pairCount);
					pairs.add(i);
					pairs2.add(button[a]);
					
					if (b1 == button[i])
						System.out.println(true);
					
					if (counter == 2) {
						pairs2.get(0).addActionListener(this);
						pairs2.get(1).addActionListener(this);
						timer.start();
						timer.setRepeats(false);
						if (test(pairCount) == false)
							move.setText("Turn: Player 1");
						else 
							move.setText("Turn: Player 2");
						
						pairCount++;
						
						if (check(Sbutton[shuffled[pairs.get(0)]-1], Sbutton[shuffled[pairs.get(1)]-1]) == true) {
							log.setText("You got a match!");
							button[pairs.get(0)].setEnabled(false);
							button[pairs.get(1)].setEnabled(false);
						
							if (test(pairCount) == false) {
								score1++;
								player1.setText("Player 1: " + score1);
							} else if (test(pairCount) == true) {
								score2++;
								player2.setText("Player 2: " + score2);
							}
						} else 
							log.setText("Wrong! Try again!");
				
						counter = 0;
						pairs.clear();
						pairs2.clear();
					}
				}
			}
		}
	}
 	
	public void Click() {
 	
	Random random = new Random();
 		
	ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
	randomNumbers.add(random.nextInt(55)-1);
	randomNumbers.add(random.nextInt(55)-1);
		
	button[randomNumbers.get(0)].doClick();
	button[randomNumbers.get(1)].doClick();
 }
 
 	public void replay() { //method to restart the game
		player1.setText("Player 1: 0");
		player2.setText("Player 2: 0");
		move.setText("Turn: Player 1");
		log.setText("");
		numberOfMoves.setText("Attempts: 0");
		pairCount = 0;
		counter = 0;
		score1 = 0;
		score2 = 0;
		
		for (int i = 0; i < button.length; i++) {
			button[i].setIcon(card);
			button[i].setEnabled(true);
		}
	}
 	
 	public static boolean test(int a) { //method to test if even or odd
		if (a % 2 == 0) {
			return true;
		}
		return false;
	}

	public static boolean check(String x, String y) { //method to check if the cards are the same value or not
		int a = 0, b = 0;
		if (x.equals(y))
			return false;
		for (int i = 0; i <=13; i++) {
			for (int j = 0; j<=3; j++) {
				if (compare[i][j].equals(x)) {
					a = i;
				}
				if (compare[i][j].equals(y)) {
					b = i;
				}
			}
		}
		if (a == b) { 
			return true;
		}
		return false;
	}
}

	
	
