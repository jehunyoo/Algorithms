import java.util.*;

public class CombinationsWithRepetition {

    /*
     * nHr
     * Assume that all elements are in [1...N] inclusive.
     */

    public static List<List<Integer>> combineWithRepetition(int N, int R) {
        List<List<Integer>> combinations = new ArrayList<>();
        combineWithRepetitionRecursion(1, N, R, combinations, new ArrayList<Integer>());
        return combinations;
    }

    private static void combineWithRepetitionRecursion(int next, int N, int R, List<List<Integer>> combinations, List<Integer> combination) {
        if (R == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int item = next; item <= N; item++) {
            combination.add(item);
            combineWithRepetitionRecursion(item, N, R - 1, combinations, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
