package cis.monopoly.gamePlay;

/**
 * This class defines a player. The playerID is the "key attribute" when
 * defining a player. Players should not share a playerID, otherwise it will
 * break the game. The balance is obviously what the player owns. The
 * playPieceID is what determines the player color, however, it will soon
 * identify each id with a related icon.
 *
 * @author Kyle Turske
 * @version 0.5
 */
public class Player {

    /**The name of the player.*/
    private String playName;
    /**The identifying factor for each player.*/
    private int playID;
    /**How much money the player has.*/
    private int playBalance;
    /**Whether the player is in the game.*/
    private boolean inPlay;
    /**The current position of the player.*/
    private int playPosition;
    /**Identifies the player color/icon.*/
    private int playPieceID;
    /**How much money each player starts with.*/
    private static final int START_BALANCE = 1500;

    /**
     * Base player constructor.
     * @param playName The name of the player. Will be used to identify each
     *                 player outside of the system.
     * @param playID The identifying value used in the GameController class
     * @param playBalance How much money is owned by the player
     * @param inPlay Determined whether or not this player is still in play. Set
     *               to false if this player was never in play or when they
     *               "lose." Losing conditions to be set for the next release.
     * @param playPosition Where the player is on the board.
     * @param playPieceID Used to determine the color of the piece on the board
     */
    public Player(final String playName, final int playID,
    		final int playBalance, final boolean inPlay,
    		final int playPosition, final int playPieceID) {
        this.playName = playName;
        this.playID = playID;
        this.playBalance = playBalance;
        this.inPlay = inPlay;
        this.playPosition = playPosition;
        this.playPieceID = playPieceID;
    }

    /**
     * Constructor to use only when the player's name and ID are available.
     * @param playName The name of the player. Will be used to identify each
     *                 player outside of the system.
     * @param playID The identifying value used in the GameController class
     */
    public Player(final String playName, final int playID) {
        this.playName = playName;
        this.playID = playID;
        playBalance = START_BALANCE;
        inPlay = true;
        playPosition = 0;
        playPieceID = 0;
    }

    /**
     * Constructor to use only when the player's ID, whether they are in play,
     * and pieceID are available.
     * @param playID The identifying value used in the GameController class
     * @param inPlay Determined whether or not this player is still in play. Set
     *               to false if this player was never in play or when they
     *               "lose." Losing conditions to be set for the next release.
     * @param playPieceID Used to determine the color of the piece on the board
     */
    public Player(final int playID, final boolean inPlay,
    		final int playPieceID) {
        playName = "";
        this.playID = playID;
        playBalance = START_BALANCE;
        this.inPlay = inPlay;
        playPosition = 0;
        this.playPieceID = playPieceID;
    }

    /**
     * Sets all the Player attributes to default values.
     */
    public Player() {
        playName = "";
        playID = 0;
        playBalance = START_BALANCE;
        inPlay = false;
        playPosition = 0;
        playPieceID = 0;
    }

    /**
     * Gives the name of the player.
     * @return playName The player's name
     */
    public String getPlayName() {
        return playName;
    }

    /**
     * Sets the name of the player.
     * @param playName The player's name
     */
    public void setPlayName(final String playName) {
        this.playName = playName;
    }

    /**
     * Gives the player's ID.
     * @return playID The player's ID
     */
    public int getPlayID() {
        return playID;
    }

    /**
     * Changes the player ID for whatever reason. May not need this
     * @param playID Player ID
     */
    public void setPlayID(final int playID) {
        this.playID = playID;
    }
    /**
     * Get's the player's balance.
     * @return the player's balance
     */
    public int getPlayBalance() {
        return playBalance;
    }
    
    /**
     * Set's the balance for the player.
     * @param playBalance The player's balance
     */
    public void setPlayBalance(final int playBalance) {
        this.playBalance = playBalance;
    }
    
    /**
     * Check's if the player is in play.
     * @return If they are in play true; if not false.
     */
    public boolean isInPlay() {
        return inPlay;
    }
    
    /**
     * Changes the player's inPlay status meaning if they are in play or not.
     * @param inPlay true or false
     */
    public void setInPlay(final boolean inPlay) {
        this.inPlay = inPlay;
    }
    
    /**
     * Gets the player's current position.
     * @return The player's position.
     */
    public int getPlayPosition() {
        return playPosition;
    }
    
    /**
     * Changes the position of the player.
     * @param playPosition the new position.
     */
    public void setPlayPosition(final int playPosition) {
        this.playPosition = playPosition;
    }
    
    /**
     * Moves the player's position within the GameController.
     * @param boardLength The max number of spaces (40)
     * @param roll The number of spaces to move.
     */
    public void movePlayerPosition(final int boardLength, final int roll) {
        int newPos = playPosition + roll;
        if (newPos > boardLength) {
            playPosition = newPos - boardLength;
        } else {
            playPosition = newPos;
        }
    }
    
    /**
     * Get's the player's pieceID.
     * @return The pieceID
     */
    public int getPlayPieceID() {
        return playPieceID;
    }
    
    /**
     * Changes the player's pieceID.
     * @param playPieceID the new pieceID
     */
    public void setPlayPieceID(final int playPieceID) {
        this.playPieceID = playPieceID;
    }
    
    /**
     * Adds money to the player's balance.
     * @param amount The amount to be added to the player's account
     */
    public void addBalance(final int amount) {
        playBalance += amount;
    }
    
    /**
     * Takes money from the player's balance.
     * @param amount The amount of money to be taken from the player.
     */
    public void subtractBalance(final int amount) {
        playBalance -= amount;
    }

}
