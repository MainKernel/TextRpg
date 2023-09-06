package org.fantasy.inventory.weapon;

import org.fantasy.hero.types.HeroType;
import org.fantasy.inventory.Item;
import org.fantasy.inventory.Rarity;
import org.fantasy.tradingsystem.Money;

public class Weapon extends Item {

    private int damage;
    private HeroType heroType;
    private int weaponLevel;
    private int nextLevel;

    public Weapon(String name, Rarity rarity, Money money,
                  int damage, HeroType heroType, int weaponLevel, int nextLevel) {
        super(name, rarity, money);
        this.damage = damage;
        this.heroType = heroType;
        this.weaponLevel = weaponLevel;
        this.nextLevel = nextLevel;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    public int getWeaponLevel() {
        return weaponLevel;
    }

    public void setWeaponLevel(int weaponLevel) {
        this.weaponLevel = weaponLevel;
    }

    public int getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(int nextLevel) {
        this.nextLevel = nextLevel;
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
