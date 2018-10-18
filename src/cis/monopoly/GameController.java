package cis.monopoly;

public class GameController {

    private static Player player1;
    private static Player player2;
    private static Player player3;
    private static Player player4;

    private static GameDice dice;
    public static final int MAX_SPACES = 40;

    public static int bank;

    public static Property[] properties;

    public GameController() {
        player1 = new Player(1,true);
        player2 = new Player(2, true);
        player3 = new Player(3, true);
        player4 = new Player(4, true);

        bank = 20580;

        properties = new Property[40];
        dice = new GameDice();

    }

    public static void runPlayerTurn() {

    }

    public static Player getPlayer1() {
        return player1;
    }

    public static Player getPlayer2() {
        return  player2;
    }

    public static Player getPlayer3() {
        return player3;
    }

    public static Player getPlayer4() {
        return player4;
    }

    public static void movePlayer(Player p, int roll) {
        if (p.getPlayPosition() + roll > MAX_SPACES) {
            p.setPlayPosition(p.getPlayPosition() + roll - MAX_SPACES);
        } else {
            p.setPlayPosition(p.getPlayPosition() + roll);
        }
    }

    public static GameDice getDice() {
        return dice;
    }

    public static void addBankFunds(int ammount) {
        bank += ammount;
    }

    public static int getBankFunds() {
        return bank;
    }

}
