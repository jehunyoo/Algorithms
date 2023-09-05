import java.util.*;

public class PermutationsWithRepetition {

    /*
     * n∏r
     * Assume that all elements are in [1...N] inclusive.
     */

    public static List<List<Integer>> permuteWithRepetition(int N, int R) {
        List<List<Integer>> permutations = new ArrayList<>();
        permuteWithRepetitionRecursion(N, R, permutations, new ArrayList<>());
        return permutations;
    }

    private static void permuteWithRepetitionRecursion(int N, int R, List<List<Integer>> permutations, List<Integer> permutation) {
        if (R == 0) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int item = 1; item <= N; item++) {
            permutation.add(item);
            permuteWithRepetitionRecursion(N, R - 1, permutations, permutation);
            permutation.remove(permutation.size() - 1);
        }
    }
}
