package org.fantasy.tasksystem;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.rewardsystem.Reward;

public abstract class BaseTask {
    private String name;
    private String taskDescription;
    private Reward reward;
    private boolean isComplete;

    public abstract void startTask(Hero hero);

    public int taskDuration(int choice) {
        int duration = (int) (3000 * (1.0 - (Math.random() / Math.nextDown(1.0)))
                + 10000 * (Math.random() / Math.nextDown(1.0)));
        if(choice != 0){
            return duration * choice;
        }
        return duration;
    }

    public abstract int userChoice();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
