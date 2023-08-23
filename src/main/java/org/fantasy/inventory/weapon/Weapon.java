package org.fantasy.inventory.weapon;

import org.fantasy.combatsystem.HeroType;
import org.fantasy.inventory.Item;
import org.fantasy.inventory.Rarity;
import org.fantasy.tradingsystem.Money;

public class Weapon extends Item {

    private int damage;
    private HeroType heroType;

    public Weapon(String name, Rarity rarity, int damage, HeroType heroType, Money money) {
        super(name, rarity, money);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                " name= " + getName() +
                " damage= " + damage +
                " rarity= " + getRarity() +
                " coast= " + getMoney() +
                '}';
    }
}
