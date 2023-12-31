package org.fantasy.world.locations;


import org.fantasy.enemy.Enemy;
import org.fantasy.hero.heroes.Hero;
import org.fantasy.inventory.drop.generator.BaseGenerator;
import org.fantasy.world.dungeon.Dungeon;
import org.fantasy.world.village.Village;

import java.util.List;

public class BaseLocation {
    private String name;
    private String description;
    private int requiredLevel;
    private List<Enemy> enemyList;
    private int locationX;
    private int locationY;
    private Village village;
    private Dungeon dungeon;
    private Hero hero;

    private void generateVillage() {
        if (BaseGenerator.getInstance().eventRarityGenerator() == 1) {
            village = new Village();
        }
        if (BaseGenerator.getInstance().eventRarityGenerator() == 1) {
            dungeon = new Dungeon();
        }
    }

    public void enterLocation(Hero hero) {
        if (hero.getLevel() == this.requiredLevel) {
            this.hero = hero;
            hero.getLocation().removeHero();
            hero.setLocation(this);
            hero.setPlayerX(this.getLocationX());
            hero.setPlayerY(this.getLocationY());
        } else {
            System.out.println("Your level is " + hero.getLevel() +
                    ". Location required at least " + this.getRequiredLevel());
        }
    }
    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(List<Enemy> enemyList) {
        this.enemyList = enemyList;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public void removeHero() {
        this.hero = null;
    }
}
