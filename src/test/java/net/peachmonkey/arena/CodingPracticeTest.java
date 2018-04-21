package net.peachmonkey.arena;

import net.peachmonkey.Constants.Alignment;
import net.peachmonkey.entity.Creature;
import net.peachmonkey.entity.Hero;
import net.peachmonkey.entity.Villain;
import net.peachmonkey.entity.Weapon;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CodingPracticeTest {

    @Test
    public void basicTest() {
        int num = 1 + 1;

        assertEquals(2, num);
    }

    @Test
    public void easyFixTest() {
        int num = 3 * 4;

        // ------ Only change above this line
        assertEquals(7, num);
    }

    @Test
    public void wordTest() {
        String word = "Hello";

        // ------ Only change above this line
        assertEquals("Goodbye", word);
    }

    @Test
    public void creatureTest() {
        Creature creature = new Creature("Jeff the Monkey", 3, Alignment.NEUTRAL);

        // ------ Only change above this line
        assertEquals("The creature has the wrong name!", "Fred the Monkey", creature.getName());
        assertEquals("A monkey should have 10 health.", 10, creature.getHealth());
        assertEquals("A monkey is neither good nor evil.", Alignment.NEUTRAL, creature.getAlignment());
    }

    @Test
    public void fightTest() {
        Hero hercules = new Hero("Hercules", 500);
        Weapon fist = new Weapon("Fist", 50);
        hercules.giveWeapon(fist);
        Villain antaeus = new Villain("Antaeus", 2000);
        Weapon sword = new Weapon("Sword", 200);
        antaeus.giveWeapon(sword);

        // ------ Only change above this line
        SimulationResult result = Arena.fight(hercules, antaeus);
        assertEquals("Hercules should win against Antaeus!", hercules, result.getWinner());
    }

}
