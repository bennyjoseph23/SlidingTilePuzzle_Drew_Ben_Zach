package search_solutions;

import core_search.BaseSearch;
import core_search.FIFOQueue;
import search_problems.Puzzle;

import java.util.List;

public class Puzzle_BFS {
    public Puzzle_BFS() {
        // Create the problem and frontier BFS = FIFO
        Puzzle puzzle = new Puzzle();
        FIFOQueue<List<Integer>, String> frontier = new FIFOQueue<>();

        // Create the BaseSearch
        BaseSearch<List<Integer>, String> search = new BaseSearch<>(puzzle, frontier);

        // Run the search
        boolean found = search.search();
        if (!found) {
            System.out.println("No solution found.");
        }
    }

    public static void main(String[] args) {
        // Solve the puzzle
        new Puzzle_BFS();
    }
}
