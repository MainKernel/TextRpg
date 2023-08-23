package org.fantasy.inventory.armor;

import org.fantasy.inventory.Item;
import org.fantasy.inventory.Rarity;
import org.fantasy.tradingsystem.Money;

public class Armor extends Item {
    private int protection;
    private int requiredLevel;

    public Armor(String name, Rarity rarity, int protection, int requiredLevel, Money money) {
        super(name, rarity,money);
        this.protection = protection;
        this.requiredLevel = requiredLevel;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
