package Final_Project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Map;

public class GamePlayGUI extends JFrame {

    private JPanel mainPanel;
    //word entry components
    private JButton enterWordButton;
    private JTextField enterWordTextBox;

    //components that use dictionary API
    private JButton dictionaryButton;
    private JTextField dictionaryTextBox;
    private JButton challengeButton;

    //components for displaying data
    //private JList<scoreObject> playerNameList;
    //private JList PlayerScoreList;
    private JTable playerTable;

    //quit function
    private JButton finishButton;

    private Controller controller;

    private DefaultListModel<scoreObject> PlayerScoreModel;
    DefaultTableModel tableModel = new DefaultTableModel();
    GamePlayGUI(Map<String, String> playerData) {



        tableModel.addColumn("Player Name");
        tableModel.addColumn("Current Score");

        //add the initial data
        for (String data : playerData.keySet()) {
            tableModel.addRow(new String[]{data, playerData.get(data)});
        }
        playerTable.setModel(tableModel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setVisible(true);

        buttonListeners();
        addPlayers();
    }

        public void addPlayers(){
        String playerNum = showInputDialog("Enter number of players");
        int convertedNum = Integer.parseInt(playerNum);
        for (int x = 1; x < convertedNum+1; x++){
            String playerName = showInputDialog("Enter player #"+x+"'s name");
            String[] newTableRow = {playerName, "0"};
            tableModel.addRow(newTableRow);
        }
        }
        public void buttonListeners(){

        }

    protected String showInputDialog(String question) {
        return JOptionPane.showInputDialog(this, question);
    }

}
