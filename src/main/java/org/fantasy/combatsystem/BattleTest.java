package org.fantasy.combatsystem;

import org.fantasy.enemy.Enemy;
import org.fantasy.hero.heroes.Hero;

public class BattleTest {

    public void startBattle(Hero hero, Enemy enemy) {
        while (enemy.getAlive()){
            System.out.println(hero.getName() + " hit enemy for " + hero.doDamage());
            enemy.takeDamage(hero.doDamage());
            System.out.println("Enemy have " + enemy.getHealth());
        }
        System.out.println("Battle ends, hero winn");
    }
}
