package search_solutions;
import core_search.BaseSearch;
import core_search.SortedQueue;
import core_search.Node;
import search_problems.Puzzle;

import java.util.Comparator;
import java.util.List;
public class Puzzle_UCS {
    public Puzzle_UCS() {
        // Create a puzzle and a sorted Q
        Puzzle puzzle = new Puzzle();
        SortedQueue<List<Integer>, String> frontier =
                new SortedQueue<>(new ComparePathCost());

        // Create the BaseSearch
        BaseSearch<List<Integer>, String> search = new BaseSearch<>(puzzle, frontier);

        //Run the search
        boolean found = search.search();
        if (!found) {
            System.out.println("No solution found.");
        }
    }

    public static void main(String[] args) {
        // Solve the puzzle using UCS
        new Puzzle_UCS();
    }

    // Custom Comparator to compare path costs of nodes
    public static class ComparePathCost implements Comparator<Node<List<Integer>, String>> {
        @Override
        public int compare(Node<List<Integer>, String> o1, Node<List<Integer>, String> o2) {
            return Integer.compare(o1.getPathCost(), o2.getPathCost());
        }
    }
}
