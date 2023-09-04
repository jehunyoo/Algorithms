import java.util.*;

public class Combinations {
    /*
     * nCr
     * Assume that all elements are in [1...N] inclusive.
     * combineTopDown() is faster than combineBottomUp().
     * (It does not mean that top-down approach is always faster than bottom-up apporach. Speed depends on implementation.)
     */

    public static List<List<Integer>> combineTopDown(int N, int R) {
        List<List<Integer>> combinations = new ArrayList<>();
        combineTopDownRecursion(1, N, R, combinations, new ArrayList<Integer>());
        return combinations;
    }

    private static void combineTopDownRecursion(int next, int N, int R, List<List<Integer>> combinations, List<Integer> combination) {
        if (R == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int item = next; item <= N; item++) {
            combination.add(item);
            combineTopDownRecursion(item + 1, N, R - 1, combinations, combination);
            combination.remove(combination.size() - 1);
        }
    }

    public static List<List<Integer>> combineBottomUp(int N, int R) {
        if (R == 0) {
            List<List<Integer>> combinations = new ArrayList<>();
            combinations.add(new ArrayList<Integer>());
            return combinations;
        }

        List<List<Integer>> combinations = new ArrayList<>();
        for (List<Integer> combination : combineBottomUp(N, R - 1)) {
            int next = (R == 1 ? 1 : combination.get(R - 2) + 1);
            for (int item = next; item <= N; item++) {
                List<Integer> nextCombination = new ArrayList<>(combination);
                nextCombination.add(item);
                combinations.add(nextCombination);
            }
        }

        return combinations;
    }
}
