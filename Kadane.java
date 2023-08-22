// Maximum Subarray Problem
public class Kadane {
    public static int kadane(int[] array) {
        int largestSum = Integer.MIN_VALUE;
        int localSum = 0;
        for(int item: array) {
            localSum = Math.max(localSum, localSum + item);
            largestSum = Math.max(largestSum, localSum);
        }

        return largestSum;
    }
}
