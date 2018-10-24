package cis.monopoly.gamePlay;


import cis.monopoly.guiElements.ConfirmBox;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class GameController {

    private static Player player1;
    private static Player player2;
    private static Player player3;
    private static Player player4;
    private static List<Player> playerList;
    //private static TreeSet<Property> properties;
    private static List<Property> propertyList;
    private static int currentPlayer;

    private static GameDice dice;

    private static int bank;

    public static final int MAX_SPACES = 40;
    public static final int PASS_GO = 200;
    public static final int BANK_START_AMOUNT = 20580;

    public GameController() {
        player1 = new Player(1,true, 1);
        player2 = new Player(2, true, 2);
        player3 = new Player(3, true, 3);
        player4 = new Player(4, true, 4);
        playerList =new ArrayList<>();
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

        propertyList.add(new Property(
                "GO LAKERS", 0, 0, 0, 0, -1));
        propertyList.add(new Property(
                "Freshman Land", 1, 60, 2, 1));
        propertyList.add(new Property(
                "Community Chest", 2, 0, 0, 11, -1));
        propertyList.add(new Property(
                "Kleiner Commons", 3, 60, 4, 1));
        propertyList.add(new Property(
                "Income Tax", 4, 0, 0, 13, -1));
        propertyList.add(new Property(
                "Route 37", 5, 200, 25, 10));
        propertyList.add(new Property(
                "Ravine Center", 6, 100, 6, 2));
        propertyList.add(new Property(
                "Chance", 7, 0, 0, 12, -1));
        propertyList.add(new Property(
                "The Commons", 8, 100, 6, 2));
        propertyList.add(new Property(
                "Campus Saftey Center", 9, 120, 8, 2));
        propertyList.add(new Property(
                "GVPD", 10, 0, 0, 0, -1));
        propertyList.add(new Property(
                        "Holton-Hooker", 11, 140, 10, 3));
        propertyList.add(new Property(
                "GVSU Solar Garden", 12, 150, 40, 9));
        propertyList.add(new Property(
                "Mackinac Hall", 13, 140, 10, 3));
        propertyList.add(new Property(
                "Great Lakes Plaza", 14, 160, 12, 3));
        propertyList.add(new Property(
                "Route 48", 15, 200, 25, 10));
        propertyList.add(new Property(
                "Kindschi Hall", 16, 180, 14, 4));
        propertyList.add(new Property(
                "Community Chest", 17, 0, 0, 11, -1));
        propertyList.add(new Property(
                "The Marketplace", 18, 180, 14, 4));
        propertyList.add(new Property(
                "Padnos Hall", 19, 200, 16, 4));
        propertyList.add(new Property(
                "Student Parking", 20, 0, 0, 0, -1));
        propertyList.add(new Property(
                "Grand Valley Apartments", 21, 220, 18, 5));
        propertyList.add(new Property(
                "Chance", 22, 0, 0, 12, -1));
        propertyList.add(new Property(
                "The Connection", 23, 220, 18, 5));
        propertyList.add(new Property(
                "Laker Village", 24, 240, 20, 5));
        propertyList.add(new Property(
                "Route 50", 25, 200, 25, 10));
        propertyList.add(new Property(
                "Zumberge Pond", 26, 260, 22, 6));
        propertyList.add(new Property(
                "Little Mac Bridge", 27, 260, 22, 6));
        propertyList.add(new Property(
                "GVSU Water Tower", 28, 150, 40, 9));
        propertyList.add(new Property(
                "Little Mac Bridge", 29, 280, 24, 6));
        propertyList.add(new Property(
                "GO TO GVPD", 30, 0, 0, 0, -1));
        propertyList.add(new Property(
                "The Fieldhouse", 31, 300, 26, 7));
        propertyList.add(new Property(
                "Kirkhoff Center", 32, 300, 26, 7));
        propertyList.add(new Property(
                "Community Chest", 33, 0, 0, 11, -1));
        propertyList.add(new Property(
                "Mary Idema Pew Library", 34, 320, 28, 7));
        propertyList.add(new Property(
                "Route 85", 35, 200, 25, 10));
        propertyList.add(new Property(
                "Chance", 36, 0, 0, 12, -1));
        propertyList.add(new Property(
                "Cook Carillon Tower", 37, 350, 35, 8));
        propertyList.add(new Property(
                "Tuition", 38, 0, 0, 14, -1));
        propertyList.add(new Property(
                "Lubbers Stadium", 37, 350, 35, 8));

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
            bankPayPlayer(p, PASS_GO);
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
        for (Player player : playerList) {
            if (player.getPlayID() == currentPlayer)
                return player;
        }
        return null;
    }

    public static Player getSpecificPlayer(int ID) {
        for (Player player : playerList) {
            if (player.getPlayID() == ID)
                return player;
        }
        return null;
    }

    public static Property getCurrentPlayerPosition() {
        Player p = getCurrentPlayer();

        for (Property prop : propertyList) {
            if (prop.spaceID == p.getPlayPosition()) return prop;
        }
        return null;
    }

    public static void spaceCheck() {
        Player player = getCurrentPlayer();
        Property prop = getCurrentPlayerPosition();

        if (prop.getPropOwnerID() == 0) {
            buyProperty(player, prop);
        } else if (prop.getPropOwnerID() != player.getPlayID()
                && prop.getPropOwnerID() != -1
                && prop.getPropOwnerID() != 0) {
            transferPlayerFunds(player,
                    getSpecificPlayer(prop.getPropOwnerID()),
                    prop.getPropRent());
        }
    }

    public static void buyProperty(Player player, Property prop) {
        Boolean isBought = ConfirmBox.display("Buy Property",
                "Would you like to buy " +
                prop.getSpaceName() + " for $" +
                Integer.toString(prop.getPropPrice()) + "?");

        if (isBought == true) {
            playerPayBank(player, prop.getPropPrice());
            prop.setPropOwnerID(player.getPlayID());
        }
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
