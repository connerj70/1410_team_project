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
	public JLabel finalMessage;
	private Deck deck = new Deck();
	private ArrayList<Card> dealerCards = new ArrayList<Card>();
	private ArrayList<Card> playerCards = new ArrayList<Card>();
	private CardTable cardTable = new CardTable(dealerCards, playerCards, new Deck());
	private JLabel dealerScoreLabel;
	private JLabel playerScoreLabel;

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
		
		dealerCards.add(new NormalCard(Deck.takeCard(deck.deck), false));
		dealerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));

		playerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
		playerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));

		
		cardTable.setBackground(new Color(7,99,36));
		contentPane.add(cardTable);
		
		deck.shuffleCards(deck.deck);
		
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
		
		JButton hitBtn = new JButton("Hit");
		cardTable.add(hitBtn);
		hitBtn.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    	
		    	try {
			        // Add the returned int to the players current score, then check if they have busted or not.
			    	int card = Deck.takeCard(deck.deck);
					playerCards.add(new NormalCard(card, true));
					playerScoreLabel.setText("Player Score: " + cardTable.getPlayerScore());
					revalidate();
					repaint();
					
					// TODO: Change this out for the method in player?
					int cardTotal = cardTable.getPlayerScore();
					if (cardTotal == 21)
					{
						System.out.println("The player got a blackjack");
						JPanel panel = new JPanel();
						cardTable.add(panel);
				    	hitBtn.setEnabled(false);
				  
						JLabel bustedLabel = new JLabel("You won with a blackjack!");
						
						panel.add(bustedLabel);
						JButton playAgainBtn = new JButton("Play again?");
						playAgainBtn.addActionListener(new ActionListener() {

						    @Override
						    public void actionPerformed(ActionEvent e) {
						    	System.out.println("Reset the game.");
						    	deck = new Deck();
								deck.shuffleCards(deck.deck);
						    	dealerCards = new ArrayList<Card>();
						    	playerCards = new ArrayList<Card>();
						    	dealerCards.add(new NormalCard(Deck.takeCard(deck.deck), false));
								dealerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
								playerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
								playerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
								cardTable.setPlayerCards(playerCards);
								cardTable.setDealerCards(dealerCards);
								cardTable.setDeck(deck);
						    	hitBtn.setEnabled(true);
								dealerScoreLabel.setText("Dealer Score: " + cardTable.getDealerScore() + (cardTable.anyDealerCardsFaceDown() ? " (?)" : ""));
								playerScoreLabel.setText("Player Score: " + cardTable.getPlayerScore());
								cardTable.remove(panel);
						    	revalidate();
								repaint();
						    }
						});
						panel.add(playAgainBtn);
						JButton quitBtn = new JButton("Quit.");
						quitBtn.addActionListener(new ActionListener() {

						    @Override
						    public void actionPerformed(ActionEvent e) {
						    	player.quitGame();
						    }
						});
						panel.add(quitBtn);
					}
					else if (cardTotal > 21)
					{
						System.out.println("The player busted");
						JPanel panel = new JPanel();
						cardTable.add(panel);
				    	hitBtn.setEnabled(false);
				  
						JLabel bustedLabel = new JLabel("Oh no you busted!");
						
						panel.add(bustedLabel);
						JButton playAgainBtn = new JButton("Play again?");
						playAgainBtn.addActionListener(new ActionListener() {

						    @Override
						    public void actionPerformed(ActionEvent e) {
						    	System.out.println("Reset the game.");
						    	deck = new Deck();
								deck.shuffleCards(deck.deck);
						    	dealerCards = new ArrayList<Card>();
						    	playerCards = new ArrayList<Card>();
						    	dealerCards.add(new NormalCard(Deck.takeCard(deck.deck), false));
								dealerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
								playerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
								playerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
								cardTable.setPlayerCards(playerCards);
								cardTable.setDealerCards(dealerCards);
								cardTable.setDeck(deck);
						    	hitBtn.setEnabled(true);
								dealerScoreLabel.setText("Dealer Score: " + cardTable.getDealerScore() + (cardTable.anyDealerCardsFaceDown() ? " (?)" : ""));
								playerScoreLabel.setText("Player Score: " + cardTable.getPlayerScore());
								cardTable.remove(panel);
						    	revalidate();
								repaint();
						    }
						});
						panel.add(playAgainBtn);
						JButton quitBtn = new JButton("Quit.");
						quitBtn.addActionListener(new ActionListener() {

						    @Override
						    public void actionPerformed(ActionEvent e) {
						    	player.quitGame();
						    }
						});
						panel.add(quitBtn);
					}
					
					if (cardTable.getPlayerScore() < 21) {
						// Dealers turn.
						// Reveal their facedown card.
						dealerCards.get(0).setFaceUp();
						revalidate();
						repaint();
						// Check if the dealer should draw another card.
						if (cardTable.getDealerScore() < 16) {
							// TODO: Change this to work with the dealer cards array.
							int dCard = Deck.takeCard(deck.deck);
							dealerCards.add(new NormalCard(dCard, true));
							dealerScoreLabel.setText("Dealer Score: " + cardTable.getDealerScore());
							revalidate();
							repaint();
						}
						
						dealerScoreLabel.setText("Dealer Score: " + cardTable.getDealerScore());
						revalidate();
						repaint();
						
						int dealerCardTotal = cardTable.getDealerScore();
						if(dealerCardTotal > 21) {
							JPanel panel = new JPanel();
							cardTable.add(panel);
					    	hitBtn.setEnabled(false);
					  
							JLabel bustedLabel = new JLabel("The dealer busted! You won!");
							
							panel.add(bustedLabel);
							JButton playAgainBtn = new JButton("Play again?");
							playAgainBtn.addActionListener(new ActionListener() {

							    @Override
							    public void actionPerformed(ActionEvent e) {
							    	System.out.println("Reset the game.");
							    	deck = new Deck();
									deck.shuffleCards(deck.deck);
							    	dealerCards = new ArrayList<Card>();
							    	playerCards = new ArrayList<Card>();
							    	dealerCards.add(new NormalCard(Deck.takeCard(deck.deck), false));
									dealerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
									playerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
									playerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
									cardTable.setPlayerCards(playerCards);
									cardTable.setDealerCards(dealerCards);
									cardTable.setDeck(deck);
							    	hitBtn.setEnabled(true);
									dealerScoreLabel.setText("Dealer Score: " + cardTable.getDealerScore() + (cardTable.anyDealerCardsFaceDown() ? " (?)" : ""));
									playerScoreLabel.setText("Player Score: " + cardTable.getPlayerScore());
									cardTable.remove(panel);
							    	revalidate();
									repaint();
							    }
							});
							panel.add(playAgainBtn);
							JButton quitBtn = new JButton("Quit.");
							quitBtn.addActionListener(new ActionListener() {

							    @Override
							    public void actionPerformed(ActionEvent e) {
							    	player.quitGame();
							    }
							});
							panel.add(quitBtn);
						} else if(dealerCardTotal == 21) {
							JPanel panel = new JPanel();
							cardTable.add(panel);
					    	hitBtn.setEnabled(false);
					  
							JLabel bustedLabel = new JLabel("Oh no the dealer got a blackjack! You lost.");
							
							panel.add(bustedLabel);
							JButton playAgainBtn = new JButton("Play again?");
							playAgainBtn.addActionListener(new ActionListener() {

							    @Override
							    public void actionPerformed(ActionEvent e) {
							    	System.out.println("Reset the game.");
							    	deck = new Deck();
									deck.shuffleCards(deck.deck);
							    	dealerCards = new ArrayList<Card>();
							    	playerCards = new ArrayList<Card>();
							    	dealerCards.add(new NormalCard(Deck.takeCard(deck.deck), false));
									dealerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
									playerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
									playerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
									cardTable.setPlayerCards(playerCards);
									cardTable.setDealerCards(dealerCards);
									cardTable.setDeck(deck);
							    	hitBtn.setEnabled(true);
									dealerScoreLabel.setText("Dealer Score: " + cardTable.getDealerScore() + (cardTable.anyDealerCardsFaceDown() ? " (?)" : ""));
									playerScoreLabel.setText("Player Score: " + cardTable.getPlayerScore());
									cardTable.remove(panel);
							    	revalidate();
									repaint();
							    }
							});
							panel.add(playAgainBtn);
							JButton quitBtn = new JButton("Quit.");
							quitBtn.addActionListener(new ActionListener() {

							    @Override
							    public void actionPerformed(ActionEvent e) {
							    	player.quitGame();
							    }
							});
							panel.add(quitBtn);
						} else if(dealerCardTotal > 17) {
							System.out.println("The dealer is over a score of 17 and should not draw again.");
						}
					}
					
		    	} catch(Exception ex) {
		    		ex.printStackTrace();
		    	}
		    }
		});
		
		JButton standBtn = new JButton("Stand");
		cardTable.add(standBtn);
	
		standBtn.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	standBtn.setEnabled(false);
		    	System.out.println("You chose to stand.");
//		        dealer.dealersTurn(dealer.dCards, dealer.deck);
		    	// Dealers turn.
				// Reveal their facedown card.
				dealerCards.get(0).setFaceUp();
				revalidate();
				repaint();
				while(cardTable.getDealerScore() < 17) {
					// TODO: Change this to work with the dealer cards array.
					int dCard = Deck.takeCard(deck.deck);
					dealerCards.add(new NormalCard(dCard, true));
					dealerScoreLabel.setText("Dealer Score: " + cardTable.getDealerScore());
					revalidate();
					repaint();
				}
				
				// Check score and determine winner
				int dealerCardTotal = cardTable.getDealerScore();
				String text = "";
				if(dealerCardTotal > 21) {
					System.out.println("The dealer busted!");
				} else if(dealerCardTotal > 17) {
					System.out.println("The dealer is over a score of 17 and should not draw again.");
				}
				
				if(dealerCardTotal <= 21 && dealerCardTotal > cardTable.getPlayerScore()) {
					System.out.println("The dealer won.");
					text = "The dealer won.";
				} else if(dealerCardTotal <= 21 && dealerCardTotal < cardTable.getPlayerScore() && cardTable.getPlayerScore() <= 21) {
					System.out.println("The player won!");
					text = "The player won!";
				} else if(dealerCardTotal > 21 && cardTable.getPlayerScore() <= 21) {
					System.out.println("The player won a different way!");
					text = "The player won a different way!";
				}
				
				JPanel panel = new JPanel();
				cardTable.add(panel);
				
				JLabel finalLabel = new JLabel(text);
				
				panel.add(finalLabel);
				JButton playAgainBtn = new JButton("Play again?");
				playAgainBtn.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) {
				    	System.out.println("Reset the game.");
				    	deck = new Deck();
						deck.shuffleCards(deck.deck);
				    	dealerCards = new ArrayList<Card>();
				    	playerCards = new ArrayList<Card>();
				    	dealerCards.add(new NormalCard(Deck.takeCard(deck.deck), false));
						dealerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
						playerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
						playerCards.add(new NormalCard(Deck.takeCard(deck.deck), true));
						cardTable.setPlayerCards(playerCards);
						cardTable.setDealerCards(dealerCards);
						cardTable.setDeck(deck);
						dealerScoreLabel.setText("Dealer Score: " + cardTable.getDealerScore() + (cardTable.anyDealerCardsFaceDown() ? " (?)" : ""));
						playerScoreLabel.setText("Player Score: " + cardTable.getPlayerScore());
						cardTable.remove(panel);
				    	revalidate();
						repaint();
				    }
				});
				panel.add(playAgainBtn);
				JButton quitBtn = new JButton("Quit.");
				quitBtn.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) {
				    	player.quitGame();
				    }
				});
				panel.add(quitBtn);
				
		    	standBtn.setEnabled(true);
		    }
		});
	}

}
