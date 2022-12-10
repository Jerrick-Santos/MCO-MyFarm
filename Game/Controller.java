/**
 * The controller class is where the logic (model) and GUI (view) elements are used. The class also handles the
 * different event driven actions (i.e., when a button is clicked).
 */
package Game;

import Game.Model.PlayerMechanics.Player;
import Game.Model.Tools.*;
import Game.View.MyFarmGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private Tool PlowTool;
    private Tool WaterCan;
    private Tool FertilizerTool;
    private Tool Pickaxe;
    private Tool Shovel;
    private Player player;
    private MyFarmGUI mainGUI;
    private int row;
    private int col;

    /**
     * PlayerMechanics constructor
     */
    public Controller() {
        PlowTool = new PlowTool("PlowTool", 0, 0.5);
        WaterCan = new WaterCan("WaterCan", 0, 0.5);
        FertilizerTool = new FertilizerTool("FertilizerTool", 10, 4);
        Pickaxe = new Pickaxe("Pickaxe", 50, 15);
        Shovel = new Shovel("Shovel", 7, 2);
        player = new Player(WaterCan, FertilizerTool, PlowTool, Pickaxe, Shovel);
        mainGUI = new MyFarmGUI();
        updateView();
        row = 0;
        col = 0;
        updateTileInfo(0, 0);
        mainGUI.setActionListener(this);
        mainGUI.changeToolButtonColor(0,player.getSelectedTool());
    }

    /**
     * Checks if the game will restart or terminate based on game conditions on model. The user is given an
     * option to end the game or to restart by utilizing a JOptionPane and methods from the Player class in model
     */
    public void farmEnder(){
        if (player.endGame()){
            int select = mainGUI.displayEndGameOption();

            if (select == 1){
                player.restartGame();
                updateView();
                updateTileInfo(0,0);
                mainGUI.changeToolButtonColor(0,player.getSelectedTool());
            }
            else if (select == 0){
                player.endGameNow();
                mainGUI.terminateGUI();
                System.exit(0);
            }
        }
    }

    /**
     * Updates the 2D array of tiles in the Game. Different states of the tile can differ based on tile conditions
     * such as a tile can have a seed or it can be withered. When certain conditions are met, the state or the visual
     * representation (GUI) also changes it state to indicate there are indeed changes once an action has been done.
     */
    public void updateView(){
        mainGUI.setFarmerTypeName(player.getFarmerType().getFarmerTypeName());
        mainGUI.setFarmerLevel(player.getLevel());
        mainGUI.setFarmerBalance(Math.round(player.getGameStats().balance));
        mainGUI.setFarmerExpVal(Math.round(player.getGameStats().exp));
        mainGUI.setDaysPassed(player.getPassedDays());

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                if (player.getLand(i,j).isRock() && player.getLand(i,j).isOccupied()){ //if there is a rock
                    mainGUI.rockOccupied(i,j);
                }
                else if (!player.getLand(i,j).isRock() && !player.getLand(i,j).isOccupied() &&
                        player.getLand(i,j).isPlowed()){ //if a tile i plowed
                    mainGUI.plowedTile(i,j);
                }
                else if (!player.getLand(i,j).isRock() && player.getLand(i,j).isOccupied() && player.getLand(i,j).isPlowed()
                && player.getLand(i,j).isPlowed() && player.getLand(i,j).getPlantedSeed() != null && player.getLand(i,j).getPlantedSeed().isWithered()){ //if a plant has withered
                    mainGUI.plantWithered(i,j);
                }
                else if (player.checkHarvestPlantEligibility(i,j)){ //if a plant is ready for harvest
                    mainGUI.readyForHarvest(i,j);
                }
                else if (!player.getLand(i,j).isRock() && player.getLand(i,j).isOccupied()){ //if occupied with a plant
                    mainGUI.tileIsOccupied(i,j);
                }
                else {
                    mainGUI.revertOriginalTileColor(i,j);
                }
            }
        }

        if (player.updateLevel()){
            mainGUI.setFarmerLevel(player.getLevel());
            mainGUI.displayLevelUp(player.getLevel());
            if (player.checkFarmerTypeUpgradeEligibility()){
                mainGUI.displayFarmerUpgradeEligibility();
            }
        }


    }

    /**
     * Updates the information of a single tile. Different states of the tile can differ based on tile conditions
     * such as a tile can have a seed or it can be withered. When the state of the tile changes, the GUI elements of
     * that specific tile also changes.
     * @param row row index
     * @param col column index
     */
    public void updateTileInfo(int row, int col){
        if (player.getLand(row,col).getPlantedSeed() != null){
            mainGUI.setCropM(player.getLand(row,col).getPlantedSeed().getDaysPassed());
            mainGUI.setHarvestD(player.getLand(row,col).getPlantedSeed().getHarvestDayRequired());
            mainGUI.setMaxWR(player.getLand(row,col).getPlantedSeed().getWater().getWaterMax());
            mainGUI.setMinWR(player.getLand(row,col).getPlantedSeed().getWater().getWaterMin());
            mainGUI.setTimesCW(player.getLand(row,col).getPlantedSeed().getWater().getTimesCropWatered());
            mainGUI.setMaxFR(player.getLand(row,col).getPlantedSeed().getFertilizer().getFertilizerMax());
            mainGUI.setMaxWR(player.getLand(row,col).getPlantedSeed().getWater().getWaterMax());
            mainGUI.setMinFR(player.getLand(row,col).getPlantedSeed().getFertilizer().getFertilizerMin());
            mainGUI.setTimesCF(player.getLand(row,col).getPlantedSeed().getFertilizer().getTimesCropFertilized());
            mainGUI.revertTileInfo();
            mainGUI.setPlantLabel(player.getLand(this.row, this.col).getPlantedSeed().getName());
            mainGUI.setRockIcon(player.getLand(row,col).isRock());
            mainGUI.setPlowIcon(player.getLand(row,col).isPlowed());
            mainGUI.setSeedIcon(true);
            mainGUI.setWitherIcon(player.getLand(row,col).getPlantedSeed().isWithered());

        } else if (player.getLand(row,col).getPlantedSeed() == null){
            mainGUI.removeAllTileInfo();
            mainGUI.setPlantLabel("None");
            mainGUI.setRockIcon(player.getLand(row,col).isRock());
            mainGUI.setPlowIcon(player.getLand(row,col).isPlowed());
            mainGUI.setSeedIcon(false);
            mainGUI.setWitherIcon(false);

        }
    }

    /**
     * Handles all the actions in the game or specifically when buttons are clicked within the GUI, there will be
     * also changes in state and form of the GUI (view) as well as the data running in the backend (model).
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Watercan")) { //when a water can is used
            mainGUI.changeToolButtonColor(0,player.getSelectedTool());
            player.equipTool(0);
            System.out.println("0");
        }
        else if (e.getActionCommand().equals("Fertilizer")){ //when a fertilizer is used
            mainGUI.changeToolButtonColor(1,player.getSelectedTool());
            player.equipTool(1);
        }
        else if (e.getActionCommand().equals("Plow Tool")){ //when a plow tool is used
            mainGUI.changeToolButtonColor(2,player.getSelectedTool());
            player.equipTool(2);
        }
        else if (e.getActionCommand().equals("Pickaxe")){ //when a pickaxe is used
            mainGUI.changeToolButtonColor(3,player.getSelectedTool());
            player.equipTool(3);
        }
        else if (e.getActionCommand().equals("Shovel")){ //when a shovel is used
            mainGUI.changeToolButtonColor(4,player.getSelectedTool());
            player.equipTool(4);
        }
        else if (e.getActionCommand().equals("Plant")){ //when the user wants to plant in a tile

            try {
                int select = mainGUI.displaySeedOptions();

                if (!player.plant(select, this.row, this.col)){
                    mainGUI.displayPlantError();
                }

                updateView();
                updateTileInfo(this.row, this.col);
            }
            catch (Exception error){
                System.out.println("No plant was chosen");
            }


        }
        else if (e.getActionCommand().equals("Harvest")){ //when a user wants to harvest a seed in a tile

            if (!player.harvestPlant(this.row, this.col)){
                mainGUI.displayHarvestError();
            }

            updateView();
            updateTileInfo(this.row, this.col);
        }
        else if (e.getActionCommand().equals("Next Day")){ //when the user chooses to proceed to the next day
            player.nextDay();
            updateTileInfo(this.row, this.col);
            updateView();
        }
        else if (e.getActionCommand().equals("Use Tool")){ //when the user chooses to use the selected tool

            if (!player.useEquippedTool(this.row,this.col)){
                mainGUI.displayToolError();
            }

            updateView();
            updateTileInfo(this.row, this.col);
        }
        else if (e.getActionCommand().equals("Prestige Up")){ //when the user chooses to upgrade the farmer type
            if (player.checkFarmerTypeUpgradeEligibility()){
                int choice = mainGUI.displayFarmerTypeUpgradeOptions(player.getNextFarmerType().getFarmerTypeName(), player.getNextFarmerType().getFee());
                System.out.println(choice);
                player.updateFarmerType(choice);
            }
            else{
                mainGUI.displayFarmerError();
            }
            updateView();
            updateTileInfo(this.row, this.col);
        }
        else { //responds to ever click within the 2D array of tiles (land)
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 5; j++) {
                  String entry = i + "," + j;
                    if (e.getActionCommand().equals(entry)){
                        if (e.getSource() instanceof JButton) {
                            String text = ((JButton) e.getSource()).getText(); //gets the text 2D index of the array (in String form)
                            String[] arrStr = text.split(",",2); // 2D index is then transferred to an array of Strings
                            this.row = Integer.parseInt(arrStr[0]); //gets the row index of the clicked tile (String to int)
                            this.col = Integer.parseInt(arrStr[1]); //gets the column index of the clicked tile (String to int)
                            mainGUI.setPlantCoordinate(text);
                            updateTileInfo(this.row,this.col);
                        }
                    }
                }
            }
        }

        farmEnder();

    }

}
