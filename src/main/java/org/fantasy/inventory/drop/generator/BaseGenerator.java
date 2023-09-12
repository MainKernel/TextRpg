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


    public int eventRarityGenerator() {
        double chance = getChance();
        if (chance < 0.5) {
            return 1; // 50%
        } else {
            return 0;
        }
    }

    public int smallGoldAmountGenerator() {
        double chance = getChance();
        if (chance < 0.3) {
            return 3;
        } else if (chance < 0.4) {
            return 2;
        } else if (chance < 0.5) {
            return 1;
        } else {
            return 0;
        }
    }

    public int smallSilverAndCopperAmountGenerator() {
        double chance = getChance();
        if (chance < 0.3) {
            return 2;
        } else if (chance < 0.4) {
            return 3;
        } else if (chance < 0.6) {
            return 5;
        } else {
            return 1;
        }
    }

    public int largeGoldAmountGenerator() {
        double chance = getChance();
        if (chance < 0.1) {
            return 10;
        } else if (chance < 0.2) {
            return 15;
        } else if (chance < 0.3) {
            return 20;
        } else {
            return 5;
        }
    }

    public int largeSilverAndCopperAmountGenerator() {
        double chance = getChance();
        if (chance < 0.3) {
            return 10;
        } else if (chance < 0.4) {
            return 8;
        } else if (chance < 0.5) {
            return 7;
        } else {
            return 5;
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
