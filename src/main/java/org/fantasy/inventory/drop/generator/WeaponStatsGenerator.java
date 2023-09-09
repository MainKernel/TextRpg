package org.fantasy.inventory.drop.generator;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.inventory.weapon.Weapon;

public class WeaponStatsGenerator {


    public Weapon generateWeapon(Hero hero, Weapon weapon) {
        BaseGenerator baseGenerator = BaseGenerator.getInstance();
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

}
