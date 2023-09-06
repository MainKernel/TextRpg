package org.fantasy.inventory.potions;

import org.fantasy.inventory.Item;
import org.fantasy.inventory.Rarity;
import org.fantasy.tradingsystem.Money;

public class Potion extends Item implements Consumables{

    public Potion(String name, Rarity rarity, Money money) {
        super(name, rarity, money);
    }

    @Override
    public void consume() {

    }
}
