package org.fantasy.inventory.drop.generator;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.hero.heroes.melee.Samurai;
import org.fantasy.inventory.weapon.Weapon;
import org.fantasy.inventory.weapon.melee.Widowmaker;

public class WeaponStatsGenerator {


    public Weapon generateWeapon(Hero hero, Weapon weapon) {
        BaseGenerator baseGenerator = new BaseGenerator();
        weapon.setRarity(baseGenerator.generateRarity());
        weapon.setDamage(damageBasedOnHero(hero));
        weapon.setRequiredLevel(requiredLevel(hero));
        weapon.normalize();
        return weapon;
    }

    private int damageBasedOnHero(Hero hero) {
        double damage = Math.random() / Math.nextDown(1.0);
        double x = hero.getLevel() * 10 * (1.0 - damage) + 10 * damage;
        return (int) Math.floor(x);
    }

    private int requiredLevel(Hero hero) {
        double damage = Math.random() / Math.nextDown(1.0);
        double x = (hero.getLevel() + 3) * 1 * (1.0 - damage) + 1 * damage;
        return (int) Math.floor(x);
    }

    public static void main(String[] args) {
        Samurai samurai = new Samurai();
        Widowmaker widowmaker = new Widowmaker();
        samurai.setLevel(20);
        new WeaponStatsGenerator().generateWeapon(samurai,widowmaker);
        System.out.println(widowmaker);
    }
}
