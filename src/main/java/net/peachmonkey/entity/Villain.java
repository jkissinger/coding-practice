package net.peachmonkey.entity;

import net.peachmonkey.Constants.Alignment;

public class Villain extends Creature {

    public Villain(String name, int health) {
        super(name, health, Alignment.EVIL);
    }

}
