import java.util.*;

public class Subsets {

    /*
     * Assume that all elements are in [1...N] inclusive.
     * Result includes an empty set.
     */

    public static List<List<Integer>> subsetsByBitMask(int N) {
        List<List<Integer>> subsets = new ArrayList<>();
        for (int mask = 0; mask < 1 << N; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if((1 & mask >> i) == 1)
                    subset.add(i + 1);
            }
            subsets.add(subset);
        }

        return subsets;
    }

    public static List<List<Integer>> subsetsByCombinations(int N) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsetsByCombinationsRecursion(1, N, N, subsets, new ArrayList<>());
        return subsets;
    }

    private static void subsetsByCombinationsRecursion(int next, int N, int R, List<List<Integer>> subsets, List<Integer> subset) {
        if (R < 0) {
            return;
        }

        subsets.add(new ArrayList<>(subset));

        for (int item = next; item <= N; item++) {
            subset.add(item);
            subsetsByCombinationsRecursion(item + 1, N, R - 1, subsets, subset);
            subset.remove(subset.size() - 1);
        }
    }
}