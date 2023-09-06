package org.fantasy.hero.skills;

import org.fantasy.hero.types.HeroType;

public abstract class Skills {
    private int skillExp;
    private int lvl;
    private int damage;
    private String name;
    private String description;
    private HeroType heroType;
    private int chance;


    public int getSkillExp() {
        return skillExp;
    }

    public void setSkillExp(int skillExp) {
        if((this.skillExp += skillExp) >= 100){
            this.skillExp = (skillExp+= this.skillExp % 100);
            lvl = (this.skillExp += skillExp / 100);
        }else {
            this.skillExp = skillExp;
        }
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "name= " + name +
                ", heroClass='" + heroType + '\'' +
                ", lvl=" + lvl +
                ", damage=" + damage +
                ", description='" + description + '\'' +
                '}';
    }
}
