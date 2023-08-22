public class ZeroOneKnapsackProblem {
    public static int zeroOneKnapsackProblem(int N, int W, int[] value, int[] weight) {
        int[][] dp = new int[N + 1][W + 1]; // dp[n][w]: maximum value of n weights with limit w
        for(int n=0; n<=N; n++) {
            for(int w=0; w<=W; w++) {
                if(n == 0 || w == 0)
                    dp[n][w] = 0;
                else if(weight[n - 1] <= w)
                    dp[n][w] = Math.max(dp[n - 1][w], value[n - 1] + dp[n - 1][w - weight[n - 1]]); // max value: (without using nth weight) or (with using nth weight)
                else
                    dp[n][w] = dp[n - 1][w]; // unusable nth weight
            }
        }

        return dp[N][K];
    }
}