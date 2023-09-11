package org.fantasy.tradingsystem.trader;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.inventory.Item;
import org.fantasy.tradingsystem.Money;

import java.util.List;

public class Trader {
    {
        setMoney(new Money(999999,99999,999999));
    }
    private List<Item> items;
    private Money money;

    public Trader(List<Item> items) {
        this.items = items;
    }

    public void buy(Hero hero, Item item) {
        System.out.println(item.getName() + " successfully sold for " + item.getMoney().toString());
        if (this.money.subtractMoney(item.getMoney())) {
            hero.addMoney(item.getMoney());
            this.money.subtractMoney(item.getMoney());
            hero.removeItem(item);
            addItem(item);

        } else {
            System.out.println("Trader do not have enough money to buy " + item.getName());
        }
    }

    public void sell(Hero hero, Item item) {
        Money money = item.getMoney();
        if (hero.takeMoney(money) == 1) {
            this.money.addMoney(item.getMoney());
            System.out.println("You successfully buy " + item.getName() + " for " + money.toString());
            hero.addItem(item);
            this.removeItem(item);
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
    }
}
