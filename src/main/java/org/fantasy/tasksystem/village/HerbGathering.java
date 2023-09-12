package org.fantasy.tasksystem.village;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.hero.heroes.melee.Samurai;
import org.fantasy.inventory.weapon.Weapon;
import org.fantasy.inventory.weapon.melee.Shadowblade;
import org.fantasy.rewardsystem.Reward;
import org.fantasy.tasksystem.BaseTask;

import java.util.Scanner;

public class HerbGathering extends BaseTask {
    {
        setName("Herb Gathering");
        setTaskDescription("\nThe local herbalist in the village is running low on rare " +
                "\nherbs needed for their potions. The player is asked to gather a specific " +
                "\nnumber of \"Glowing Moonflowers\" from the nearby forest.\n" +
                "\nTask Objectives:\n" +
                "\n" +
                "    Gather 5 Glowing Moonflowers.\n" +
                "    Return to the herbalist with the collected herbs.\n");
        setComplete(false);
    }

    public static void main(String[] args) {
        Samurai samurai = new Samurai();
        samurai.addItem(new Shadowblade());
        samurai.equipWeapon((Weapon) samurai.getInventory().get(0));
        new HerbGathering().watchTask(samurai);
    }

    public void watchTask(Hero hero) {
        setReward(new Reward().initLargeReward(hero));
        System.out.println(this);
    }


    @Override
    public void startTask(Hero hero) {
        //setReward
        int collectedMoonflowers = 0;
        while (!isComplete()) {
            synchronized (this) {
                collectedMoonflowers++;
                System.out.println("You've gathered a Glowing Moonflower.");
                try {
                    wait(taskDuration(userChoice()));
                } catch (InterruptedException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
            if (collectedMoonflowers >= 5) {
                setComplete(true);
                System.out.println("You've collected enough Glowing Moonflowers!");
                System.out.println("\nYour reward:");
                System.out.println(getReward());
                break;
            }
        }
        getReward().useReward(hero);
    }

    @Override
    public int userChoice() {
        Scanner scanner = new Scanner(System.in);
        int userInput = (int) (1 * (1.0 - (Math.random() / Math.nextDown(1.0)))
                + 4 * (Math.random() / Math.nextDown(1.0)));
        System.out.println("Where to go to look\n" +
                "1. North\n" +
                "2. South\n" +
                "3. West\n" +
                "4. East\n");
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                System.out.println("Searching on the north suburbs......");
                break;
            case 2:
                System.out.println("Searching on the south suburbs......");
                break;
            case 3:
                System.out.println("Searching on the west suburbs......");
                break;
            case 4:
                System.out.println("Searching on the east suburbs......");
                break;
            default:
                System.out.println("Searching nearby.......");
                break;
        }
        if (userInput == i) {
            return 0;
        }
        return 2;
    }

    @Override
    public String toString() {
        return getName() +
                "\nTask Description: " + getTaskDescription() +
                "\nCompleted: " + (isComplete() ? "Yes" : "No") +
                "\nTask Reward: \n" + getReward().toString();
    }
}
