package org.fantasy;

import org.fantasy.combatsystem.BattleTest;
import org.fantasy.enemy.Enemy;
import org.fantasy.hero.heroes.Hero;
import org.fantasy.hero.heroes.melee.Melee;
import org.fantasy.hero.heroes.melee.Samurai;

public class Main {
    public static void main(String[] args) {
        Enemy enemy = new Enemy(19,3,5,3,100);
        Samurai samurai = new Samurai();
        BattleTest test = new BattleTest();
        test.startBattle(samurai, enemy);

    }
}