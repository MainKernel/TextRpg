package org.fantasy.inventory.armor;

import org.fantasy.hero.types.HeroType;
import org.fantasy.inventory.Item;
import org.fantasy.tradingsystem.Money;


public class Armor extends Item {
    private int protection;
    private int requiredLevel;
    private HeroType heroType;

    {
        setMoney(new Money(1, 1, 1));
    }

    public void normalize() {
        switch (this.getRarity()) {
            case COMMON:
                this.protection = (int) Math.floor((protection * 1.1));
                setMoney(new Money(0,1,1));
                normalizePrise(1);
                break;
            case UNCOMMON:
                this.protection = (int) Math.floor((protection * 1.2));
                setMoney(new Money(0,5,1));
                normalizePrise(1.5);
                break;
            case RARE:
                this.protection = (int) Math.floor((protection * 1.3));
                setMoney(new Money(1,2,1));
                normalizePrise(1.7);
                break;
            case BLESSED:
                this.protection = (int) Math.floor((protection * 1.4));
                setMoney(new Money(5,1,3));
                normalizePrise(2);
                break;
            case LEGENDARY:
                this.protection = (int) Math.floor((protection * 1.5));
                setMoney(new Money(5,1,4));
                normalizePrise(2.5);
                break;
            case IMMORTAL:
                this.protection = (int) Math.floor((protection * 1.8));
                setMoney(new Money(5,4,1));
                normalizePrise(5);
                break;
            case DIVINE:
                this.protection = protection * 2;
                setMoney(new Money(5,9,9));
                normalizePrise(10);
                break;
        }
    }


    private void normalizePrise(double coefficient) {
        this.getMoney().setGold((int) (this.getMoney().getGold() * coefficient));
        this.getMoney().setSilver((int) (this.getMoney().getSilver() * coefficient));
        this.getMoney().setCopper((int) (this.getMoney().getCopper() * coefficient));
    }

    public Armor copy() {
        Armor newArmor = new Armor();
        newArmor.setName(this.getName());
        newArmor.setProtection(this.getProtection());
        newArmor.setRequiredLevel(this.getRequiredLevel());
        newArmor.setRarity(this.getRarity());
        newArmor.setMoney(this.getMoney());
        newArmor.setDescription(this.getDescription());
        newArmor.setHeroType(this.getHeroType());
        return newArmor;
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "protection=" + protection +
                ", requiredLevel=" + requiredLevel +
                ", heroType=" + heroType +
                ", cost=" + getMoney().toString() +
                ", rarity= " + getRarity() +
                '}';
    }
    public void gainXp(int armourExperience) {

    }
}
