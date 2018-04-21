package net.peachmonkey.entity;

import net.peachmonkey.Constants.Alignment;

import java.util.ArrayList;
import java.util.List;

public class Creature {

    private String name;
    private int initialHealth;
    private int health;
    private Alignment alignment;
    private List<Weapon> weapons = new ArrayList<>();

    public Creature(String name, int health, Alignment alignment) {
        this.name = name;
        this.initialHealth = health;
        this.health = health;
        this.alignment = alignment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public void setInitialHealth(int initialHealth) {
        this.initialHealth = initialHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void giveWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public void takeWeapon(Weapon weapon) {
        this.weapons.remove(weapon);
    }

    public void disarm() {
        this.weapons.clear();
    }

    public String toKeyString() {
        return name + "[" + health + "]";
    }

    @Override public String toString() {
        return "Creature [" +
                "name='" + name + '\'' +
                ", initialHealth=" + initialHealth +
                ", health=" + health +
                ", alignment=" + alignment +
                ", weapons=" + weapons +
                ']';
    }
}
