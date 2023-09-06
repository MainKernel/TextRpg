package org.fantasy.tradingsystem.trader;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.hero.heroes.melee.Samurai;
import org.fantasy.hero.types.HeroType;
import org.fantasy.inventory.Item;
import org.fantasy.inventory.Rarity;
import org.fantasy.inventory.weapon.Weapon;
import org.fantasy.tradingsystem.Money;

import java.util.ArrayList;
import java.util.List;

public class Trader {
    private List<Item> items;
    private Money money;

    public Trader(List<Item> items, Money money) {
        this.items = items;
        this.money = money;
    }

    public void buy(Hero hero, Item item) {
        System.out.println(item.getName() + " successfully sold for " + item.getMoney().toString());
        hero.addMoney(item.getMoney());
        hero.removeItem(item);
    }

    public void sell(Hero hero, Item item) {
        Money money = item.getMoney();
        if(hero.takeMoney(money) == 1){
            System.out.println("You successfully buy " + item.getName() + " for " + money.toString());
            hero.addItem(item);
        } else {
            System.out.println("Not enough money");
        }
    }


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public static void main(String[] args) {
        Trader trader = new Trader(new ArrayList<Item>(), new Money(100, 90,90));
        Samurai samurai = new Samurai();
        Weapon weapon = new Weapon("Common sword", Rarity.COMMON, new Money(1, 0, 0), 10,
                HeroType.MELEE, 1, 100);
        trader.addItem(weapon);
        samurai.addMoney(new Money(10,1,1));
        trader.sell(samurai,weapon);
        System.out.println(samurai.getMoney().toString());
    }
}
