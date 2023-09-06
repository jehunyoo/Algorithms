public class BinarySearch {

    /*
     * Example
     * array = {1, 1, 2, 2, 2, 4, 4, 5, 5, 5}
     * binarySearchLeft(array, 2) = 2
     * binarySearchLeft(array, 3) = 5
     * binarySearchLeft(array, 4) = 5
     * binarySearchRight(array, 2) = 5
     * binarySearchRight(array, 3) = 5
     * binarySearchRight(array, 4) = 7
     */

    public static int binarySearchLeft(int[] array, int target) {

        /*
         * Returns an insertion point (index)
         * which comes before (to the left of) any existing entries of `target` in `array`
         */

        int low = 0, high = array.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static int binarySearchRight(int[] array, int target) {

        /*
         * Returns an insertion point (index)
         * which comes after (to the right of) any existing entries of `target` in `array`
         */
        
        int low = 0, high = array.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
