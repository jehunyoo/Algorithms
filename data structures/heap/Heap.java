import java.util.Arrays;

// min heap
public class Heap {
    private int[] heap;
    private int size;

    public Heap() {
        this(10);
    }

    public Heap(int size) {
        heap = new int[size + 1];
        this.size = size;
    }

    public void push(int item) {
        heap[++size] = item;
        int index = size;

        while(index != 1 && item < heap[index / 2]) {
            heap[index] = heap[index / 2];
            index /= 2;
        }

        heap[index] = item;
    }

    public int pop() {
        int item = heap[1];
        int last = heap[size--];
        int parent = 1, child = 2;

        while(child <= size) {
            if(child < size && heap[child + 1] < heap[child]) {
                child++;
            }
            if(last <= heap[child])
                break;

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }

        heap[parent] = last;

        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(heap, 1, size + 1));
    }
}
