package blackjack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;

/*
 * Author Conner Jensen, Silas Knox, Taylor Shipley
 */
public class BlackJackApp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlackJackApp frame = new BlackJackApp();
					frame.setPreferredSize(new Dimension(1000, 800));
					frame.pack();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BlackJackApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		ArrayList<Card> dealerCards = new ArrayList<Card>();
		dealerCards.add(new NormalCard(2, false));
		dealerCards.add(new NormalCard(2, true));
		dealerCards.add(new NormalCard(2, true));

		ArrayList<Card> playerCards = new ArrayList<Card>();
		playerCards.add(new NormalCard(2, true));
		playerCards.add(new NormalCard(2, true));

		
		CardTable cardTable = new CardTable(dealerCards, playerCards, new Deck());
		cardTable.setBackground(new Color(7,99,36));
		contentPane.add(cardTable);
		
		
		JLabel dealerScoreLabel = new JLabel("Dealer Score: " + cardTable.getDealerScore() + (cardTable.anyDealerCardsFaceDown() ? " (?)" : ""));
		dealerScoreLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		dealerScoreLabel.setBorder(new EmptyBorder(50,500,0,0));
		cardTable.add(dealerScoreLabel);
		
		JLabel playerScoreLabel = new JLabel("Player Score: " + cardTable.getPlayerScore());
		playerScoreLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		playerScoreLabel.setBorder(new EmptyBorder(550,500,0,0));
		cardTable.add(playerScoreLabel);
		
		Player player = new Player("Bob");
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		
		JButton hitBtn = new JButton("Hit");
		cardTable.add(hitBtn);
		hitBtn.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	// TODO: Disable this button until the end of this function?
		    	
//		        int card = player.hit();
		        // Add the returned int to the players current score, then check if they have busted or not.
				playerCards.add(new NormalCard(2, true));
				playerScoreLabel.setText("Player Score: " + cardTable.getPlayerScore());
				revalidate();
				repaint();
				
				// TODO: Check here if the player busted.
				
				// Dealers turn.
				// Check if the dealer should draw another card.
//				if (cardTable.getDealerScore() < 16) {
//					// TODO: Change this to work with the dealer cards array.
//					dealer.takeCard(dealer.dCards, dealer.deck, cardTable.getDealerScore());
//				}
				
				// TODO: Check here if the dealer busted.
				
				// TODO: Enable this button.
				
		    }
		});
		
		JButton standBtn = new JButton("Stand");
		cardTable.add(standBtn);
		standBtn.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	System.out.println("You chose to stand.");
//		        dealer.dealersTurn(dealer.dCards, dealer.deck);
		    }
		});
	}

}
