package cis.monopoly;

/**
 * This class defines a player.
 *
 * @author Kyle Turske
 * @version 0.1
 */
public class Player {

    /**Identfies the name of the player.*/
    private String playName;
    /**Used to set the order of the players.*/
    private int playID;
    /**Total balance for each player.
     * Starts with $1500 and loses when balance <= 0.*/
    private int playBalance;
    /**Determines whether or not the player is in play.
     * Set to false if they aren't active from the start
     * or if they lose the game.*/
    private boolean inPlay;

    private int playPosition;

    private int playPieceID;

    private static int START_BALANCE = 1500;



    public Player(String playName, int playID, int playBalance,
                  boolean inPlay, int playPosition, int playPieceID) {
        this.playName = playName;
        this.playID = playID;
        this.playBalance = playBalance;
        this.inPlay = inPlay;
        this.playPosition = playPosition;
        this.playPieceID = playPieceID;
    }

    public Player(String playName, int playID) {
        this.playName = playName;
        this.playID = playID;
        playBalance = START_BALANCE;
        inPlay = true;
        playPosition = 0;
        playPieceID = 0;
    }

    public Player(int playID, boolean inPlay) {
        playName = "";
        this.playID = playID;
        playBalance = START_BALANCE;
        this.inPlay = inPlay;
        playPosition = 0;
        playPieceID = 0;
    }

    public Player(int playID) {
        playName = "";
        this.playID = playID;
        playBalance = START_BALANCE;
        inPlay = false;
        playPosition = 0;
        playPieceID = 0;
    }

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

    public void addBalance(double amount) {
        playBalance += amount;
    }

    public void subtractBalance(double amount) {
        playBalance -= amount;
    }
}
