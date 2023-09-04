import java.util.*;

public class Permutations {

    /*
     * nPr
     * Assume that all elements are in [1...N] inclusive.
     */

    public static List<List<Integer>> permute(int N, int R) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        permuteRecursion(N, R, permutations, new ArrayList<>(), visited);
        return permutations;
    }

    private static void permuteRecursion(int N, int R, List<List<Integer>> permutations, List<Integer> permutation, boolean[] visited) {
        if (R == 0) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int item = 1; item <= N; item++) {
            if(!visited[item]) {
                permutation.add(item);
                visited[item] = true;
                permuteRecursion(N, R - 1, permutations, permutation, visited);
                permutation.remove(permutation.size() - 1);
                visited[item] = false;
            }
        }
    }
}
