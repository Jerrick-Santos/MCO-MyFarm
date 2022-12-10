/**
 * This is the Tool class which is an abstract class. The purpose of this class is only to provide a template
 * or reusable code for its child classes such as the WaterCan, Fertilizer, Plow Tool, Pickaxe and Shovel.
 * This class also contains one abstract method which is how tools are individually used based on their different implementations.
 */

package Game.Model.Tools;
import Game.Model.PlayerMechanics.Tile;



public abstract class Tool {
    private String name;
    private int cost;
    private double expGain;

    /**
     * Constructs the tool class.
     * @param name name of the tool
     * @param cost cost per use
     * @param expGain exp gained when tool is used
     */
    public Tool(String name, int cost, double expGain) {
        this.name = name;
        this.cost = cost;
        this.expGain = expGain;
    }

    //GETTERS

    /**
     * gets the name of the tool
     * @return name of the tool
     */
    public String getName() {
        return name;
    }

    /**
     * gets the cost of usage
     * @return cost of usage
     */
    public int getCost() {
        return cost;
    }

    /**
     * gets the experience gain
     * @return experience gain
     */
    public double getExpGain() {
        return expGain;
    }

    /**
     * This method actually uses the tool based on their required functions and behaviours.
     * @param tile the object taken input is a tile which will be used in the child classes
     * @return if the tool usage is successful
     */
    public abstract boolean useTool(Tile tile);

}
