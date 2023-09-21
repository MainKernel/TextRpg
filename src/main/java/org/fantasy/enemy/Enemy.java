package org.fantasy.enemy;

import org.fantasy.enemy.skills.EnemySkill;

import java.util.ArrayList;
import java.util.List;

public class Enemy {
    private int damage;
    private int agility;
    private int strength;
    private int level;
    private int health;
    private boolean isAlive = true;
    private EnemyType enemyType;

    List<EnemySkill> enemySkills = new ArrayList<>();

    public void takeDamage(int damage) {
        if(damage < health){
            health = health - damage;
            isAlive = true;
        }else {
            health = 0;
            isAlive = false;
        }
    }
    public boolean getAlive() {
        return isAlive;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(EnemyType enemyType) {
        this.enemyType = enemyType;
    }

    public List<EnemySkill> getEnemySkills() {
        return enemySkills;
    }

    public void setEnemySkills(List<EnemySkill> enemySkills) {
        this.enemySkills = enemySkills;
    }
}
