package org.fantasy.inventory.weapon;

import org.fantasy.hero.types.HeroType;
import org.fantasy.inventory.Item;
import org.fantasy.inventory.Rarity;
import org.fantasy.tradingsystem.Money;

public class Weapon extends Item {
    {
        setMoney(new Money(0,0,0));
        setRarity(Rarity.COMMON);
    }
    private int damage = 10;
    private HeroType heroType;
    private int weaponLevel = 1;
    private int weaponXp = 0;
    private int nextLvlXp = 100;

    private int requiredLevel = 1;

    public void normalize() {
        switch (this.getRarity()) {
            case COMMON:
                this.damage = (int) Math.floor((damage * 1.1));
                setMoney(new Money(0,1,1));
                normalizePrise(1);
                break;
            case UNCOMMON:
                this.damage = (int) Math.floor((damage * 1.2));
                setMoney(new Money(0,5,1));
                normalizePrise(1.5);
                break;
            case RARE:
                this.damage = (int) Math.floor((damage * 1.3));
                setMoney(new Money(1,2,3));
                normalizePrise(1.7);
                break;
            case BLESSED:
                this.damage = (int) Math.floor((damage * 1.4));
                setMoney(new Money(5,1,3));
                normalizePrise(2);
                break;
            case LEGENDARY:
                this.damage = (int) Math.floor((damage * 1.5));
                setMoney(new Money(5,1,4));
                normalizePrise(2.5);
                break;
            case IMMORTAL:
                this.damage = (int) Math.floor((damage * 1.8));
                setMoney(new Money(5,4,1));
                normalizePrise(5);
                break;
            case DIVINE:
                this.damage = damage * 2;
                setMoney(new Money(5,9,9));
                normalizePrise(10);
                break;
        }
    }

    public void lvlUp() {
        while (weaponXp > nextLvlXp) {
            this.damage = (int) Math.floor((damage * (weaponLevel * 1.3)));
            this.weaponLevel += 1;
            this.nextLvlXp = (int) (this.nextLvlXp * 1.7);
        }
    }

    public void gainXp(int xp) {
        if ((weaponXp += xp) > nextLvlXp) {
            lvlUp();
        } else {
            weaponXp += xp;
        }
    }

    private void normalizePrise(double coefficient) {
        this.getMoney().setGold((int) (this.getMoney().getGold() * coefficient));
        this.getMoney().setSilver((int) (this.getMoney().getSilver() * coefficient));
        this.getMoney().setCopper((int) (this.getMoney().getCopper() * coefficient));
    }

    public Weapon() {

    }

    public Weapon copy() {
        Weapon weapon = new Weapon();
        weapon.setName(this.getName());
        weapon.setHeroType(this.getHeroType());
        weapon.setRarity(this.getRarity());
        weapon.setDamage(this.getDamage());
        weapon.setWeaponLevel(this.getWeaponLevel());
        weapon.setRequiredLevel(this.getRequiredLevel());
        weapon.setMoney(this.getMoney());
        weapon.setDescription(this.getDescription());
        return weapon;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    @Override
    public String toString() {
        return "name : " + getName() + "\ndamage :  " + getDamage() +
                "\nrarity : " + getRarity() + "\nweapon level : "
                + getWeaponLevel() + "\nweapon xp : " + getWeaponXp() +
                "\nweapon next level xp: " + getNextLvlXp() +
                "\nrequired level: " + requiredLevel +
                "\ncoast : " + getMoney().toString();
    }
}
