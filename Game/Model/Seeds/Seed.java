package Game.Model.Seeds;

import Game.Model.FarmerTypes.FarmerType;

/**
 * The Seed class contains the necessary information/data for a seed object. It can also compute the value
 * or the finalPrice when a seed is harvested. It also checks if a seed is withered given the conditions.
 *
 * This class is a template for other subclasses (i.e., this class is a parent class)
 */
public abstract class Seed {
    private String name;
    private String cropType;
    private int harvestDayRequired;
    private int daysPassed;
    private Water water;
    private Fertilizer fertilizer;
    private int seedCost;
    private int productsProducedMin;
    private int productsProducedMax;
    private int baseSellingPrice;
    private double expYield;
    private boolean withered;

    /**
     * Constructs a seed class.
     * Water and Fertilizer are immediately created upon creation of this class. Water and Fertilizers are individual
     * classes which are instantiated when a Seed class is created.
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
    public Seed(String name, String cropType, int harvestDayRequired, int waterMin, int waterMax, int fertilizerMin, int fertilizerMax,
                int seedCost, int productsProducedMin, int productsProducedMax, int baseSellingPrice, double expYield, FarmerType farmerType) {
        this.name = name;
        this.cropType = cropType;
        this.harvestDayRequired = harvestDayRequired;
        this.daysPassed = 0;
        this.water = new Water(waterMin, waterMax, farmerType); //Water object is created
        this.fertilizer = new Fertilizer(fertilizerMin, fertilizerMax, farmerType); //Fertilizer object is created
        this.seedCost = seedCost;
        this.productsProducedMin = productsProducedMin;
        this.productsProducedMax = productsProducedMax;
        this.baseSellingPrice = baseSellingPrice;
        this.expYield = expYield;
        this.withered = false;
    }

    /**
     * Increments daysPassed by 1
     */
    public void addDaysPassed(){
        this.daysPassed++;
    }

    /**
     * Computes the final price of the seed
     * @param farmerType is used for bonuses in computation
     * @return the final price of the seed
     */
    public double computeFinalPrice(FarmerType farmerType){
        double retVal = 0;
        //random val is used to set the products produced by providing the lower and upper bound of products produced to have a random number
        int randomVal = (int)Math.floor(Math.random()*(this.productsProducedMax-this.productsProducedMin+1)+this.productsProducedMin);
        double harvestTotal = 0;
        double waterBonus = 0;
        double fertilizerBonus = 0;
        harvestTotal = randomVal * (this.baseSellingPrice + farmerType.getBonusEarns());
        waterBonus = harvestTotal * 0.2 * (this.water.getTimesCropWatered()-1);
        fertilizerBonus = harvestTotal * 0.5 * this.fertilizer.getTimesCropFertilized();
        retVal = harvestTotal + waterBonus + fertilizerBonus;
        System.out.println(this.name + "has produced " + randomVal + " product(s).");
        return retVal;
    }

    /**
     * Checks if the seed is withered based on the conditions.
     * If the seed is withered and the harvest day has been met and the minimum requirements for water and fertilizer
     * is not met then the seed will now be withered.
     */
    public void checkWithered(){
        if (!this.withered){ //if withered
            if (this.daysPassed == this.harvestDayRequired){
                if (this.water.getWaterMin() <= this.water.getTimesCropWatered() //checks minimum water and fertilizer requirement.
                        && this.fertilizer.getFertilizerMin() <= this.fertilizer.getTimesCropFertilized()){
                    System.out.println("Note: You can now HARVEST your plant!");
                }
                else {
                    this.withered = true;
                    System.out.println("Warning: Your Plant has been withered. Did not meet sufficient water OR fertilizer");
               }
            }
            else if (this.daysPassed > this.harvestDayRequired){
                this.withered = true;
                System.out.println("Warning: Your Plant has been withered. Harvest day has passed");
            }
        }
    }

    //GETTERS AND SETTERS

    /**
     * Sets the value of withered
     * @param withered boolean value to set to withered
     */
    public void setWithered(boolean withered) {
        this.withered = withered;
    }

    /**
     * Gets the name of the seed
     * @return the name of the seed
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the crop type
     * @return a crop type
     */
    public String getCropType() {
        return cropType;
    }

    /**
     * Gets the harvest day required or date of maturity of a seed
     * @return harvest day required
     */
    public int getHarvestDayRequired() {
        return harvestDayRequired;
    }

    /**
     * Get the days passed of the seed itself
     * @return days passed of the seed
     */
    public int getDaysPassed() {
        return daysPassed;
    }

    /**
     * Gets water attribute
     * @return Water attribute of seed
     */
    public Water getWater() {
        return water;
    }

    /**
     * Gets Fertilizer attribute
     * @return Fertilizer attribute of a seed
     */
    public Fertilizer getFertilizer() {
        return fertilizer;
    }

    /**
     * Gets the seed cost
     * @return seed cost
     */
    public int getSeedCost() {
        return seedCost;
    }

    /**
     * Gets the base selling price
     * @return base selling price
     */
    public int getBaseSellingPrice() {
        return baseSellingPrice;
    }

    /**
     * Gets the Experience Yield
     * @return Experience Yield
     */
    public double getExpYield() {
        return expYield;
    }

    /**
     * Gets the boolean value of withered
     * @return boolean value of withered
     */
    public boolean isWithered() {
        return withered;
    }
}
