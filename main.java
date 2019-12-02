package Final_Project;

import java.util.HashMap;
import java.util.Map;

public class main {

    static GamePlayGUI gamePlayGUI;
    //create database
    public static void main(String[] args) {
        String databaseURI = Database.dbURI;

        Map<String, String> playerData = new HashMap<>();

        GamePlayGUI gui = new GamePlayGUI(playerData);


    }

}
