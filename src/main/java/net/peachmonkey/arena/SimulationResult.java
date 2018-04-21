package net.peachmonkey.arena;

import net.peachmonkey.Constants.FightResult;
import net.peachmonkey.entity.Creature;

import java.util.Objects;

public class SimulationResult {

    private Creature winner;
    private FightResult result;
    private String reason;

    public SimulationResult(Creature winner, FightResult result, String reason) {
        this.winner = winner;
        this.result = result;
        this.reason = reason;
    }

    public Creature getWinner() {
        return winner;
    }

    public void setWinner(Creature winner) {
        this.winner = winner;
    }

    public FightResult getResult() {
        return result;
    }

    public void setResult(FightResult result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SimulationResult that = (SimulationResult) o;
        return Objects.equals(winner, that.winner) &&
                result == that.result;
    }

    @Override
    public int hashCode() {

        return Objects.hash(winner, result);
    }

    @Override public String toString() {
        return "SimulationResult [" +
                "winner=" + winner +
                ", result=" + result +
                ", reason='" + reason + '\'' +
                ']';
    }
}
