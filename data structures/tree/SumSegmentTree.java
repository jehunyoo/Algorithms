public class SumSegmentTree {

    private int[] tree;
    private int leafCount;

    public SumSegmentTree(int[] array) {
        int height = (int) Math.ceil(Math.log(array.length) / Math.log(2));
        int spaceSize = (int) Math.pow(2, height + 1) - 1;

        this.tree = new int[spaceSize];
        this.leafCount = array.length;

        initTree(array, 1, 0, array.length - 1);
    }

    /**
     * initialize binary tree
     * @param array
     * @param node
     * @param start: inclusive
     * @param end: inclusive
     */
    private void initTree(int[] array, int node, int start, int end) {
        if (start == end) {
            tree[node] = array[start];
            return;
        }

        initTree(array, node * 2, start, (start + end) / 2);
        initTree(array, node * 2 + 1, (start + end) / 2 + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public int query(int queryStart, int queryEnd) {
        return query(1, 0, leafCount - 1, queryStart, queryEnd);
    }

    private int query(int node, int start, int end, int queryStart, int queryEnd) {
        if (queryStart > end || queryEnd < start) {
            return 0;
        }

        if (queryStart <= start && end <= queryEnd) {
            return tree[node];
        }

        int leftSum = query(node * 2, start, (start + end) / 2, queryStart, queryEnd);
        int rightSum = query(node * 2 + 1, (start + end) / 2 + 1, end, queryStart, queryEnd);

        return leftSum + rightSum;
    }

    public void update(int index, int value) {
        update(1, 0, leafCount, index, value);
    }

    private void update(int node, int start, int end, int index, int value) {
        if (index < start || index > end) {
            return;
        }

        if (start == end) {
            tree[node] = value;
            return;
        }

        update(node * 2, start, (start + end) / 2, index, value);
        update(node * 2 + 1, (start + end) / 2 + 1, end, index, value);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}
