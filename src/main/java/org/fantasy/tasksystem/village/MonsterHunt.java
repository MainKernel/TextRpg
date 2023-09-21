package org.fantasy.tasksystem.village;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.inventory.weapon.Weapon;
import org.fantasy.inventory.weapon.melee.Shadowblade;
import org.fantasy.rewardsystem.Reward;
import org.fantasy.tasksystem.BaseTask;

import java.util.Scanner;

public class MonsterHunt extends BaseTask {
    {
        setName("Monster Hunt");
        setTaskDescription("\nThe village is terrorized by a fierce monster " +
                "that dwells in the nearby forest. The player is tasked with hunting down " +
                "and defeating the monster to ensure the safety of the village.\n" +
                "\nTask Objectives:\n" +
                "\n" +
                "    Locate and confront the monster in the forest.\n" +
                "    Defeat the monster and return victorious to the village.\n");
        setComplete(false);
    }

    @Override
    public void startTask(Hero hero) {
        // Set the player's weapon for the mission
        Weapon playerWeapon = new Shadowblade();
        hero.setWeapon(playerWeapon);

        System.out.println("You are armed with a " + playerWeapon.getName() + ".");
        System.out.println("Prepare to hunt down the fierce monster in the forest!");

        // Simulate a battle with the monster (You can add more complexity here)
        boolean monsterDefeated = simulateMonsterBattle(hero);

        if (monsterDefeated) {
            setComplete(true);
            System.out.println("You've defeated the monster!");
            System.out.println("\nYour reward:");
            System.out.println(getReward());
        } else {
            System.out.println("You were unable to defeat the monster. The village remains in danger.");
        }
    }

    @Override
    public int userChoice() {
        return 0;
    }

    // Simulate a battle with the monster (You can customize this)
    private boolean simulateMonsterBattle(Hero hero) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You encounter the fierce monster!");

        while (true) {
            System.out.println("Choose your action:");
            System.out.println("1. Attack");
            System.out.println("2. Flee");

            int choice = scanner.nextInt();

            if (choice == 1) {
                // Calculate damage based on hero's weapon and stats (You can use your doDamage() method)
                int heroDamage = hero.doDamage();
                int monsterHealth = 100;  // Initial monster health (You can adjust this)
                monsterHealth -= heroDamage;

                if (monsterHealth <= 0) {
                    return true; // Monster defeated
                } else {
                    System.out.println("You dealt " + heroDamage + " damage to the monster.");
                    System.out.println("The monster has " + monsterHealth + " health remaining.");
                }
            } else if (choice == 2) {
                System.out.println("You flee from the battle.");
                return false; // Player chose to flee
            }
        }
    }

    @Override
    public String toString() {
        return getName() +
                "\nTask Description: " + getTaskDescription() +
                "\nCompleted: " + (isComplete() ? "Yes" : "No") +
                "\n\nTask Reward: \n" + getReward().toString();
    }
}
