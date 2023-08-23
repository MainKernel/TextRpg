package org.fantasy.inventory.drop.generator;

import org.fantasy.combatsystem.HeroClass;
import org.fantasy.combatsystem.HeroType;
import org.fantasy.hero.Hero;
import org.fantasy.inventory.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class WeaponGenerator {
    private final List<Weapon> weapons;

    private WeaponGenerator() {
        weapons = new ArrayList<>();
    }

    public List<Weapon> getWeapons(Hero hero){
        List<Weapon> randomWeapon =  randomWeapons(hero);

        return weapons;
    }

    private List<Weapon> randomWeapons(Hero hero) {
        HeroType heroType = hero.getHeroType();
        hero.
    }


}
