package cis.monopoly.gamePlay;

import cis.monopoly.Main;

/**<h1>CommunityChestCard</h1>
* This class is used to define the Community Chest cards. These cards either
* give or take money from the player. This is represented by the boolean
* "getMoney."
 * 
 */
public class CommunityChestCard extends Card {
	
	/**Determines whether or not the player will get or give money.*/
	private boolean getMoney;
	
	/**The amount of money given/taken.*/
	private int cardAmount;
	
	/**
	 * Default CommunityChestCard constructor.
	 */
	public CommunityChestCard() {
		super(0, "");
		getMoney = true;
		cardAmount = 0;
	}
	
	/**
	 * The constructor that is used for card creation.
	 * @param iD The ID for the community chest card.
	 * @param text The text that will be displayed on the card
	 * @param getMoney Determines whether the player pays or not.
	 * @param cardAmount The amount of money given/recieved.
	 */
	public CommunityChestCard(final int iD, final String text, 
			final boolean getMoney, final int cardAmount) {
		super(iD, text);
		this.getMoney = getMoney;
		this.cardAmount = cardAmount;
	}

	/**
	 * Used for seeing whether player gets or receives money from the bank.
	 * @return True if they get money, false if they give money.
	 */
	public boolean isGetMoney() {
		return getMoney;
	}

	/**
	 * Gets the amount listed on the card.
	 * @return The amount of money given/taken.
	 */
	public int getCardAmount() {
		return cardAmount;
	}
	
	/**
	 * Applies the card condition to the player who has received the
	 * community chest card.
	 * @param player The player who got the card.
	 */
	public void applyCondition(final Player player) {
		
		if (getMoney) {
			Main.getGc().bankPayPlayer(player,
					cardAmount);				
		} else {
			Main.getGc().playerPayBank(player,
					cardAmount);
		}
	}

	
	
}
