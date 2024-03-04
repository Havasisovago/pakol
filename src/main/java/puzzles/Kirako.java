package puzzles;

import search.AbstractState;
import search.State;
import java.util.ArrayList;
enum Negyzet {A, B, C};
public class Kirako extends AbstractState {
    ArrayList<Negyzet> bal;
    ArrayList<Negyzet> jobb;

    public Kirako() {
        this.bal = new ArrayList<>();
        this.jobb = new ArrayList<>();
    }

    @Override
    public Iterable<State> getPossibleMoves() {
        ArrayList<State> moves = new ArrayList<>();

        for (Negyzet square : bal) {
            Kirako newState = new Kirako();
            newState.bal = new ArrayList<>(this.bal); // Másoljuk az eredeti listát
            newState.jobb = new ArrayList<>(this.jobb); // Másoljuk az eredeti listát
            newState.bal.remove(square);
            newState.jobb.add(square);
            moves.add(newState);
        }

        for (Negyzet square : jobb) {
            Kirako newState = new Kirako();
            newState.bal = new ArrayList<>(this.bal); // Másoljuk az eredeti listát
            newState.jobb = new ArrayList<>(this.jobb); // Másoljuk az eredeti listát
            newState.jobb.remove(square);
            newState.bal.add(square);
            moves.add(newState);
        }

        return moves;
    }



    @Override
    public boolean isSolution() {
        return bal.isEmpty() && jobb.isEmpty();
    }

    @Override
    public double getHeuristic() {
        return 0;
    }
}
