package org.fantasy.inventory.potions;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.inventory.Item;

public class Potion extends Item {
    int healHp;
    int dexterity;
    int strength;
    int intelligence;

    public void consume(Hero hero) {
        hero.setHealth(Math.min(hero.getHealth() + healHp, hero.getMaxHealth()));
        hero.setDexterity(hero.getDexterity() + this.dexterity);
        hero.setStrength(hero.getStrength() + this.strength);
        hero.setIntelligence(hero.getIntelligence() + this.intelligence);
    }


}
