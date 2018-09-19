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
    private double playBalance;
    /**Determines whether or not the player is in play.
     * Set to false if they aren't active from the start
     * or if they lose the game.*/
    private boolean inPlay;

    public Player(String playName, int playID, double playBalance, boolean inPlay) {
        this.playName = playName;
        this.playID = playID;
        this.playBalance = playBalance;
        this.inPlay = inPlay;
    }

    public Player() {
        playName = "";
        playID = 0;
        playBalance = 0.00;
        inPlay = false;
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

    public double getPlayBalance() {
        return playBalance;
    }

    public void setPlayBalance(double playBalance) {
        this.playBalance = playBalance;
    }

    public boolean isInPlay() {
        return inPlay;
    }

    public void setInPlay(boolean inPlay) {
        this.inPlay = inPlay;
    }

    public void addBalance(double amount) {
        playBalance += amount;
    }

    public void subtractBalance(double amount) {
        playBalance -= amount;
    }
}
