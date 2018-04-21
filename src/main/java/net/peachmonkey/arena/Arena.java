package net.peachmonkey.arena;

import net.peachmonkey.Constants.Alignment;
import net.peachmonkey.Constants.FightResult;
import net.peachmonkey.entity.Creature;
import net.peachmonkey.entity.Weapon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Arena {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Random random = new Random();

    public static SimulationResult fight(Creature c1, Creature c2) {
        if (c1.getAlignment().equals(c2.getAlignment())) {
            return new SimulationResult(null, FightResult.TIE, "Fighters had the same alignment, so they refused to fight.");
        }
        if (!c1.getAlignment().equals(Alignment.EVIL) && !c2.getAlignment().equals(Alignment.EVIL)) {
            return new SimulationResult(null, FightResult.TIE, "Neither fighter was a villain, so they refused to fight.");
        }
        if (c1.getWeapons().isEmpty() && c2.getWeapons().isEmpty()) {
            return new SimulationResult(null, FightResult.TIE, "Neither fighter had weapons.");
        }
        if (c1.getWeapons().isEmpty() || c2.getWeapons().isEmpty()) {
            Creature winner = c1.getWeapons().isEmpty() ? c2 : c1;
            return new SimulationResult(winner, FightResult.DECISIVE, "Only one of the creatures had weapons.");
        }
        while (c1.getHealth() > 0 && c2.getHealth() > 0) {
            Creature first = random.nextInt(1) == 0 ? c1 : c2;
            Creature second = first == c1 ? c2 : c1;
            doDamage(first, second);
            doDamage(second, first);
        }
        Creature winner = c1.getHealth() > 0 ? c1 : c2;
        return new SimulationResult(winner, getFightResult(winner), "The creatures fought valiantly.");
    }

    private static FightResult getFightResult(Creature winner) {
        double percentageHealthRemaining = (double) winner.getHealth() / (double) winner.getInitialHealth();
        if (percentageHealthRemaining > 0.5) {
            return FightResult.DECISIVE;
        } else {
            return FightResult.CLOSE;
        }
    }

    private static void doDamage(Creature attacker, Creature victim) {
        if (attacker.getHealth() > 0) {
            int dmg = getRandomWeaponDamage(attacker);
            victim.setHealth(victim.getHealth() - dmg);
            LOGGER.info("{} did {} damage to {}", attacker.toKeyString(), dmg, victim.toKeyString());
        }
    }

    private static int getRandomWeaponDamage(Creature c) {
        Weapon weapon = getRandomWeapon(c);
        return random.nextInt(weapon.getPower());
    }

    private static Weapon getRandomWeapon(Creature c) {
        return c.getWeapons().get(random.nextInt(c.getWeapons().size()));
    }

}
