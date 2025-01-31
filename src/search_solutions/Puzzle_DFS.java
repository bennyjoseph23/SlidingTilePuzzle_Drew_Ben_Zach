package search_solutions;

import core_search.BaseSearch;
import core_search.FILOQueue;
import search_problems.Puzzle;

import java.util.List;

public class Puzzle_DFS {
    public Puzzle_DFS() {
        // Create the puzzle problem and frontier DFS = FILO
        Puzzle puzzle = new Puzzle();
        FILOQueue<List<Integer>, String> frontier = new FILOQueue<>();

        // Create the BaseSearch
        BaseSearch<List<Integer>, String> search = new BaseSearch<>(puzzle, frontier);

        //Run the search
        boolean found = search.search();
        if (!found) {
            System.out.println("No solution found.");
        }
    }

    public static void main(String[] args) {
        // Solve using DFS
        new Puzzle_DFS();
    }
}
