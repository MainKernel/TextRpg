package org.fantasy;

import org.fantasy.combatsystem.HeroType;
import org.fantasy.hero.Templar;
import org.fantasy.inventory.Rarity;
import org.fantasy.inventory.weapon.Weapon;
import org.fantasy.tradingsystem.Money;

public class Main {
    public static void main(String[] args) {
        Money coast =  new Money(0,0,3);
        Weapon item = new Weapon("Sword", Rarity.COMMON,10, HeroType.MELEE, coast);


        Templar swordsman = new Templar("Ancient Evil");
        swordsman.setInventory(item);
        swordsman.setWeapon(item);
        swordsman.setMoney(new Money(1,2,134));
        System.out.println(swordsman.getMoney().toString());

        System.out.println("----------------");
        System.out.println(swordsman);

        swordsman.setExperience(30);
        System.out.println(swordsman.getExperience());
        System.out.println(swordsman.getLevel());
    }
}