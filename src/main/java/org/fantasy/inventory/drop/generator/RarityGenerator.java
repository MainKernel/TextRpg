package org.fantasy.inventory.drop.generator;

import org.fantasy.inventory.Rarity;

public class RarityGenerator {

    public Rarity generateRarity() {
        double chance = Math.random();
        if (chance < 0.1) {
            return Rarity.DIVINE;
        } else if (chance < 0.2) {
            return Rarity.IMMORTAL;
        }else if (chance < 0.3){
            return Rarity.LEGENDARY;
        } else if (chance < 0.4) {
            return Rarity.BLESSED;
        }else if (chance < 0.5){
            return Rarity.RARE;
        }else if (chance < 0.6){
            return Rarity.UNCOMMON;
        }else {
            return Rarity.COMMON;
        }
    }

}
