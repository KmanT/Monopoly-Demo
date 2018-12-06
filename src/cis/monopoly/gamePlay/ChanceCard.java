package cis.monopoly.gamePlay;

import cis.monopoly.Main;

/**<h1>ChanceCard</h1>
 * This class is used to define the Chance cards. Chance cards either move the
 * player to a certain spot, give money, or take money. This is determined by
 * the cardCondition value which determines what rule, and the amount which
 * either determines how much money is give/taken or what space the player moves
 * to/
 * @author Kyle Turske
 * @version 0.7
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
		super(0, "");
		cardCondition = 0;
		cardAmount = 0;
	}
	
	/**
	 * This is the constructor that will be used.
	 * @param iD The card's identifier
	 * @param text The text on the card.
	 * @param cardCondition The rule placed on the card.
	 * @param cardAmount Either the space to move to or the amount of money.
	 */
	public ChanceCard(final int iD, final String text,
			final int cardCondition, final int cardAmount) {
		super(iD, text);
		this.cardCondition = cardCondition;
		this.cardAmount = cardAmount;
	}
	
	/**
	 * Returns the rule on the card. Will be taken through a series of case
	 * statements.
	 * @return The card's rule ID
	 */
	public int getCardCondition() {
		return cardCondition;
	}
	
	/**
	 * Returns the amount of money listed on the card.
	 * @return The amount of money given/taken from the player.
	 */
	public int getCardAmount() {
		return cardAmount;
	}
	
	/**
	 * Applies the card condition to the player who has received the chance
	 * card. 0 will move the player to the property with the spaceID equal
	 * to the cardAmount, 1 will move the player to the property nearest to
	 * the player that is in the group equal to the card amount, 2 will
	 * have the  bank pay the player the card amount, 3 gives the player a
	 * Get Out of Jail Free Card, 4 puts the player in jail, 5 has the
	 * player pay the bank, 
	 * @param player The player who got the card.
	 */
	public void applyCondition(final Player player) {
		
		switch (cardCondition) {
			case 0: player.setPlayPosition(cardAmount);
				break;
			case 1: player.setPlayPosition(Main.getGc().getNearestPropInGroup(
						player.getPlayPosition(), cardAmount).getSpaceID());
				break;
			case 2: Main.getGc().bankPayPlayer(player, cardAmount);
				break;
			case 3: player.setHasGetOutCard(true);
				break;
			case 4: player.setPlayPosition(cardAmount);
				player.putInJail();
				break;
			case 5: Main.getGc().playerPayBank(player, cardAmount);
				break;
			case 6: Main.getGc().everyonePayPlayer(player, cardAmount);
				break;
			default:
				
		}
	}
	
	
}
