public class CountingSort {
    public static int[] countingSort(int[] array) {
        int N = 100;
        int[] count = new int[N];
        int[] sorted = new int[array.length];

        for(int i=0; i<array.length; i++)
            count[array[i]]++;
        
        for(int i=1; i<count.length; i++)
            count[i] += count[i - 1];
        
        for(int i=array.length-1; i>=0; i--)
            sorted[--count[array[i]]] = array[i];
        
        return sorted;
    }
}