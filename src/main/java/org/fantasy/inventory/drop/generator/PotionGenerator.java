package org.fantasy.inventory.drop.generator;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.hero.heroes.melee.Samurai;
import org.fantasy.inventory.Rarity;
import org.fantasy.inventory.potions.ElixirOfHealing;
import org.fantasy.inventory.potions.Potion;

public class PotionGenerator {

    public Potion generatePotion(Hero hero, Potion potion) {

        if (potion.getName().contains("Elixir")) {
           return elixirStatsGenerator(hero, potion);
        } else {
            return potionStatsGenerator(hero, potion);
        }
    }

    private Potion elixirStatsGenerator(Hero hero, Potion potion) {
        switch (potion.getName()) {
            case "Elixir of Dexterity":
                potion.setDexterity(BaseGenerator.getInstance().elixirGenerator());
                break;
            case "Elixir of Healing":
                potion.setHealHp((int)(hero.getMaxHealth() * 0.75));
                break;
            case "Elixir of Intelligence":
                potion.setIntelligence(BaseGenerator.getInstance().elixirGenerator());
                break;
            case "Elixir of Strength":
                potion.setStrength(BaseGenerator.getInstance().elixirGenerator());
                break;
            default:
                break;
        }
        return potion;
    }

    private Potion potionStatsGenerator(Hero hero, Potion potion) {
        switch (potion.getName()) {
            case "Potion of Dexterity":
                potion.setDexterity(BaseGenerator.getInstance().elixirGenerator() > 1 ? 1 : 2);
                break;
            case "Potion of Healing":
                potion.setHealHp((int)(hero.getMaxHealth() * 0.40));
                break;
            case "Potion of Intelligence":
                potion.setIntelligence(BaseGenerator.getInstance().elixirGenerator() > 1 ? 1 : 2);
                break;
            case "Potion of Strength":
                potion.setStrength(BaseGenerator.getInstance().elixirGenerator() > 1 ? 1 : 2);
                break;
        }
        return potion;
    }

    public static void main(String[] args) {
        Potion potion = new ElixirOfHealing();
        Samurai samurai = new Samurai();
        PotionGenerator potionGenerator = new PotionGenerator();
        for (int i = 0; i < 20; i++) {
            System.out.println(potionGenerator.generatePotion(samurai, potion));
        }
    }
}
