class NumArray {

    private int[] nums;
    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums.clone();
        tree = new int[n + 1];

        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    private void add(int index, int delta) {
        while (index <= n) {
            tree[index] += delta;
            index += index & (-index);
        }
    }

    private int prefixSum(int index) {
        int sum = 0;
        index++;

        while (index > 0) {
            sum += tree[index];
            index -= index & (-index);
        }

        return sum;
    }

    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;
        add(index + 1, delta);
    }

    public int sumRange(int left, int right) {
        return prefixSum(right) - prefixSum(left - 1);
    }
}