package srcpackage;

public class Player {

    private String playName;
    private int playID;
    private double playBalance;

    public Player (String playName, int playID, double playBalance) {
        this.playName = playName;
        this.playID = playID;
        this.playBalance = playBalance;
    }

    public Player () {
        playName = "";
        playID = 0;
        playBalance = 0.00;
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

    public void addBalance(double amount) {
        playBalance += amount;
    }

    public void subtractBalance(double amount) {
        playBalance -= amount;
    }
}
