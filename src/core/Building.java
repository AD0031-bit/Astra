
package core;

import interfaces.ResourceProducer;

public class Building implements ResourceProducer {

    private String name;
    private String resourceProduced;
    private int productionAmount;
    private int constructionCost;
    private boolean constructed;

    public Building(String name, String resourceProduced,
                    int productionAmount, int constructionCost) {

        this.name = name;
        this.resourceProduced = resourceProduced;
        this.productionAmount = productionAmount;
        this.constructionCost = constructionCost;
        this.constructed = false;
    }

    public void construct(Colony colony) {

        if (colony.getResource("Metal") >= constructionCost) {

            colony.changeResource("Metal", -constructionCost);
            constructed = true;

            System.out.println(name + " constructed successfully!");

        } else {
            System.out.println("Not enough Metal to construct " + name);
        }
    }

    @Override
    public void produce(Colony colony) {

        if (constructed) {
            colony.changeResource(resourceProduced, productionAmount);

            System.out.println(name + " produced "
                    + productionAmount + " " + resourceProduced);
        }
    }

    public String getName() {
        return name;
    }

    public boolean isConstructed() {
        return constructed;
    }
}
