package org.fantasy.inventory.drop.generator;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.inventory.Rarity;

public class BaseGenerator {

    private static final BaseGenerator baseGenerator = new BaseGenerator();

    private BaseGenerator() {

    }

    public static BaseGenerator getInstance() {
        return baseGenerator;
    }

    private static double getChance() {
        return Math.random();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(BaseGenerator.getInstance().eventRarityGenerator());
        }
    }

    public int eventRarityGenerator() {
        double chance = getChance();
        if (chance < 0.5) {
            return 1; // 50%
        } else {
            return 0;
        }
    }

    public int elixirGenerator() {
        double chance = getChance();
        if (chance < 0.1) {
            return 3; // 10%
        } else if (chance < 0.3) {
            return 2; // 30%
        } else {
            return 1; // 50%
        }
    }



    public Rarity generateRarity() {
        double chance = getChance();
        if (chance < 0.05) {
            return Rarity.DIVINE;
        } else if (chance < 0.1) {
            return Rarity.IMMORTAL;
        } else if (chance < 0.2) {
            return Rarity.LEGENDARY;
        } else if (chance < 0.3) {
            return Rarity.BLESSED;
        } else if (chance < 0.4) {
            return Rarity.RARE;
        } else if (chance < 0.5) {
            return Rarity.UNCOMMON;
        } else {
            return Rarity.COMMON;
        }
    }
}
