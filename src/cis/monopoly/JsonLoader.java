package cis.monopoly;

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

    public void loadPlayer(Player player) {
        ObjectMapper objMapper = new ObjectMapper();
    }

    public void loadSpace(Space space) {

    }

}
