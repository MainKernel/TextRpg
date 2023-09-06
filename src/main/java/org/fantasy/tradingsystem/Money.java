package org.fantasy.tradingsystem;

public class Money {
    private int gold;
    private int silver;
    private int copper;


    public Money(int gold, int silver, int copper) {
        this.gold = gold;
        this.silver = silver;
        this.copper = copper;
        normalize(); // Ensure proper formatting (e.g., 1 silver = 10 copper)
    }

    // Getters and Setters
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
        normalize();
    }

    public int getCopper() {
        return copper;
    }

    public void setCopper(int copper) {
        this.copper = copper;
        normalize();
    }

    // Normalize the money values to ensure proper conversion between currency types
    private void normalize() {
        int totalCopper = gold * 100 + silver * 10 + copper;
        gold = totalCopper / 100;
        silver = (totalCopper % 100) / 10;
        copper = totalCopper % 10;
    }

    // Add money to the current instance
    public void addMoney(Money money) {
        gold += money.getGold();
        silver += money.getSilver();
        copper += money.getCopper();
        normalize();
    }

    // Subtract money from the current instance (returns false if insufficient funds)
    public boolean subtractMoney(Money money) {
        int totalCopper = gold * 100 + silver * 10 + copper;
        int moneyCopper = money.getGold() * 100 + money.getSilver() * 10 + money.getCopper();

        if (totalCopper >= moneyCopper) {
            totalCopper -= moneyCopper;
            gold = totalCopper / 100;
            silver = (totalCopper % 100) / 10;
            copper = totalCopper % 10;
            return true;
        } else {
            return false; // Insufficient funds
        }
    }


    @Override
    public String toString() {
        return "gold " + gold +
                ", silver " + silver +
                ", copper " + copper;
    }
}