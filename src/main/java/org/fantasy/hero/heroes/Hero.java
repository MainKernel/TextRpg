package org.fantasy.hero.heroes;

import org.fantasy.hero.types.HeroType;
import org.fantasy.hero.skills.Skills;
import org.fantasy.inventory.Rarity;
import org.fantasy.inventory.armor.Armor;
import org.fantasy.inventory.Item;
import org.fantasy.inventory.armor.mage.StarFallRobe;
import org.fantasy.inventory.armor.melee.WarriorsPlateMail;
import org.fantasy.inventory.armor.renge.EagleEyeCamouflage;
import org.fantasy.inventory.weapon.Weapon;
import org.fantasy.inventory.weapon.mage.SorceryStaff;
import org.fantasy.inventory.weapon.melee.CrimsonFang;
import org.fantasy.inventory.weapon.range.LongshotBow;
import org.fantasy.tradingsystem.Money;
import org.fantasy.world.locations.BaseLocation;
import org.fantasy.world.locations.StartLocation;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    {
        location = new StartLocation();
        money = new Money(0, 3, 8);
        if (getHeroType() == HeroType.MAGE) {
            SorceryStaff sorceryStaff = new SorceryStaff();
            StarFallRobe starFallRobe = new StarFallRobe();
            setWeapon(sorceryStaff);
            setArmor(starFallRobe);
        } else if (getHeroType() == HeroType.MELEE) {
            CrimsonFang crimsonFang = new CrimsonFang();
            WarriorsPlateMail warriorsPlateMail = new WarriorsPlateMail();
            setWeapon(crimsonFang);
            setArmor(warriorsPlateMail);
        } else {
            LongshotBow longshotBow = new LongshotBow();
            EagleEyeCamouflage eagleEyeCamouflage = new EagleEyeCamouflage();
            setWeapon(longshotBow);
            setArmor(eagleEyeCamouflage);
        }
    }
    private int playerX = 0;
    private int playerY = 0;
    private String name;
    private int level = 1;
    private int experience;
    private int experienceForNextLvl = 80;
    private int maxHealth = 100;
    private int health = 100;
    private double protection;
    private int strength;
    private int dexterity;
    private int intelligence;
    private List<Item> inventory = new ArrayList<>();
    private Weapon weapon;
    private Armor armor;
    private List<Skills> skills;
    private Money money;
    private HeroType heroType;
    private int damage;
    private BaseLocation location;



    public void lvlUp() {
        // Increase the level
        level++;

        // Adjust attributes based on the hero type
        if (heroType == HeroType.MAGE) {
            maxHealth += 10;
            intelligence += 5;
        } else if (heroType == HeroType.MELEE) {
            maxHealth += 20;
            strength += 5;
        } else if (heroType == HeroType.RANGE) {
            maxHealth += 15;
            dexterity += 5;
        }

        // Reset health to maximum
        health = maxHealth;

        // Update the experience required for the next level (you can define your own formula)
        experienceForNextLvl = calculateExperienceForNextLevel();

        // Display a message to the player
        System.out.println("Congratulations! You've leveled up to level " + level);
    }

    private int calculateExperienceForNextLevel() {
        // This is a basic linear progression, you can adjust the values
        int baseExperience = 100;  // Adjust this based on your game's balance
        int experienceIncreasePerLevel = 50;  // Adjust this based on your game's balance

        return baseExperience + (level - 1) * experienceIncreasePerLevel;
    }

    public int doDamage() {
        int baseDamage = weapon.getDamage();

        switch (heroType) {
            case MAGE:
                // For Mage, consider intelligence in damage calculation
                baseDamage += intelligence / 2;
                break;
            case MELEE:
                // For Melee, consider strength in damage calculation
                baseDamage += strength;
                break;
            case RANGE:
                // For Range, consider dexterity in damage calculation
                baseDamage += dexterity / 2;
                break;
            default:
                // Handle other HeroTypes or provide a default value
                break;
        }
        // add more complex calculations here, such as critical hits and modifiers

        return baseDamage;
    }

    public void takeDamage(int damage) {
        int overAllProtection = armor.getProtection();
        int incomingDamage = overAllProtection - damage;
        if (damage > overAllProtection) {
            this.health = health - (incomingDamage - overAllProtection);
        }
    }

    public void equipWeapon(Weapon weapon) {
        if (this.weapon != null
                & getHeroType().equals(weapon.getHeroType())
                & weapon.getRequiredLevel() == this.getLevel()) {
            inventory.add(this.weapon);
            inventory.remove(weapon);
            System.out.println(weapon.getName() + " equipped");
            this.weapon = weapon;
        } else if (this.weapon == null
                & getHeroType().equals(weapon.getHeroType())
                & weapon.getRequiredLevel() == this.getLevel()) {
            inventory.remove(weapon);
            this.weapon = weapon;
            System.out.println(weapon.getName() + " equipped");
        } else if (weapon.getRequiredLevel() != this.getLevel()) {
            System.out.println("You need to be " + weapon.getRequiredLevel() + " level");
        } else {
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
        } else {
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

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
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

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    public BaseLocation getLocation() {
        return location;
    }

    public void setLocation(BaseLocation location) {
        this.location = location;
    }
}
