package net.peachmonkey.arena;

import net.peachmonkey.Constants.FightResult;
import net.peachmonkey.entity.Hero;
import net.peachmonkey.entity.Villain;
import net.peachmonkey.entity.Weapon;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArenaTest {

    @Test
    public void fight() {
        Villain ant = new Villain("Ant", 5);
        Hero hercules = new Hero("Hercules", 5000);
        assertEquals(new SimulationResult(null, FightResult.TIE, ""), Arena.fight(ant, hercules));

        Weapon mandibles = new Weapon("Mandibles", 2);
        ant.giveWeapon(mandibles);
        Weapon sword = new Weapon("Sword", 100);
        hercules.giveWeapon(sword);
        assertEquals(new SimulationResult(hercules, FightResult.DECISIVE, ""), Arena.fight(ant, hercules));
    }
}