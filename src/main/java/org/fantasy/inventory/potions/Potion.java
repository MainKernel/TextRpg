package org.fantasy.inventory.potions;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.inventory.Item;

public class Potion extends Item {
    private int healHp;
    private int dexterity;
    private int strength;
    private int intelligence;

    public void consume(Hero hero) {
        hero.setHealth(Math.min(hero.getHealth() + healHp, hero.getMaxHealth()));
        hero.setDexterity(hero.getDexterity() + this.dexterity);
        hero.setStrength(hero.getStrength() + this.strength);
        hero.setIntelligence(hero.getIntelligence() + this.intelligence);
    }

    public Potion copy() {
        Potion potion = new Potion();
        potion.setName(this.getName());
        potion.setDescription(this.getDescription());
        potion.setRarity(this.getRarity());
        potion.setMoney(this.getMoney());
        return potion;
    }

    public int getHealHp() {
        return healHp;
    }

    public void setHealHp(int healHp) {
        this.healHp = healHp;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
