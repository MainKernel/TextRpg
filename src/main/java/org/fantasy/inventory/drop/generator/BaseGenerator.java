package org.fantasy.inventory.drop.generator;

import org.fantasy.inventory.Rarity;

import java.util.Random;

public class BaseGenerator {

    public int eventRarityGenerator(){

        double chance = Math.random();
        if (chance < 0.05) {
            return 3; // 5%
        } else if (chance < 0.1) {
            return 2; // 10%
        }else if (chance < 0.2){
            return 1; // 20%
        }else if (chance < 0.3){
            return 1; // 30%
        }else if (chance < 0.4){
            return 1; // 40%
        }else if (chance < 0.5){
            return 1; // 50%
        } else {
            return 0;
        }
    }

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
