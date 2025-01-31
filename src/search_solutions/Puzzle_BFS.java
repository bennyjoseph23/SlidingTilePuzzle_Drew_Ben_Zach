package search_solutions;

import core_search.BaseSearch;
import core_search.FIFOQueue;
import search_problems.Puzzle;
import search_problems.Travel;

import java.util.List;

public class Puzzle_BFS {
    public Puzzle_BFS() {
        // Create the problem and frontier (FIFOQueue for BFS)
        Puzzle puzzle = new Puzzle();
        FIFOQueue<List<Integer>, String> frontier = new FIFOQueue<>(); // Use the FIFOQueue for BFS

        // Create the BaseSearch instance
        BaseSearch<List<Integer>, String> search = new BaseSearch<>(puzzle, frontier);

        // Perform the search
        boolean found = search.search();
        if (!found) {
            System.out.println("No solution found.");
        }
    }

    public static void main(String[] args) {
        // Create a new instance of Puzzle_BFS to start the search
        new Puzzle_BFS();
    }
}
