package org.fantasy.inventory.drop.generator;

import org.fantasy.hero.heroes.Hero;
import org.fantasy.hero.heroes.melee.Samurai;
import org.fantasy.inventory.armor.Armor;
import org.fantasy.inventory.armor.mage.*;
import org.fantasy.inventory.armor.melee.*;
import org.fantasy.inventory.armor.renge.*;
import org.fantasy.inventory.potions.*;
import org.fantasy.inventory.weapon.Weapon;
import org.fantasy.inventory.weapon.mage.*;
import org.fantasy.inventory.weapon.melee.*;
import org.fantasy.inventory.weapon.range.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemGenerator {
    private List<Weapon> weapons;
    private List<Armor> armors;
    private List<Potion> potions;
//    public ItemGenerator(Hero hero) {
//
//    }

    public List<Weapon> generateWeapomList(Hero hero){
        weaponInit();
        WeaponStatsGenerator weaponStatsGenerator = new WeaponStatsGenerator();
        List<Weapon> weaponList = new ArrayList<>();
        for (Weapon w:weapons) {
            weaponList.add(weaponStatsGenerator.generateWeapon(hero,w));
        }
        return weaponList;
    }
    public void weaponInit() {

        weapons = Arrays.asList(new AetherialStaff(), new ArcaneStaff(), new AstralScepter(), new CelestialGrimoire(),
                new DoomscrollTome(), new DragonfireRod(), new EtherealBlade(), new FrostfireWand(), new InfernalCodex(),
                new MysticRunestaff(), new NecromancersScythe(), new SorceryStaff(), new StaffOfTimebending(),
                new StarfallWand(), new VoidcallerStaff(), new BloodthirstAxe(), new CrimsonFang(), new DeathsEmbrace(),
                new DoombringerBlade(), new DragonsClaw(), new Excalibur(), new FrostbiteDagger(), new PhoenixTalon(),
                new RunicBlade(), new RunicWaraxe(), new Shadowblade(), new ShadowstrikeBlade(), new SoulreaperScythe(),
                new Stormbringer(), new ThunderstrikeHammer(), new VoidScythe(), new VorpalSword(), new WarlordsMaul(),
                new Widowmaker(), new CelestialArbalest(), new FirestormCannon(), new FrostshardLauncher(),
                new HawkEyeCrossbow(), new LongshotBow(), new MoonshadowShortbow(), new RangersRepeater(),
                new RapidfireBlunderbuss(), new ShadowstalkerBow(), new StingrayRevolver(), new ThunderclapRifle(),
                new VenomfangBlowgun(), new WhisperwindSling(), new WidowmakerSniper());

        armors = Arrays.asList(new AetherialSpellWeaver(), new ArcaneArchmageGarb(), new EtherealMageRobes(),
                new MoonshadowMageVestments(), new MysticRuneClothRobes(), new NecromancersDarkShroud(),
                new SpellboundPhoenixCloak(), new StarFallRobe(), new BarbariansBattleHarness(),
                new ChampionsBulwarkPlate(), new DuelistsRapierMail(), new ExecutionersGuillotineSet(),
                new GuardiansAegisArmor(), new MaraudersRaiderGear(), new PaladinsFaithfulPlate(),
                new WarriorsPlateMail(), new BoltCastersLightningVest(), new EagleEyeCamouflage(),
                new EaglesGazeScoutArmor(), new FrostarrowFrostcloak(), new MoonshadowScoutCloak(),
                new SharpshootersVestments(), new SilentWatchersGhillieSuit(), new StealthStrikersCamoSuit());

        potions = Arrays.asList(new ElixirOfDexterity(), new ElixirOfHealing(), new ElixirOfIntelligence(),
                new ElixirOfStrength(), new PotionOfDexterity(), new PotionOfHealing(), new PotionOfIntelligence(),
                new PotionOfStrength());
    }

    public static void main(String[] args) {
        ItemGenerator itemGenerator = new ItemGenerator();
        Samurai samurai = new Samurai();
        samurai.setLevel(3);
        List<Weapon> inventory = itemGenerator.generateWeapomList(samurai);
        for (Weapon w:
             inventory) {
            System.out.println(w);
            System.out.println();
        }
    }

}
