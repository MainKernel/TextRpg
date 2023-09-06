package org.fantasy.inventory.armor;

import org.fantasy.hero.types.HeroType;
import org.fantasy.inventory.Item;
import org.fantasy.inventory.Rarity;
import org.fantasy.tradingsystem.Money;


public class Armor extends Item {
    private int protection;
    private int requiredLevel;
    private HeroType heroType;

    public void normalize() {
        switch (this.getRarity()) {
            case COMMON:
                this.protection = (int) Math.floor((protection * 1.1));
                normalizePrise(1);
                break;
            case UNCOMMON:
                this.protection = (int) Math.floor((protection * 1.2));
                normalizePrise(1.5);
                break;
            case RARE:
                this.protection = (int) Math.floor((protection * 1.3));
                normalizePrise(1.7);
                break;
            case BLESSED:
                this.protection = (int) Math.floor((protection * 1.4));
                normalizePrise(2);
                break;
            case LEGENDARY:
                this.protection = (int) Math.floor((protection * 1.5));
                normalizePrise(2.5);
                break;
            case IMMORTAL:
                this.protection = (int) Math.floor((protection * 1.8));
                normalizePrise(5);
                break;
            case DIVINE:
                this.protection = protection * 2;
                normalizePrise(10);
                break;
        }
    }


    private void normalizePrise(double coefficient) {
        this.getMoney().setGold((int) (this.getMoney().getGold() * coefficient));
        this.getMoney().setSilver((int) (this.getMoney().getSilver() * coefficient));
        this.getMoney().setCopper((int) (this.getMoney().getCopper() * coefficient));
    }

    public void setProtection(int protection) {
        this.protection = protection;
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

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
