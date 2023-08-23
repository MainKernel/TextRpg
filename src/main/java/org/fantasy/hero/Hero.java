package org.fantasy.hero;

import org.fantasy.combatsystem.HeroClass;
import org.fantasy.combatsystem.HeroType;
import org.fantasy.combatsystem.Skills;
import org.fantasy.inventory.armor.Armor;
import org.fantasy.inventory.Item;
import org.fantasy.inventory.weapon.Weapon;
import org.fantasy.tradingsystem.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    private String name;
    private int level;
    private int experience;
    private int experienceForNextLvl;
    private int maxHealth = 100;
    private int health = 100;
    private double protection = 3;
    private int strength;
    private int dexterity;
    private int intelligence;
    private List<Item> inventory = new ArrayList<>();
    private Weapon weapon;
    private Armor armor;
    private List<Skills> skills;
    private Money money;
    private HeroClass heroClass;
    private HeroType heroType;

    private void lvlUp() {
        setLevel(getLevel()+1);
        increaseBaseAttribute();
        System.out.println("Level up! " + getName() + " is now level " + getLevel());
    }

    private void increaseBaseAttribute() {
        if (getHeroType() == HeroType.MELEE) {
            setStrength(getStrength()+3);
            setMaxHealth(getMaxHealth()+8);
            setDexterity(getDexterity()+2);
            setIntelligence(getIntelligence()+1);
            setProtection(getStrength()*0.33);
        } else if(getHeroType() == HeroType.RANGE){
            setStrength(getStrength()+1);
            setMaxHealth(getMaxHealth()+5);
            setDexterity(getDexterity()+5);
            setIntelligence(getIntelligence()+2);
            setProtection(getStrength()*0.5);
        } else {
            setStrength(getStrength()+1);
            setMaxHealth(getMaxHealth()+5);
            setDexterity(getDexterity()+1);
            setIntelligence(getIntelligence()+7);
            setProtection(getStrength()*0.15);
        }
    }

    public  void setExperience(int experience){
        addExperience(getExperience() + experience);
        if (getExperience() >= getExperienceForNextLvl()) {
            do {
                lvlUp();
                // automatically increase exp need to get new lvl
                setExperienceForNextLvl(getExperienceForNextLvl() + (getLevel() * 10));
            } while (getExperience() >= getExperienceForNextLvl());
        }
    }


    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hero class=" + heroClass.toString() +
                ", level=" + level +
                ", experience=" + experience +
                ", maxHealth=" + maxHealth +
                ", health=" + health +
                ", protection=" + protection +
                ", inventory=" + inventory +
                ", weapon=" + weapon +
                ", armor=" + armor +
                ", skills=" + skills +
                ", money=" + money +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getMaxHealth() {
        return maxHealth;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health += Math.max(health, this.health);
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
    }

    public double getProtection() {
        return protection;
    }

    public void setProtection(double protection) {
        this.protection = protection;
    }

    public List<? extends Item> getInventory() {
        return inventory;
    }

    public void setInventory(Item item) {
        this.inventory.add(item);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        if(this.armor != null){
            protection -= this.armor.getProtection();
        }else {
            this.armor = armor;
        }
        protection +=armor.getProtection();
    }


    public List<Skills> getSkills() {
        return skills;
    }
    public void setSkills(Skills skill) {
        this.skills.add(skill);
    }

    public void setMoney(Money money){
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }

    public int getExperienceForNextLvl() {
        return experienceForNextLvl;
    }

    public void setExperienceForNextLvl(int experienceForNextLvl) {
        this.experienceForNextLvl += experienceForNextLvl;
    }


    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }
}
