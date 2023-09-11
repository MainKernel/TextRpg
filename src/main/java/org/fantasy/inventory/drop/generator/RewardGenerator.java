package org.fantasy.inventory.drop.generator;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.inventory.Item;

import java.util.ArrayList;
import java.util.List;

public class RewardGenerator {
    public List<Item> generateReward(Hero hero, int size) {
        List<Item> reward = new ArrayList<>();
        PotionGenerator potionGenerator = new PotionGenerator();
        WeaponGenerator weaponGenerator = new WeaponGenerator();
        ArmorGenerator armorGenerator = new ArmorGenerator();
        for (int i = 0; i < size; i++) {
            int j = rewardSize();
            switch (j) {
                case 0:
                    reward.add(potionGenerator.potionDrop(hero));
                    break;
                case 1:
                    reward.add(weaponGenerator.weaponDrop(hero));
                    break;
                case 2:
                    reward.add(armorGenerator.armorDrop(hero));
                    break;
            }
        }
        return reward;
    }

    private int rewardSize() {
        return (int) (0 * (1.0 - (Math.random() / Math.nextDown(1.0)))
                + 3 * (Math.random() / Math.nextDown(1.0)));
    }

}
