package org.fantasy.inventory.weapon.range;

import org.fantasy.hero.types.HeroType;
import org.fantasy.inventory.Rarity;
import org.fantasy.inventory.weapon.Weapon;
import org.fantasy.tradingsystem.Money;

public class RangeWeapon extends Weapon {
    public RangeWeapon(String name, Rarity rarity, Money money, int damage, HeroType heroType, int weaponLevel, int nextLevel) {
        super(name, rarity, money, damage, heroType, weaponLevel, nextLevel);
    }
}
