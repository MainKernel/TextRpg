package org.fantasy.hero;

import org.fantasy.combatsystem.HeroClass;
import org.fantasy.combatsystem.HeroType;
import org.fantasy.inventory.Rarity;
import org.fantasy.inventory.armor.Armor;
import org.fantasy.inventory.weapon.Weapon;
import org.fantasy.tradingsystem.Money;

public class Templar extends Hero {

    public Templar(String name) {
        setName(name);
        setHeroClass(HeroClass.TEMPLAR);
        setHeroType(HeroType.MELEE);
        setDexterity(3);
        setStrength(6);
        setIntelligence(1);
        setWeapon(new Weapon("Stick", Rarity.COMMON,3, HeroType.MELEE,
                new  Money(0,0,0)));
        setArmor(new Armor("Rusty Plates", Rarity.COMMON, 1,
                0, new Money(0,0,0)));
    }

}
