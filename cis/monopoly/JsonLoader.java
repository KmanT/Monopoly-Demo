package cis.monopoly;

import cis.monopoly.gamePlay.Player;
import cis.monopoly.gamePlay.Space;
import cis.monopoly.guiElements.AlertBox;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonLoader {

    static String newGameFile = "cis/monopoly/new_game.json";

    public void JsonLoader() {

    }

    public static void printPlayer() {
        ObjectMapper objMapper = new ObjectMapper();

        try {
            /*
            List<Player> players = objMapper.readValue(new File(newGameFile),
                    new TypeReference<List<Player>>(){});
            System.out.print(players);
            */
            List<Player> players = Arrays.asList(objMapper.readValue(new File(newGameFile), Player[].class));
            System.out.print(players);

        } catch (IOException e) {
            AlertBox.display("IOException", "There was an error");
        }


    }

    public void loadPlayer(Player player, int id) {

        ObjectMapper objMapper = new ObjectMapper();
        try {
            player = objMapper.readValue(new File("new_game.json"), Player.class);
        } catch (Exception e) {
            AlertBox.display("JSON File Exception", "There was an error" +
                    "with your JSON file (doesn't exist or corrupted).");
        }

    }

    public void savePlayer(Player player) {
        //String
    }

    public void loadSpace(Space space) {

    }

}
