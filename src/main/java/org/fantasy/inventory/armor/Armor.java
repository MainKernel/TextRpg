package org.fantasy.inventory.armor;

import org.fantasy.inventory.Item;
import org.fantasy.inventory.Rarity;
import org.fantasy.tradingsystem.Money;


public class Armor extends Item {
    private int protection;
    private int requiredLevel;

    public Armor(String name, Rarity rarity, Money money) {
        super(name, rarity, money);
    }

    public int getProtection() {
        return protection;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
