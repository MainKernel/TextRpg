package org.fantasy.inventory.drop.generator;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.inventory.potions.Potion;

public class PotionGenerator {
    BaseGenerator baseGenerator = BaseGenerator.getInstance();

    public Potion generatePotion(Hero hero, Potion potion) {
        potion.setRarity(baseGenerator.generateRarity());
        if (potion.getName().contains("Elixir")) {
            return elixirStatsGenerator(hero, potion);
        } else {
            return potionStatsGenerator(hero, potion);
        }

    }

    private Potion elixirStatsGenerator(Hero hero, Potion potion) {
        Potion newPotion = potion.copy();
        switch (potion.getName()) {
            case "ElixirOfDexterity":
                potion.setDexterity(baseGenerator.elixirGenerator());
                break;
            case "ElixirOfHealing":
                potion.setHealHp((int)(hero.getMaxHealth() * 0.75));
                break;
            case "ElixirOfIntelligence":
                potion.setIntelligence(baseGenerator.elixirGenerator());
                break;
            case "ElixirOfStrength":
                potion.setStrength(baseGenerator.elixirGenerator());
                break;
            default:
                break;
        }
        return newPotion;
    }

    private Potion potionStatsGenerator(Hero hero, Potion potion) {
        Potion newPotion = potion.copy();
        switch (potion.getName()) {
            case "PotionOfDexterity":
                potion.setDexterity(baseGenerator.elixirGenerator() > 1 ? 1 : 2);
                break;
            case "PotionOfHealing":
                potion.setHealHp((int)(hero.getMaxHealth() * 0.50));
                break;
            case "PotionOfIntelligence":
                potion.setIntelligence(baseGenerator.elixirGenerator() > 1 ? 1 : 2);
                break;
            case "PotionOfStrength":
                potion.setStrength(baseGenerator.elixirGenerator() > 1 ? 1 : 2);
                break;
            default:
                break;
        }
        return newPotion;
    }


}
