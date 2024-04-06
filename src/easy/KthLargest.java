package easy;

import java.util.PriorityQueue;

class KthLargest {
    private int k;
    private PriorityQueue<Integer> elements = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int number: nums) {
            elements.add(number);
        }
    }

    public int add(int val) {
        elements.add(val);
        while (elements.size() != k) {
            elements.poll();
        }

        if (!elements.isEmpty()) {
            return elements.peek();
        }
        return 0;
    }
}