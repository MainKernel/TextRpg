package org.fantasy.inventory.weapon;

import org.fantasy.hero.types.HeroType;
import org.fantasy.inventory.Item;

public class Weapon extends Item {

    private int damage;
    private HeroType heroType;
    private int weaponLevel = 1;
    private int weaponXp = 0;
    private int nextLvlXp = 100;

    public void normalize() {
        switch (this.getRarity()) {
            case COMMON:
                this.damage = (int) Math.floor((damage * 1.1));
                normalizePrise(1);
                break;
            case UNCOMMON:
                this.damage = (int) Math.floor((damage * 1.2));
                normalizePrise(1.5);
                break;
            case RARE:
                this.damage = (int) Math.floor((damage * 1.3));
                normalizePrise(1.7);
                break;
            case BLESSED:
                this.damage = (int) Math.floor((damage * 1.4));
                normalizePrise(2);
                break;
            case LEGENDARY:
                this.damage = (int) Math.floor((damage * 1.5));
                normalizePrise(2.5);
                break;
            case IMMORTAL:
                this.damage = (int) Math.floor((damage * 1.8));
                normalizePrise(5);
                break;
            case DIVINE:
                this.damage = damage * 2;
                normalizePrise(10);
                break;
        }
    }

    public void lvlUp() {
        while (weaponXp > nextLvlXp) {
            this.damage = (int) Math.floor((damage * (weaponLevel * 1.3)));
            this.weaponLevel += 1;
            this.nextLvlXp = (int) (this.weaponXp * 1.7);
        }
    }

    public void gainXp(int xp) {
        if ((weaponXp += xp) > nextLvlXp) {
            lvlUp();
        }else {
            weaponXp += xp;
        }
    }

    private void normalizePrise(double coefficient) {
        this.getMoney().setGold((int) (this.getMoney().getGold() * coefficient));
        this.getMoney().setSilver((int) (this.getMoney().getSilver() * coefficient));
        this.getMoney().setCopper((int) (this.getMoney().getCopper() * coefficient));
    }

    public int getDamage() {
        return damage;
    }


    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    public int getWeaponLevel() {
        return weaponLevel;
    }

    public void setWeaponLevel(int weaponLevel) {
        this.weaponLevel = weaponLevel;
    }

    public int getNextLvlXp() {
        return nextLvlXp;
    }

    public int getWeaponXp() {
        return weaponXp;
    }


    @Override
    public String toString() {
        return
                "name : " + getName() +
                        "\ndamage :  " + getDamage() +
                        "\nrarity : " + getRarity() +
                        "\nweapon level : " + getWeaponLevel() +
                        "\nweapon xp : " + getWeaponXp() +
                        "\nweapon next level xp: " + getNextLvlXp() +
                        "\ncoast : " + getMoney().toString();
    }
}
