package org.fantasy.inventory.drop.generator;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.inventory.armor.Armor;

import java.util.List;

public class ArmorGenerator {

    public static void main(String[] args) {

    }

    public Armor armorDrop(Hero hero) {
        List<Armor> armors = new ItemGenerator().generateArmor(hero);
        return armors.get((int) (0 * (1.0 - (Math.random() / Math.nextDown(1.0)))
                + armors.size() * (Math.random() / Math.nextDown(1.0))));
    }

    public Armor getArmor(Hero hero, Armor armor) {
        BaseGenerator baseGenerator = BaseGenerator.getInstance();
        armor.setRarity(baseGenerator.generateRarity());
        armor.setProtection(damageBasedOnHero(hero));
        armor.setRequiredLevel(requiredLevel(hero));
        armor.normalize();
        return armor;
    }

    private int damageBasedOnHero(Hero hero) {
        double damage = Math.random() / Math.nextDown(1.0);
        double x = hero.getLevel() * 2 * (1.0 - damage) + 2 * damage;
        return (int) Math.floor(x);
    }

    private int requiredLevel(Hero hero) {
        double damage = Math.random() / Math.nextDown(1.0);
        double x = (hero.getLevel() + 3) * 1 * (1.0 - damage) + 1 * damage;
        return (int) Math.floor(x);
    }
}
