package core;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Colony implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String OXYGEN = "Oxygen";
    public static final String FOOD = "Food";
    public static final String WATER = "Water";
    public static final String ENERGY = "Energy";
    public static final String METAL = "Metal";

    private static final int MIN_VALUE = 0;
    private static final int MAX_RESOURCE_VALUE = 100;
    
    private static final int DEFAULT_DAY = 1;
    private static final int DEFAULT_POPULATION = 27;
    private static final int DEFAULT_MORALE = 76;
    private static final int STARTING_OXYGEN = 85;
    private static final int STARTING_FOOD = 70;
    private static final int STARTING_WATER = 75;
    private static final int STARTING_ENERGY = 60;
    private static final int STARTING_METAL = 40;

    private final LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
    private int day;
    private int population;
    private int morale;

    public Colony() {
        this(DEFAULT_DAY, DEFAULT_POPULATION, DEFAULT_MORALE, defaultResources());
    }

    public Colony(int day, int population, int morale, Map<String, Integer> initialResources) {
        this.day = Math.max(1, day);
        this.population = Math.max(0, population);
        this.morale = clamp(morale);

        resources.put(OXYGEN, valueFrom(initialResources, OXYGEN));
        resources.put(FOOD, valueFrom(initialResources, FOOD));
        resources.put(WATER, valueFrom(initialResources, WATER));
        resources.put(ENERGY, valueFrom(initialResources, ENERGY));
        resources.put(METAL, valueFrom(initialResources, METAL));
    }

    private static Map<String, Integer> defaultResources() {
        Map<String, Integer> defaults = new LinkedHashMap<>();
        defaults.put(OXYGEN, STARTING_OXYGEN);
        defaults.put(FOOD, STARTING_FOOD);
        defaults.put(WATER, STARTING_WATER);
        defaults.put(ENERGY, STARTING_ENERGY);
        defaults.put(METAL, STARTING_METAL);
        return defaults;
    }

    private static int valueFrom(Map<String, Integer> values, String resource) {
        if (values == null || values.get(resource) == null) {
            return MIN_VALUE;
        }
        return clamp(values.get(resource));
    }

    public int getDay() {
        return day;
    }

    public int getPopulation() {
        return population;
    }

    public int getMorale() {
        return morale;
    }

    public int getResource(String resource) {
        validateResource(resource);
        return resources.get(resource);
    }

    public Map<String, Integer> getResources() {
        return Collections.unmodifiableMap(new LinkedHashMap<>(resources));
    }

    public int adjustResource(String resource, int amount) {
        validateResource(resource);
        int updated = clamp(resources.get(resource) + amount);
        resources.put(resource, updated);
        return updated;
    }

    public boolean consumeResources(Map<String, Integer> costs) {
        if (costs == null) {
            throw new IllegalArgumentException("Resource costs cannot be null.");
        }
        for (Map.Entry<String, Integer> entry : costs.entrySet()) {
            validateResource(entry.getKey());
            if (entry.getValue() == null || entry.getValue() < 0) {
                throw new IllegalArgumentException("Resource costs must be non-negative.");
            }
            if (resources.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        for (Map.Entry<String, Integer> entry : costs.entrySet()) {
            resources.put(entry.getKey(), resources.get(entry.getKey()) - entry.getValue());
        }
        return true;
    }

    public void adjustPopulation(int amount) {
        population = Math.max(0, population + amount);
    }

    public void adjustMorale(int amount) {
        morale = clamp(morale + amount);
    }

    public void advanceDay() {
        int oxygenUpkeep = Math.max(1, population / 6);
        int foodUpkeep = Math.max(1, population / 9);
        int waterUpkeep = Math.max(1, population / 9);
        int energyUpkeep = Math.max(1, population / 12);

        adjustResource(OXYGEN, -oxygenUpkeep);
        adjustResource(FOOD, -foodUpkeep);
        adjustResource(WATER, -waterUpkeep);
        adjustResource(ENERGY, -energyUpkeep);
        day++;
    }

    public boolean isCollapsed() {
        return population == 0
                || getResource(OXYGEN) == 0
                || getResource(FOOD) == 0
                || getResource(WATER) == 0;
    }

    private void validateResource(String resource) {
        if (!resources.containsKey(resource)) {
            throw new IllegalArgumentException("Unknown resource: " + resource);
        }
    }

    private static int clamp(int value) {
        return Math.max(MIN_VALUE, Math.min(MAX_RESOURCE_VALUE, value));
    }
}
