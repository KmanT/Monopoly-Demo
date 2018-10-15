package cis.monopoly;

public class GameController {

    public static Player player1;
    public static Player player2;
    public static Player player3;
    public static Player player4;

    public static int bank;

    public static Property[] properties;

    public GameController() {
        player1 = new Player(1,true);
        player2 = new Player(2, true);
        player3 = new Player(3, true);
        player4 = new Player(4, true);

        bank = 20580;

        properties = new Property[40];

    }

    public static void runPlayerTurn() {

    }

}
