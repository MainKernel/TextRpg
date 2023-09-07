package org.fantasy.inventory.drop.generator;

import org.fantasy.inventory.Rarity;

import java.util.Random;

public class BaseGenerator {

    public int eventRarityGenerator(){

        double chance = Math.random();
        if (chance < 0.05) {
            return 6; // 5%
        } else if (chance < 0.1) {
            return 5; // 10%
        }else if (chance < 0.2){
            return 4; // 20%
        }else if (chance < 0.3){
            return 3; // 30%
        }else if (chance < 0.4){
            return 2; // 40%
        }else if (chance < 0.5){
            return 1; // 50%
        } else {
            return 0;
        }
    }

    public Rarity generateRarity() {
        double chance = Math.random();
        if (chance < 0.05) {
            return Rarity.DIVINE;
        } else if (chance < 0.1) {
            return Rarity.IMMORTAL;
        }else if (chance < 0.2){
            return Rarity.LEGENDARY;
        } else if (chance < 0.3) {
            return Rarity.BLESSED;
        }else if (chance < 0.4){
            return Rarity.RARE;
        }else if (chance < 0.5){
            return Rarity.UNCOMMON;
        }else {
            return Rarity.COMMON;
        }
    }

}
