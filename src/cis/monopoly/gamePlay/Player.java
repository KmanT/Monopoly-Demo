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
    /**Identifies the player clor/icon.*/
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
    public Player(String playName, int playID, int playBalance,
                  boolean inPlay, int playPosition, int playPieceID) {
        this.playName = playName;
        this.playID = playID;
        this.playBalance = playBalance;
        this.inPlay = inPlay;
        this.playPosition = playPosition;
        this.playPieceID = playPieceID;
    }

    /**
     * Constructor to use only when the player's name and ID are available
     * @param playName The name of the player. Will be used to identify each
     *                 player outside of the system.
     * @param playID The identifying value used in the GameController class
     */
    public Player(String playName, int playID) {
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
    public Player(int playID, boolean inPlay, int playPieceID) {
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

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public int getPlayID() {
        return playID;
    }

    public void setPlayID(int playID) {
        this.playID = playID;
    }

    public int getPlayBalance() {
        return playBalance;
    }

    public void setPlayBalance(int playBalance) {
        this.playBalance = playBalance;
    }

    public boolean isInPlay() {
        return inPlay;
    }

    public void setInPlay(boolean inPlay) {
        this.inPlay = inPlay;
    }

    public int getPlayPosition() {
        return playPosition;
    }

    public void setPlayPosition(int playPosition) {
        this.playPosition = playPosition;
    }

    public void movePlayerPosition(int boardLength, int roll) {
        int newPos = playPosition + roll;
        if (newPos > boardLength) {
            playPosition = newPos - boardLength;
        } else {
            playPosition = newPos;
        }
    }

    public int getPlayPieceID() {
        return playPieceID;
    }

    public void setPlayPieceID(int playPieceID) {
        this.playPieceID = playPieceID;
    }

    public void addBalance(int amount) {
        playBalance += amount;
    }

    public void subtractBalance(int amount) {
        playBalance -= amount;
    }

}
