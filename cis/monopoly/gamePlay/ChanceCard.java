package cis.monopoly.gamePlay;

/**<h1>ChanceCard</h1>
 * This class is used to define the Chance cards. Chance cards either move the
 * player to a certain spot, give money, or take money. This is determined by
 * the cardCondition value which determines what rule, and the amount which
 * either determines how much money is give/taken or what space the player moves
 * to/
 * @author Kyle
 *
 */
public class ChanceCard extends Card {
	
	/**This is the flag that determines what the card does. The card can
	 * either move the player, or give/take money*/
	private int cardCondition;
	
	/**This determines how much money is given/taken or what space the 
	 * player moves to.*/
	private int cardAmount;
	
	/**
	 * Default ChanceCard constructor.
	 */
	public ChanceCard() {
		cardID = 0;
		cardText = "";
		cardCondition = 0;
		cardAmount = 0;
	}
	
	/**
	 * This is the constructor that will be used
	 * @param _cardID
	 * @param _cardText
	 * @param cardCondition
	 * @param cardAmount
	 */
	public ChanceCard(int _cardID, String _cardText, int cardCondition,
			int cardAmount) {
		super(_cardID, _cardText);
		this.cardCondition = cardCondition;
		this.cardAmount = cardAmount;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCardCondition() {
		return cardCondition;
	}
	
	
}
