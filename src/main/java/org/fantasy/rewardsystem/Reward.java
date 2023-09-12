package org.fantasy.rewardsystem;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.inventory.Item;
import org.fantasy.inventory.drop.generator.ItemGenerator;
import org.fantasy.tradingsystem.Money;

import java.util.List;

public class Reward {
    private Money money;
    private List<Item> reward;
    private int heroExperience;
    private int weaponExperience;
    private int armourExperience;


    public void useReward(Hero hero) {
        for (Item i :
                reward) {
            hero.addItem(i);
        }
        hero.getMoney().addMoney(getMoney());
        hero.addExp(getHeroExperience());
        hero.getWeapon().gainXp(getWeaponExperience());
        hero.getArmor().gainXp(getArmourExperience());
    }

    public Reward initSmallReward(Hero hero) {
        ItemGenerator generator = new ItemGenerator();
        Reward reward = new Reward();
        reward.setReward(generator.inventoryGenerator(hero, smallReward()));
        reward.setMoney(generator.genMoney("smallReward"));
        reward.setHeroExperience(generator.genHeroExp(hero, "smallReward"));
        reward.setWeaponExperience(generator.genWeaponExp(hero, "smallReward"));
        reward.setArmourExperience(generator.genArmorExp(hero, "smallReward"));
        return reward;
    }

    public Reward initLargeReward(Hero hero) {
        ItemGenerator generator = new ItemGenerator();
        Reward reward = new Reward();
        reward.setReward(generator.inventoryGenerator(hero, largeReward()));
        reward.setMoney(generator.genMoney("largeReward"));
        reward.setHeroExperience(generator.genHeroExp(hero, "largeReward"));
        reward.setWeaponExperience(generator.genWeaponExp(hero, "largeReward"));
        reward.setArmourExperience(generator.genArmorExp(hero, "largeReward"));
        return reward;
    }

    public int smallReward() {
        return (int) (1 * (1.0 - (Math.random() / Math.nextDown(1.0)))
                + 5 * (Math.random() / Math.nextDown(1.0)));
    }

    public int largeReward() {
        return (int) (1 * (1.0 - (Math.random() / Math.nextDown(1.0)))
                + 10 * (Math.random() / Math.nextDown(1.0)));
    }


    @Override
    public String toString() {
        return "money: " + money.toString() +
                "\nreward: " + listReward() +
                "\nheroExperience: " + heroExperience +
                "\nweaponExperience: " + weaponExperience +
                "\narmor experience: " + armourExperience;
    }

    private String listReward() {
        StringBuilder sb = new StringBuilder();
        for (Item i : reward
        ) {
            sb.append("\n");
            sb.append(i);
            sb.append("\n");
            sb.append("---------------");
        }
        return sb.toString();
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }


    public void setReward(List<Item> reward) {
        this.reward = reward;
    }

    public int getHeroExperience() {
        return heroExperience;
    }

    public void setHeroExperience(int heroExperience) {
        this.heroExperience = heroExperience;
    }

    public int getWeaponExperience() {
        return weaponExperience;
    }

    public void setWeaponExperience(int weaponExperience) {
        this.weaponExperience = weaponExperience;
    }

    public int getArmourExperience() {
        return armourExperience;
    }

    public void setArmourExperience(int armourExperience) {
        this.armourExperience = armourExperience;
    }
}
