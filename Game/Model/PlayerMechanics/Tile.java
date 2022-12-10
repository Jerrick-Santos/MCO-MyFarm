/**
 * The Tile class contains information about a tile whether it has a rock, is plowed, is occupied, and has a seed.
 * The Tile class is also responsible for instantiating a seed based on the preferences of the user which will be
 * supplied by the Player class. A Tile can have 0 or 1 seed throughout the entire game.
 */
package Game.Model.PlayerMechanics;

import Game.Model.FarmerTypes.FarmerType;
import Game.Model.Seeds.*;

public class Tile {
    private boolean rock;
    private boolean occupied;
    private boolean plowed;
    private Seed plantedSeed;

    /**
     * Constructor for the Tile Class.
     */
    public Tile() {
        this.rock = false;
        this.occupied = false;
        this.plowed = false;
        this.plantedSeed = null;
    }

    /**
     * Gets rock boolean value
     * @return rock boolean value
     */
    public boolean isRock() {
        return rock;
    }

    /**
     * Gets rock occupied value
     * @return rock occupied value
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**
     * Gets plowed boolean value
     * @return plowed boolean value
     */
    public boolean isPlowed() {
        return plowed;
    }

    /**
     * Gets the seed attribute
     * @return the seed attribute
     */
    public Seed getPlantedSeed() {
        return plantedSeed;
    }

    /**
     * Sets the value of the rock attribute
     * @param rock a boolean value to set it to the rock attribute
     */
    public void setRock(boolean rock) {
        this.rock = rock;
        this.occupied = true;
    }

    /**
     * Sets the value of the occupied attribute
     * @param occupied a boolean value to set it to the occupied attribute
     */
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    /**
     * Sets the value of the plowed attribute
     * @param plowed a boolean value to set it to the plowed attribute
     */
    public void setPlowed(boolean plowed) {
        this.plowed = plowed;
    }

    /**
     * Removes the plantedSeed by making the plantedSeed attribute to null
     */
    public void removePlantedSeed(){
        if (this.plantedSeed != null){
            this.plantedSeed = null;
        }
    }

    /**
     * Instantiates the actual seed into the Tile class. The farmer type @param is used to apply the necessary upgrades
     * @param select user selection of the seed
     * @param name name of the seed
     * @param cropType crop type
     * @param harvestDayRequired harvest day expiry (required)
     * @param waterMin lower limit of water
     * @param waterMax upper limit of water
     * @param fertilizerMin lower limit of fertilizer
     * @param fertilizerMax upper limit of fertilizer
     * @param seedCost cost of planting
     * @param productsProducedMin lower limit of produce
     * @param productsProducedMax upper limit of produce
     * @param baseSellingPrice base selling price
     * @param expYield experience yielded when harvested
     * @param farmerType farmer type
     */
    public void setPlantedSeed(int select, String name, String cropType, int harvestDayRequired,
                               int waterMin, int waterMax, int fertilizerMin, int fertilizerMax,
                               int seedCost, int productsProducedMin, int productsProducedMax, int baseSellingPrice, double expYield, FarmerType farmerType) {

        if (!this.rock && !this.occupied && this.plowed && this.plantedSeed == null){
            if (select == 0){
                this.plantedSeed = new Turnip(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            }
            else if (select == 1){
                this.plantedSeed = new Carrot(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            } else if (select == 2) {
                this.plantedSeed = new Potato(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            } else if (select == 3){
                this.plantedSeed = new Rose(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            } else if (select == 4){
                this.plantedSeed = new Tulips(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            } else if (select == 5){
                this.plantedSeed = new Sunflower(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            } else if (select == 6){
                this.plantedSeed = new Mango(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            } else if (select == 7){
                this.plantedSeed = new Apple(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            }


            this.occupied = true;
        }

    }
}
