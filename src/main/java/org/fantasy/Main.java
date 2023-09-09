package org.fantasy;

import org.fantasy.combatsystem.BattleTest;
import org.fantasy.enemy.Enemy;
import org.fantasy.hero.heroes.melee.Samurai;
import org.fantasy.inventory.weapon.Weapon;
import org.fantasy.inventory.weapon.melee.MeleeWeapon;
import org.fantasy.inventory.weapon.melee.Widowmaker;

public class Main {
    public static void main(String[] args) {
        Widowmaker widowmaker = new Widowmaker();
        Weapon newWinemaker = widowmaker.copy();
        widowmaker.setDamage(20);

        newWinemaker.setDamage(4);
        System.out.println(widowmaker);
        System.out.println(newWinemaker);

    }
}