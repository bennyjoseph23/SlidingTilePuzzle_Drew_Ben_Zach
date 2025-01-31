package search_problems;

import core_search.Problem;
import core_search.Tuple;

import java.util.ArrayList;
import java.util.List;



public class Puzzle implements Problem<List<Integer>, String> {
    //Variables setting the game board size and both states
    private final int SIZE = 3;
    private final List<Integer> INITIAL_STATE = new ArrayList<>(List.of(7,2,4, 5,0,6, 8,3,1));
    private final List<Integer> GOAL_STATE = new ArrayList<>(List.of(0,1,2, 3,4,5, 6,7,8));


    @Override
    public List<Integer> initialState() {
        return INITIAL_STATE;
    }

    @Override
    public List<Integer> goalState() {
        return GOAL_STATE;
    }

    @Override
    public List<Tuple<List<Integer>, String>> execution(List<Integer> state) {
        List<Tuple<List<Integer>, String>> result = new ArrayList<>();
        int zeroIndex = state.indexOf(0);  // Find the 0
        int row = zeroIndex / SIZE;        // Calculate row based on index
        int col = zeroIndex % SIZE;       // Calculate column based on index

        //Move the 0(empty space) in all possible ways
        if (row > 0) {
            // Move up
            result.add(new Tuple<>(swap(state, zeroIndex, zeroIndex - SIZE), "Up", 1));
        }
        if (row < SIZE - 1) {
            // Move down
            result.add(new Tuple<>(swap(state, zeroIndex, zeroIndex + SIZE), "Down", 1));
        }
        if (col > 0) {
            // Move left
            result.add(new Tuple<>(swap(state, zeroIndex, zeroIndex - 1), "Left", 1));
        }
        if (col < SIZE - 1) {
            // Move right
            result.add(new Tuple<>(swap(state, zeroIndex, zeroIndex + 1), "Right", 1));
        }

        return result;
    }

    //Swap method to move the space
    private List<Integer> swap(List<Integer> state, int i, int j) {
        List<Integer> newState = new ArrayList<>(state);
        int temp = newState.get(i);
        newState.set(i, newState.get(j));
        newState.set(j, temp);
        return newState;
    }

    @Override
    //Prints puzzle
    public void printState(List<Integer> state) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(state.get(i * SIZE + j) + " ");
                }
                System.out.println();
            }
        }

    // Main method for testing
    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();

        // Print the initial state
        System.out.println("Initial State:");
        puzzle.printState(puzzle.initialState());

        // Generate and print possible moves (4)
        System.out.println("\nPossible moves from the initial state:");
        List<Tuple<List<Integer>, String>> possibleMoves = puzzle.execution(puzzle.initialState());
        for (Tuple<List<Integer>, String> move : possibleMoves) {
            System.out.println("Action: " + move.getAction());
            puzzle.printState(move.getState());
        }

        // Print the goal state
        System.out.println("\nGoal State:");
        puzzle.printState(puzzle.goalState());
    }
}

