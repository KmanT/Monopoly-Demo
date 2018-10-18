package cis.monopoly;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private static Player player1;
    private static Player player2;
    private static Player player3;
    private static Player player4;
    private static List<Player> playerList;
    private static int currentPlayer;

    private static GameDice dice;
    public static final int MAX_SPACES = 40;

    public static int bank;

    public static Property[] properties;

    public GameController() {
        player1 = new Player(1,true);
        player2 = new Player(2, true);
        player3 = new Player(3, true);
        player4 = new Player(4, true);
        playerList =new ArrayList<Player>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        bank = 20580;

        properties = new Property[40];
        dice = new GameDice();
        currentPlayer = 1;

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
        if (p.getPlayPosition() + roll > MAX_SPACES - 1) {
            p.setPlayPosition(p.getPlayPosition() + roll - MAX_SPACES);
        } else {
            p.setPlayPosition(p.getPlayPosition() + roll);
        }
    }

    public static GameDice getDice() {
        return dice;
    }

    public static void addBankFunds(int amount) {
        bank += amount;
    }

    public static void subtractBankFunds(int amount) { bank -= amount;}

    public static void playerPayBank(Player p, int amount) {
        p.subtractBalance(amount);
        bank += amount;
    }

    public static void bankPayPlayer(Player p, int amount) {
        p.addBalance(amount);
        bank -= amount;
    }

    public static void transferPlayerFunds(Player p1, Player p2, int amount) {
        p1.subtractBalance(amount);
        p2.addBalance(amount);
    }

    public static void playerBuyProperty(Player player, Property prop) {
        playerPayBank(player, prop.getPropPrice());
        prop.setPropOwnerID(player.getPlayID());
        prop.setPropPrice(prop.getPropPrice() / 2); //cuts the property price in half
    }

    public static void playerSellProperty(Player player, Property prop) {
        bankPayPlayer(player, prop.getPropPrice());
        prop.setPropOwnerID(0);
        prop.setPropPrice(prop.getPropPrice() * 2);
    }

    public static Player getCurrentPlayer() {
        /*
        for (int i = 0; i >= playerList.size(); i++) {
            if (playerList.get(i).getPlayID() == currentPlayer) {
                return playerList.get(i);
            }
        }
        return null;
        */

        for (Player player : playerList) {
            if (player.getPlayID() == currentPlayer)
                return player;
        }
        return null;
    }

    public static void changeCurrentPlayer() {
        if (currentPlayer + 1 > playerList.size()) {
            currentPlayer = 1;
        } else {
            currentPlayer += 1;
        }
    }

    public static int getBankFunds() {
        return bank;
    }

}
