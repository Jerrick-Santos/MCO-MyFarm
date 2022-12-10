/**
 * Apple seed, a subclass of the Seed class
 */

package Game.Model.Seeds;

import Game.Model.FarmerTypes.FarmerType;

public class Apple extends Seed{
    /**
     * Constructor of Apple
     * @param name name of the seed
     * @param cropType type of seed
     * @param harvestDayRequired - days required for harvest
     * @param waterMin water lower bound
     * @param waterMax water upper bound
     * @param fertilizerMin fertilizer lower bound
     * @param fertilizerMax fertilizer upper bound
     * @param seedCost cost it takes to plant a seed
     * @param productsProducedMin products produced lower bound
     * @param productsProducedMax products produced upper bound
     * @param baseSellingPrice base selling price
     * @param expYield EXP yield when seed is harvested
     */
    public Apple(String name, String cropType, int harvestDayRequired, int waterMin, int waterMax, int fertilizerMin, int fertilizerMax, int seedCost, int productsProducedMin, int productsProducedMax, int baseSellingPrice, double expYield, FarmerType farmerType) {
        super(name, cropType, harvestDayRequired, waterMin, waterMax, fertilizerMin, fertilizerMax, seedCost, productsProducedMin, productsProducedMax, baseSellingPrice, expYield, farmerType);
    }
}
