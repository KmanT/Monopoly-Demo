package cis.monopoly.gamePlay;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	private static final String CHANCE_FILE = "src/cis/monopoly/chance.txt";
	
	/**Defines the file path to the community chest card info file.*/
	private static final String COMM_FILE = "src/cis/monopoly/community.txt";
	
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
		
		try {
			
			if (type.equals("chance")) {
				List<String> lineList = readCardFile(
						CHANCE_FILE);
				
				for (String line : lineList) {
					try {
						String[] card = line.split(",");
						try {
							card[0] = card[0].replaceAll("[^0-9]", "");
							card[2] = card[2].replaceAll("[^0-9]", "");
							card[3] = card[3].replaceAll("[^0-9]", "");
						} catch (ArrayIndexOutOfBoundsException ea) {
							System.out.println(line);
							System.out.println(card.length);
						}
						
						int cardID = Integer.parseInt(card[0]);
						String cardText = card[1];
						int cardCond = Integer.parseInt(card[2]);
						int cardAmt = Integer.valueOf(card[3]);
						playDeck.push(new ChanceCard(
								cardID, cardText,
								cardCond, cardAmt));
					} catch (NumberFormatException ex) {
						AlertBox.display("Number format error", "There was an"
								+ " error with the number formatting");
						System.out.println(line);
						System.out.println(ex.getMessage());
					}
					
				}
				
				
			} else if (type.equals("community")) {
				boolean getMoney;
				
				List<String> lineList = readCardFile(COMM_FILE);
				
				for (String line : lineList) {
					try {
						String[] card = line.split(",", 4);						
						int cardID = Integer.parseInt(card[0]);
						String cardText = card[1];
						int cardCond = Integer.parseInt(card[2]);
						int cardAmt = Integer.parseInt(card[3]);
						
						if (cardCond == 0) {
							getMoney = true;
						} else {
							getMoney = false;
						}
						playDeck.push(new CommunityChestCard(
								cardID, cardText,
								getMoney, cardAmt));
						
					} catch (NumberFormatException ex) {
						AlertBox.display("Number format error", "There was an"
								+ " error with the number formatting");
						System.out.println(line);
						System.out.println(ex.getMessage());
					} 
					
				}
				
			}
			
			Collections.shuffle(playDeck);
			
		} catch (IOException ei) {
			AlertBox.display("File not found exception", "The file"
				+ " you were looking for was not found.");
			System.out.println(System.err);
		} 
	}
	/**
	 * This reads the card file.
	 * @param dir The directory where the card belongs
	 * @return A list of strings which contain the information for card
	 * creation
	 * @throws IOException If there is something wrong with the card file.
	 */
	public List<String> readCardFile(final String dir) throws IOException {
		List<String> lineList = new ArrayList<>();
		File file = new File(dir);
		Scanner scan = new Scanner(file, "utf-8");
		while (scan.hasNextLine()) {
			lineList.add(scan.nextLine());
		}
		scan.close();
		return lineList;
	}
	
	/**
	 * Refills the deck if it is empty.
	 */
	public void reFillDeck() {
		if (playDeck.isEmpty()) {
			fillDeck();
		}
	}
	
	/**
	 * Gets the deck.
	 * @return A stack of cards.
	 */
	public Stack<Card> getPlayDeck() {
		return playDeck;
	}
	
	/**
	 * Draws the card and applies the condition to the player.
	 * @param player The player who drew the card.
	 */
	public void drawCard(final Player player) {
		if (playDeck.peek() instanceof ChanceCard) {
			ChanceCard temp = (ChanceCard) playDeck.pop();
			temp.applyCondition(player);
		} else if (playDeck.peek() instanceof CommunityChestCard) {
			CommunityChestCard temp = 
					(CommunityChestCard) playDeck.pop();
			temp.applyCondition(player);
		}
	}
}
