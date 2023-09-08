package org.fantasy.rewardsystem;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.inventory.Item;
import org.fantasy.tradingsystem.Money;

import java.util.List;

public class Reward {
    private Money money;
    private List<Item> reward;
    private int heroExperience;
    private int weaponExperience;


    public void initReward(Hero hero){

    }
    public void getReward(Hero hero) {
        hero.getMoney().addMoney(this.money);
        hero.addExp(this.heroExperience);
        hero.getWeapon().gainXp(this.weaponExperience);
        for (Item i:reward) {
            hero.addItem(i);
        }
    }


}
