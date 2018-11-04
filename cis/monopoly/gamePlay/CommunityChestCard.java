package cis.monopoly.gamePlay;

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

	
	
}
