package org.fantasy.enemy;

import org.fantasy.enemy.skills.EnemySkill;
import org.fantasy.hero.skills.Skills;

import java.util.ArrayList;
import java.util.List;

public class Enemy {
    int damage;
    int agility;
    int strength;
    int level;
    int health;
    boolean isAlive = true;

    List<EnemySkill> enemySkills = new ArrayList<>();

    public Enemy(int damage, int agility, int strength, int level, int health) {
        this.damage = damage;
        this.agility = agility;
        this.strength = strength;
        this.level = level;
        this.health = health;
    }

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
}
