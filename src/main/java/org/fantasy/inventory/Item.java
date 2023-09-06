package org.fantasy.inventory;

import org.fantasy.tradingsystem.Money;

public abstract class Item {
    private String name;
    private Rarity rarity;
    private Money money;

    public Item(String name, Rarity rarity, Money money) {
        this.name = name;
        this.rarity = rarity;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }
}
