package net.peachmonkey.entity;

import net.peachmonkey.Constants.Alignment;

public class Hero extends Creature {

    public Hero(String name, int health) {
        super(name, health, Alignment.GOOD);
    }

}
