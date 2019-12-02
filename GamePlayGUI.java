package Final_Project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

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
    private JLabel playerTurnLabel;

    private Controller controller;

    //private DefaultListModel<scoreObject> PlayerScoreModel;
    DefaultTableModel tableModel = new DefaultTableModel();
    List<String> playerTurnList = new ArrayList();

    public int turnCounter =0;



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
        playerTurnLabel.setText(playerTurnList.get(0)+"'s Turn");

    }

        public void addPlayers(){
        // ask for number of turns
        String playerNum = showInputDialog("Enter number of players");
        // convert to integer
        int convertedNum = Integer.parseInt(playerNum);
        // loop through number of players, ask player names, add to Jtablemodel and tracking list
        for (int x = 1; x < convertedNum+1; x++){
            String playerName = showInputDialog("Enter player #"+x+"'s name");
            String[] newTableRow = {playerName, "0"};
            tableModel.addRow(newTableRow);
            playerTurnList.add(playerName);
        }
        }
        //TODO get value from jtablemodel for current player's score and add new score from the textbox
        public void buttonListeners(){
            enterWordButton.addActionListener(event -> {
                String scoreString = enterWordTextBox.getText();
                int scoreInt = Integer.parseInt(scoreString);
         //TODO try again to pull data directly from jtable as an object and convert

//                Object currentObject = tableModel.getValueAt(turnCounter,1);
//                String current = (String) currentObject;
//                int addInt = Integer.parseInt(current);

                tableModel.setValueAt(scoreInt, turnCounter,1);
                if(turnCounter < playerTurnList.size()-1){
                    turnCounter += 1;
                    playerTurnLabel.setText(playerTurnList.get(turnCounter)+"'s turn");
                }else{
                    turnCounter = 0;
                    playerTurnLabel.setText(playerTurnList.get(turnCounter)+"'s turn");
                }

            });
        }

    protected String showInputDialog(String question) {
        return JOptionPane.showInputDialog(this, question);
    }

}
