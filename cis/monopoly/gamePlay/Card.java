package cis.monopoly.gamePlay;

/**<h1>Card</h1>
 * This generalized class is used to define the Chance and Community Chest
 * cards.
 * @author Kyle Turske
 * @version 0.6
 *
 */
public abstract class Card {
	
	/**This is used to identify each card.*/
	private int cardID;
	
	/**This is the text on the card that will be provided.*/
	private String cardText;
	
	/**
	 * Card constructor.
	 */
	public Card() {
		cardID = 0;
		cardText = "";
	}
	
	/**
	 * Card constructor.
	 * @param cardID the card identifier
	 * @param cardText the text on the card.
	 */
	public Card(final int cardID, final String cardText) {
		this.cardID = cardID;
		this.cardText = cardText;
	}
	
	/**
	 * Gets the cardID from the stack.
	 * @return the card's ID
	 */
	public int getCardID() {
		return cardID;
	}
	
	/**
	 * Gets the text written on the card.
	 * @return the card's text.
	 */
	public String getCardText() {
		return cardText;
	}
	
}
