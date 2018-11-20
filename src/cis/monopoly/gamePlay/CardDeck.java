package cis.monopoly.gamePlay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

import cis.monopoly.guiElements.AlertBox;

/**<h1>CardDeck</h1>
 * This is the class that hold all of the cards. It contains a stack that holds
 * all of the cards for each separate deck, and it performs the operations
 * the card provides.
 * 
 * @author Kyle Turske
 * @version 0.7
 *
 */
public class CardDeck {
	
	/**Defines the file path to the chance card info file.*/
	private static final String CHANCE_FILE = "cis/monopoly/"
			+ "gamePlay/chance.txt";
	
	/**Defines the file path to the community chest card info file.*/
	private static final String COMM_FILE = "cis/monopoly/"
			+ "gamePlay/community.txt";
	
	/**
	 * The stack that can hold either chance cards or community chest
	 * cards.
	 */
	private Stack<Card> playDeck;
	
	/**Determines the type of the deck.*/
	private String type;
	
	/**
	 * Deck Constructor.
	 */
	public CardDeck() {
		playDeck = new Stack<>();
		type = "";
	}
	
	/**
	 * Deck Constructor with the type declared.
	 * @param type Either chance or community chest.
	 */
	public CardDeck(final String type) {
		playDeck = new Stack<>();
		this.type = type;
		fillDeck();
	}
	
	/**
	 * Fills the deck with cards depending on what type the deck is.
	 */
	public void fillDeck() {
		
		String cardID = "";
		String cardText = "";
		String cardCond = "";
		String cardAmt = "";
		
		try {
			
			if (type.equals("chance")) {
				
				Scanner fileScan = new Scanner(
						new File(CHANCE_FILE));
				fileScan.useDelimiter(",");	
				
				while (fileScan.hasNext()) {
					cardID = fileScan.next();
					cardText = fileScan.next();
					cardCond = fileScan.next();
					cardAmt = fileScan.next();
					
					playDeck.push(new ChanceCard(
						Integer.parseInt(cardID),
						cardText, 
						Integer.parseInt(cardCond),
						Integer.parseInt(cardAmt)
					));
				}
				
				fileScan.close();
				
			} else if (type.equals("community")) {
				
				boolean getMoney;
				
				Scanner fileScan = new Scanner(COMM_FILE);
				fileScan.useDelimiter(",");	
				
				while (fileScan.hasNext()) {
					cardID = fileScan.next();
					cardText = fileScan.next();
					cardCond = fileScan.next();
					cardAmt = fileScan.next();
					
					if (cardCond.equals("0")) {
						getMoney = true;
					} else {
						getMoney = false;
					}
					
					playDeck.push(new CommunityChestCard(
						Integer.parseInt(cardID),
						cardText, 
						getMoney,
						Integer.parseInt(cardAmt)
					));
				}
				
				fileScan.close();
			}
			
			Collections.shuffle(playDeck);
			
		} catch (FileNotFoundException e) {
			AlertBox.display("File not found exception", "The file"
				+ " you were looking for was not found.");
		}
	}
	
	/**
	 * Refills the deck if it is empty.
	 */
	public void reFillDeck() {
		if (playDeck.isEmpty()) {
			fillDeck();
		}
	}
	
}
