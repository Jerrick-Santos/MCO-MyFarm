package Game.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * This is the GUI class (View) which handles all the panels that make up
 * the visuals for the game. This class is responsible for enabling the user to
 * interact through the different farm icons and buttons of the game.
 */
public class MyFarmGUI extends JFrame{

    private Icon cancelIcon;
    private Icon grassIcon;
    private Icon checkIcon;
    private Icon seedIcon;
    private Icon rockIcon, skull, plowedIcon, plantIcon;
    // North Panel
    private JLabel farmerTypeStat, levelVal, objcoinsVal, expVal, daysPassed;
    private JButton updateFT;
    // East Panel
    private JLabel lblText;
    private JLabel cropMaturity, harvestDay, minimumWaterReq, maximumWaterReq, timesCropWatered, minimumFertilizerReq, maximumFertilizerReq, timesCropFertilized;
    private int cropM = 0, harvestD = 0, minWR = 0, maximumWR = 0, timesCW = 0, minFR = 0, maximumFR = 0, timesCF = 0;
    private JButton btnUse, btnPlant, btnHarvest, btnNextDay;
    private JLabel plantLbl;
    private JLabel forRock, forPlow, forSeed, forWither;
    // Center Panel
    private JButton[][] plantButtons;
    // South Panel
    private JButton[] toolButtons;

    /**
     * This constructor creates the GUI for the game itself. Creates the panels
     * necessary for filling up the game window.
     */
    public MyFarmGUI() {
        super("MP-MyFarm");
        setLayout(new BorderLayout());
        setSize(1000,500);
        setLocation(100,100);
        setAlwaysOnTop(true);

        mainContainer(NORTHPanel(),
                EASTPanel(panelEastNORTH(), panelEastCENTER(panelEastCenterSOUTH()),
                        panelEastSOUTH()),
                CENTERPanel(),
                SOUTHPanel());

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cancelIcon= new ImageIcon(Objects.requireNonNull(getClass().getResource("icons8-cancel-32.png")));
        checkIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("icons8-done-32.png")));
        grassIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("grass.png")));
        rockIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("rock1.png")));
        seedIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("seeded1.png")));
        skull = new ImageIcon(Objects.requireNonNull(getClass().getResource("skull.png")));
        plowedIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("plowed.png")));
        plantIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("plant.png")));

    }

    /**
     * mainContainer holds all four panels under the 'Border' Layout.
     * @param NORTHPanel the north panel
     * @param EASTPanel the east panel
     * @param CENTERPanel the center panel
     * @param SOUTHPanel the south panel
     */
    public void mainContainer(RoundPanel NORTHPanel, JPanel EASTPanel, RoundPanel CENTERPanel,
                              RoundPanel SOUTHPanel) {
        Container mainContainer = this.getContentPane();
                  mainContainer.setLayout(new BorderLayout(8,6));
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(10,10,10,10,
                Color.decode("#A9AF7E")));
        mainContainer.setBackground(Color.decode("#A9AF7E"));

        mainContainer.add(NORTHPanel, BorderLayout.NORTH);
        mainContainer.add(EASTPanel, BorderLayout.CENTER);
        mainContainer.add(CENTERPanel, BorderLayout.EAST);
        mainContainer.add(SOUTHPanel, BorderLayout.SOUTH);
    }

    /**
     * NORTHPanel holds the in-game personal stats and information of the player like
     * the player's farmer status, level, wallet, and such.
     * @return the north panel
     */
    public RoundPanel NORTHPanel() {
        RoundPanel panelNorth = new RoundPanel();
                     panelNorth.setLayout(new FlowLayout(5));
                     panelNorth.setBackground(Color.decode("#E6E5A3"));
                     panelNorth.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));

        JLabel bracket1 = new JLabel(" [");
               bracket1.setFont(new Font("Arial", Font.BOLD, 14));
        farmerTypeStat = new JLabel("LEGENDARY");
        farmerTypeStat.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel bracket2 = new JLabel("]     ");
               bracket2.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel levelLbl = new JLabel("Level[");
               levelLbl.setFont(new Font("Arial", Font.BOLD, 14));
        levelVal = new JLabel("1");
        levelVal.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel space = new JLabel("]      ");
               space.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel objcoinsLbl = new JLabel("ObjCoins[");
               objcoinsLbl.setFont(new Font("Arial", Font.BOLD, 14));
        objcoinsVal = new JLabel("100");
        objcoinsVal.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel space2 = new JLabel("]      ");
               space2.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel expLbl = new JLabel("Exp[");
               expLbl.setFont(new Font("Arial", Font.BOLD, 14));
        expVal = new JLabel("5");
        expVal.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel bracket3 = new JLabel("]      ");
               bracket3.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel bracket4 = new JLabel("Days Passed[");
               bracket4.setFont(new Font("Arial", Font.BOLD, 14));
        daysPassed = new JLabel("0");
        daysPassed.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel bracket5 = new JLabel("]");
               bracket5.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel spacee = new JLabel("                                                                                       ");
        updateFT = new JButton("Prestige Up");
        updateFT.setBackground(Color.GREEN);
        updateFT.setForeground(Color.BLACK);
        updateFT.setFont(new Font("Arial", Font.BOLD, 14));
        updateFT.setUI(new CustomButton());

        panelNorth.add(bracket1);
        panelNorth.add(farmerTypeStat);
        panelNorth.add(bracket2);
        panelNorth.add(levelLbl);
        panelNorth.add(levelVal);
        panelNorth.add(space);
        panelNorth.add(objcoinsLbl);
        panelNorth.add(objcoinsVal);
        panelNorth.add(space2);
        panelNorth.add(expLbl);
        panelNorth.add(expVal);
        panelNorth.add(bracket3);
        panelNorth.add(bracket4);
        panelNorth.add(daysPassed);
        panelNorth.add(bracket5);
        panelNorth.add(spacee);
        panelNorth.add(updateFT);

        return panelNorth;
    }

    /**
     * EASTPanel holds all the information pertaining to the player's plants statuses. This
     * includes the player's chosen coordinates, tile status, plant label and status, and
     * plant action buttons.
     * @param panelEastNORTH north panel of the EAST panel
     * @param panelEastCENTER center panel of the EAST panel
     * @param panelEastSOUTH south panel of the EAST panel
     * @return the east panel
     */
    public JPanel EASTPanel(RoundPanel panelEastNORTH, JPanel panelEastCENTER, RoundPanel panelEastSOUTH) {
        JPanel panelEast = new JPanel();
               panelEast.setLayout(new BorderLayout());
               panelEast.setBackground(Color.decode("#A9AF7E"));

        panelEast.add(panelEastNORTH, BorderLayout.NORTH);
        panelEast.add(panelEastCENTER, BorderLayout.CENTER);
        panelEast.add(panelEastSOUTH, BorderLayout.SOUTH);

        return panelEast;
    }

    /**
     * panelEastNORTH holds the player's chosen coordinates.
     * @return the north panel of the EAST panel
     */
    public RoundPanel panelEastNORTH() {
        RoundPanel panelEastNORTH = new RoundPanel();
                     panelEastNORTH.setLayout(new FlowLayout(FlowLayout.CENTER));
                     panelEastNORTH.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
                     panelEastNORTH.setBackground(Color.decode("#E6E5A3"));

        lblText = new JLabel("x, y");
        lblText.setFont(new Font("Arial", Font.BOLD, 14));
        lblText.setForeground(Color.black);

        panelEastNORTH.add(lblText);
        return panelEastNORTH;
    }

    /**
     * panelEastCENTER holds the player's seeds' statuses.
     * @param panelEastCenterSOUTH the south panel of the Center panel of the SOUTH panel
     * @return the center panel of the EAST panel
     */
    public JPanel panelEastCENTER(JPanel panelEastCenterSOUTH) {
        JPanel panelEastCENTER = new JPanel();
               panelEastCENTER.setLayout(new BorderLayout());
               panelEastCENTER.setBackground(Color.decode("#A9AF7E"));

        RoundPanel status = new RoundPanel();
                     status.setLayout(new GridLayout(8, 2));
                     status.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));
                     status.setBackground(Color.decode("#E6E5A3"));

        JLabel cM = new JLabel("                          Crop Maturity (in days)");
               cM.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(cM);
        cropMaturity = new JLabel("........................................" + cropM);
        cropMaturity.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(cropMaturity);
        JLabel hD = new JLabel("                                            Harvest Day");
               hD.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(hD);
        harvestDay = new JLabel("........................................" + harvestD);
        harvestDay.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(harvestDay);
        JLabel mWR = new JLabel("                              Minimum Water Req");
               mWR.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(mWR);
        minimumWaterReq = new JLabel("........................................" + minWR);
        minimumWaterReq.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(minimumWaterReq);

        JLabel maxWR = new JLabel("                              Maximum Water Req");
        maxWR.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(maxWR);
        maximumWaterReq = new JLabel("........................................" + maximumWR);
        maximumWaterReq.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(maximumWaterReq);

        JLabel tCW = new JLabel("                             Times Crop Watered");
               tCW.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(tCW);
        timesCropWatered = new JLabel("........................................" + timesCW);
        timesCropWatered.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(timesCropWatered);
        JLabel mFR = new JLabel("                         Minimum Fertilizer Req");
               mFR.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(mFR);
        minimumFertilizerReq = new JLabel("........................................" + minFR);
        minimumFertilizerReq.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(minimumFertilizerReq);

        JLabel maxFR = new JLabel("                         Maximum Fertilizer Req");
        maxFR.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(maxFR);
        maximumFertilizerReq = new JLabel("........................................" + maximumFR);
        maximumFertilizerReq.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(maximumFertilizerReq);

        JLabel tCF = new JLabel("                           Times Crop Fertilized");
               tCF.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(tCF);
        timesCropFertilized = new JLabel("........................................" + timesCF);
        timesCropFertilized.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(timesCropFertilized);

        panelEastCENTER.add(status, BorderLayout.CENTER);
        panelEastCENTER.add(panelEastCenterSOUTH, BorderLayout.SOUTH);

        return panelEastCENTER;
    }

    /**
     * panelEastSOUTH holds the buttons responsible for the player's action towards a tile.
     * @return the south panel of the EAST panel
     */
    public RoundPanel panelEastSOUTH() {
        RoundPanel panelEastSOUTH = new RoundPanel();
                     panelEastSOUTH.setLayout(new FlowLayout());
                     panelEastSOUTH.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
                     panelEastSOUTH.setBackground(Color.decode("#E6E5A3"));

        btnUse = new JButton("Use Tool");
        btnUse.setFont(new Font("Arial", Font.BOLD, 14));
        btnUse.setForeground(Color.black);
        btnUse.setUI(new CustomButton());
        panelEastSOUTH.add(btnUse);
        btnPlant = new JButton("Plant");
        btnPlant.setFont(new Font("Arial", Font.BOLD, 14));
        btnPlant.setForeground(Color.black);
        btnPlant.setUI(new CustomButton());
        panelEastSOUTH.add(btnPlant);
        btnHarvest = new JButton("Harvest");
        btnHarvest.setFont(new Font("Arial", Font.BOLD, 14));
        btnHarvest.setForeground(Color.black);
        btnHarvest.setUI(new CustomButton());
        panelEastSOUTH.add(btnHarvest);
        btnNextDay = new JButton("Next Day");
        btnNextDay.setFont(new Font("Arial", Font.BOLD, 14));
        btnNextDay.setForeground(Color.black);
        btnNextDay.setUI(new CustomButton());
        panelEastSOUTH.add(btnNextDay);

        return panelEastSOUTH;
    }

    /**
     * panelEastCenterSOUTH holds the seed's label and statuses of a particular tile.
     * @return the south panel of the EastCenter panel
     */
    public JPanel panelEastCenterSOUTH() {
        JPanel panelEastCenterSOUTH = new JPanel();
               panelEastCenterSOUTH.setLayout(new BorderLayout());
               panelEastCenterSOUTH.setBackground(Color.decode("#A9AF7E"));

        RoundPanel textTitle = new RoundPanel();
                     textTitle.setBackground(Color.decode("#E6E5A3"));
                     textTitle.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
                     textTitle.setLayout(new FlowLayout(FlowLayout.CENTER));

        plantLbl = new JLabel("Turnip");
        plantLbl.setFont(new Font("Arial", Font.BOLD, 14));
        plantLbl.setForeground(Color.black);
        textTitle.add(plantLbl);
        panelEastCenterSOUTH.add(textTitle, BorderLayout.NORTH);

        RoundPanel textDesc = new RoundPanel();
                     textDesc.setBackground(Color.decode("#E6E5A3"));
                     textDesc.setBorder(BorderFactory.createEmptyBorder(8, 3, 8, 3));
                     textDesc.setLayout(new GridLayout(2, 4));

        JLabel rockLbl = new JLabel("   Rock");
               rockLbl.setFont(new Font("Arial", Font.BOLD, 14));
               rockLbl.setBackground(Color.gray);
               rockLbl.setForeground(Color.black);
        textDesc.add(rockLbl);
        JLabel plowed = new JLabel("Plowed");
               plowed.setFont(new Font("Arial", Font.BOLD, 14));
               plowed.setBackground(Color.gray);
               plowed.setForeground(Color.black);
        textDesc.add(plowed);
        JLabel seed = new JLabel("Seed");
               seed.setFont(new Font("Arial", Font.BOLD, 14));
               seed.setBackground(Color.gray);
               seed.setForeground(Color.black);
        textDesc.add(seed);
        JLabel withered = new JLabel("Withered");
               withered.setFont(new Font("Arial", Font.BOLD, 14));
               withered.setBackground(Color.gray);
               withered.setForeground(Color.black);
        textDesc.add(withered);

        forRock = new JLabel(this.cancelIcon);
        textDesc.add(forRock);
        forPlow = new JLabel(this.cancelIcon);
        textDesc.add(forPlow);
        forSeed = new JLabel(this.cancelIcon);
        textDesc.add(forSeed);
        forWither = new JLabel(this.cancelIcon);
        textDesc.add(forWither);

        panelEastCenterSOUTH.add(textDesc, BorderLayout.SOUTH);

        return panelEastCenterSOUTH;
    }

    /**
     * CENTERPanel serves as the 'motherboard' of the GUI. This panel contains all the tiles for the game.
     * @return the center panel
     */
    public RoundPanel CENTERPanel() {
        RoundPanel panelCenter = new RoundPanel();
                     panelCenter.setLayout(new GridLayout(10,5));
                     panelCenter.setBackground(Color.decode("#E6E5A3"));
                     panelCenter.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

        plantButtons = new JButton[10][5];
        JLabel textFrame = new JLabel("");
        Icon RockIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("grass.png")));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                String text = Integer.toString(i) + "," + Integer.toString(j);
                plantButtons[i][j] = new JButton(text);
                plantButtons[i][j].setFont(new Font("Arial", Font.BOLD, 14));
                plantButtons[i][j].setBackground(Color.decode("#E6E5A3"));
                plantButtons[i][j].setForeground(Color.black);
                panelCenter.add(plantButtons[i][j]);
                plantButtons[i][j].setIcon(RockIcon);
                plantButtons[i][j].setForeground(plantButtons[i][j].getBackground());
            }
        }
        return panelCenter;
    }

    /**
     * SOUTHPanel holds the tools of the player. This includes the Watercan, Fertilizer, Plow tool, Pickaxe,
     * and Shovel.
     * @return the south panel
     */
    public RoundPanel SOUTHPanel() {
        RoundPanel panelSouth = new RoundPanel();
                     panelSouth.setLayout(new GridLayout(1,5));
                     panelSouth.setBackground(Color.decode("#E6E5A3"));
                     panelSouth.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        toolButtons = new JButton[5];
        JLabel toolFrame = new JLabel();
        String[] toolNames = {"Watercan", "Fertilizer", "Plow Tool", "Pickaxe", "Shovel"};
        for (int l = 0; l < 5; l++) {
            toolButtons[l] = new JButton(toolNames[l]);
            toolButtons[l].setFont(new Font("Arial", Font.BOLD, 14));
            toolButtons[l].setBackground(Color.decode("#E6E5A3"));
            toolButtons[l].setForeground(Color.black);

            panelSouth.add(toolButtons[l]);


        }
        return panelSouth;
    }

    //NORTH PANEL SETTERS

    /**
     * setFarmerTypeName sets the Farmer type of the player.
     * @param farmerTypeName the farmer type of the player
     */
    public void setFarmerTypeName(String farmerTypeName){
        this.farmerTypeStat.setText(farmerTypeName);
    }

    /**
     * setFarmerLevel sets the value for player's level.
     * @param level level of the player
     */
    public void setFarmerLevel(int level){
        String levelString = Integer.toString(level);
        this.levelVal.setText(levelString);
    }

    /**
     * setFarmerBalance sets the value for the player's wallet.
     * @param balance the balance of the wallet
     */
    public void setFarmerBalance(double balance){
        String balanceString = Double.toString(balance);
        this.objcoinsVal.setText(balanceString);
    }

    /**
     * setFarmerExpVal sets the value for the players experience (ExP)
     * @param exp amount of experience earned
     */
    public void setFarmerExpVal(double exp){
        String expString = Double.toString(exp);
        this.expVal.setText(expString);
    }

    /**
     * setDaysPassed sets the value for the days passed.
     * @param days amount of days passed
     */
    public void setDaysPassed(int days){
        String daysPassedString = Integer.toString(days);
        this.daysPassed.setText(daysPassedString);
    }

    //ACTION LISTENER

    /**
     * setActionListener sets the action listener event to the button attributes in the class.
     * @param listener action listener
     */
    public void setActionListener(ActionListener listener) {
        for (int i = 0; i < 5; i++) {
            toolButtons[i].addActionListener(listener);
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                plantButtons[i][j].addActionListener(listener);
            }
        }

        btnPlant.addActionListener(listener);
        btnHarvest.addActionListener(listener);
        btnNextDay.addActionListener(listener);
        btnUse.addActionListener(listener);
        updateFT.addActionListener(listener);
    }


    //PANEL EAST NORTH

    /**
     * setPlantCoordinate set the coordinate of the plant chosen
     * @param coordinate the tile coordinate of the chosen plant
     */
    public void setPlantCoordinate(String coordinate){
        this.lblText.setText(coordinate);
    }

    //PANEL EAST CENTER

    /**
     * setCropM sets the crop maturity value.
     * @param cropM crop maturity value
     */
    public void setCropM(int cropM) {
        this.cropM = cropM;
    }

    /**
     * setHarvestD sets the harvest day.
     * @param harvestD harvest day
     */
    public void setHarvestD(int harvestD) {
        this.harvestD = harvestD;
    }

    /**
     * setMinWR sets the minimum water requirement.
     * @param minWR minimum water requirement
     */
    public void setMinWR(int minWR) {
        this.minWR = minWR;
    }

    /**
     * setMaxWR sets the maximum water requirement.
     * @param maximumWR maximum water requirement
     */
    public void setMaxWR(int maximumWR) {
        this.maximumWR = maximumWR;
    }

    /**
     * setTimesCW sets the amount of times the crop was watered.
     * @param timesCW amount of the times the crop was watered
     */
    public void setTimesCW(int timesCW) {
        this.timesCW = timesCW;
    }

    /**
     * setMinFR sets the minimum fertilizer requirement.
     * @param minFR minimum fertilizer requirement
     */
    public void setMinFR(int minFR) {
        this.minFR = minFR;
    }

    /**
     * setMaxFR sets the maximum fertilizer requirement.
     * @param maximumFR maximum fertilizer requirement
     */
    public void setMaxFR(int maximumFR) {
        this.maximumFR = maximumFR;
    }

    /**
     * setTimesCF sets the amount of times the crop was fertilized.
     * @param timesCF amount of times the crop was fertilized
     */
    public void setTimesCF(int timesCF) {
        this.timesCF = timesCF;
    }

    /**
     * removeAllTileInfo removes all tile information. The method changes all text into blank.
     */
    public void removeAllTileInfo(){
        cropMaturity.setText("");
        harvestDay.setText("");
        minimumWaterReq.setText("");
        maximumWaterReq.setText("");
        timesCropWatered.setText("");
        minimumFertilizerReq.setText("");
        maximumFertilizerReq.setText("");
        timesCropFertilized.setText("");
    }

    /**
     * revertTileInfo reverts all information of the chosen tile coordinate.
     */
    public void revertTileInfo(){
        cropMaturity.setText("........................................" + cropM);
        harvestDay.setText("........................................" + harvestD);
        minimumWaterReq.setText("........................................" + minWR);
        maximumWaterReq.setText("........................................" + maximumWR);
        timesCropWatered.setText("........................................" + timesCW);
        minimumFertilizerReq.setText("........................................" + minFR);
        maximumFertilizerReq.setText("........................................" + maximumFR);
        timesCropFertilized.setText("........................................" + timesCF);
    }

    //EAST SOUTH

    /**
     * setPlantLabel sets the name of the plant.
     * @param plantLabel name of the plant
     */
    public void setPlantLabel(String plantLabel){
        this.plantLbl.setText(plantLabel);
    }

    //EAST CENTER SOUTH

    /**
     * setRockIcon sets the icon for the plant's rock occupying status.
     * @param val boolean value for rock status
     */
    public void setRockIcon(boolean val){
        if (val){
            forRock.setIcon(this.checkIcon);
        }
        else {
            forRock.setIcon(this.cancelIcon);
        }

    }

    /**
     * setPlowIcon sets the icon for the plant's plowed status.
     * @param val boolean value for plowed status
     */
    public void setPlowIcon(boolean val){
        if (val){
            forPlow.setIcon(this.checkIcon);
        }
        else {
            forPlow.setIcon(this.cancelIcon);
        }

    }

    /**
     * setSeedIcon sets the icon for the plant's seeded status.
     * @param val boolean value for seeded status
     */
    public void setSeedIcon(boolean val){
        if (val){
            forSeed.setIcon(this.checkIcon);
        }
        else {
            forSeed.setIcon(this.cancelIcon);
        }

    }

    /**
     * setWitherIcon sets the icon for the plant's withered status.
     * @param val boolean value for withered status
     */
    public void setWitherIcon(boolean val){
        if (val){
            forWither.setIcon(this.checkIcon);
        }
        else {
            forWither.setIcon(this.cancelIcon);
        }

    }

    //EAST SOUTH

    /**
     * setPlantButtonColor sets the background color for the plant button.
     */
    public void setPlantButtonColor(){
        btnPlant.setBackground(Color.decode("#EBE29F"));
    }

    /**
     * setHarvestButtonColor sets the background color for the harvest button.
     */
    public void setHarvestButtonColor(){
        btnHarvest.setBackground(Color.decode("#EBE29F"));
    }

    //CENTER PANEL

    /**
     * readyForHarvest is used for when a plant is ready for harvest. Takes in a row and a column then sets
     * the background color, foreground color, and icon, for that button.
     * @param row row coordinate
     * @param col column coordinate
     */
    public void readyForHarvest(int row, int col){
        plantButtons[row][col].setBackground(Color.green);
        plantButtons[row][col].setForeground(plantButtons[row][col].getBackground());
        plantButtons[row][col].setIcon(this.plantIcon);
    }

    /**
     * plowedTile is used for when a plant is plowed. Takes in a row and a column then sets the background
     * color, foreground color, and icon, for that button.
     * @param row row coordinate
     * @param col column coordinate
     */
    public void plowedTile(int row, int col){
        plantButtons[row][col].setBackground(Color.cyan);
        plantButtons[row][col].setForeground(plantButtons[row][col].getBackground());
        plantButtons[row][col].setIcon(this.plowedIcon);
    }

    /**
     * revertOriginalTileColor is used to revert the tile to the original/initial color, including the icon.
     * @param row row coordinate
     * @param col column coordinate
     */
    public void revertOriginalTileColor(int row, int col){
        plantButtons[row][col].setBackground(Color.decode("#E6E5A3"));
        plantButtons[row][col].setForeground(plantButtons[row][col].getBackground());
        plantButtons[row][col].setIcon(this.grassIcon);
    }

    /**
     * rockOccupied sets rock to occupy the designated tile.
     * @param row row coordinate
     * @param col column coordinate
     */
    public void rockOccupied(int row, int col){
        Icon rockyIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("rock1.png")));
        plantButtons[row][col].setBackground(Color.orange);
        plantButtons[row][col].setForeground(plantButtons[row][col].getBackground());
        plantButtons[row][col].setIcon(this.rockIcon);
    }

    /**
     * tileIsOccupied sets tile as occupied.
     * @param row row coordinate
     * @param col column coordinate
     */
    public void tileIsOccupied(int row, int col){
        plantButtons[row][col].setBackground(Color.yellow);
        plantButtons[row][col].setForeground(plantButtons[row][col].getBackground());
        plantButtons[row][col].setIcon(this.seedIcon);
    }

    /**
     * plantWithered sets tile as withered.
     * @param row row coordinate
     * @param col column coordinate
     */
    public void plantWithered(int row, int col){
        plantButtons[row][col].setBackground(Color.red);
        plantButtons[row][col].setForeground(plantButtons[row][col].getBackground());
        plantButtons[row][col].setIcon(this.skull);
    }

    //SOUTH PANEL

    /**
     * changeToolButtonColor changes the color of the current tool if the selected tool is different from
     * the current tool.
     * @param select selected tool
     * @param currentTool currently used tool
     */
    public void changeToolButtonColor(int select, int currentTool){
        if (select != currentTool){
            toolButtons[currentTool].setBackground(Color.decode("#E6E5A3"));
            toolButtons[select].setBackground(Color.PINK);
        }
        else {
            toolButtons[currentTool].setBackground(Color.PINK);
        }
    }

    //JOPTION PANES

    /**
     * displaySeedOptions displays all the plants as options for the player to choose from.
     * @return the chosen seed
     */
    public int displaySeedOptions(){
        int retVal = -1;
        //i solved my problem adding the following 2 lines of code...
        Object[] options = {"Turnip", "Carrot", "Potato", "Rose", "Tulips", "Sunflower", "Mango", "Apple"};
        JFrame panel = new JFrame();
        panel.add(new JButton("Click"));
        panel.add(new JTextField(20));
        panel.add(new JLabel("Label"));
        //...and passing `frame` instead of `null` as first parameter
        Object selectionObject = JOptionPane.showInputDialog(this, "Choose", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String selectionString = selectionObject.toString();

        for (int i = 0; i < options.length; i++) {
            if (selectionString.equals(options[i])){
                retVal = i;
            }
        }

        return retVal;
    }

    /**
     * displayFarmerUpgradeEligibility displays text telling the player that he/she is eligible to upgrade his/her
     * farmer type.
     */
    public void displayFarmerUpgradeEligibility(){
        JOptionPane.showMessageDialog(this, "You are now eligible to upgrade your farmer type!"
        , "Farmer Update", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * displayLevelUp displays text telling the player he/she has leveled up.
     * @param level player level
     */
    public void displayLevelUp(int level){
        JOptionPane.showMessageDialog(this, "Level Up! You are now at Level " + level
                , "Farmer Update", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * displayFarmerTypeUpgradeOptions asks the player if he/she wants to upgrade his/her farmer type.
     * @param farmerTypeName player's current farmer type
     * @param fee cost of the upgrade
     * @return the index option of the array, 'options'. Either 'No' or 'Yes'.
     */
    public int displayFarmerTypeUpgradeOptions(String farmerTypeName, double fee){
        String[] options = {"No", "Yes"};

        int retVal = JOptionPane.showOptionDialog(this,
                "Do you want to update to " + farmerTypeName + " for " + fee + " OJCs?",
                "Farmer Upgrade",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, 1);

        return retVal;
    }

    /**
     * displayEndGameOption asks the player if he/she wants to start over the game, after finishing the game.
     * @return the index option of the array, 'options'. Either 'No' or 'Yes'.
     */
    public int displayEndGameOption(){
        String[] options = {"No", "Yes"};

        int retVal = JOptionPane.showOptionDialog(this,
                "Game Over: Do you want to start over?",
                "Game Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, 1);

        return retVal;
    }

    /**
     * displayFarmerError displays an error prompt telling the player that he/she cannot upgrade.
     */
    public void displayFarmerError(){
        JOptionPane.showMessageDialog(this, "Warning! You cant upgrade. Check conditions"
                , "Farmer Upgrade Error", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * displayPlantError displays an error prompt telling the player that he/she cannot plant the chosen seed.
     * Whether if the player has sufficient funds or the tile is occupied/withered.
     */
    public void displayPlantError(){
        JOptionPane.showMessageDialog(this, "Warning: cannot be planted! Check OBJCs wallet if sufficient or if tile is occupied/withered (or if Fruit Tree is attempted check surrounding tiles."
                , "Plant Error", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * displayHarvestError displays an error prompt telling the player that he/she cannot harvest the seed.
     */
    public void displayHarvestError(){
        JOptionPane.showMessageDialog(this, "Warning: Cannot harvest Seed. Check if seed exists or had wither"
                , "Harvest Error", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * displayToolError displays an error prompt telling the player that he/she cannot use the equipped tool.
     */
    public void displayToolError(){
        JOptionPane.showMessageDialog(this, "Cannot use tool: Check tile conditions and cost usage of tool"
                , "Invalid Tool Usage", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * terminateGUI terminates the GUI
     */
    public void terminateGUI(){
        System.exit(0);
    }

}
