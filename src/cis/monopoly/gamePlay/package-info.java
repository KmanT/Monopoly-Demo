/**<h1>gamePlay</h1>
 * This package includes all of the different classes that 
 * control the logic of the monopoly game, the players, properties
 * and spaces in the monopoly game.
 */ 

package cis.monopoly.gamePlay;

/**
 * <h2>GameController</h2>
 * This is the class that does the actual logic of the monopoly game.
 * It receives the dice values, moves the player to that position on 
 * the board. Confirms if the player would buy properties or not and 
 * determines the winner of the game.
 * 
 * <h2>GameDice</h2>
 * This is the class that rolls the two dice, and gets the total value. The
 * GameController access this class.
 * 
 * <h2>Player</h2>
 * This is the class that defines a player in the game, including their ID.
 * 
 * <h2>Space</h2>
 * This is the class defines a space on the monopoly board. Used as the base
 * class for the Property class.
 * 
 * <h2>Property</h2>
 * This is the class that defines the properties on the monopoly board. 
 * In this case, most of the properties are named based on buildings in 
 * Grand Valley.
 * 
 * <h2>Card</h2>
 * This is an abstract class where the CommunityChestCard and ChanceCard
 * classes inherit their attributes
 * 
 * <h2>ChanceCard</h2>
 * This is the class that defines a chance card in which its conditions will be
 * applied to the player that lands on the space.
 * 
 * <h2>CommunityChestCard</h2>
 * This is the class that defines a community chest card in which its
 * conditions will be applied to the player that lands on the space.
 * 
 * @version 0.6
 * @author Kyle Turske
 */
