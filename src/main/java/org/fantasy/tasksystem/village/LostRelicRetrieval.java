package org.fantasy.tasksystem.village;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.inventory.Item;
import org.fantasy.inventory.armor.renge.StealthStrikersCamoSuit;
import org.fantasy.rewardsystem.Reward;
import org.fantasy.tasksystem.BaseTask;

import java.util.Scanner;

public class LostRelicRetrieval extends BaseTask {
    {
        setName("Lost Relic Retrieval");
        setTaskDescription("\nAn ancient artifact of great value has been stolen from the village museum.\n "
                + "The player must track down the thief, recover the relic, and return it to the museum.\n"
                + "Task Objectives:\n\n"
                + "    Investigate the crime scene.\n"
                + "    Follow clues to locate the thief.\n"
                + "    Retrieve the stolen relic.\n");
        setComplete(false);
    }

    @Override
    public void startTask(Hero hero) {
        int cluesFound = 0;
        boolean thiefFound = false;
        boolean relicRecovered = false;

        System.out.println("You begin your investigation into the stolen relic...");

        // Implement the logic for investigating, finding clues, and locating the thief.
        // You can use loops, conditions, and user input to simulate the investigation process.

        // For simplicity, we'll assume the hero finds clues and locates the thief.
        cluesFound = 3;
        thiefFound = true;

        if (cluesFound >= 3 && thiefFound) {
            System.out.println("You've located the thief and recovered the stolen relic!");
            relicRecovered = true;
        } else {
            System.out.println("Your investigation did not yield results. The relic remains missing.");
        }

        if (relicRecovered) {
            setComplete(true);
            Reward reward = new Reward(); // Customize the reward as needed.
            reward.useReward(hero);
            System.out.println("You've completed the mission!");
            System.out.println("Your reward:");
            System.out.println(reward);
        }
    }

    @Override
    public int userChoice() {
        Scanner scanner = new Scanner(System.in);

        // Implement user choices relevant to the investigation (e.g., examining a room, interviewing a suspect).
        return 0; // For simplicity, we assume a successful choice here.
    }
}
