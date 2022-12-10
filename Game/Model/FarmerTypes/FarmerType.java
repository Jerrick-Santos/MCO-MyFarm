/**
 * The FarmerType is an abstract class contains the necessary information for the player's current
 * farmer type. As the player progresses through the game and levels up, the player
 * is subject for 'prestige leveling' wherein upgrading the farmer type may grant the
 * player benefits such as cost reduction for seeds, water and fertilizer maximum
 * requirement increase, and bonus earnings.
 */
package Game.Model.FarmerTypes;


public abstract class FarmerType {
    private String farmerTypeName;
    private int levelRequirement;
    private int bonusEarns;
    private int costReduction;
    private int waterIncrease;
    private int fertilizerIncrease;
    private double fee;

    /**
     * Constructor to the Farmer Type abstract class.
     * @param farmerTypeName name of farmer type
     * @param levelRequirement level requirement
     * @param bonusEarns earned bonus
     * @param costReduction cost of usage reduction
     * @param waterIncrease water increase
     * @param fertilizerIncrease fertilizer increase
     * @param fee fee needed to upgrade to the farmer type
     */
    public FarmerType(String farmerTypeName, int levelRequirement, int bonusEarns,
                      int costReduction, int waterIncrease,
                      int fertilizerIncrease, double fee) {
        this.farmerTypeName = farmerTypeName;
        this.levelRequirement = levelRequirement;
        this.bonusEarns = bonusEarns;
        this.costReduction = costReduction;
        this.waterIncrease = waterIncrease;
        this.fertilizerIncrease = fertilizerIncrease;
        this.fee = fee;
    }


    /**
     * Getter for variable, farmerTypeName.
     * @return name of current farmer type.
     */
    public String getFarmerTypeName() {
        return farmerTypeName;
    }


    /**
     * Getter for variable, levelRequirement.
     * @return level requirement
     */
    public int getLevelRequirement() {
        return levelRequirement;
    }

    /**
     * Getter for variable, bonusEarns.
     * @return bonus earnings
     */
    public int getBonusEarns() {
        return bonusEarns;
    }

    /**
     * Getter for variable, costReduction.
     * @return cost reduction
     */
    public int getCostReduction() {
        return costReduction;
    }


    /**
     * Getter for variable, waterIncrease.
     * @return water increase
     */
    public int getWaterIncrease() {
        return waterIncrease;
    }

    /**
     * Getter for variable, fertilizerIncrease.
     * @return fertilizer increase
     */
    public int getFertilizerIncrease() {
        return fertilizerIncrease;
    }

    /**
     * Getter for variable, fee.
     * @return registration
     */
    public double getFee() {
        return fee;
    }

}
