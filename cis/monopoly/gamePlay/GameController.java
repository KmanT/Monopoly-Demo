package cis.monopoly.gamePlay;


import cis.monopoly.guiElements.AlertBox;
import cis.monopoly.guiElements.ChanceBox;
import cis.monopoly.guiElements.CommunityBox;
import cis.monopoly.guiElements.ConfirmBox;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>GameController</h1>
 * This class controls all of the different values within the game.
 * This includes all the players, the spaces/properties, and the bank.
 * This class defines how players move throughout the board, make
 * transactions with the bank and other players
 *
 * @author Kyle Turske
 * @version 0.5
 */

public class GameController {

    /**First player.*/
    private Player player1;
    /**Second player.*/
    private Player player2;
    /**Third player.*/
    private Player player3;
    /**Fourth player.*/
    private Player player4;
    /**List that contains all the players.*/
    private  List<Player> playerList;
    /**List that contains all the spaces and properties.*/
    private  List<Property> propertyList;
    /**Stores the value for the current player.*/
    private int currentPlayer;
    /**Used for piece moving calculations.*/
    private GameDice dice;
    /**Total balance for the bank.*/
    private int bank;
    /**Total number of spaces. Used for checking potential overflows.*/
    public static final int MAX_SPACES = 40;
    /**The amount added to the player balance when they pass "Go".*/
    public static final int PASS_GO = 200;
    /**Starting amount for the bank.*/
    public static final int BANK_START_AMOUNT = 20580;

    /**
     * GameController constructor. Holds all the different values needed in
     * order to run the game properly.
     */
    public GameController() {
        player1 = new Player(1, true, 1);
        player2 = new Player(2, true, 2);
        player3 = new Player(3, true, 3);
        player4 = new Player(4, true, 4);
        playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        bank = BANK_START_AMOUNT;

        propertyList = new ArrayList<>();
        /*
            Will eventually load the space object through the JSON loader
            For now, just creating the space objects
         */

        //PROPERTIES//
        //(Name, propID, propPrice, propRent, propGroup, propOwnerID)
        propertyList.add(new Property("GO LAKERS", 0, 0, 0, 0, -1));
        propertyList.add(new Property("Freshman Land", 1, 60, 2, 1));
        propertyList.add(new Property("Community Chest", 2, 0, 0, 11, -1));
        propertyList.add(new Property("Kleiner Commons", 3, 60, 4, 1));
        propertyList.add(new Property("Tuition", 4, 0, 0, 13, -1));
        propertyList.add(new Property("Route 37", 5, 200, 25, 10));
        propertyList.add(new Property("Ravine Center", 6, 100, 6, 2));
        propertyList.add(new Property("Chance", 7, 0, 0, 12, -1));
        propertyList.add(new Property("The Commons", 8, 100, 6, 2));
        propertyList.add(new Property("Campus Saftey Center", 9, 120, 8, 2));
        propertyList.add(new Property("GVPD", 10, 0, 0, 0, -1));
        propertyList.add(new Property("Holton-Hooker", 11, 140, 10, 3));
        propertyList.add(new Property("GVSU Solar Garden", 12, 150, 40, 9));
        propertyList.add(new Property("Mackinac Hall", 13, 140, 10, 3));
        propertyList.add(new Property("Great Lakes Plaza", 14, 160, 12, 3));
        propertyList.add(new Property("Route 48", 15, 200, 25, 10));
        propertyList.add(new Property("Kindschi Hall", 16, 180, 14, 4));
        propertyList.add(new Property("Community Chest", 17, 0, 0, 11, -1));
        propertyList.add(new Property("The Marketplace", 18, 180, 14, 4));
        propertyList.add(new Property("Padnos Hall", 19, 200, 16, 4));
        propertyList.add(new Property("Student Parking", 20, 0, 0, 0, -1));
        propertyList.add(new Property(
        		"Grand Valley Apartments", 21, 220, 18, 5));
        propertyList.add(new Property("Chance", 22, 0, 0, 12, -1));
        propertyList.add(new Property("The Connection", 23, 220, 18, 5));
        propertyList.add(new Property("Laker Village", 24, 240, 20, 5));
        propertyList.add(new Property("Route 50", 25, 200, 25, 10));
        propertyList.add(new Property("Zumberge Pond", 26, 260, 22, 6));
        propertyList.add(new Property("Little Mac Bridge", 27, 260, 22, 6));
        propertyList.add(new Property("GVSU Water Tower", 28, 150, 40, 9));
        propertyList.add(new Property("Arboretum Trail", 29, 280, 24, 6));
        propertyList.add(new Property("GO TO GVPD", 30, 0, 0, 0, -1));
        propertyList.add(new Property("The Fieldhouse", 31, 300, 26, 7));
        propertyList.add(new Property("Kirkhoff Center", 32, 300, 26, 7));
        propertyList.add(new Property("Community Chest", 33, 0, 0, 11, -1));
        propertyList.add(new Property(
        		"Mary Idema Pew Library", 34, 320, 28, 7));
        propertyList.add(new Property("Route 85", 35, 200, 25, 10));
        propertyList.add(new Property("Chance", 36, 0, 0, 12, -1));
        propertyList.add(new Property("Cook Carillon Tower", 37, 350, 35, 8));
        propertyList.add(new Property("Rent", 38, 0, 0, 14, -1));
        propertyList.add(new Property("Lubbers Stadium", 39, 350, 35, 8));

        //DICE//
        dice = new GameDice();

        //Sets the current player to playerID 1//
        currentPlayer = 1;

    }

    /**
     * Utilized to complete a player turn. Calls the methods movePlayer,
     * spaceCheck, and changeCurrentPlayer.
     * @param roll Dice roll
     * @param player Player
     */
    public void runPlayerTurn(final int roll, final Player player) {
        movePlayer(player, roll);
        spaceCheck();
        changeCurrentPlayer();
    }

    /**
     * Changes the Player's position value.
     * If the player's position plus the roll go over the max amount
     * of spaces, then the value will rollover back to zero and continue.
     * Otherwise, this method just adds the roll amount to the current
     * player position
     * @param p Player
     * @param roll Dice roll
     */
    public void movePlayer(final Player p, final int roll) {
        if (p.getPlayPosition() + roll > MAX_SPACES - 1) {
            p.setPlayPosition(p.getPlayPosition() + roll - MAX_SPACES);
            bankPayPlayer(p, PASS_GO);
        } else {
            p.setPlayPosition(p.getPlayPosition() + roll);
        }
    }

    /**
     * Used by the GamePlayScene to get the dice attributes in order
     * to draw the dice properly.
     * @return dice
     */
    public GameDice getDice() {
        return dice;
    }

    /**
     * The amount given is subtracted from the player's balance whilst
     * that same amount is given to the bank.
     * @param p Player
     * @param amount Amount for transaction
     */
    public void playerPayBank(final Player p, final int amount) {
        p.subtractBalance(amount);
        bank += amount;
    }

    /**
     * The amount given is added to the player's balance whilst
     * that same amount is taken from the bank.
     * @param p Player
     * @param amount Amount for transaction
     */
    public void bankPayPlayer(final Player p, final int amount) {
        p.addBalance(amount);
        bank -= amount;
    }

    /**
     * The amount given is subtracted from the first player's balance, whilst
     * the amount given is added to the second player's balance.
     * @param p1 Player giving funds
     * @param p2 Player getting funds
     * @param amount Amount for transaction
     */
    public static void transferPlayerFunds(final Player p1, final Player p2,
    		final int amount) {
        p1.subtractBalance(amount);
        p2.addBalance(amount);
    }

    /**
     * This method calls the payPayBank method and then sets the ownerId of the
     * property to the player's ID. The price of the property will be cut in
     * half since that players get half of what they paid back if they sell it
     * to the bank.
     * @param player Player
     * @param prop Property for sale
     */
    public void playerBuyProperty(final Player player, final Property prop) {
        playerPayBank(player, prop.getPropPrice());
        prop.setPropOwnerID(player.getPlayID());
        prop.setPropPrice(prop.getPropPrice() / 2); //cuts the price in half
    }

    /**
     * This method calls bankPayPlayer which the bank gives whatever the price
     * of the property is, then the property owner ID is then set to 0 for
     * resale.
     * @param player Player
     * @param prop Property being sold back
     */
    public void playerSellProperty(final Player player, final Property prop) {
        bankPayPlayer(player, prop.getPropPrice());
        prop.setPropOwnerID(0);
        prop.setPropPrice(prop.getPropPrice() * 2);
    }

    /**
     * This method will search through the list of players in order to find the
     * player that shares an id with the "currentPlayer" value.
     * @return player Current Player
     */
    public Player getCurrentPlayer() {
        for (Player player : playerList) {
            if (player.getPlayID() == currentPlayer) {
            	return player;
            }                
        }
        return null;
    }

    /**
     * This method will search through the list of players in order to get the
     * player that has id that matches the given value.
     * @param iD playID
     * @return player Player's ID who matches the given
     *
     */
    public Player getSpecificPlayer(final int iD) {
        for (Player player : playerList) {
            if (player.getPlayID() == iD) {
                return player;
            }
        }
        return null;
    }

    /**
     * Searches through the list of properties, and if the property owner ID
     * matches the current player's ID, then that property will be returned.
     * @return prop Property where the currentPlayer is.
     */
    public Property getCurrentPlayerPosition() {
        Player p = getCurrentPlayer();

        for (Property prop : propertyList) {
            if (prop.getSpaceID() == p.getPlayPosition()) {
            	return prop;
            }
        }
        return null;
    }
    
    /**
     * Searches through the list of properties for a specific property.
     * @param propID The id of the desired property
     * @return The property if it is found, and null if it is not.
     */
    public Property getSpecificProperty(final int propID) {
    	for (Property prop : propertyList) {
            if (prop.getSpaceID() == propID) {
            	return prop;
            }
        }
        return null;
    }

    /**
     * This method is part of the player turn. Gets the current player and the
     * current player's position. If the space has no owner and is up for
     * purchase (ownerID = 0), then the buyProperty method will be called. If
     * the property's ownerID isn't equal to negative one, zero, or the the
     * current player's ID, then rent will be payed to the owner of that
     * property.
     *
     * More will be added to this method
     */
    public void spaceCheck() {
        Player player = getCurrentPlayer();
        Property prop = getCurrentPlayerPosition();

        if (prop.getPropOwnerID() == 0) {
            buyProperty(player, prop);
        } else if (prop.getPropOwnerID() != player.getPlayID()
                && prop.getPropOwnerID() != -1
                && prop.getPropOwnerID() != 0) {
            
        	//if property has shared owner in group
        	
        	
        	//if group is Bus Routes
        	
        	//if group is Utilities
        	
        	transferPlayerFunds(player,
                    getSpecificPlayer(prop.getPropOwnerID()),
                    prop.getPropRent());
        	
        } else if (prop.getPropGroup() == 11) {
        	CommunityBox.display("BottomText", true, 500);
        } else if (prop.getPropGroup() == 12) {
        	ChanceBox.display("BottomText", 1, 500, this);
        } else if (prop.getSpaceID() == 30) {
        	playerGoToJail(player);
        } else if (prop.getSpaceID() == 4) {
        	AlertBox.display("Tuition", "Tuition is due! \n Pay $200.");
        	playerPayBank(player, 200);
        } else if (prop.getSpaceID() == 38) {
        	AlertBox.display("Rent",
        			"Rent for the month is due! \n Pay $100.");
        	playerPayBank(player, 100);
        }
        
        //group for Chance
        
        //group for Community Chest
        
        //space is luxury tax
        
        //space is other tax
    }
    
    /**
     * Counts the number of properties that a property in a group has a shared
     * owner. Used inside the propertyRentMultiplier method.
     * @param spaceID The ID of the space the player has landed on.
     */
    public boolean propSharedOwnerCount(int spaceID) {
    	Property playerProperty = getSpecificProperty(spaceID);
    	
    	List<Property> propGroupList = new ArrayList<>();
    	
    	for (Property prop : propertyList) {
            if (prop.getPropGroup() == playerProperty.getPropGroup()) {
            	propGroupList.add(prop);
            }
        }
    	
    	int sharedOwnerCount = 0;
    	
    	for (Property prop : propGroupList) {
    		if (prop.getPropOwnerID() == playerProperty.getPropOwnerID()) {
    			sharedOwnerCount++;
    		}
    	}
    	
        return sharedOwnerCount == propGroupList.size();
    	
    }
    

    /**
     * A dialogue box pops asking the player if they would like to purchase the
     * property. If the player clicks on "Yes" then the property's ownerID will
     * be set to the player's then the playerPayBank method will be called.
     * @param player Player who is purchasing the property
     * @param prop The property up for purchase
     */
    public void buyProperty(final Player player, final Property prop) {
        Boolean isBought = ConfirmBox.display("Buy Property",
                "Would you like to buy "
                        + prop.getSpaceName() + " for $"
                        + Integer.toString(prop.getPropPrice()) + "?");

        if (isBought) {
            playerPayBank(player, prop.getPropPrice());
            prop.setPropOwnerID(player.getPlayID());
        }
    }

    /**
     * This method will apply the effects of any given Community Chest card to
     * the given player.
     */
    public void drawCommunityCard() {

    }

    /**
     * This method will apply the effects of any given Chance card to the given
     * player.
     */
    public void drawChanceCard() {

    }

    /**
     * This method changes the currentPlayer value in this class. If the
     * addition will roll-over the the total number of players, then the current
     * player will be changed to player 1. If that next player is in jail, then
     * their sentence will be lowered and the method will be called again.
     */
    public void changeCurrentPlayer() {
        if (currentPlayer + 1 > playerList.size()) {
            currentPlayer = 1;
        } else {
            currentPlayer += 1;
        }
        
        if (getCurrentPlayer().getInJailCount() > 0) {
        	AlertBox.display("In Jail", "Player " 
    			+ getCurrentPlayer().getPlayID() + " has "
    			+ getCurrentPlayer().getInJailCount()
    			+ " turns left in jail!");
        	getCurrentPlayer().lowerInJail();
        	changeCurrentPlayer();
        }
    }

    /**
     * Give the bank funds. Used to update the bank label on the GamePlayScene
     * class.
     * @return bank Bank Balance
     */
    public int getBankFunds() {
        return bank;
    }
    
    /**
     * When the player lands on the "GO TO JAIL" space, they will be sent to the
     * jail space and their inJailCount will be set to three.
     * @param player The current player being placed in jail.
     */
    public void playerGoToJail(final Player player) {
    	player.setPlayPosition(10);
    	player.putInJail();
    }

}
