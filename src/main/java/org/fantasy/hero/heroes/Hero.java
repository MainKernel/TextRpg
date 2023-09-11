package org.fantasy.hero.heroes;

import org.fantasy.hero.types.HeroType;
import org.fantasy.hero.skills.Skills;
import org.fantasy.inventory.armor.Armor;
import org.fantasy.inventory.Item;
import org.fantasy.inventory.weapon.Weapon;
import org.fantasy.tradingsystem.Money;
import org.fantasy.world.locations.BaseLocation;
import org.fantasy.world.locations.StartLocation;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    int playerX = 0;
    int playerY = 0;
    String name;
    int level;
    int experience;
    int experienceForNextLvl;
    int maxHealth = 100;
    int health = 100;
    double protection;
    int strength;
    int dexterity;
    int intelligence;
    List<Item> inventory = new ArrayList<>();
    Weapon weapon;
    Armor armor;
    List<Skills> skills;
    Money money;
    HeroType heroType;
    int damage;
    BaseLocation location;

    {
        location = new StartLocation();
    }

    public abstract void lvlUp();

    public abstract void increaseBaseAttribute();

    public abstract int doDamage();

    public void takeDamage(int damage) {
        int overAllProtection = armor.getProtection();
        int incomingDamage = overAllProtection - damage;
        if (damage > overAllProtection) {
            this.health = health - (incomingDamage - overAllProtection);
        }
    }

    public void equipWeapon(Weapon weapon) {
        if (this.weapon != null & getHeroType().equals(weapon.getHeroType())) {
            inventory.add(this.weapon);
            inventory.remove(weapon);
            this.weapon = weapon;
        } else if (this.weapon == null & getHeroType().equals(weapon.getHeroType())) {
            inventory.remove(weapon);
            this.weapon = weapon;
        }else {
            System.out.println("This weapon is not suitable for your class");
        }

    }

    public void equipArmor(Armor armor) {
        if (this.armor != null & getHeroType().equals(armor.getHeroType())) {
            inventory.add(this.armor);
            inventory.remove(armor);
            this.armor = armor;
        } else if (this.armor == null & getHeroType().equals(armor.getHeroType())) {
            inventory.remove(armor);
            this.armor = armor;
        }else {
            System.out.println("This armor is not suitable for your class");
        }
    }

    public void addExp(int experience) {
        if ((this.experience += experience) > experienceForNextLvl) {
            lvlUp();
        } else {
            this.experience += experience;
        }
    }

    public void addMoney(Money money) {
        if (this.money == null) {
            this.money = money;
        } else {
            this.money.addMoney(money);
        }
    }

    public int takeMoney(Money money) {
        if (this.money.subtractMoney(money)) {
            return 1;
        } else {
            return 0;
        }
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public int getExperienceForNextLvl() {
        return experienceForNextLvl;
    }

    public void setExperienceForNextLvl(int experienceForNextLvl) {
        this.experienceForNextLvl = experienceForNextLvl;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getProtection() {
        return protection;
    }

    public void setProtection(double protection) {
        this.protection = protection;
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
        this.armor = armor;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public Money getMoney() {
        return money;
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public BaseLocation getLocation() {
        return location;
    }

    public void setLocation(BaseLocation location) {
        this.location = location;
    }
}
