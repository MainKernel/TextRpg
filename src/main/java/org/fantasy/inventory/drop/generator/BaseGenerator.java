package org.fantasy.inventory.drop.generator;

import java.util.Random;

public class BaseGenerator {

    public int eventRarityGenerator(){

        double chance = Math.random();
        if (chance < 0.2) {
            return 3;
        } else if (chance < 0.3) {
            return 2;
        }else if (chance < 0.5){
            return 1;
        } else {
            return 0;
        }
    }
}
